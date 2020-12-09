
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
public class Contacto implements Serializable {
    
    @Id
    @GeneratedValue (strategy=GenerationType.SEQUENCE)
    int con_id;
    
    @Basic
    String telefono;
    String mail;
    String domicilio;
    
    @OneToMany
    List<Cliente> listaClientes;
    List<Empleado> listaEmpleados;

    public Contacto() {
    }

    public Contacto(int con_id, String telefono, String mail, String domicilio, List<Cliente> listaClientes, List<Empleado> listaEmpleados) {
        this.con_id = con_id;
        this.telefono = telefono;
        this.mail = mail;
        this.domicilio = domicilio;
        this.listaClientes = listaClientes;
        this.listaEmpleados = listaEmpleados;
    }

    public int getCon_id() {
        return con_id;
    }

    public void setCon_id(int con_id) {
        this.con_id = con_id;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public List<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(List<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    
    
    
}
