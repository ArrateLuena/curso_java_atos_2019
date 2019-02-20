<%-- 
    Document   : 04_reg_ses
    Created on : 20-feb-2019, 14:03:37
    Author     : USUARIO
--%>

<%@page import="java.util.regex.*"%>
<%@page import="java.io.IOException"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.io.FileWriter"%>
<%-- https://github.com/germanux/curso_java_oracle_atos --%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestión de peticiones y respuestas JSP</title>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    </head>
    <body class="container">
        <%@ include file="cabecera.jsp" %>    
        <%= dameTitulo("Gestión de peticiones y respuestas JSP") %>

        <% 
            String nomApell = request.getParameter("nombre_apell");
            String desc = request.getParameter("descripcion");
            String email = request.getParameter("email");
            if (nomApell == null || desc == null || email == null){ 
        %>
        <div class="col-lg-2"></div>
        <div class="col-lg-8">
            <script>
                function preguntarSiEnviar(){
                   
                   if (document.getElementById("nombre_apell").value !== ""
                           && document.getElementById("nombre_apell").value.length > 1){
                       //Cuando el nombre es correcto
                       let siQuiereEnviar = window.confirm("¿Seguro que quiere enviar?");
                       return siQuiereEnviar;
                   }else{
                       alert("El nombre debe ser mayor de 1 caracter");
                       return false;
                   }
                }
            </script>
            <form action="04_reg_ses.jsp" method="get" class="form-inline" onsubmit="return preguntarSiEnviar()">
                <p>Nombre y apellidos:</p>
                <p><input id="nombre_apell" type="text" name="nombre_apell" 
                          autocomplete="true" size="100" maxlength="100"
                           required="true" 
                           placeholder="Introduzca nombre y apellidos"
                           class="form-control"/></p>
                <p>Descripción:</p>
                <p><textarea id="descripcion" name="descripcion" required="true" cols="100" rows="10"
                             placeholder="Introduzca una descripción detallada"
                             class="form-control">                    
                </textarea></p>
                <p>Email:</p>
                <p><input type="text" id="email"  name="email" 
                          autocomplete="true" size="100" maxlength="100"
                           required="true" 
                           placeholder="Introduzca su email"
                           class="form-control"/></p>
                <input type="submit" value="Enviar" class="btn   btn-default"/>
            </form>
        </div>
        <div class="col-lg-2"></div>
        <%   
            } // Fin if mostrar FORM
            else {  // Cuando ningun parametro es null
                    if (nomApell != null || desc != null || email != null) {
                    // Lógica de validación
                    if (nomApell != null && nomApell.length() > 1) {
                        if (desc != null && desc.length() > 5) {
                            // Validacion del mail
                            if(email.matches("^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,4})$")){
                                try{
                                      FileWriter fileWriter = new FileWriter("C:/Users/USUARIO/Desktop/curso_java_oracle_atos-master/curso_java_oracle_atos-master/02_WebJSP/solicitudes.txt");
                                      PrintWriter printWriter = new PrintWriter(fileWriter);
                                      printWriter.printf("Nombre='%s'\r\nDescripcion='%s'\r\nE-mail='%s'\n", 
                                              nomApell, desc, email);
                                      printWriter.close();
                                      out.println("<h2>Enviado</h2>");
                                }catch(IOException e){
                                      out.println("<h2>Error al enviar el formulario</h2>");
                                }
                                
                            }else{
                                out.println("<h2>Email no valido</h2>");
                            }
                            
                            //Modo mas complejo de encontrar email invalido.
                                /*String compEmail = request.getParameter("email");
                                // compruebo que no empieze por punto o @
                                Pattern buscar = Pattern.compile("^.|^@");
                                Matcher cadena = buscar.matcher(compEmail);
                                if (cadena.find())
                                   out.println("<h3>Las direcciones email no empiezan por punto o @</h3>");

                                // compruebo que no empieze por www.
                                buscar = Pattern.compile("^www.");
                                cadena = buscar.matcher(compEmail);
                                if (cadena.find())
                                  out.println("<h3>Los emails no empiezan por www</h3>");

                                // compruebo que contenga @
                                buscar = Pattern.compile("@");
                                cadena = buscar.matcher(compEmail);
                                if (!cadena.find())
                                  out.println("<h3>La cadena no tiene arroba</h3>");

                                // compruebo que no contenga caracteres prohibidos	
                                buscar = Pattern.compile("[^A-Za-z0-9.@_-~#]+");
                                cadena = buscar.matcher(compEmail);
                                StringBuffer sb = new StringBuffer();
                                boolean resultado = cadena.find();
                                boolean caracteresIlegales = false;

                                while(resultado) {
                                   caracteresIlegales = true;
                                   cadena.appendReplacement(sb, "");
                                   resultado = cadena.find();
                                }

                                // Añado el ultimo segmento de la entrada a la cadena
                                cadena.appendTail(sb);

                                compEmail = sb.toString();

                                if (caracteresIlegales) {
                                   out.println("<h3>La cadena contiene caracteres ilegales<h/3>");
                                }
                            }*/
       
                        } else {
                            out.println("<h3>Introduzca una descripción.</h3>");
                        }
                    } else {
                        %>  <h3>Introduzca su nombre.</h3>  <%
                    }                
                }
            }
        %>
        
        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    </body>
</html>
