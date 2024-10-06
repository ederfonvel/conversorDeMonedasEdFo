import java.util.InputMismatchException;
import java.util.Scanner;

public class mainPrincipal {


        private Scanner scanner = new Scanner(System.in);

        private void datosDeConversion(String monedaOrigen, String monedaDestino) {
            System.out.println("*************************************************");
            System.out.println("Convertir: " + monedaOrigen + " a " + monedaDestino);
            double cantidad = scanner.nextDouble();
            ConvierteConAPI convertir = new ConvierteConAPI();
            double valorConvertido = convertir.convertirMoneda(monedaOrigen, monedaDestino, cantidad);
            System.out.println("Resultado: " + valorConvertido + " " + monedaDestino);
            System.out.println("************************************************");
            GenerarArchivo archivo = new GenerarArchivo();
            archivo.guardarConversion(monedaOrigen, monedaDestino, cantidad, valorConvertido);
        }
        public void mostrarMenu(){

        /**
             * Método que muestra el menú de opciones.
             * Permite al usuario seleccionar una conversión de moneda o salir del programa.
         */

            int opcion = 0;
            do{
                System.out.println("**********<< MENU PRINCIPAL >>**********");
                System.out.println("1. Dólar            --->  Pesos Argentinos");
                System.out.println("2. Pesos Argentino  --->  Dolar");
                System.out.println("3. Dólar            --->  Real Brasileño");
                System.out.println("4. Real Brasileño   --->  Dólar");
                System.out.println("5. Dólar            --->  Pesos Colombiano");
                System.out.println("6. Pesos Colomibano --->  Dólar");
                System.out.println("7. Salir");


                try {
                    System.out.print("Elija una Opción [1-7]: ");
                    opcion = scanner.nextInt();
                } catch (InputMismatchException ex) {
                    System.out.println("¡Digitar! Solo puedes introducir números enteros.");
                    scanner.next();
                }
                    switch (opcion){
                        case 1:
                            datosDeConversion("USD","ARS");
                            break;
                        case 2:
                            datosDeConversion("ARS", "USD");
                            break;
                        case 3:
                            datosDeConversion("USD", "BRL");
                            break;
                        case 4:
                            datosDeConversion("BRL", "USD");
                            break;
                        case 5:
                            datosDeConversion("USD", "COP");
                            break;
                        case 6:
                            datosDeConversion("COP", "USD");
                            break;
                        case 7:
                            System.out.println("********* <<  Fin del Programa  >> ********");
                            break;
                        default:
                            System.out.println("Opción equivocada\n Digite opcion de 1-7.");
                            break;
                    }
            }while (opcion != 7);
        }

    public static void main(String[] args) {
        mainPrincipal principal = new mainPrincipal();
        principal.mostrarMenu();
    }
}
