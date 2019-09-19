/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controlador;

import com.mycompany.dto.DTOUsuario;
import com.mycompany.interfaces.ILoginSesion;
import com.mycompany.interfaces.IUsuarioFacadel;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Yonathan
 */
@Named
@RequestScoped
public class LoginController implements Serializable{

    private List<DTOUsuario> listaUsuarios;
    private String username;
    private String password;
    
    @EJB
    ILoginSesion ejb;
    
    @EJB
    IUsuarioFacadel ejbUsuario;
    /**
     * Creates a new instance of LoginController
     */
    public LoginController() {
        listaUsuarios = new ArrayList();
    }
    
    public String iniciarSesion(){
        DTOUsuario user = ejbUsuario.login(username, password);
        if(user!=null){
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", user);
            return user.getRol().toLowerCase()+"/inicio.xhtml?faces-redirect=true";
        }else{
            return "login.xhtml?faces-redirect=true";
        }
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
