package com.icar.demy.schoolmovil.Registros;

public class Padres {
    String padreid;
    String nombreHijo;
    String nombrePadre;
    String ci;
    String email;
    String telefono;
    String contraseña;

    public Padres(String padreid, String nombreHijo, String nombrePadre, String ci, String email, String telefono, String contraseña) {
        this.padreid = padreid;
        this.nombreHijo = nombreHijo;
        this.nombrePadre = nombrePadre;
        this.ci = ci;
        this.email = email;
        this.telefono = telefono;
        this.contraseña = contraseña;
    }

    public String getPadreid() {
        return padreid;
    }

    public String getNombreHijo() {
        return nombreHijo;
    }

    public String getNombrePadre() {
        return nombrePadre;
    }

    public String getCi() {
        return ci;
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

