package com.icar.demy.schoolmovil.Registros;

public class Notas {
    String notaid;
    String tipoTrabajo;
    String nombreEstudiante;
    String notaEstudianteTrabajo;
    String descripcionTrabajo;

    public Notas(String notaid, String tipoTrabajo, String nombreEstudiante, String notaEstudianteTrabajo, String descripcionTrabajo) {
        this.notaid = notaid;
        this.tipoTrabajo = tipoTrabajo;
        this.nombreEstudiante = nombreEstudiante;
        this.notaEstudianteTrabajo = notaEstudianteTrabajo;
        this.descripcionTrabajo = descripcionTrabajo;
    }

    public String getNotaid() {
        return notaid;
    }

    public String getTipoTrabajo() {
        return tipoTrabajo;
    }

    public String getNombreEstudiante() {
        return nombreEstudiante;
    }

    public String getNotaEstudianteTrabajo() {
        return notaEstudianteTrabajo;
    }

    public String getDescripcionTrabajo() {
        return descripcionTrabajo;
    }


}
