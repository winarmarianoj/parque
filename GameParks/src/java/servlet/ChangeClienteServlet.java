package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        manager.getCcli().getCli().setNombre(request.getParameter("nombreCliente"));
        manager.getCcli().getCli().setApellido(request.getParameter("apellidoCliente"));
        manager.getCcli().getCli().setDni(request.getParameter("dniCliente"));
        manager.getCcli().getCli().setTelefono(request.getParameter("telefonoCliente"));
        manager.getCcli().getCli().setMail(request.getParameter("mailCliente"));
        
        if(manager.getCcli().creaCliente(manager.getCcli().getCli())){
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
