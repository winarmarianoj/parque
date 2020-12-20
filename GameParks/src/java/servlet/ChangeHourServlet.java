package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.Horario;
import logica.controladora.ManagerControl;

@WebServlet(name = "ChangeHourServlet", urlPatterns = {"/ChangeHourServlet"})
public class ChangeHourServlet extends HttpServlet {
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
        Horario aux = manager.getChor().traerHorarioEnParticular(Integer.parseInt(request.getParameter("idHorario")));
        aux.setHora_inicio(request.getParameter("horaInicio"));
        aux.setHora_fin(request.getParameter("horaFin"));
        
        try{
            manager.getChor().modifHorario(aux);
            res = true;
        } catch(Exception e){
            manager.getErrors().logError(e.getMessage());
        }
        
        if(res){
            request.getSession().setAttribute("resultado", "Los Datos Ingresados para cambiar un Horario son correctos!");
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
