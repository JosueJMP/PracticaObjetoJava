package Rol;

public class Guerrero extends Personaje {

    public Guerrero(String nombre, int puntosDeVida, int ataqueBase) {
        super(nombre, puntosDeVida, ataqueBase);
    }

    @Override
    public void atacar(Personaje objetivo) {
        super.atacar(objetivo);
        // El guerrero puede realizar un ataque especial, aumentando el daño.
        int danioExtra = 5;
        System.out.println(getNombre() + " realiza un ataque poderoso!");
        objetivo.recibirDanio(danioExtra);
    }
}