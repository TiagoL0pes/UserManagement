/**
 * Java Web Project
 */
package com.user.management.crud.exceptions;

import lombok.NoArgsConstructor;

/**
 *
 * User Management - Simple Crud Project
 *
 * @since 27/11/2019
 * @author Tiago Lopes
 */
@NoArgsConstructor
public class NotFoundException extends RuntimeException {

    private static final long serialVersionUID = 8790061329839358652L;

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(Throwable cause) {
        super(cause);
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
