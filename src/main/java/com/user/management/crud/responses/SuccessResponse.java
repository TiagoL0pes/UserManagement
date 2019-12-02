/**
 * Java Web Project
 */
package com.user.management.crud.responses;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import lombok.Data;

/**
 *
 * User Management - Simple Crud Project
 *
 * @since 27/11/2019
 * @author Tiago Lopes
 */
@Data
public class SuccessResponse {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private Date date;
    private String message;

    public SuccessResponse(Date date, String message) {
        this.date = date;
        this.message = message;
    }
    
}
