<%-- 
    Document   : comprueba
    Created on : 22-feb-2019, 12:43:45
    Author     : USUARIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Verificación de datos</title>
    </head>
    <body>
        <h1>Introduzca el email de usuario y la contraseña</h1>
        <form method="get" action="usuario.do">
            <p>Email: <input type="text" name="email" id="email" required/></p>
            <p>Contraseña: <input type="password" name="pass" id="pass" required/></p>
            <input type="submit" value="Enviar"/>
        </form>
    </body>
</html>
