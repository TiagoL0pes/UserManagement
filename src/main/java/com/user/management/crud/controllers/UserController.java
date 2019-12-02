/**
 * Java Web Project
 */
package com.user.management.crud.controllers;

import com.user.management.crud.dtos.UserDto;
import com.user.management.crud.responses.SuccessResponse;
import com.user.management.crud.exceptions.NotFoundException;
import com.user.management.crud.filter.Filter;
import com.user.management.crud.forms.UserForm;
import com.user.management.crud.models.User;
import com.user.management.crud.repositories.UserRepository;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * User Management - Simple Crud Project
 *
 * @since 27/11/2019
 * @author Tiago Lopes
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository repository;

    @PostMapping
    public ResponseEntity<UserDto> create(@RequestBody @Valid UserForm form) {
        User user = form.getUser();
        return ResponseEntity.ok(new UserDto(repository.save(user)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> findById(@PathVariable Long id) {
        Optional<User> op = repository.findById(id);
        if (op.isPresent()) {
            return ResponseEntity.ok().body(new UserDto(op.get()));
        }

        throw new NotFoundException("User not found");
    }

    @PostMapping("/list")
    public ResponseEntity<List<UserDto>> findAll(@RequestBody @Valid Filter filter) {
        List<UserDto> list = UserDto.toList(repository.getPaginetedUsers(filter));
        return ResponseEntity.ok(list);
    }

    @PutMapping("/{id}") 
    public ResponseEntity<UserDto> update(@PathVariable Long id, @RequestBody @Valid UserForm form) {
        Optional<User> op = repository.findById(id);
        if (op.isPresent()) {
            User entity = op.get();
            entity.setName(form.getName());
            entity.setEmail(form.getEmail());
            entity.setAge(form.getAge());
            repository.save(entity);

            return ResponseEntity.ok().body(new UserDto(entity));
        }

        throw new NotFoundException("User not found");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SuccessResponse> delete(@PathVariable Long id) {
        Optional<User> op = repository.findById(id);
        if (op.isPresent()) {
            repository.delete(op.get());
            return ResponseEntity.ok(new SuccessResponse(new Date(), "User has been deleted."));
        }

        throw new NotFoundException("User not found");
    }
}
