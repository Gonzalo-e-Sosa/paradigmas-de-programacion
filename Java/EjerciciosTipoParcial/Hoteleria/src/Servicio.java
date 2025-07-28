public class Servicio implements Vendible {
    private String nombre;
    private double importeUnitario;

    public Servicio(String nombre, double importeUnitario) {
        super();
        this.nombre = nombre;
        this.importeUnitario = importeUnitario;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public double getImporteUnitario() {
        return this.importeUnitario;
    }

}
