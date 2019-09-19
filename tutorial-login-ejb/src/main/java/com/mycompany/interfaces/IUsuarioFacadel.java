/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.interfaces;

import com.mycompany.dto.DTOUsuario;
import com.mycompany.entity.Usuario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Yonathan
 */
@Local
public interface IUsuarioFacadel {

    void create(Usuario usuario);

    void edit(Usuario usuario);

    void remove(Usuario usuario);

    Usuario find(Object id);

    List<Usuario> findAll();

    List<Usuario> findRange(int[] range);

    int count();
    
    DTOUsuario login(String username, String password);
    
}
