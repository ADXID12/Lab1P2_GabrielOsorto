package lab1p2_gabirelosorto;

import java.util.*;

public class Usuario {

    String nombre;
    String apellido;
    Date FechadeNacimiento;
    String correo;
    String contra;

    public Usuario(String nombre, String apellido, Date FechadeNacimiento, String correo, String contra) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.FechadeNacimiento = FechadeNacimiento;
        this.correo = correo;
        this.contra = contra;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFechadeNacimiento() {
        return FechadeNacimiento;
    }

    public void setFechadeNacimiento(Date FechadeNacimiento) {
        this.FechadeNacimiento = FechadeNacimiento;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    @Override
    public String toString() {
        return "Usuario{" + "nombre=" + nombre + ", apellido=" + apellido + ",  correo=" + correo + ", contra=" + contra + " Fecha de nacimiento= ";
    }

}
