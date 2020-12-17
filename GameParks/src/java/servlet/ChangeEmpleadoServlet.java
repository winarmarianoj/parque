package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.controladora.ManagerControl;

@WebServlet(name = "ChangeEmpleadoServlet", urlPatterns = {"/ChangeEmpleadoServlet"})
public class ChangeEmpleadoServlet extends HttpServlet {
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
        manager.getCemp().getEmp().setNombre(request.getParameter("changeNameEmpleado"));
        manager.getCemp().getEmp().setApellido(request.getParameter("changeApellidoEmpleado"));
        if(manager.getCemp().creaEmpleado(manager.getCemp().getEmp())){
            request.getSession().setAttribute("resultado", "Los Datos Ingresados para el Cambio de un Empleado son correctos!");
            response.sendRedirect("Respuestas.jsp");
        }else{
            request.getSession().setAttribute("resultado", "Los Datos Ingresados son incorrectos.");
            response.sendRedirect("Respuestas.jsp");
        }
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
