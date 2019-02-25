<%-- 
    Document   : login
    Created on : 22-feb-2019, 12:43:29
    Author     : USUARIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Introduzca sus datos</h1>
        <form method="get" action="usuario.do">
            <p>Email: <input type="text" name="email" id="email" required/></p>
            <p>Contraseña: <input type="password" name="pass" id="pass" required/></p>
            <input type="submit" value="Login"/>
            <input type="hidden" value="doGet" name="joker" id="joker"/>
        </form>
    </body>
</html>
