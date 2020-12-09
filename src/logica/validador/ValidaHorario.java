package logica.validador;

import logica.Horario;
import logica.excepciones.HorarioException;

public class ValidaHorario {
    public boolean validHorario(Horario horario) throws HorarioException{
        boolean res = validHoraInicio(horario.getHora_inicio());
        res &= validHoraFin(horario.getHora_fin());
        
        if(!res){throw new HorarioException();}
        return res;
    }

    private boolean validHoraInicio(String hora_inicio) {
        return !hora_inicio.isEmpty() && hora_inicio != null;
    }
    private boolean validHoraFin(String hora_fin){
        return !hora_fin.isEmpty() && hora_fin != null;
    }
}
