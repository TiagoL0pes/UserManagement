/**
 * Java Web Project
 */
package com.user.management.crud.responses;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *
 * User Management - Simple Crud Project
 *
 * @since 27/11/2019
 * @author Tiago Lopes
 */
@Data
@AllArgsConstructor
@JsonInclude(Include.NON_DEFAULT)
public class ErrorResponse {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private Date date;
    private String message;
    private int status;
    private String error;
    private String object;
    private String path;
    private List<Error> errors;

    public ErrorResponse(String message, int code, String status) {
        this.date = new Date();
        this.status = code;
        this.error = status;
        this.message = message;
    }
    
}
