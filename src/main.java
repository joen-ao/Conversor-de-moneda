import java.math.BigDecimal;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        ConsultarMoneda consulta = new ConsultarMoneda();
        ConvertirMoneda convertirMoneda = new ConvertirMoneda();
        int opcion = 0;
       Scanner lectura = new Scanner(System.in);


        while (opcion != 8){
            System.out.println("\n***********************************************");
            System.out.println("\nBienvenido/a al conversor de monedas :)");
            System.out.println("1. Dolar a Peso Colombiano");
            System.out.println("2. Peso Colombiano a Dolar");
            System.out.println("3. Dolar a Peso Argentino");
            System.out.println("4. Peso Argentino a Dolar");
            System.out.println("5. Dolar a Real brasileño");
            System.out.println("6. Real brasileño a Dolar");
            System.out.println("7. Ingresar otras monedas");
            System.out.println("8. Salir");

            System.out.println("\nIngrese la opción que desea: ");
            opcion = Integer.valueOf(lectura.nextLine());

            try {
                switch (opcion){
                    case 1:
                        ConvertirMoneda.convertirMoneda("USD", "COP", consulta);
                        break;

                    case 2:
                        ConvertirMoneda.convertirMoneda("COP", "USD", consulta);
                        break;

                    case 3:
                        ConvertirMoneda.convertirMoneda("USD", "ARS", consulta);
                        break;

                    case 4:
                        ConvertirMoneda.convertirMoneda("ARS", "USD", consulta);
                        break;

                    case 5:
                        ConvertirMoneda.convertirMoneda("USD", "BRL", consulta);
                        break;

                    case 6:
                        ConvertirMoneda.convertirMoneda("BRL", "USD", consulta);
                        break;

                    case 7:
                        ConvertirMoneda.convertirOtraMoneda(consulta);
                        break;

                    case 8:
                        System.out.println("Gracias por usar el conversor de monedas :)");
                        break;

                    default:
                        System.out.println("Opción no válida, intente de nuevo");
                }
            }catch (MonedaInvalidaException e){
                System.out.println("Ocurrio un error: "+e.getMessage());
            }
            catch (Exception e){
                System.out.println("Ocurrio un error: "+e.getMessage());
            }
        }
    }
}
