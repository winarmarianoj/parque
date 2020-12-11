package logica;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Juego implements Serializable {
    
    @Id
    @GeneratedValue (strategy=GenerationType.SEQUENCE)
    int juego_id;
    
    @Basic
    String nombre;
    String edadMinima;
    String capacidad;
    String categoria;	    
    
    @OneToMany
    List <Empleado> listaEmpleado;
   

    public Juego() {
    }

    public Juego(int juego_id, String nombre, List<Empleado> listaEmpleado) {
        this.juego_id = juego_id;
        this.nombre = nombre;
        this.listaEmpleado = listaEmpleado;
    }

    public int getJuego_id() {
        return juego_id;
    }

    public void setJuego_id(int juego_id) {
        this.juego_id = juego_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Empleado> getListaEmpleado() {
        return listaEmpleado;
    }

    public void setListaEmpleado(List<Empleado> listaEmpleado) {
        this.listaEmpleado = listaEmpleado;
    }

    
    
}
