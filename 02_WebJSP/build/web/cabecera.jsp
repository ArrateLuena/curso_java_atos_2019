<%-- 
    Document   : cabecera
    Created on : 20-feb-2019, 16:52:26
    Author     : USUARIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<header><h1>Ejemplos JSP curso Java</h1></header>
<nav>
    <% 
        String[] url = {"00_probando.jsp", "01_expresiones.jsp", "02_scriptlets.jsp", "03_ejer_scriptlet.jsp",
        "04_reg_ses.jsp", "05_sesiones.jsp", "06_cookies_form.jsp"};
        String[] nombres = {"Probar suerte","Expresiones","Scriptlets","Ejercicio Scriptlets",
            "Petición, respuesta y sesiones","Gestión de sesiones JSP","Gestión de cookies con JSP"};
        
        for (int i = 0; i<url.length; i++){
    %>
        <a href="<%= url[i] %>"><h3><%= nombres[i] %></h3></a>
        
    <% } %>
</nav>

<%!

    private String dameTitulo(String titulo){
        
        return "<h2 style='color:Brown'>" + titulo + "</h2>";

    }
%>