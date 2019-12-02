/**
 * Java Web Project
 */
package com.user.management.crud.dtos;

import com.user.management.crud.models.User;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Data;

/**
 *
 * User Management - Simple Crud Project
 *
 * @since 27/11/2019
 * @author Tiago Lopes
 */
@Data
public class UserDto {

    private String name;
    private String email;
    private Long age;

    public UserDto(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.age = user.getAge();
    }
    
    public static List<UserDto> toList(List<User> users) {
        return users.stream().map(UserDto::new).collect(Collectors.toList());
    }
    
}
