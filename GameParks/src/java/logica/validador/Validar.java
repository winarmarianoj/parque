package logica.validador;

import logica.Cliente;
import logica.Empleado;
import logica.Horario;
import logica.Juego;
import logica.Usuario;
import logica.excepciones.ClienteException;
import logica.excepciones.EmpleadoException;
import logica.excepciones.HorarioException;
import logica.excepciones.JuegoException;
import logica.excepciones.UsuarioException;

public class Validar {
    
    public boolean validUser(Usuario usu) throws UsuarioException{
        boolean res = validaInfo(usu.getNombre());        
        res &= validaInfo(usu.getPass());
        
        if(!res){throw new UsuarioException();}
        
        return res;
    }
    
     public boolean validHorario(Horario horario) throws HorarioException{
        boolean res = validaInfo(horario.getHora_inicio());
        res &= validaInfo(horario.getHora_fin());
        
        if(!res){throw new HorarioException();}
        return res;
    }
    
    public boolean validJuego(Juego juego) throws JuegoException{
        boolean res = validaInfo(juego.getNombre());
        res &= validaInfo(juego.getEdadMinima());
        res &= validaInfo(juego.getCapacidad());
        res &= validaInfo(juego.getCategoria());
        
        if(!res){throw new JuegoException();}
        return res;
    }    
    
    public boolean validaEmpleado(Empleado emp) throws EmpleadoException{
        boolean res = validaInfo(emp.getNombre());
        res &= validaInfo(emp.getApellido());
        
        if(!res){throw new EmpleadoException();}
        return res;
    }
    
     public boolean validaCliente(Cliente cliente) throws ClienteException{
        boolean res = validaInfo(cliente.getNombre());
        res &= validaInfo(cliente.getApellido());
        res &= validaInfo(cliente.getDni());
        
        if(!res){throw new ClienteException();}
        return res;
    }    

    private boolean validaInfo(String nombre) {
        return !nombre.isEmpty();
    }    
    
    
}
