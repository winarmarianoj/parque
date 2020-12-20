package servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.Cliente;
import logica.Empleado;
import logica.Juego;
import logica.controladora.ManagerControl;

@WebServlet(name = "InputServlet", urlPatterns = {"/InputServlet"})
public class InputServlet extends HttpServlet {
    ManagerControl manager = ManagerControl.getInstante();
    private Cliente clientito = null;

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
        
        // Traigo a los objetos Empleado y Juegos
        int idGame = Integer.parseInt(request.getParameter("idGame"));
        int idEmp = Integer.parseInt(request.getParameter("idEmployee"));
        Juego juego = manager.getCjue().traerJuegoEnParticular(idGame);
        Empleado empleado = manager.getCemp().traerEmpleadoEnParticular(idEmp);   
        
        // Creación del Cliente        
        String n = request.getParameter("nameClient");
        String a = request.getParameter("lastNameClient");
        
        // Verifico si ya existe o no el Cliente en BD
        if(!searchClient(n,a)){
            manager.getCcli().getCli().setNombre(n);
            manager.getCcli().getCli().setApellido(a);
            manager.getCcli().getCli().setDni(request.getParameter("dniClient"));
            manager.getCcli().getCli().setTelefono(request.getParameter("phoneClient"));
            manager.getCcli().getCli().setMail(request.getParameter("emailClient"));            
            
            try{
                manager.getCcli().creaCliente(manager.getCcli().getCli());
                result = true;                
            }catch(Exception e){
                manager.getErrors().logError(e.getMessage());
            }
            
            Cliente cliAux = searchNewClient(manager.getCcli().getCli());
            result = createEntrada(juego,empleado,cliAux);
        }else{
            result = createEntrada(juego,empleado,clientito);
        }
        
        // Informo resultados
        
        if(result){
            request.getSession().setAttribute("resultado", 
                    "Los Datos Ingresados al Crear el Cliente y Entrada son correctos!");
            response.sendRedirect("Respuestas.jsp");
        } else{
            request.getSession().setAttribute("resultado", 
                    "Los Datos ingresados de Cliente y Entrada son inválidos.");
            response.sendRedirect("Respuestas.jsp");
        }       
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private Cliente searchNewClient(Cliente cli) {
        List<Cliente> listCli = manager.getCcli().traerCliente();
        Cliente clientito = null;
        for (Cliente ele : listCli){
            if(ele.getNombre().equals(cli.getNombre()) && ele.getApellido().equals(cli.getApellido())){
                clientito = ele;
            }
        }
        return clientito;
    }

    private boolean searchClient(String n, String a) {
        boolean isExist = false;
        List<Cliente> listCli = manager.getCcli().traerCliente();
        for (Cliente e : listCli){
            if(e.getNombre().equals(n) && e.getApellido().equals(a)){
                clientito = e;
                isExist = true;
            }
        }
        return isExist;
    }

    private boolean createEntrada(Juego juego, Empleado empleado, Cliente cli) {
        boolean good = false;
        LocalDate dia = LocalDate.now();   
        String fecha = dia.toString();
        
        manager.getCent().getEnt().setCliente(cli);
        manager.getCent().getEnt().setEmpleado(empleado);
        manager.getCent().getEnt().setJuego(juego);
        manager.getCent().getEnt().setFecha(fecha);
        
        try{
            manager.getCent().creaEntrada(manager.getCent().getEnt());
            good = true;
        } catch(Exception e){
            manager.getErrors().logError(e.getMessage());
        }
        return good;
    }    

}
