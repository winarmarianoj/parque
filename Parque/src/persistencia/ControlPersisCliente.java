package persistencia;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Cliente;
import persistencia.JPA.ClienteJpaController;
import persistencia.exceptions.NonexistentEntityException;

public class ControlPersisCliente {
    ClienteJpaController ccli = new ClienteJpaController();

    public boolean createCliente(Cliente cli) {
        return ccli.create(cli);
    }

    public boolean modifCliente(Cliente cli) {
        boolean res = false;
        try {
            if(ccli.edit(cli)){res=true;}
        } catch (Exception ex) {
            Logger.getLogger(ControlPersisCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    public boolean eliminaCliente(int cliId) {
        boolean res = false;
        try {
            if(ccli.destroy(cliId)){res=true;}
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControlPersisCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    public List<Cliente> traerCliente() {
        return ccli.findClienteEntities();
    }

    public Cliente traerUnCliente(int id) {
        return ccli.findCliente(id);
    }
    
}
