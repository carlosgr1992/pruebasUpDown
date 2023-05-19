package modelo;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Empleado {

    private String nombre;
    private String apellidos;
    private LocalDate fechaNac;
    private String email;

    public Empleado(String nombre, String apellidos, LocalDate fechaNac, String email) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNac = fechaNac;
        this.email = email;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(getNombre()).append(getApellidos()).append(getFechaNac()).append(calculaEdad()).append(getEmail());

        return sb.toString();
    }

    public int calculaEdad(){

        return (int) ChronoUnit.YEARS.between(getFechaNac(),LocalDate.now());
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
