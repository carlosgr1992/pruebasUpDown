package servicios;

import modelo.Empleado;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Repositorio {

    public static List<Empleado> empleados;

    public static List<Empleado> getEmpleados(){
            if(empleados == null) {
        empleados = new ArrayList<Empleado>();

        empleados.add(new Empleado("Carlos", "García Ramírez", LocalDate.of(1992, 01, 27), "carlos.gr92@hotmail.com"));
        empleados.add(new Empleado("Yolanda", "Pérez Gómez", LocalDate.of(1982, 05, 6), "yolanda.h@educa.madrid.org"));
        empleados.add(new Empleado("Juan", "Álvarez Beltrán", LocalDate.of(1979, 3, 19), "juanito@gmail.com"));
        empleados.add(new Empleado("Marcos", "García Ramírez", LocalDate.of(1986, 12, 18), "carlos.gr86@gmail.com"));
        empleados.add(new Empleado("María", "Castillo Intriago", LocalDate.of(1994, 12, 16), "maria94@hotmail.com"));
        empleados.add(new Empleado("Alberto", "Gutierrez Olmos", LocalDate.of(1980, 5, 29), "alberto80@gmail.com"));
    }

        return empleados;
    }

}
