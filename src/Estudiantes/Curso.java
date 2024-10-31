package Estudiantes;

import java.util.ArrayList;
import java.util.List;

public class Curso {
    private String nombre;
    private Profesor profesor;
    private List<Estudiante> estudiantes;
    private List<Double> calificaciones;

    public Curso(String nombre, Profesor profesor) {
        this.nombre = nombre;
        this.profesor = profesor;
        this.estudiantes = new ArrayList<>();
        this.calificaciones = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarEstudiante(Estudiante estudiante) {
        estudiantes.add(estudiante);
    }

    public void asignarCalificacion(Estudiante estudiante, double calificacion) {
        if (estudiantes.contains(estudiante)) {
            int index = estudiantes.indexOf(estudiante);
            if (index < calificaciones.size()) {
                calificaciones.set(index, calificacion); // Actualizar calificación
            } else {
                calificaciones.add(calificacion); // Añadir nueva calificación
            }
        } else {
            System.out.println("El estudiante no está en este curso.");
        }
    }

    public double getCalificacion(Estudiante estudiante) {
        if (estudiantes.contains(estudiante)) {
            int index = estudiantes.indexOf(estudiante);
            return calificaciones.get(index);
        }
        return 0; // Si el estudiante no está en el curso
    }
}