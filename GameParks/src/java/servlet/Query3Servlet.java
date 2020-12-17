package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.Juego;
import logica.controladora.ManagerControl;

@WebServlet(name = "Query3Servlet", urlPatterns = {"/Query3Servlet"})
public class Query3Servlet extends HttpServlet {
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
        String juego = request.getParameter("juegoReports");
        List<Juego> listJuego = manager.getCjue().traerJuego();
        int cantEmp = 0;
        int idJue = 0;
        for(Juego elem : listJuego){
            if(elem.getNombre().equals(juego)){
                idJue = elem.getJuego_id();
            }
        }
        Juego jue = manager.getCjue().traerJuegoEnParticular(idJue);
        request.getSession().setAttribute("resulQ3", jue);
        response.sendRedirect("Query3.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
