package logica.controladora;

import java.util.List;
import logger.Errors;
import logica.Cliente;
import logica.Juego;
import logica.excepciones.ClienteException;
import logica.excepciones.JuegoException;
import logica.validador.ValidaCliente;
import persistencia.ControlPersisCliente;

public class ControlCliente {
    
    private final ControlPersisCliente ccli;
    private final ValidaCliente vcli;
    private final Errors errors;

    public ControlCliente(ValidaCliente vcli, ControlPersisCliente ccli, Errors errors) {
        this.ccli = ccli;
        this.vcli = vcli;
        this.errors = errors;
    }
    
    //Crea Cliente
    public boolean creaCliente(Cliente cli) {
        boolean res = false;        
        try{
            if(vcli.validaCliente(cli)){
            res = ccli.createCliente(cli);
            }
        } catch(ClienteException e){
            errors.logError(e.getMessage());
        }         
        return res;
    }
    
    //Modifica Cliente
    public boolean modifCliente(Cliente cli){
        return ccli.modifCliente(cli);
    }
    
    //Elimina Cliente
    public boolean eliminaCliente(int cliId){
        return ccli.eliminaCliente(cliId);
    }

    //Devuelve la Lista de Clientes
    public List<Cliente> traerCliente() {
        return ccli.traerCliente();
    }

    //Devuelve a un Cliente en Particular
    public Cliente traerClienteEnParticular(int id) {
        return ccli.traerUnCliente(id);
    }    
}
