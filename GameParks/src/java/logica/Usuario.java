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
    String contrasenia;
    boolean conectado;

    public Usuario() {
    }
    public Usuario(String nombre, String contraseña, boolean conectado){
        this.nombre = nombre;
        this.contrasenia = contrasenia;
        this.conectado = conectado;
    }

    public Usuario(int usuario_id, String nombre, String contrasenia, boolean conectado) {
        this.usuario_id = usuario_id;
        
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

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public boolean isConectado() {
        return conectado;
    }

    public void setConectado(boolean conectado) {
        this.conectado = conectado;
    }
    
    public void logueoEmpleado() {
        setConectado(true);
    }
    
    public void logoutEmpleado(){
        setConectado(false);
    }
        
}
