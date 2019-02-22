/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webservlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author USUARIO
 */
public class Funciones extends HttpServlet{
    
    protected void procesarPeticion(HttpServletRequest peticion, 
            HttpServletResponse respuesta)
            throws ServletException, IOException{

    }
    
        @Override
    protected void doGet(HttpServletRequest peticion, 
            HttpServletResponse respuesta)
            throws ServletException, IOException {
        procesarPeticion(peticion, respuesta);
    }
    
    @Override
    protected void doPost(HttpServletRequest peticion, 
            HttpServletResponse respuesta)
            throws ServletException, IOException {
        procesarPeticion(peticion, respuesta);
    }
    
    protected void doPut(){
        
    }
    
    protected void doDelete(){
        
    }
    
    public static String comprobarParam(
            HttpServletRequest req, 
            PrintWriter out, 
            String par) {
        String valor = req.getParameter(par);
        if (valor.equals("")) {
            out.println("<h2>El parámetro " 
                + par 
                + " no puede estar vacío.");
            return "";
        } else {
            return valor;
        }
    }

}
