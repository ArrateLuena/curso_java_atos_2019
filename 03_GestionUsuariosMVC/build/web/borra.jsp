<%-- 
    Document   : borra
    Created on : 22-feb-2019, 12:43:52
    Author     : USUARIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Borrar datos</title>
    </head>
    <body>
        <h1>Introduzca su email y contraseña</h1>
        <form method="get" action="">
            <p>Email: <input type="text" name="email" id="email" required/></p>
            <p>Contraseña: <input type="password" name="pass" id="pass" required/></p>
            <input type="submit" value="Borrar usuario"/>
        </form>
    </body>
</html>
