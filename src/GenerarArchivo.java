import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class GenerarArchivo {

    private static final String archivoCVS = "transaccionConversiones.csv";

    private List<AuxiliarConversion> transaccion = new ArrayList<>();

    /*
     * Guarda el transaccion de conversiones en formato CSV, numerado y con fecha y hora.
     * Parametros: monedaOrigen Moneda de origen.
     * Parametros: MonedaDestino Moneda de destino.
     * Parametros: cantidad Cantidad original.
     * Parametros: resultadoConversion Resultado de la conversión.
     */
    public void guardarConversion(String monedaOrigen, String MonedaDestino, double cantidad, double resultadoConversion) {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(archivoCVS, true));
            String fechaHoraConversion = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            writer.println(fechaHoraConversion + "," + monedaOrigen + "," + MonedaDestino + "," + cantidad + "," + resultadoConversion);
            writer.close();
            transaccion.add(new AuxiliarConversion(fechaHoraConversion, monedaOrigen, MonedaDestino, cantidad, resultadoConversion));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

