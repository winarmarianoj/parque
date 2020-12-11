package persistencia;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Usuario;
import persistencia.JPA.UsuarioJpaController;
import persistencia.exceptions.NonexistentEntityException;

public class ControlaPersisUsuario {

    public ControlaPersisUsuario() { }
    
    UsuarioJpaController usuJpa = new UsuarioJpaController();

    /* CREA AL USUARIO */
    public boolean createUsuario(Usuario usu) {
        return usuJpa.create(usu);
    }

    /* MODIFICA AL USUARIO */
    public boolean modifUsu(Usuario usu) {
        boolean res = false;
        try {
            res = usuJpa.edit(usu);
        } catch (Exception ex) {
            Logger.getLogger(ControlaPersisUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    /* ELIMINA AL USUARIO */
    public boolean eliminaUsu(int usuId) {
        boolean res = false;
        try {
            res = usuJpa.destroy(usuId);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControlaPersisUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    /* DEVUELVE LA LISTA DE USUARIOS */
    public List<Usuario> traerUsuario() {
        return usuJpa.findUsuarioEntities();
    }

    /*DEVUELVE A UN USUARIO EN PARTICULAR */
    public Usuario traerUnUsuario(int id) {
        return usuJpa.findUsuario(id);
    }
    
}
