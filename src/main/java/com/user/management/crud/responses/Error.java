/**
 * PlayFile - Web Project
 */
package com.user.management.crud.responses;

import lombok.Data;

/**
 *
 * User Management - Simple Crud Project
 *
 * @since 27/11/2019
 * @author Tiago Lopes
 */
@Data
public class Error {

    private final String field;
    private final String message;
    private final Object parameter;
    
}
