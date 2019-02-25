/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Usuario;
import modelo.logica.IUsuarioDAO;

/**
 *
 * @author USUARIO
 */
public class JavaJDUsuario implements IUsuarioDAO {

    public JavaJDUsuario() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
        } catch (Exception ex) {
            Logger.getLogger(JavaJDUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean guardarUsuario(Usuario usuario) {

        try (Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/Usuario",
                "usuario", "usuario")) {
            String squery = "SELECT COUNT(Id) as ultId FROM Usuario";
            Statement stmt = con.createStatement();
            ResultSet res = stmt.executeQuery(squery);
            if (res.next()) { 
                int ultId = res.getInt("ultId");
                ultId++; // Nuestro autoincrement
                squery = "INSERT INTO Usuario (id, nombre, edad, email, password) VALUES(" + ultId + ", '" + usuario.getNombre() + "', '"
                        + usuario.getEdad() + "', '" + usuario.getEmail() + "', '" + usuario.getContraseña()+ "')" ;
                stmt = con.createStatement();
                stmt.executeUpdate(squery);
                return true;
            }
            return false;
        } catch (SQLException ex) {
            return false;
        }
    }

    @Override
    public Usuario leerUsuario(String id) {
        try (Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/Usuario",
                "usuario", "usuario")) {
            String squery = "SELECT id, nombre, edad, email, password FROM Usuario WHERE id=" + id;
            Statement stmt = con.createStatement();
            ResultSet res = stmt.executeQuery(squery);
            if (res.next()) {   // Cogemos cualquier persona (última o la primera...)
                String id1 = res.getString("id");
                String nombre = res.getString("nombre");
                String email = res.getString("email");
                String pass = res.getString("pass");
                String edad = res.getString("edad");
                return new Usuario(id1, nombre, edad, email, pass);
            }
            return null;
        } catch (SQLException ex) {
            return null;
        }
    }
    
    @Override
    public ArrayList<Usuario> listarUsuarios() {
        try (Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/Usuario",
                "usuario", "usuario")) {
            
            ArrayList<Usuario> listaUsuarios = new ArrayList<>();
            String squery = "SELECT id, nombre, edad, email, password FROM Usuario";
            Statement stmt = con.createStatement();
            ResultSet res = stmt.executeQuery(squery);
            while (res.next()) { 
                String id = res.getNString("id");
                String nombre = res.getString("nombre");
                String edad = res.getString("edad");
                String email = res.getString("email");
                String password = res.getString("password");
                Usuario usu = new Usuario(id, nombre, edad, email, password);
                listaUsuarios.add(usu);
            }
            return listaUsuarios;
        } catch (SQLException ex) {
            return null;
        }
    }
}
