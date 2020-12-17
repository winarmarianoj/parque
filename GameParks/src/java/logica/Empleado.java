package logica;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Empleado implements Serializable{
    
    @Id
    @GeneratedValue (strategy=GenerationType.SEQUENCE)
    int empleado_id; 
    
    @Basic
    String nombre;
    String apellido;
    
    @OneToOne
    Usuario usuario;    

    public Empleado() {
    }
    public Empleado(String n, String a){
        this.nombre = n;
        this.apellido = a;
    }

    public Empleado(int empleado_id, String nombre, String apellido, Usuario usuario) {
        this.empleado_id = empleado_id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.usuario = usuario;
    }

    public int getEmpleado_id() {
        return empleado_id;
    }

    public void setEmpleado_id(int empleado_id) {
        this.empleado_id = empleado_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }    
    
}
