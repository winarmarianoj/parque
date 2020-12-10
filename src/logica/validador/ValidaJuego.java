package logica.validador;

import logica.Juego;
import logica.excepciones.JuegoException;

public class ValidaJuego {
    
    public boolean validJuego(Juego juego) throws JuegoException{
        boolean res = validNombre(juego.getNombre());
        
        if(!res){throw new JuegoException();}
        return res;
    }

    private boolean validNombre(String nombre) {
        return !nombre.isEmpty();
    }
    
}
