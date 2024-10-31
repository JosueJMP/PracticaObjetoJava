package Tareas;

import java.util.ArrayList;
import java.util.List;

public class Proyecto {
    private String nombre;
    private List<Tarea> tareas;

    public Proyecto(String nombre) {
        this.nombre = nombre;
        this.tareas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarTarea(Tarea tarea) {
        tareas.add(tarea);
        System.out.println("Tarea añadida al proyecto '" + nombre + "': " + tarea.getDescripcion());
    }

    public void mostrarTareas() {
        System.out.println("Tareas del proyecto '" + nombre + "':");
        for (Tarea tarea : tareas) {
            System.out.println("- " + tarea);
        }
    }

    public void marcarTareaComoCompletada(int index) {
        if (index >= 0 && index < tareas.size()) {
            tareas.get(index).marcarComoCompletada();
        } else {
            System.out.println("Índice de tarea no válido.");
        }
    }
}
