package com.icar.demy.schoolmovil.Registros;

public class Materias {
    String materiaid;
    String nombreMateria;
    String profesorMateria;
    String cursoMateria;



    public Materias(String materiaid, String nombreProfe, String profesorMateria, String cursoMateria) {
        this.materiaid = materiaid;
        this.nombreMateria = nombreMateria;
        this.profesorMateria = profesorMateria;
        this.cursoMateria = cursoMateria;
    }
    public String getMateriaid() {
        return materiaid;
    }

    public String getNombre() {
        return nombreMateria;
    }

    public String getProfesorMateria() {
        return profesorMateria;
    }

    public String getCursoMateria() {
        return cursoMateria;
    }


}
