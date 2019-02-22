/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.logica.GestionUsuario;

/**
 *
 * @author USUARIO
 */
public class UsuariosServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        String nombre = request.getParameter("nombre");
        String edad = request.getParameter("edad");
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");

        GestionUsuario.TipoResultado resultado;
        resultado = GestionUsuario.getInstancia().guardarUsuario(nombre, edad, email, pass);
        switch (resultado) {
            case OK:
                request.getSession().setAttribute("persona1",
                        GestionUsuario.getInstancia().getUsuario());
                request.getRequestDispatcher("exito.jsp").forward(request, response);
                break;
            case SIN_VALORES:
                request.getRequestDispatcher("errorCampos.jsp").forward(request, response);
                break;
            case EDAD_MAL:
                request.getRequestDispatcher("errorNumero.jsp").forward(request, response);
                break;
            case ERR_IO:
                request.getRequestDispatcher("errorIO.jsp").forward(request, response);
                break;
            case EMAIL_MAL:
                request.getRequestDispatcher("errorEmail.jsp").forward(request, response);
                break;
        }
    }

    @Override
        public String getServletInfo() {
        return "Short description";
    }

}
