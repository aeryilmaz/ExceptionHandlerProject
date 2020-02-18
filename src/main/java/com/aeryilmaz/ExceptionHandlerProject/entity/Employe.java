package com.aeryilmaz.ExceptionHandlerProject.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;


@Entity
@Data
@NoArgsConstructor
public class Employe implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "firstName name must not be empty")
    private String firstName;

    @NotEmpty(message = "lastName must not be empty")
    private String lastName;

    @NotEmpty(message = "email must not be empty")
    @Email(message = "email should be a valid email")
    private String email;



}
