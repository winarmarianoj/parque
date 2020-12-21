package logica.controladora;

import logica.Usuario;
import persistencia.ControlaPersisUsuario;
import java.util.List;
import logica.logger.Errors;
import logica.excepciones.UsuarioException;
import logica.validador.Validar;

public class ControlUsuario {
    
    private final ControlaPersisUsuario cusu;
    private final Validar validusu;
    private final Errors errors;
    private final Usuario usuario;
    
    public ControlUsuario(Validar validaUsuario, ControlaPersisUsuario cusu, Errors errors, Usuario usu) {
        this.cusu = cusu;
        this.validusu = validaUsuario;
        this.errors = errors;
        this.usuario = usu;
    }    
    
    //Crea Usuario
    public boolean creaUsuario(Usuario usu) throws UsuarioException{        
        boolean res = false;
        try{
            if(!searchUsuario(usu)){
                if(validusu.validUser(usu)){
                    res = cusu.createUsuario(usu);
                }
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
    
    private boolean searchUsuario(Usuario usu){
        boolean res = false;
        List<Usuario> listUsu = traerUsuario();
        for(Usuario element : listUsu){
            if(element.getNombre().equals(usu.getNombre())){
                res = true;
                break;
            }
        }
        return res;
    }    

    public Usuario getUsuario() {
        return usuario;
    }
    
}
