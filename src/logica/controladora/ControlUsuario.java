package logica.controladora;

import java.io.IOException;
import logica.Usuario;
import persistencia.ControlaPersisUsuario;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.List;
import logger.Errors;
import logica.excepciones.UsuarioException;
import logica.validador.ValidaUsuario;

public class ControlUsuario {
    
    private final ControlaPersisUsuario cusu;
    private final ValidaUsuario validusu;
    private final Errors errors;
    
    public ControlUsuario(ValidaUsuario validaUsuario, ControlaPersisUsuario cusu, Errors errors) {
        this.cusu = cusu;
        this.validusu = validaUsuario;
        this.errors = errors;
    }
    
    //Crea Usuario
    public boolean creaUsuario(Usuario usu) throws UsuarioException{
        boolean res = false;        
        try{
            if(validusu.validUser(usu)){
            res = cusu.createUsuario(usu);
            }
        } catch(UsuarioException e){
            errors.logError(e.getMessage());
        }         
        return res;
    }
    
    //Modifica Usuario
    public boolean modifUsuario(Usuario usu){
        return cusu.modifUsu(usu);
    }
    
    //Elimina Usuario
    public boolean eliminaUsu(int usuId){
        return cusu.eliminaUsu(usuId);
    }

    //Devuelve la Lista de Usuario
    public List<Usuario> traerUsuario() {
        return cusu.traerUsuario();
    }

    //Devuelve a un Usuario en Particular
    public Usuario traerUsuarioEnParticular(int id) {
        return cusu.traerUnUsuario(id);
    }


}
