package logica;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import logica.Juego;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2020-12-15T20:32:49", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(Horario.class)
public class Horario_ { 

    public static volatile SingularAttribute<Horario, Integer> horario_id;
    public static volatile ListAttribute<Horario, Juego> listaJuegos;
    public static volatile SingularAttribute<Horario, String> hora_inicio;
    public static volatile SingularAttribute<Horario, String> hora_fin;

}