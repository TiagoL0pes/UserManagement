/**
 * Java Web Project
 */
package com.user.management.crud.models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * User Management - Simple Crud Project
 *
 * @since 27/11/2019
 * @author Tiago Lopes
 */
@Data
@NoArgsConstructor
@Entity
@Table(schema = "admin", name = "user")
@SequenceGenerator(schema = "admin", name = "seq_user", sequenceName = "admin.seq_user", allocationSize = 1)
public class User implements Serializable {

    private static final long serialVersionUID = -5356995534376345607L;

    @Id
    @GeneratedValue(generator = "seq_user", strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "age")
    private Long age;
}
