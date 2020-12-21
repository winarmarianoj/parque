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
import logica.excepciones.UsuarioException;

@WebServlet(name = "UserServlet", urlPatterns = {"/UserServlet"})
public class UserServlet extends HttpServlet {
    ManagerControl manager = ManagerControl.getInstante();    
    private Usuario usuario = null;

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
        boolean conectado = false;
        boolean resultado = false;
        
        // Tomo datos
        String nameUsu = request.getParameter("nameUser");
        String pass = String.valueOf(request.getParameter("passUser1"));	
        String nameEmp = request.getParameter("nameEmployee");
        String apeEmp = request.getParameter("lastNameEmployee");
        
        // Creo un Usuario        
        
        // Verifico si existe el Usuario o no
        if(!searchUsu(nameUsu)){
            manager.getCusu().getUsuario().setNombre(nameUsu);
            manager.getCusu().getUsuario().setPass(pass);
            manager.getCusu().getUsuario().setConectado(conectado);
            
            try {
                manager.getCusu().creaUsuario(manager.getCusu().getUsuario());         
                resultado = true;
            } catch (UsuarioException ex) {
                manager.getErrors().logError(ex.getMessage());            
            }
            Usuario uss = takeUsu(nameUsu);
            resultado = createEmpleado(nameEmp, apeEmp, uss);
            
        }else{
            resultado = createEmpleado(nameEmp, apeEmp, usuario);
        }
                
        // Informo los resultados
        
        if(resultado){
            request.getSession().setAttribute("resLogReg", "Los Datos de Usuario y Empleado ingresados son correctos!");
            response.sendRedirect("ResLogRes.jsp");
        } else{
            request.getSession().setAttribute("resLogReg", "Datos ingresados inválidos.");
            response.sendRedirect("ResLogRes.jsp");
        }
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private boolean searchUsu(String nameUsu) {
        boolean isUsu = false;
        List<Usuario> listUsu = manager.getCusu().traerUsuario();
        for(Usuario ele : listUsu){
            if(ele.getNombre().equals(nameUsu)){
                usuario = ele;
                isUsu = true;
            }
        }
        return isUsu;
    }

    private Usuario takeUsu(String nameUsu) {
        Usuario u = null;
        List<Usuario> listUsu = manager.getCusu().traerUsuario();
        for(Usuario ele : listUsu){
            if(ele.getNombre().equals(nameUsu)){
                u = ele;
            }
        }
        return u;
    }

    private boolean createEmpleado(String nameEmp, String apeEmp, Usuario uss) {
        boolean resultado = false;
        
        // Creo un Empleado
        manager.getCemp().getEmp().setNombre(nameEmp);
        manager.getCemp().getEmp().setApellido(apeEmp);
        manager.getCemp().getEmp().setUsuario(uss);
        
        if(manager.getCemp().creaEmpleado(manager.getCemp().getEmp())){resultado = true;}
        
        return resultado;
    }

}
