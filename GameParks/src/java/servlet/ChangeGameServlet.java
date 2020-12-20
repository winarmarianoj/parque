package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.Juego;
import logica.controladora.ManagerControl;

@WebServlet(name = "ChangeGameServlet", urlPatterns = {"/ChangeGameServlet"})
public class ChangeGameServlet extends HttpServlet {
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
        boolean res = false;
        Juego aux = manager.getCjue().traerJuegoEnParticular(Integer.parseInt(request.getParameter("idJuego")));
        aux.setNombre(request.getParameter("nombreJuego"));
        aux.setEdadMinima(request.getParameter("edadMinimaJuego"));
        aux.setCapacidad(request.getParameter("cantidadPersonas"));
        aux.setCategoria(request.getParameter("categoriaJuego"));        
        
        try {
            manager.getCjue().modifJuego(aux);
            res = true;
        } catch (Exception ex) {
            manager.getErrors().logError(ex.getMessage());
        }
            
        if(res){
            request.getSession().setAttribute("resultado", "Los Datos Ingresados del Cambio de un Juego son correctos!");
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
