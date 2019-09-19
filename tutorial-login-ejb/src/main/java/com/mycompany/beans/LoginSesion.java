/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.beans;

import com.mycompany.dto.DTOUsuario;
import com.mycompany.interfaces.ILoginSesion;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateful;

/**
 *
 * @author Yonathan
 */
@Stateful
public class LoginSesion implements ILoginSesion {

    private DTOUsuario usuario1;
    private DTOUsuario usuario2;
    private DTOUsuario usuario3;
    private List<DTOUsuario> listaUsuarios;

    public LoginSesion() {
        listaUsuarios = new ArrayList();
    }
    
    
    @Override
    public void agregarUsuarios(){
        usuario1 = new DTOUsuario("Alejandro", "Administrador", "alejo", "123456");
        usuario2 = new DTOUsuario("Lorena", "Director", "lore", "987654");
        usuario3 = new DTOUsuario("David", "Trabajador", "deivid", "654321");
        
        listaUsuarios.add(usuario1);
        listaUsuarios.add(usuario2);
        listaUsuarios.add(usuario3);
        System.out.println("Usuarios Agregados");
    }
    
    @Override
    public DTOUsuario obtenerUsuario(String username, String password){
        for (DTOUsuario usuario : listaUsuarios) {
            if(usuario.getUsername().equals(username) && usuario.getPassword().equals(password)){
                return usuario;
            }
        }
        return null;
    }
}
