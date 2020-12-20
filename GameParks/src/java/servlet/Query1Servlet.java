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

@WebServlet(name = "Query1Servlet", urlPatterns = {"/Query1Servlet"})
public class Query1Servlet extends HttpServlet {
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
        String anio = request.getParameter("anio");
        String mes = request.getParameter("mes");
        String dia = request.getParameter("dia");
        String fecha = anio + "-" + mes + "-" + dia;
        int cantEntradas = 0;
        List<Entrada> listEnt = manager.getCent().traerEntradas();
        for (Entrada element : listEnt){
            if(element.getFecha().equals(fecha)){
                cantEntradas++;
            }
        }
        request.getSession().setAttribute("resulQ1", "Fecha : " + "  " + " " + fecha + "  " + 
                "  " + " Cantidad de Entradas Vendidas : " + " " + String.valueOf(cantEntradas));
        response.sendRedirect("Query1.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
