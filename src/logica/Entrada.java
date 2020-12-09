
package logica;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Entrada implements Serializable {
    
   @Id
   @GeneratedValue (strategy=GenerationType.SEQUENCE)
   int entrada_id;
   
   @Basic
   Date fecha;
   
   @OneToOne
   Cliente cliente;   
   Empleado empleado;
   Juego juego;

    public Entrada() {
    }

    public Entrada(int entrada_id, Date fecha, Cliente cliente, Empleado empleado, Juego juego) {
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
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
