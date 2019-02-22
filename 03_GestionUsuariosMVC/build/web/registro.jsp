<%-- 
    Document   : registro
    Created on : 22-feb-2019, 12:43:10
    Author     : USUARIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro</title>
    </head>
    <body>
        <h1>Introduzca sus datos</h1>
        <form method="post" action="usuario.do">
            <p>Nombre: <input type="text" name="nombre" id="nombre" required/></p>
            <p>Edad: <input type="text" name="edad" id="edad" required/></p>
            <p>Email: <input type="text" name="email" id="email" required/></p>
            <p>Contraseña: <input type="password" name="pass" id="pass" required/></p>
            <input type="submit" value="Enviar"/>
        </form>
    </body>
</html>
