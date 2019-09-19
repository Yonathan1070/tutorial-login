/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dto;

import java.io.Serializable;

/**
 *
 * @author Yonathan
 */
public class DTOUsuario implements Serializable{
    
    private int id;
    private String nombres;
    private String rol;
    private String username;
    private String password;

    public DTOUsuario(String nombres, String rol, String username, String password) {
        this.nombres = nombres;
        this.rol = rol;
        this.username = username;
        this.password = password;
    }

    public DTOUsuario(int id, String nombres, String rol, String username, String password) {
        this.id = id;
        this.nombres = nombres;
        this.rol = rol;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
