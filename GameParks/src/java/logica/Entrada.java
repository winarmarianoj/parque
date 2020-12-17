package logica;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Entrada implements Serializable {
    
   @Id
   @GeneratedValue (strategy=GenerationType.SEQUENCE)
   int entrada_id;
   
   @Basic
   String fecha;
   
   @OneToOne
   Cliente cliente;
   
   @OneToOne    
   Empleado empleado;
   
   @OneToOne
   Juego juego;

    public Entrada() {
    }

    public Entrada(int entrada_id, String fecha, Cliente cliente, Empleado empleado, Juego juego) {
        this.entrada_id = entrada_id;
        this.fecha = fecha;
        this.cliente = cliente;
        this.empleado = empleado;
        this.juego = juego;
    }    

    public int getEntrada_id() {
        return entrada_id;
    }

    public void setEntrada_id(int entrada_id) {
        this.entrada_id = entrada_id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }   

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Juego getJuego() {
        return juego;
    }

    public void setJuego(Juego juego) {
        this.juego = juego;
    }  
   
}
