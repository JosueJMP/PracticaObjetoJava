package Hotel;

public class Habitacion {
    private String numero;
    private boolean disponible;

    public Habitacion(String numero) {
        this.numero = numero;
        this.disponible = true;
    }

    public String getNumero() {
        return numero;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void reservar() {
        this.disponible = false;
    }

    public void cancelar() {
        this.disponible = true;
    }
}