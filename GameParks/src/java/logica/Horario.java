package logica;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Horario implements Serializable {
    
    @Id
    @GeneratedValue (strategy=GenerationType.SEQUENCE)
    int horario_id;
    
    @Basic
    String hora_inicio;
    String hora_fin;
    
    @OneToMany
    List <Juego> listaJuegos;

    public Horario() {
    }

    public Horario(int horario_id, String hora_inicio, String hora_fin, List<Juego> listaJuegos) {
        this.horario_id = horario_id;
        this.hora_inicio = hora_inicio;
        this.hora_fin = hora_fin;
        this.listaJuegos = listaJuegos;
    }    

    public int getHorario_id() {
        return horario_id;
    }

    public void setHorario_id(int horario_id) {
        this.horario_id = horario_id;
    }

    public String getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(String hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public String getHora_fin() {
        return hora_fin;
    }

    public void setHora_fin(String hora_fin) {
        this.hora_fin = hora_fin;
    }    
        
    // METHODS AND FUNCTION GAME LIST
    
    public List<Juego> getListaJuegos() {
        if (listaJuegos == null){listaJuegos = new ArrayList<>();}
        return listaJuegos;
    }

    public void addJuegos(Juego juegos) {
        if (listaJuegos == null){listaJuegos = new ArrayList<>();}
        listaJuegos.add(juegos);
    }  
    public int listaJuegosSize(){
        if (listaJuegos == null){listaJuegos = new ArrayList<>();}
        return listaJuegos.size();
    }
    public Juego searchJuego(int index){
        if (index < 0 || index >= listaJuegosSize()){return null;}
        return listaJuegos.get(index);
    }
    public boolean removeJuegos(int index){
        if (index < 0 || index >= listaJuegosSize()){return false;}
        listaJuegos.remove(index);
        return true;
    }
    
}
