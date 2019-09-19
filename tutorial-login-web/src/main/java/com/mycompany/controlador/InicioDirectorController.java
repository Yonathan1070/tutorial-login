/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controlador;

import com.mycompany.dto.DTOUsuario;
import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Yonathan
 */
@Named
@SessionScoped
public class InicioDirectorController implements Serializable{

    private DTOUsuario user;
    /**
     * Creates a new instance of InicioDirectorController
     */
    public InicioDirectorController() {
    }
    
    public void validarSesion() {
        try {
            FacesContext faces = FacesContext.getCurrentInstance();
            DTOUsuario usuario = (DTOUsuario) faces.getExternalContext().getSessionMap().get("usuario");
            if (usuario == null) {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                        "Está tratando de ingresar violentamente al sitio.");
                faces.addMessage(null, msg);
                faces.getExternalContext().getFlash().setKeepMessages(true);
                faces.getExternalContext().redirect("./../login.xhtml");
            }
            else if(!usuario.getRol().equals("Director")){
                FacesContext context = FacesContext.getCurrentInstance();
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                        "No tiene permisos para ingresar a esta sección del sitio.");
                faces.addMessage(null, msg);
                context.getExternalContext().getFlash().setKeepMessages(true);
                faces.getExternalContext().redirect(usuario.getRol().toLowerCase()+"/inicio.xhtml");
            }
            user=usuario;
        } catch (Exception e) {

        }
    }

    public String cerrarSesion(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "login?faces-redirect=true";
    }
    
    public DTOUsuario getUser() {
        return user;
    }

    public void setUser(DTOUsuario user) {
        this.user = user;
    }
}
