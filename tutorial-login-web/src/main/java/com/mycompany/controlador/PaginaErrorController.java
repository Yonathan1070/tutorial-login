/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controlador;

import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author Yonathan
 */
@Named
@SessionScoped
public class PaginaErrorController implements Serializable {

    /**
     * Creates a new instance of PaginaErrorController
     */
    public PaginaErrorController() {
    }

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String navigate() {
        // Assume an exception has been thrown by some business logic
        System.out.println(10 / 0);
        return "login";
    }
}
