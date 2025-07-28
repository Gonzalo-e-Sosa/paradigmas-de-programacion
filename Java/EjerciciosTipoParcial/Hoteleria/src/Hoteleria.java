import java.util.Date;

public class Hoteleria {
    public Hospedaje reservar(Habitacion habitacion, Huesped huesped, Date fecha, int cantDias) {
        habitacion.setEstado(HabitacionEstados.RESERVADA);

        return new Hospedaje(habitacion, huesped, fecha, cantDias);
    }
}
