package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.controladora.ManagerControl;
import logica.excepciones.EmpleadoException;
import logica.excepciones.UsuarioException;

@WebServlet(name = "UserServlet", urlPatterns = {"/UserServlet"})
public class UserServlet extends HttpServlet {
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
        boolean conectado = false;
        boolean resultado = false;
        manager.getCusu().getUsuario().setNombre(request.getParameter("nameUser"));
        manager.getCusu().getUsuario().setContrasenia(request.getParameter("passUser"));        
        manager.getCusu().getUsuario().setConectado(conectado);
        
        try {
            if(manager.getCusu().creaUsuario(manager.getCusu().getUsuario())){resultado = true;}
        } catch (UsuarioException ex) {
            manager.getErrors().logError(ex.getMessage());            
        }    
        manager.getCemp().getEmp().setNombre(request.getParameter("nameEmployee"));
        manager.getCemp().getEmp().setApellido(request.getParameter("lastNameEmployee"));
        
        if(manager.getCemp().creaEmpleado(manager.getCemp().getEmp())){resultado = true;}
        
        if(resultado){
            request.getSession().setAttribute("resLogReg", "Los Datos de Usuario y Empleado ingresados son correctos!");
            response.sendRedirect("ResLogRes.jsp");
        } else{
            request.getSession().setAttribute("resLogReg", "Datos ingresados inválidos.");
            response.sendRedirect("ResLogRes.jsp");
        }
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
