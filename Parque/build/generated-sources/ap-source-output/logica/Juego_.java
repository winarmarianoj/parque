package logica;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import logica.Empleado;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2020-12-15T20:32:49", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(Juego.class)
public class Juego_ { 

    public static volatile ListAttribute<Juego, Empleado> listaEmpleado;
    public static volatile SingularAttribute<Juego, Integer> juego_id;
    public static volatile SingularAttribute<Juego, String> categoria;
    public static volatile SingularAttribute<Juego, String> edadMinima;
    public static volatile SingularAttribute<Juego, String> nombre;
    public static volatile SingularAttribute<Juego, String> capacidad;

}