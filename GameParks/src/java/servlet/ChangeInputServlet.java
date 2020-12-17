package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.Cliente;
import logica.Empleado;
import logica.Juego;
import logica.controladora.ManagerControl;

@WebServlet(name = "ChangeInputServlet", urlPatterns = {"/ChangeInputServlet"})
public class ChangeInputServlet extends HttpServlet {
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
        manager.getCent().getEnt().setFecha(request.getParameter("fechaEntrada"));
        
        Cliente cliente = manager.getCcli().traerClienteEnParticular(Integer.parseInt(request.getParameter("idCliEntrada")));
        manager.getCent().getEnt().setCliente(cliente);
        Empleado empleado = manager.getCemp().traerEmpleadoEnParticular(Integer.parseInt(request.getParameter("idEmpEntrada")));        
        manager.getCent().getEnt().setEmpleado(empleado);
        Juego juego = manager.getCjue().traerJuegoEnParticular(Integer.parseInt(request.getParameter("idJueEntrada")));
        manager.getCent().getEnt().setJuego(juego);
        
        if(manager.getCent().creaEntrada(manager.getCent().getEnt())){
            request.getSession().setAttribute("resultado", "Los Datos Ingresados para cambiar una Entrada son correctos!");
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
