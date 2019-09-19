/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.interfaces;

import com.mycompany.dto.DTOUsuario;
import javax.ejb.Local;

/**
 *
 * @author Yonathan
 */
@Local
public interface ILoginSesion {
    public void agregarUsuarios();
    public DTOUsuario obtenerUsuario(String username, String password);
}
