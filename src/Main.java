import Biblioteca.*;
import Hotel.*;
import Rol.*;
import Estudiantes.*;
import Tareas.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Biblioteca biblioteca = new Biblioteca();
        Hotel hotel = new Hotel();
        Guerrero guerrero = new Guerrero("Arthas", 100, 10);
        Mago mago = new Mago("Khaeltas", 80, 8, 20);
        UsuarioTarea usuarioTarea = new UsuarioTarea("Josue");

        while (true) {
            System.out.println("\n--- Menú Principal ---");
            System.out.println("1. Biblioteca");
            System.out.println("2. Hotel");
            System.out.println("3. Rol");
            System.out.println("4. Estudiantes");
            System.out.println("5. Tareas");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    bibliotecaMenu(scanner, biblioteca);
                    break;
                case 2:
                    hotelMenu(scanner, hotel);
                    break;
                case 3:
                    rolMenu(guerrero, mago);
                    break;
                case 4:
                    estudiantesMenu(scanner);
                    break;
                case 5:
                    tareasMenu(scanner, usuarioTarea);
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    return;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
    }

    // Menú de Biblioteca
    private static void bibliotecaMenu(Scanner scanner, Biblioteca biblioteca) {
        // Sección de Biblioteca
        Libro libro1 = new Libro("Spiderman", "Marvel", "123456789");
        Libro libro2 = new Libro("Harry Potter", "J.K. Rowling", "987654321");

        biblioteca.agregarLibro(libro1);
        biblioteca.agregarLibro(libro2);

        Usuario usuario1 = new Usuario("Josué", 1);
        Usuario usuario2 = new Usuario("Angelote", 2);

        biblioteca.registrarUsuario(usuario1);
        biblioteca.registrarUsuario(usuario2);

        biblioteca.prestarLibro("123456789", usuario1);
        biblioteca.prestarLibro("987654321", usuario2);
        biblioteca.devolverLibro("123456789");
        biblioteca.devolverLibro("987654321");

        // Puedes agregar un menú para que el usuario interactúe con la biblioteca
        System.out.println("Interacción con la biblioteca completada.");
    }

    // Menú de Hotel
    private static void hotelMenu(Scanner scanner, Hotel hotel) {
        // Sección de Hotel
        hotel.agregarHabitacion(new Habitacion("101"));
        hotel.agregarHabitacion(new Habitacion("102"));
        hotel.agregarHabitacion(new Habitacion("103"));

        // Crear clientes
        Cliente cliente1 = new Cliente("Josué", 1);
        Cliente cliente2 = new Cliente("Raul", 2);

        // Realizar reservas
        hotel.reservarHabitacion(cliente1, "101");
        hotel.reservarHabitacion(cliente2, "102");
        hotel.cancelarReserva(cliente1, "101");

        // Mostrar reservas activas
        hotel.mostrarReservasActivas();
    }

    // Menú de Rol
    private static void rolMenu(Guerrero guerrero, Mago mago) {
        Hechizo hechizoFuego = new Hechizo("Fuego", 15, 5);

        while (guerrero.estaVivo() && mago.estaVivo()) {
            guerrero.atacar(mago);
            if (mago.estaVivo()) {
                mago.lanzarHechizo(hechizoFuego, guerrero);
            }
        }

        if (!guerrero.estaVivo()) {
            System.out.println(guerrero.getNombre() + " ha sido derrotado.");
        } else {
            System.out.println(mago.getNombre() + " ha sido derrotado.");
        }
    }

    // Menú de Estudiantes
    private static void estudiantesMenu(Scanner scanner) {
        Profesor profesor1 = new Profesor("Luis");
        Curso cursoMatematicas = new Curso("Programación", profesor1);
        Estudiante estudiante1 = new Estudiante("Josué");

        profesor1.asignarCurso(estudiante1, cursoMatematicas);
        profesor1.asignarCalificacion(cursoMatematicas, estudiante1, 90);

        System.out.println("Promedio de " + estudiante1.getNombre() + ": " + estudiante1.calcularPromedio());
    }

    // Menú de Tareas
    private static void tareasMenu(Scanner scanner, UsuarioTarea usuarioTarea) {
        // Crear proyectos
        Proyecto proyectoPersonal = new Proyecto("Proyecto Personal");
        Proyecto proyectoTrabajo = new Proyecto("Proyecto de Trabajo");

        usuarioTarea.crearProyecto(proyectoPersonal);
        usuarioTarea.crearProyecto(proyectoTrabajo);

        // Crear tareas
        Tarea tarea1 = new Tarea("Tarea de Programación");
        Tarea tarea2 = new Tarea("Enviar Tarea de Programación");
        usuarioTarea.agregarTareaAProyecto(0, tarea1);
        usuarioTarea.agregarTareaAProyecto(1, tarea2);

        usuarioTarea.mostrarProyectos();

        // Marcar una tarea como completada
        usuarioTarea.marcarTareaComoCompletada(0, 0);

        // Mostrar proyectos y tareas nuevamente
        System.out.println("\nProyectos y Tareas Después de Completar una Tarea:");
        usuarioTarea.mostrarProyectos();
    }
}

