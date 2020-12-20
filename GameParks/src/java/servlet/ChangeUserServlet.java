package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.Usuario;
import logica.controladora.ManagerControl;

@WebServlet(name = "ChangeUserServlet", urlPatterns = {"/ChangeUserServlet"})
public class ChangeUserServlet extends HttpServlet {
    ManagerControl manager = ManagerControl.getInstante();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {       
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {        
        boolean resul = false;
        
        Usuario aux = manager.getCusu().traerUsuarioEnParticular(Integer.parseInt(request.getParameter("changeIdUser")));
        aux.setNombre(request.getParameter("changeNameUser"));
        try{
            manager.getCusu().modifUsuario(aux);
            resul = true;
        } catch(Exception e){
            manager.getErrors().logError(e.getMessage());
        }        
        
        if(resul){
            request.getSession().setAttribute("resultado", "Los Datos Ingresados del Cambio de Usuario son correctos!");
            response.sendRedirect("Respuestas.jsp");
        }else{           
            request.getSession().setAttribute("resultado", "Los Datos Ingresados son incorrectos!");
            response.sendRedirect("Respuestas.jsp");
        }
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
