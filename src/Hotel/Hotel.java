package Hotel;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private List<Habitacion> habitaciones;
    private List<Reserva> reservas;

    public Hotel() {
        habitaciones = new ArrayList<>();
        reservas = new ArrayList<>();
    }

    public void agregarHabitacion(Habitacion habitacion) {
        habitaciones.add(habitacion);
        System.out.println("Habitación " + habitacion.getNumero() + " agregada al hotel.");
    }

    public boolean reservarHabitacion(Cliente cliente, String numeroHabitacion) {
        for (Habitacion habitacion : habitaciones) {
            if (habitacion.getNumero().equals(numeroHabitacion) && habitacion.isDisponible()) {
                habitacion.reservar();
                reservas.add(new Reserva(cliente, habitacion));
                System.out.println("Reserva realizada: " + cliente.getNombre() + " ha reservado la habitación " + numeroHabitacion);
                return true;
            }
        }
        System.out.println("La habitación " + numeroHabitacion + " no está disponible.");
        return false;
    }

    public void cancelarReserva(Cliente cliente, String numeroHabitacion) {
        Reserva reservaAEliminar = null;
        for (Reserva reserva : reservas) {
            if (reserva.getCliente().getId() == cliente.getId() && reserva.getHabitacion().getNumero().equals(numeroHabitacion)) {
                reservaAEliminar = reserva;
                break;
            }
        }

        if (reservaAEliminar != null) {
            reservaAEliminar.getHabitacion().cancelar();
            reservas.remove(reservaAEliminar);
            System.out.println("Reserva cancelada: " + cliente.getNombre() + " ha cancelado la reserva de la habitación " + numeroHabitacion);
        } else {
            System.out.println("No se encontró ninguna reserva para el cliente " + cliente.getNombre() + " en la habitación " + numeroHabitacion);
        }
    }

    public void mostrarReservasActivas() {
        System.out.println("Reservas activas:");
        if (reservas.isEmpty()) {
            System.out.println("No hay reservas activas.");
        } else {
            for (Reserva reserva : reservas) {
                System.out.println(reserva);
            }
        }
    }
}