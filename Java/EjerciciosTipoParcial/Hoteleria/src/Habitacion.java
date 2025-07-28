
public class Habitacion implements Vendible {
    private String nro;
    private double importeUnitario;
    private HabitacionEstados estado;

    public Habitacion(String nro, double importeUnitario) {
        super();
        this.nro = nro;
        this.importeUnitario = importeUnitario;
        this.estado = HabitacionEstados.DISPONIBLE;
    }

    public String getNro() {
        return nro;
    }

    public HabitacionEstados getEstado() {
        return estado;
    }

    public void setEstado(HabitacionEstados estado) {
        this.estado = estado;
    }

    @Override
    public double getImporteUnitario() {
        return this.importeUnitario;
    }

}
