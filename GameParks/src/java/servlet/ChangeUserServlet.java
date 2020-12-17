package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        manager.getCusu().getUsuario().setNombre(request.getParameter("changeNameUser")); 
        manager.getCusu().getUsuario().setContrasenia(request.getParameter("changePassword"));
        manager.getCusu().getUsuario().setConectado(true);
        if(manager.getCusu().modifUsuario(manager.getCusu().getUsuario())){
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
