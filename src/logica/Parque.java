package logica;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import logica.controladora.ControlCliente;
import logica.controladora.ControlEmpleado;
import logica.controladora.ControlEntrada;
import logica.controladora.ControlHorario;
import logica.controladora.ControlJuego;
import logica.controladora.ControlUsuario;
import logica.excepciones.JuegoException;
import logica.excepciones.UsuarioException;
import logica.factory.ControladoraFactory;


public class Parque {
   
    public static void main(String[] args) throws UsuarioException, JuegoException {
        
        ControladoraFactory factory = new ControladoraFactory();
        
        Usuario usu = new Usuario();
        usu.setNombre("PRIMER");
        usu.setContrasenia("PRUEBA");
        
        
        ControlUsuario cusu = factory.createControlUsuario();
        if(cusu.creaUsuario(usu)){
            System.out.println("AGREGO EL USUARIO");
        } else {
            System.out.println("NO USUARIO");
        }        
        

        Empleado emp = new Empleado();
        emp.setNombre("Pepe");
        emp.setApellido("Argento");
        emp.setUsuario(usu);        
        
        ControlEmpleado cemp = factory.createControlEmpleado();
        if(cemp.creaEmpleado(emp)){
            System.out.println("AGREGO EL EMPLEADO");
        } else {
            System.out.println("NO EMPLEADO");
        }
        
        Cliente cli = new Cliente();
        cli.setNombre("Alguien");
        cli.setApellido("Loco");
        cli.setTelefono("11-2222-3333");
        cli.setMail("algo@jjj.com");
        
        ControlCliente ccli = factory.createControlCliente();
        if(ccli.creaCliente(cli)){
            System.out.println("AGREGO EL CLIENTE");
        } else {
            System.out.println("NO CLIENTE");
        }
        
        Juego juego = new Juego();
        juego.setNombre("tobogan");
        
        List<Empleado> listEmp = new ArrayList<>();
        listEmp.add(emp);
        
        juego.setListaEmpleado(listEmp);
        
        
        ControlJuego cjue = factory.createControlJuego();
        if(cjue.creaJuego(juego)){
            System.out.println("AGREGO EL JUEGO");
        } else {
            System.out.println("NO JUEGO");
        }
        
        Horario horario = new Horario();
        horario.setHora_inicio("17");
        horario.setHora_fin("18");
        
        List<Juego> listJuego = new ArrayList<>();
        listJuego.add(juego);
        
        horario.setListaJuegos(listJuego);
        
        
        ControlHorario cohor = factory.createControlHorario();
        if(cohor.creaHorario(horario)){
            System.out.println("AGREGO EL HORARIO");
        } else {
            System.out.println("NO HORARIO");
        }
       
        
     
        Entrada entrada = new Entrada();
        entrada.setCliente(cli);
        entrada.setEmpleado(emp);
        entrada.setJuego(juego);
        LocalDate dia = LocalDate.now();   
        String prueba = dia.toString();
        entrada.setFecha(prueba);
        
        ControlEntrada centr = factory.createControlEntrada();
        if(centr.creaEntrada(entrada)){
            System.out.println("AGREGO EL ENTRADA");
        } else {
            System.out.println("NO ENTRADA");
        }
        
        
        
    }
    
}
