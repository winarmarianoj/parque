package logica.validador;

import logica.Contacto;
import logica.excepciones.ContactoException;

public class ValidaContacto {
    
    public boolean validaContacto(Contacto con) throws ContactoException{
        boolean res = validTelefono(con.getTelefono());
        res &= validMail(con.getMail());
        res &= validDom(con.getDomicilio());
        
        if(!res){throw new ContactoException();}
        
        return res;
    }

    private boolean validTelefono(String telefono) {
        return !telefono.isEmpty() && telefono != null;
    }
    private boolean validMail(String mail){
        return !mail.isEmpty() && mail != null;
    }
    private boolean validDom(String dom){
        return !dom.isEmpty() && dom != null;
    }
}
