/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.persistencia;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import modelo.Persona;

/**
 *
 * @author USUARIO
 */
public class FicheroPersona {
    
    public static final String FICH = "C:\\Users\\USUARIO\\Documents\\NetBeansProjects\\04_EjemploMVC";
    
    public static boolean guardarPersona(Persona persona){
        try{
            ObjectOutputStream escribiendoFichero = new ObjectOutputStream(new FileOutputStream(FICH + "\\persona.dat"));
            escribiendoFichero.writeObject(persona);
            escribiendoFichero.close();
            return true;
        }catch (Exception e){
            
            return false;
        }   
    }
    
        public static Persona leerPersona(){
        try{
            ObjectInputStream leyendoFichero = new ObjectInputStream(new FileInputStream(FICH + "\\persona.dat"));
            Persona p = (Persona) leyendoFichero.readObject();
            leyendoFichero.close();
            return p;
            
        }catch (Exception e){ 
            return null;
        }   
    }
}
