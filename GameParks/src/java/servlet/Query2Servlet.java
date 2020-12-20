package servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.Entrada;
import logica.controladora.ManagerControl;

@WebServlet(name = "Query2Servlet", urlPatterns = {"/Query2Servlet"})
public class Query2Servlet extends HttpServlet {
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
        String juego = request.getParameter("juegoReport");
        String anio = request.getParameter("anio");
        String mes = request.getParameter("mes");
        String dia = request.getParameter("dia");
        String fecha = anio + "-" + mes + "-" + dia;
        int cantEnt = 0;
        List<Entrada> listEnt = manager.getCent().traerEntradas();
        for (Entrada ele : listEnt){
            if(ele.getFecha().equals(fecha) && 
               ele.getJuego().getNombre().equals(juego)){
                cantEnt++;
            }
        }
        request.getSession().setAttribute("resulQ2", "Cantidad de entradas Vendidas " + " " + " " + String.valueOf(cantEnt) + " en el día :" +
                " " + "  " + fecha + "  " + "  " + " Con el Juego :" + "  " + "  " + juego);
        response.sendRedirect("Query2.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
