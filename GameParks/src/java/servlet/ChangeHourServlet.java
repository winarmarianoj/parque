package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        manager.getChor().getHor().setHora_inicio(request.getParameter("horaInicio"));
        manager.getChor().getHor().setHora_fin(request.getParameter("horaFin"));
        if(manager.getChor().creaHorario(manager.getChor().getHor())){
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
