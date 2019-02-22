/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.persistencia;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import modelo.Usuario;
import modelo.logica.IUsuarioDAO;

/**
 *
 * @author USUARIO
 */
public class FicheroUsuario implements IUsuarioDAO {
    public static final String FICH = "C:\\Users\\USUARIO\\Documents\\NetBeansProjects\\curso_java_oracle_atos.git\\04_EjemploMVC\\persona.dat";
    
    private static final FicheroUsuario instancia = new FicheroUsuario();
    private FicheroUsuario() { }
    public static FicheroUsuario getInstancia() { return instancia; }
    
    @Override
    public boolean guardarUsuario(Usuario usuario) {
        try {
            ObjectOutputStream escribFich = new ObjectOutputStream(
                    new FileOutputStream(FICH ));
            escribFich.writeObject(usuario);
            escribFich.close();                
            return true;
        } catch (Exception ex) {            
            return false;
        }
    }
    @Override
    public Usuario leerUsuario() {
        try {
            ObjectInputStream leyendoFich = new ObjectInputStream(
                    new FileInputStream(FICH));
            Usuario p = (Usuario) leyendoFich.readObject();
            leyendoFich.close();                
            return p;
        } catch (Exception ex) {            
            return null;
        }
    }
}
