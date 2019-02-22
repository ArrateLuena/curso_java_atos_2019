/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.logica;

import modelo.Usuario;

/**
 *
 * @author USUARIO
 */
public interface IUsuarioDAO {
    
    boolean guardarUsuario(Usuario usuario);
    
    Usuario leerUsuario();
}
