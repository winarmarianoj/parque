package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.Cliente;
import logica.Empleado;
import logica.Entrada;
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
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        boolean resul = false;
        
        // Traigo los componentes
        Entrada ent = manager.getCent().traerEntradaEnParticular(Integer.parseInt(request.getParameter("idEntrada")));        
        Cliente cliente = manager.getCcli().traerClienteEnParticular(Integer.parseInt(request.getParameter("idCliEntrada")));
        Empleado empleado = manager.getCemp().traerEmpleadoEnParticular(Integer.parseInt(request.getParameter("idEmpEntrada")));
        Juego juego = manager.getCjue().traerJuegoEnParticular(Integer.parseInt(request.getParameter("idJueEntrada")));
        
        //Asigno cada uno a la entrada segun ID
        ent.setCliente(cliente);
        ent.setEmpleado(empleado);
        ent.setJuego(juego);
        
        try{
            manager.getCent().modifEntrada(ent);
            resul = true;
        } catch(Exception e){
            manager.getErrors().logError(e.getMessage());
        }
        
        //Envio resultados
        if(resul){
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
