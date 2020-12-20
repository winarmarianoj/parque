package servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.Empleado;
import logica.Horario;
import logica.controladora.ManagerControl;
import logica.excepciones.HorarioException;
import logica.excepciones.JuegoException;

@WebServlet(name = "GamesServlet", urlPatterns = {"/GamesServlet"})
public class GamesServlet extends HttpServlet {
    ManagerControl manager = ManagerControl.getInstante();
    private Horario hora = null;

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
        boolean result = false;   
        
        //Objeto empleado
        Empleado empleado = manager.getCemp().traerEmpleadoEnParticular(Integer.parseInt(request.getParameter("idEmp")));
        
        // Datos del juego
        manager.getCjue().getJue().setNombre(request.getParameter("gameName"));
        manager.getCjue().getJue().setEdadMinima(request.getParameter(String.valueOf("edadMinima")));
        manager.getCjue().getJue().setCapacidad(request.getParameter(String.valueOf("capacidadPersonas")));
        manager.getCjue().getJue().setCategoria(request.getParameter("categoria"));

        //Agrego empleado a la lista en juego            
        manager.getCjue().getJue().addEmpleado(empleado);
        
        // Creo el objeto Juego nuevo
        try{
            manager.getCjue().creaJuego(manager.getCjue().getJue());
            result = true;
        }catch (JuegoException ex) {
            manager.getErrors().logError(ex.getMessage());
        }
        

        // Datos del horario nuevo
        String ini = request.getParameter("horaInicio");
        String fin = request.getParameter("horaFin");        
        
        // Verifico si el horario ya existe o no
        if(!searchHorario(ini,fin)){
            manager.getChor().getHor().setHora_inicio(ini);
            manager.getChor().getHor().setHora_fin(fin);
            //Agrego Juego a la lista de horario            
            manager.getChor().getHor().addJuegos(manager.getCjue().getJue());
            // Creo Horario nuevo
            manager.getChor().creaHorario(manager.getChor().getHor());
            result = true;            
        } else{
            hora.addJuegos(manager.getCjue().getJue());
            manager.getChor().modifHorario(hora);
        } 
        
        // Informo resultados
        if(result){
            request.getSession().setAttribute("resultado", 
                    "Los Datos Ingresados al Crear un Horario y Juego nuevo son correctos!");
            response.sendRedirect("Respuestas.jsp");
        } else{
            request.getSession().setAttribute("resultado", 
                    "Los Datos ingresados de Horario y Juego son inválidos.");
            response.sendRedirect("Respuestas.jsp");
        }       
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private boolean searchHorario(String ini, String fin) {
        boolean res = false;
        List<Horario> listHor = manager.getChor().traerHorario();
        for (Horario ele : listHor){
            if(ele.getHora_inicio().equals(ini) && ele.getHora_fin().equals(fin)){
                hora = ele;
                res = true;
            }
        }
        return res;
    }


}
