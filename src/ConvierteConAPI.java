import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConvierteConAPI {

    private final String apiKey = "8e00051f47632f6ed5fd9fa5";
    private final String linkUrl = "https://v6.exchangerate-api.com/v6/";

    private final HttpClient httpClient;

    // Constructor que inicializa el cliente HTTP
    public ConvierteConAPI() {
        this.httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .build();
    }

    /*
     * Realiza la conversión de moneda utilizando la API de ExchangeRate.
     * parametros: monedaOrigen Moneda de origen.
     * parametros: monedaDestino Moneda de destino.
     * parametros: cantidad Cantidad a convertir.
     * @return El valor convertido.
     */
    public double convertirMoneda(String monedaOrigen, String monedaDestino, double cantidad) {
        try {
            // Construir la URL completa
            String urlStr = linkUrl + apiKey + "/latest/" + monedaOrigen;
            URI uri = new URI(urlStr);

            // Crear la solicitud HTTP
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .GET() // Petición GET
                    .build();

            // Enviar la solicitud y obtener la respuesta
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            // Si el código de respuesta es 200 esta OK
            if (response.statusCode() == 200) {
                // Parsear el JSON de la respuesta
                Gson gson = new Gson();
                JsonObject jsonResponse = gson.fromJson(response.body(), JsonObject.class);

                // Obtener la tasa de cambio y realizar la conversión
                double tasaDeCambio = jsonResponse.getAsJsonObject("conversion_rates").get(monedaDestino).getAsDouble();
                return cantidad * tasaDeCambio;

            } else {
                System.out.println("Error al intentar establecer la conexión a la API: " + response.statusCode());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Retornar 0.0 en caso de error
        return 0.0;
    }
}

