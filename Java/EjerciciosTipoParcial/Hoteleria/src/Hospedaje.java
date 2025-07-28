import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Hospedaje {
    Map<Servicio, Integer> consumos = new HashMap<>();
    private Habitacion habitacion;
    private Huesped huesped;
    private Date fechaInicio;
    private int cantDias;

    public Hospedaje(Habitacion habitacion, Huesped huesped, Date fechaInicio, int cantDias) {
        super();
        this.habitacion = habitacion;
        this.huesped = huesped;
        this.fechaInicio = fechaInicio;
        this.cantDias = cantDias;
    }

    public void registrarConsumo(Servicio servicio, int cant) {
        this.consumos.put(servicio, cant);
    }

    public double registrarSalida() {
        double total = 0;

        total += this.habitacion.getImporteUnitario() * this.cantDias;

        for (Map.Entry<Servicio, Integer> entry : this.consumos.entrySet()) {
            total += entry.getKey().getImporteUnitario() * entry.getValue();
        }

        this.habitacion.setEstado(HabitacionEstados.DISPONIBLE);

        return total;
    }
}
