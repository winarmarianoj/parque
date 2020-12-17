package logica;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import logica.Cliente;
import logica.Empleado;
import logica.Juego;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2020-12-15T20:32:49", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(Entrada.class)
public class Entrada_ { 

    public static volatile SingularAttribute<Entrada, String> fecha;
    public static volatile SingularAttribute<Entrada, Cliente> cliente;
    public static volatile SingularAttribute<Entrada, Empleado> empleado;
    public static volatile SingularAttribute<Entrada, Integer> entrada_id;
    public static volatile SingularAttribute<Entrada, Juego> juego;

}