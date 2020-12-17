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
import logica.excepciones.JuegoException;

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
        try {
            manager.getCjue().getJue().setNombre(request.getParameter("nombreJuego"));
            manager.getCjue().getJue().setEdadMinima(request.getParameter("edadMinimaJuego"));
            manager.getCjue().getJue().setCapacidad(request.getParameter("cantidadPersonas"));
            manager.getCjue().getJue().setCategoria(request.getParameter("categoriaJuego"));
            
            if(manager.getCjue().creaJuego(manager.getCjue().getJue())){
                request.getSession().setAttribute("resultado", "Los Datos Ingresados del Cambio de un Juego son correctos!");
                response.sendRedirect("Respuestas.jsp");
            }else{
                request.getSession().setAttribute("resultado", "Los Datos Ingresados son incorrectos.");
                response.sendRedirect("Respuestas.jsp");
            }
        } catch (JuegoException ex) {
            manager.getErrors().logError(ex.getMessage());
        }
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
