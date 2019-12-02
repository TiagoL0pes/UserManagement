/**
 * Java Web Project
 */
package com.user.management.crud.forms;

import com.user.management.crud.models.User;
import javax.validation.constraints.NotBlank;
import lombok.Getter;

/**
 *
 * User Management - Simple Crud Project
 *
 * @since 27/11/2019
 * @author Tiago Lopes
 */
@Getter
public class UserForm {

    @NotBlank(message = "{field.not.blank}")
    private String name;

    @NotBlank(message = "{field.not.blank}")
    private String email;
    private Long age;

    public User getUser() {
        User user = new User();
        user.setName(this.name);
        user.setEmail(this.email);
        user.setAge(this.age);
        
        return user;
    }
    
}
