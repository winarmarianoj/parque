package logica.validador;

import logica.Usuario;
import logica.excepciones.UsuarioException;

public class ValidaUsuario {
    
    public boolean validUser(Usuario usu) throws UsuarioException{
        boolean res = validNombre(usu.getNombre());
        res &= validPass(usu.getContrasenia());
        
        if(!res){throw new UsuarioException();}
        return res;
    }

    private boolean validNombre(String nombre) {
        return !nombre.isEmpty() && nombre != null;
    }
    private boolean validPass(String pass){
        return !pass.isEmpty() && pass != null;
    }
}
