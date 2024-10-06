public class AuxiliarConversion {

    private String fechaHoraConversion;
    private String monedaOrigen;
    private String monedaDestino;
    private double cantidad;
    private double resultadoConversion;

    public AuxiliarConversion(String fechaHoraConversion, String monedaOrigen, String monedaDestino, double cantidad, double resultadoConversion) {
        this.fechaHoraConversion = fechaHoraConversion;
        this.monedaOrigen = monedaOrigen;
        this.monedaDestino = monedaDestino;
        this.cantidad = cantidad;
        this.resultadoConversion = resultadoConversion;
    }

}
