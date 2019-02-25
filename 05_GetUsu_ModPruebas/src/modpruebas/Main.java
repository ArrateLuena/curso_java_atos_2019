/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modpruebas;

import java.util.ArrayList;
import modelo.Usuario;
import modelo.logica.ServicioUsuarios;

/**
 *
 * @author USUARIO
 */
public class Main {

    static void mostrarResultado(ServicioUsuarios.Resultado res, String nombre) {
        System.out.print("- Prueba " + nombre);
        switch (res) {
            case CamposMal:
                System.out.println("Error Campos mal");
                break;
            case ErrorDB:
                System.out.println("Error base de datos");
                break;
            case NoLogin:
                System.out.println("Error no login");
                break;
            case Ok:
                System.out.println("Todo correcto");
                break;
        }
    }

    static void listar() {
        ArrayList<Usuario> todos = ServicioUsuarios.getInstancia().obtenerTodos();

        System.out.println("ServicioUsuarios.getInstancia().obtenerTodos():");

        for (Usuario u : todos) {
            System.out.println("   -  " + u.getId()
                    + ", " + u.getNombre()
                    + ", " + u.getEdad()
                    + ", " + u.getEmail()
                    + ", " + u.getPassword()
            );
        }
    }

    public static void main(String[] args) {
        System.out.println("Probando modulo modelo: ");
        System.out.println("DATOS NO VALIDOS: ");

        mostrarResultado(
                ServicioUsuarios.getInstancia().add("A1", "10", "", ""), "Usuario no valido ");
        mostrarResultado(
                ServicioUsuarios.getInstancia().add("A2", "11", ".we@s.es", ""), "Usuario no valido ");
        mostrarResultado(
                ServicioUsuarios.getInstancia().add("A3", "12", "", "ase"), "Usuario no valido ");
        mostrarResultado(
                ServicioUsuarios.getInstancia().add("A4", "13", "asdqwd", ""), "Usuario no valido ");
        mostrarResultado(
                ServicioUsuarios.getInstancia().add("A4", "-2", "asw@ont.es", "qwer"), "Usuario no valido ");
        
        System.out.println("DATOS VALIDOS: ");

        mostrarResultado(
                ServicioUsuarios.getInstancia().add("B1", "18", "b1@b1.com", "qwer"), "Usuario valido ");
        mostrarResultado(
                ServicioUsuarios.getInstancia().add("B2", "19", "b2@b2.com", "erty"), "Usuario valido ");
        mostrarResultado(
                ServicioUsuarios.getInstancia().add("B3", "20", "b3@b3.com", "rtry"), "Usuario valido ");
        mostrarResultado(
                ServicioUsuarios.getInstancia().add("B4", "21", "b3@b3.com", "dsfg"), "Usuario REPETIDO ");

        
        
        Usuario usu = ServicioUsuarios.getInstancia().obtenerUno("b3@b3.com");

        mostrarResultado(
                ServicioUsuarios.getInstancia().modificar(usu.getId(), "B3ww", "12", "b3@b3.com", "qwer"), "Cambios realizados ");

        listar();
        
        
        mostrarResultado(
                ServicioUsuarios.getInstancia().validarLoginUsuario("b3@b3.com", "qwer"), "Login correcto ");
        
        listar();
        
        
        mostrarResultado(
                ServicioUsuarios.getInstancia().eliminar("b3@b3.com"), "eliminar B3");

        mostrarResultado(
                ServicioUsuarios.getInstancia().eliminar("b2@b2.es"), "eliminar B2");
        
        listar();

    }

}
