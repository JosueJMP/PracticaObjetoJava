package Estudiantes;

import java.util.ArrayList;
import java.util.List;

public class Estudiante {
    private String nombre;
    private List<Curso> cursos;

    public Estudiante(String nombre) {
        this.nombre = nombre;
        this.cursos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarCurso(Curso curso) {
        cursos.add(curso);
        curso.agregarEstudiante(this); // Añadir estudiante al curso
    }

    public double calcularPromedio() {
        if (cursos.isEmpty()) {
            return 0; // Si no tiene cursos, promedio es 0
        }

        double sumaCalificaciones = 0;
        int totalCalificaciones = 0;

        for (Curso curso : cursos) {
            sumaCalificaciones += curso.getCalificacion(this);
            totalCalificaciones++;
        }

        return sumaCalificaciones / totalCalificaciones;
    }
}