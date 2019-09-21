/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controlador;

import com.mycompany.dto.DTOCuenta;
import com.mycompany.dto.DTOInversor;
import com.mycompany.dto.DTOUsuario;
import com.mycompany.interfaces.InversorFacadeLocal;
import java.io.Serializable;
import javax.ejb.EJB;
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
public class InicioAdministradorController implements Serializable{

    private DTOUsuario user;
    
    private String nombre;
    private String cuenta;
    
    @EJB
    InversorFacadeLocal inversorCon;
    /**
     * Creates a new instance of InicioAdministradorController
     */
    public InicioAdministradorController() {
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
            else if(!usuario.getRol().equals("Administrador")){
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
    
    public void agregarInversor(){
        DTOInversor dtoInversor = new DTOInversor();
        DTOCuenta dtoCuenta = new DTOCuenta();
        dtoInversor.setNombre(nombre);
        dtoCuenta.setNumeroCuenta(cuenta);
        inversorCon.crearInversor(dtoInversor, dtoCuenta);
        FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Agregado",
                    "Inversor "+nombre+" agregado satisfactoriamente"));
    }
    
    public DTOUsuario getUser() {
        return user;
    }

    public void setUser(DTOUsuario user) {
        this.user = user;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }
    
    
}
