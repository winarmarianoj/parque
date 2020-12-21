package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.Usuario;
import logica.controladora.ManagerControl;

@WebServlet(name = "LogoutServlet", urlPatterns = {"/LogoutServlet"})
public class LogoutServlet extends HttpServlet {
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
        String name = String.valueOf(request.getParameter("usuLogout"));
        boolean res = false;
        List<Usuario> usuList = manager.getCusu().traerUsuario();
        for(Usuario ele : usuList){
            if(ele.getNombre().equals(name)){
                ele.setConectado(false);
                manager.getCusu().modifUsuario(ele);
                res = true;
                break;
            }
        }
        if(res){
            request.getSession().setAttribute("resLogReg", "Se ha desconectado correctamente!");
            response.sendRedirect("ResLogRes.jsp");
        } else{
            request.getSession().setAttribute("resLogReg", "No se desconcetaaaaaaaaa.");
            response.sendRedirect("ResLogRes.jsp");
        }
        
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
