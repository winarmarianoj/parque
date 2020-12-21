package servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.Usuario;
import logica.controladora.ManagerControl;

@WebServlet(name = "ForgotServlet", urlPatterns = {"/ForgotServlet"})
public class ForgotServlet extends HttpServlet {
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
        String name = request.getParameter("nameUser");
        String pass1 = request.getParameter("pass1");
        String pass2 = request.getParameter("pass2");
        
        Usuario user = searchUser(name);
        
        if(pass1.equals(pass2)){
            user.setPass(pass1);
            manager.getCusu().modifUsuario(user);
            request.getSession().setAttribute("resLogReg", "Los Datos Ingresados para cambiar Su Contraseña son correctos!");
            response.sendRedirect("ResLogRes.jsp");            
        }else{
            request.getSession().setAttribute("resLogReg", "Los Datos Ingresados son incorrectos!");
            response.sendRedirect("ResLogRes.jsp");            
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private Usuario searchUser(String name) {
        List<Usuario> listUs = manager.getCusu().traerUsuario();
        Usuario aux = null;
        for(Usuario ele : listUs){
            if(ele.getNombre().equals(name)){
                aux = ele;
            }
        }
        return aux;
    }

}
