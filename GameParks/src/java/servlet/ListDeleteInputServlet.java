package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.Entrada;
import logica.controladora.ManagerControl;

@WebServlet(name = "ListDeleteInputServlet", urlPatterns = {"/ListDeleteInputServlet"})
public class ListDeleteInputServlet extends HttpServlet {

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
        List<Entrada> entradaList = manager.getCent().traerEntradas();
        request.getSession().setAttribute("entDeleteList", entradaList);
        response.sendRedirect("DeleteInput.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
