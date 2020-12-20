package logica;

import java.io.Serializable;
import java.util.ArrayList;
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

    public Juego(int juego_id, String nombre, String edadMinima, String capacidad, String categoria, List<Empleado> listaEmpleado) {
        this.juego_id = juego_id;
        this.nombre = nombre;
        this.edadMinima = edadMinima;
        this.capacidad = capacidad;
        this.categoria = categoria;
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

    public String getEdadMinima() {
        return edadMinima;
    }

    public void setEdadMinima(String edadMinima) {
        this.edadMinima = edadMinima;
    }

    public String getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(String capacidad) {
        this.capacidad = capacidad;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    // METHODS AND FUNCTION GAME LIST
    
    public List<Empleado> getListaEmpleado() {
        if (listaEmpleado == null){listaEmpleado = new ArrayList<>();}
        return listaEmpleado;
    }

    public void addEmpleado(Empleado emp) {
        if (listaEmpleado == null){listaEmpleado = new ArrayList<>();}
        listaEmpleado.add(emp);
    }  
    public int listaEmpleadoSize(){
        if (listaEmpleado == null){listaEmpleado = new ArrayList<>();}
        return listaEmpleado.size();
    }
    public Empleado searchEmpleado(int index){
        if (index < 0 || index >= listaEmpleadoSize()){return null;}
        return listaEmpleado.get(index);
    }
    public boolean removeEmpleado(int index){
        if (index < 0 || index >= listaEmpleadoSize()){return false;}
        listaEmpleado.remove(index);
        return true;
    }
    
}
