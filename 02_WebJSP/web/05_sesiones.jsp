<%-- 
    Document   : 05_sesiones
    Created on : 20-feb-2019, 14:03:37
    Author     : USUARIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestión de sesiones JSP</title>
    </head>
    <body>
        <%@ include file="cabecera.jsp" %>
        <%int totalPeticiones=0; //Variable estatica %>
        <%= dameTitulo("Gestión de sesiones JSP") %>
        
        <h2>Cálculo de un factorial</h2>
        
        <form action="05_sesiones.jsp" method="get">
            <p>N&uacute;mero:
                <input id="numero" name="numero" type="number"/>
                <input type="submit" value="Calcular"/></p>
        </form>
        
        <%
            String numeroGet = request.getParameter("numero");
            int numero =0;
            double factorial=1;
            boolean error=false;
            if(numeroGet != null){
                try{
                    numero = Integer.valueOf(numeroGet);
                    if (numero < 1){
                        error = true;
                    }else {
                        for(int i = numero; i > 1; i--){
                            factorial *=i;
                        }
                    }
                }catch(NumberFormatException e){
                    error = true;
                    
                }
                
                if (error){
                    out.println("<p style='color:red'>Indicar un numero entero mayor que 0</p>");
                }else{
                    out.println("<p style='color:green'>Resultado del factorial de " + numero + " = " + factorial + "</p>");
                }
            }
            
            Integer contador = (Integer) session.getAttribute("contadorVisitas");
            out.println("<p style='color:purple'>" + contador + "</p>");
            if (contador != null){
                contador = Integer.valueOf(contador);
            }else{
                contador = 0;
            }
            
            if(contador != 0){
                %> <p> Ejeciciones de este JSP en esta sesión: <%= contador %> </p> <%
            }
            contador++;
            session.setAttribute("contadorVisitas", contador);
            
            totalPeticiones++;
        %>
        <p> Ejeciciones de este JSP en esta sesión: <%= contador %> </p>
    </body>
</html>
