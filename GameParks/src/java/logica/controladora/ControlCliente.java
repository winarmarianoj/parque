package logica.controladora;

import java.util.List;
import logica.logger.Errors;
import logica.Cliente;
import logica.excepciones.ClienteException;
import logica.validador.Validar;
import persistencia.ControlPersisCliente;

public class ControlCliente {
    
    private final ControlPersisCliente ccli;
    private final Validar vcli;
    private final Errors errors;
    private final Cliente cli;

    public ControlCliente(Validar vcli, ControlPersisCliente ccli, Errors errors, Cliente cli) {
        this.ccli = ccli;
        this.vcli = vcli;
        this.errors = errors;
        this.cli = cli;
    }
    
    //Crea Cliente
    public boolean creaCliente(Cliente cli) {
        boolean res = false;        
        try{
            if(!searchCliente(cli)){
                if(vcli.validaCliente(cli)){
                    res = ccli.createCliente(cli);
                }
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
    
    private boolean searchCliente(Cliente cli){
        boolean res = false;
        List<Cliente> listCliente = traerCliente();
        for(Cliente element : listCliente){
            if(element.getDni().equals(cli.getDni())){
                res = true;
                break;
            }
        }
        return res;
    }

    public Cliente getCli() {
        return cli;
    }   
    
}
