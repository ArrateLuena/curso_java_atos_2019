/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.registro;

import com.modelo.ServicioUsuarios;
import com.webservlet.Funciones;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Registro extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String nom = Funciones.comprobarParam(request, out, "nom");
            String strEdad = Funciones.comprobarParam(request, out, "eda");
            int edad = 0;
            if (!strEdad.equals(""))
                edad = Integer.parseInt(strEdad);
            String email = Funciones.comprobarParam(request, out, "email");
            String psswd = Funciones.comprobarParam(request, out, "psswd");
            if (nom != "" && strEdad != "" && email != "" && psswd != "") {
                if (edad < 18)
                    out.println("<h2>Eh que eres menor!</p>");
                else {
                    ServicioUsuarios.getInstancia().addUser(nom, edad, email, psswd);
                    out.println("<h2>Usuario añadido</p>");
                }
            }

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Registro</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Registro at " + request.getContextPath() + "</h1>");
            
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
