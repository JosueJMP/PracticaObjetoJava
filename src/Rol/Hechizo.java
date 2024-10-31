package Rol;

public class Hechizo {
    private String nombre;
    private int danio;
    private int costoMana;

    public Hechizo(String nombre, int danio, int costoMana) {
        this.nombre = nombre;
        this.danio = danio;
        this.costoMana = costoMana;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDanio() {
        return danio;
    }

    public int getCostoMana() {
        return costoMana;
    }
}