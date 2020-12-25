package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.Horario;
import logica.controladora.ManagerControl;

@WebServlet(name = "ListDeleteHourServlet", urlPatterns = {"/ListDeleteHourServlet"})
public class ListDeleteHourServlet extends HttpServlet {

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
        List<Horario> horaList = manager.getChor().traerHorario();
        request.getSession().setAttribute("horaDeleteList", horaList);
        response.sendRedirect("DeleteHour.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
