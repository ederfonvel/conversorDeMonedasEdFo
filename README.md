Conversor de monedas

Descripción CurrencyConverter es una aplicación Java para la conversión de monedas utilizando la API de ExchangeRate-API. Permite convertir entre distintas monedas y guarda un historial de conversiones en formato JSON y TXT.

Características

Conversión entre Dólar, Pesos Argentinos, Reales Brasileños y Pesos Colombianos.
Historial de conversiones numerado y detallado en un archivo csv, incluyendo la fecha y hora de cada conversión.
Requisitos

Java 8 o superior.
Librería Gson (gson-2.11.0.jar).
Instalación

Clonar el repositorio o descargar el archivo ZIP del proyecto.
Abrir el proyecto en IntelliJ IDEA.
Agregar la librería gson-2.11.0.jar al proyecto.
Ejecutar la clase Conversor.java.
Uso El usuario puede seleccionar opciones de conversión desde un menú y el programa solicitará el monto a convertir. La conversión se realiza a través de la API de ExchangeRate y se guarda un historial de cada operación en los archivos historial_conversiones.json y historialConversiones.txt.

API El programa usa la ExchangeRate-API para obtener las tasas de cambio en tiempo real.

