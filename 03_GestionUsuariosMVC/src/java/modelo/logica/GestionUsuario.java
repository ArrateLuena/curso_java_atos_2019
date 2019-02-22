/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.logica;

import modelo.Usuario;
import modelo.persistencia.JavaJDUsuario;

/**
 *
 * @author USUARIO
 */
public class GestionUsuario {
    // Lista, HashMap
    // private Persona persona;

    private static GestionUsuario instancia;
    private IUsuarioDAO daoUsuario = new JavaJDUsuario(); //FicheroPersona.getInstancia();
    private GestionUsuario() { }    
    public static GestionUsuario getInstancia() {
        if (instancia == null) instancia = new GestionUsuario();
        return instancia;
    }
    public enum TipoResultado {OK, SIN_VALORES, EDAD_MAL, ERR_IO, EMAIL_MAL};
    
    private boolean validarDatosUsuario(String nombre, String edad, String email, String pass) {
        return ! nombre.isEmpty() && ! edad.isEmpty() && !email.isEmpty() && ! pass.isEmpty();
    }
    private boolean validarEdad(String edad) {
       return edad.matches("^[1-9][0-9]*$");
    }
    
    private boolean validarEmail(String email){
        return email.matches("^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,4})$");
    }
    
    public TipoResultado guardarUsuario(String nombre, String edad, String email, String pass) {
        if (validarDatosUsuario(nombre, edad, email, pass)) {
            if (validarEdad(edad)) {
                if (validarEmail(email)){

                    if (daoUsuario.guardarUsuario(new Usuario(nombre, edad, email, pass)))
                        return TipoResultado.OK;
                    else
                        return TipoResultado.ERR_IO;
                }else{
                    return TipoResultado.EMAIL_MAL;
                }
            } else {
                return TipoResultado.EDAD_MAL;
            }
        } else {
            return TipoResultado.SIN_VALORES;
        }
    }
    public Usuario getUsuario() {
        return daoUsuario.leerUsuario();
    }
}
