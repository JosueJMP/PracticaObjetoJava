package Tareas;

public class Tarea {
    private String descripcion;
    private boolean completada;

    public Tarea(String descripcion) {
        this.descripcion = descripcion;
        this.completada = false;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public boolean isCompletada() {
        return completada;
    }

    public void marcarComoCompletada() {
        this.completada = true;
        System.out.println("La tarea '" + descripcion + "' ha sido marcada como completada.");
    }

    @Override
    public String toString() {
        return descripcion + (completada ? " (Completada)" : " (Pendiente)");
    }
}