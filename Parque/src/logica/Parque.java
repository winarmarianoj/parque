package logica;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import logica.controladora.ManagerControl;
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
                       
       /* 
        ControladoraFactory factory = new ControladoraFactory();
        
        Usuario usu1 = new Usuario();
        usu1.setNombre("ADSFSFSF");
        usu1.setContrasenia("DDDDDDDDDDDDD");
        usu1.setConectado(false);
        
        
        ControlUsuario cusu = factory.createControlUsuario();
        if(cusu.creaUsuario(usu1)){
            System.out.println("AGREGO EL USUARIO");
        } else {
            System.out.println("NO USUARIO");
        }        
        

        Empleado emp1 = new Empleado();
        emp1.setNombre("AAAAAAA");
        emp1.setApellido("BBBBBBBBBBB");
        emp1.setUsuario(usu1); 
        
        
        ControlEmpleado cemp = factory.createControlEmpleado();
        if(cemp.creaEmpleado(emp1)){
            System.out.println("AGREGO EL EMPLEADO");
        } else {
            System.out.println("NO EMPLEADO");
        }
        
        
        Cliente cli1 = new Cliente();
        cli1.setNombre("SFSDFFF");
        cli1.setApellido("FSDFSDFSLoco");
        cli1.setTelefono("11-2322-3333");
        cli1.setMail("algoSS@jjj.com");
        cli1.setDni("11222333");
        
        
        ControlCliente ccli = factory.createControlCliente();
        if(ccli.creaCliente(cli1)){
            System.out.println("AGREGO EL CLIENTE");
        } else {
            System.out.println("NO CLIENTE");
        }
        
        
        
        Juego juego1 = new Juego();
        juego1.setNombre("tFSDFSFSFSobogan");
        juego1.setEdadMinima("2");
        juego1.setCapacidad("35");
        juego1.setCategoria("sector1");        
        
        List<Empleado> listEmp = new ArrayList<>();
        listEmp.add(emp1);
        
        juego1.setListaEmpleado(listEmp);
        
        
        ControlJuego cjue = factory.createControlJuego();
        if(cjue.creaJuego(juego1)){
            System.out.println("AGREGO EL JUEGO");
        } else {
            System.out.println("NO JUEGO");
        }
                

        Horario horario1 = new Horario();
        horario1.setHora_inicio("09");
        horario1.setHora_fin("11");
        
        List<Juego> listJuego = new ArrayList<>();
        listJuego.add(juego1);
        
        horario1.setListaJuegos(listJuego);
        
        
        ControlHorario cohor = factory.createControlHorario();
        if(cohor.creaHorario(horario1)){
            System.out.println("AGREGO EL HORARIO");
        } else {
            System.out.println("NO HORARIO");
        }
              
        
        Entrada entrada1 = new Entrada();
        entrada1.setCliente(cli1);
        entrada1.setEmpleado(emp1);
        entrada1.setJuego(juego1);
        LocalDate dia = LocalDate.now();   
        String prueba = dia.toString();
        entrada1.setFecha(prueba);             
       
        
        ControlEntrada centr = factory.createControlEntrada();
        if(centr.creaEntrada(entrada1)){
            System.out.println("AGREGO EL ENTRADA");
        } else {
            System.out.println("NO ENTRADA");
        }
        
        
        
        // PRIMER QUERY PEDIDO
        /*
        public int blabla( String dia)
        ControlEntrada centr = factory.createControlEntrada();
        int cantEntradas=0;
        List<Entrada> primeraLista = centr.traerEntradas();
        for (Entrada element : primeraLista){
            if(element.getFecha().equals("2020-12-10")){
                System.out.println(element.getCliente().getNombre() + 
                        element.getEmpleado().getNombre() + 
                        element.getJuego().getNombre());
                
                cantEntradas++;
            }
        Mostrar en pantalla de alguna manera esta cantidad de entradas vendidas segun el dia
        }
        
        // SEGUNDO QUERY PEDIDO
        public int (String dia, String empleado, String juego)
        
        ControlEntrada centr = factory.createControlEntrada();
        int cantEntradas=0;
        List<Entrada> primeraLista = centr.traerEntradas();
        for (Entrada element : primeraLista){
            if(element.getFecha().equals("2020-12-10") && 
                element.getEmpleado().getNombre().equals(empleado) &&
                element.getJuego().getNombre().equals(juego)){
                System.out.println(element.getCliente().getNombre() + 
                        element.getEmpleado().getNombre() + 
                        element.getJuego().getNombre());
                
                cantEntradas++;
            }
        Mostrar en pantalla de alguna manera esta cantidad de entradas vendidas segun el dia
        }
        
        //TERCER QUERY PEDIDO
       //public List<Empleado> segunJuego(String juego)
        ControladoraFactory factory = new ControladoraFactory();
        ControlJuego cjue = factory.createControlJuego();
        List<Juego> listaJuego = cjue.traerJuego();
        int idJuego=0;
        for (Juego element : listaJuego){
            if(element.getNombre().equals("tFSDFSFSFSobogan")){
                idJuego=element.getJuego_id();
            }
        }
        Juego jueguito = cjue.traerJuegoEnParticular(idJuego);
        for (Empleado elem : jueguito.getListaEmpleado()){
            System.out.println(elem.getNombre() + " " + elem.getApellido());
        }
        
        //Mostrar en pantalla de alguna manera esta cantidad de entradas vendidas segun el dia
        
        */
        
        
        
        
        
        
        
    }
    
}
