package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.Empleado;
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
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        boolean res = false;
        Empleado aux = manager.getCemp().traerEmpleadoEnParticular(Integer.parseInt(request.getParameter("changeIDEmpleado")));
        aux.setNombre(request.getParameter("changeNameEmpleado"));
        aux.setApellido(request.getParameter("changeApellidoEmpleado"));
        
        try{
            manager.getCemp().modifEmpleado(aux);
            res = true;
        }catch(Exception e){
            manager.getErrors().logError(e.getMessage());
        }
                
        if(res){
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
