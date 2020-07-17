package com.icar.demy.schoolmovil.Registros;

public class Estudiantes {
    String usuarioid;
    String nombre;
    String apellidopaterno;
    String apellidomaterno;
    String ci;
    String grado;
    String email;
    String telefono;
    String contraseña;


    public Estudiantes(String usuarioid, String nombre, String apellidopaterno, String apellidomaterno, String ci, String grado, String email, String telefono, String contraseña) {
        this.usuarioid = usuarioid;
        this.nombre = nombre;
        this.apellidopaterno = apellidopaterno;
        this.apellidomaterno = apellidomaterno;
        this.ci = ci;
        this.grado = grado;
        this.email = email;
        this.telefono = telefono;
        this.contraseña = contraseña;
    }
    public String getUsuarioid() {
        return usuarioid;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidopaterno() {
        return apellidopaterno;
    }

    public String getApellidomaterno() {
        return apellidomaterno;
    }

    public String getCi() {
        return ci;
    }

    public String getGrado() {
        return grado;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getContraseña() {
        return contraseña;
    }
}
