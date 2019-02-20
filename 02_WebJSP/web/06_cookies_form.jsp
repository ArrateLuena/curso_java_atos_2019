<%-- 
    Document   : 06_cookies_form
    Created on : 20-feb-2019, 16:20:03
    Author     : USUARIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario cookies JSP</title>
    </head>
    <body>
        <%@ include file="cabecera.jsp" %>
        <%= dameTitulo("Formulario cookies JSP") %>
        
        <form method="get" action="06_cookies.jsp">
            <p>Nombre: <input type="text" name="nombre" id="nombre"/></p>
            <p>Apellidos: <input type="text" name="apellidos" id="apellidos"/></p>
            <input type="submit" value="Enviar"/>
        </form>
    </body>
</html>
