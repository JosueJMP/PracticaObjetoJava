package Tareas;

import java.util.ArrayList;
import java.util.List;

public class UsuarioTarea {
    private String nombre;
    private List<Proyecto> proyectos;

    public UsuarioTarea(String nombre) {
        this.nombre = nombre;
        this.proyectos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void crearProyecto(Proyecto proyecto) {
        proyectos.add(proyecto);
        System.out.println("Proyecto '" + proyecto.getNombre() + "' creado por " + nombre + ".");
    }

    public void mostrarProyectos() {
        System.out.println("Proyectos de " + nombre + ":");
        for (Proyecto proyecto : proyectos) {
            System.out.println("- " + proyecto.getNombre());
            proyecto.mostrarTareas(); // Muestra las tareas del proyecto
        }
    }

    public void agregarTareaAProyecto(int indexProyecto, Tarea tarea) {
        if (indexProyecto >= 0 && indexProyecto < proyectos.size()) {
            proyectos.get(indexProyecto).agregarTarea(tarea);
        } else {
            System.out.println("Índice de proyecto no válido.");
        }
    }

    public void marcarTareaComoCompletada(int indexProyecto, int indexTarea) {
        if (indexProyecto >= 0 && indexProyecto < proyectos.size()) {
            proyectos.get(indexProyecto).marcarTareaComoCompletada(indexTarea);
        } else {
            System.out.println("Índice de proyecto no válido.");
        }
    }
}
