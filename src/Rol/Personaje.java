package Rol;

public class Personaje {
    private String nombre;
    private int puntosDeVida;
    private int ataqueBase;

    public Personaje(String nombre, int puntosDeVida, int ataqueBase) {
        this.nombre = nombre;
        this.puntosDeVida = puntosDeVida;
        this.ataqueBase = ataqueBase;
    }

    public void atacar(Personaje objetivo) {
        System.out.println(nombre + " ataca a " + objetivo.nombre + " y causa " + ataqueBase + " puntos de daño.");
        objetivo.recibirDanio(ataqueBase);
    }

    public void recibirDanio(int danio) {
        puntosDeVida -= danio;
        System.out.println(nombre + " recibe " + danio + " puntos de daño. Puntos de vida restantes: " + puntosDeVida + ".");
    }

    public boolean estaVivo() {
        return puntosDeVida > 0;
    }

    public String getNombre() {
        return nombre; // Método añadido para obtener el nombre del personaje.
    }
}