/**
 * Java Web Project
 */
package com.user.management.crud.filter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import lombok.Getter;

/**
 *
 * User Management - Simple Crud Project
 *
 * @since 27/11/2019
 * @author Tiago Lopes
 */
@Getter
public class Filter {

    @PositiveOrZero(message = "{field.positive}")
    private Integer page;

    @Positive(message = "{field.positive.or.zero}")
    private Integer size;

    @NotBlank(message = "{field.not.blank}")
    private String sortBy;

}
