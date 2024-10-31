package Biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Libro> libros;
    private List<Usuario> usuarios;

    public Biblioteca() {
        libros = new ArrayList<>();
        usuarios = new ArrayList<>();
    }

    public void agregarLibro(Libro libro) {
        libros.add(libro);
        System.out.println("Libro '" + libro.getTitulo() + "' agregado a la biblioteca.");
    }

    public void registrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
        System.out.println("Usuario '" + usuario.getNombre() + "' registrado en la biblioteca.");
    }

    public boolean prestarLibro(String isbn, Usuario usuario) {
        for (Libro libro : libros) {
            if (libro.getIsbn().equals(isbn)) {
                if (!libro.isPrestado()) {
                    libro.prestar();
                    System.out.println("Libro '" + libro.getTitulo() + "' prestado a '" + usuario.getNombre() + "'.");
                    return true;
                } else {
                    System.out.println("El libro '" + libro.getTitulo() + "' ya está prestado.");
                    return false;
                }
            }
        }
        System.out.println("Libro no encontrado.");
        return false;
    }

    public void devolverLibro(String isbn) {
        for (Libro libro : libros) {
            if (libro.getIsbn().equals(isbn)) {
                if (libro.isPrestado()) {
                    libro.devolver();
                    System.out.println("Libro '" + libro.getTitulo() + "' devuelto a la biblioteca.");
                } else {
                    System.out.println("El libro no se puede devolver porque no está prestado.");
                }
                return;
            }
        }
        System.out.println("Libro no encontrado.");
    }
}