package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.Cliente;
import logica.controladora.ManagerControl;

@WebServlet(name = "ChangeClienteServlet", urlPatterns = {"/ChangeClienteServlet"})
public class ChangeClienteServlet extends HttpServlet {
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
        Cliente aux = manager.getCcli().traerClienteEnParticular(Integer.parseInt(request.getParameter("idchangeCliente")));
        aux.setNombre(request.getParameter("nombreCliente"));
        aux.setApellido(request.getParameter("apellidoCliente"));
        aux.setDni(request.getParameter("dniCliente"));
        aux.setTelefono(request.getParameter("telefonoCliente"));
        aux.setMail(request.getParameter("mailCliente"));
        
        try{
            manager.getCcli().modifCliente(aux);
            res = true;
        }catch(Exception e){
            manager.getErrors().logError(e.getMessage());
        }
                
        if(res){
            request.getSession().setAttribute("resultado", "Los Datos Ingresados para cambiar un Cliente son correctos!");
            response.sendRedirect("Respuestas.jsp");
        } else{
           request.getSession().setAttribute("resultado", "Los Datos Ingresados son incorrectos.");
           response.sendRedirect("Respuestas.jsp");
        }
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
