package logica.validador;

import logica.Cliente;
import logica.Empleado;
import logica.Entrada;
import logica.Juego;
import logica.excepciones.EntradaException;

public class ValidaEntrada {
    public boolean validaEntrada(Entrada ent) throws EntradaException{
        boolean res = validEmp(ent.getEmpleado());
        res &= validJue(ent.getJuego());
        res &= validCli(ent.getCliente());
        
        if(!res){throw new EntradaException();}
        return res;
    }

    private boolean validEmp(Empleado empleado) {
        return empleado != null;
    }
    private boolean validJue(Juego juego){
        return juego != null;
    }
    private boolean validCli(Cliente cliente){
        return cliente != null;
    }    
}
