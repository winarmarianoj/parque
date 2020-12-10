package logica.validador;

import logica.Cliente;
import logica.excepciones.ClienteException;

public class ValidaCliente {
    public boolean validaCliente(Cliente cliente) throws ClienteException{
        boolean res = validaNombre(cliente.getNombre());
        res &= validaApellido(cliente.getApellido());
        
        if(!res){throw new ClienteException();}
        return res;
    }

    private boolean validaNombre(String nombre) {
        return !nombre.isEmpty();
    }
    private boolean validaApellido(String apellido){
        return !apellido.isEmpty();
    }
}
