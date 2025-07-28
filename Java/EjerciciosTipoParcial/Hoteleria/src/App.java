import java.util.Date;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hoteleria!");

        Hoteleria hoteleria = new Hoteleria();
        Habitacion habitacion = new Habitacion("31", 300.0);
        Huesped huesped = new Huesped("John Doe");
        Date fechaInicio = new Date();
        int cantDias = 3;

        Hospedaje hospedaje = hoteleria.reservar(habitacion, huesped, fechaInicio, cantDias);
        hospedaje.registrarConsumo(new Servicio("Desayuno", 50.0), 3);

        System.out.println(hospedaje.registrarSalida());
    }
}
