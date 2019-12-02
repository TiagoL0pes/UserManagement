/**
 * Java Web Project
 */
package com.user.management.crud.repositories;

import com.user.management.crud.filter.Filter;
import com.user.management.crud.models.User;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * User Management - Simple Crud Project
 *
 * @since 27/11/2019
 * @author Tiago Lopes
 */
public interface UserRepository extends JpaRepository<User, Long> {

    default public List<User> getPaginetedUsers(Filter filter) {
        Pageable paging = PageRequest.of(filter.getPage(), filter.getSize(), Sort.by(filter.getSortBy()));

        Page<User> pages =  this.findAll(paging);

        if (pages.hasContent()) {
            return pages.getContent();
        } else {
            return new ArrayList<>();
        }
    }
}
