package logica;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuario {
    @Id
    @GeneratedValue (strategy=GenerationType.SEQUENCE)
    int usuario_id;
    
    @Basic
    String nombre;
    String pass;
    boolean conectado;

    public Usuario() {
    }

    public Usuario(String nombre, String pass, boolean conectado) {        
        this.nombre = nombre;
        this.pass = pass;
        this.conectado = conectado;
    }  
    
    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }   

    public boolean isConectado() {
        return conectado;
    }

    public void setConectado(boolean conectado) {
        this.conectado = conectado;
    }   
    
        
}
