package Rol;

public class Mago extends Personaje {
    private int mana;
    private int manaRestante;

    public Mago(String nombre, int puntosDeVida, int ataqueBase, int mana) {
        super(nombre, puntosDeVida, ataqueBase);
        this.mana = mana;
        this.manaRestante = mana;
    }

    public void lanzarHechizo(Hechizo hechizo, Personaje objetivo) {
        if (manaRestante >= hechizo.getCostoMana()) {
            System.out.println(getNombre() + " lanza el hechizo '" + hechizo.getNombre() + "' a " + objetivo.getNombre() + ".");
            objetivo.recibirDanio(hechizo.getDanio());
            manaRestante -= hechizo.getCostoMana();
            System.out.println("Mana restante: " + manaRestante + ".");
        } else {
            System.out.println(getNombre() + " no tiene suficiente mana para lanzar '" + hechizo.getNombre() + "'.");
        }
    }
}