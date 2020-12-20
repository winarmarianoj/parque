package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.controladora.ManagerControl;

@WebServlet(name = "DeleteInputServlet", urlPatterns = {"/DeleteInputServlet"})
public class DeleteInputServlet extends HttpServlet {
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
        int id = Integer.parseInt(request.getParameter("idDeleteEntrada"));
        try{
            manager.getCent().eliminaEntrada(id);
            res = true;
        }catch(Exception ex){
            manager.getErrors().logError(ex.getMessage());
        }
        if(res){
            request.getSession().setAttribute("resultado", "La Entrada ha sido eliminado!");
            response.sendRedirect("Respuestas.jsp");
        }else{           
            request.getSession().setAttribute("resultado", "No puede eliminarse.");
            response.sendRedirect("Respuestas.jsp");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
