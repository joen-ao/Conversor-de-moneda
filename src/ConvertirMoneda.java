import java.math.BigDecimal;
import java.util.Scanner;

public class ConvertirMoneda {

    public static void convertirMoneda(String base_code, String target_code, ConsultarMoneda consulta) {

        Moneda moneda = consulta.consultarMoneda(base_code, target_code);
        Scanner lectura = new Scanner(System.in);


        System.out.println("\nLa tasa de conversion para hoy es: 1"+moneda.base_code()+" = "+moneda.conversion_rate()+" "+moneda.target_code());

        System.out.println("\nIngrese la cantidad de dinero que desea convertir: ");
        var cantidad = BigDecimal.valueOf(Integer.valueOf(lectura.nextLine()));
        BigDecimal resulltado = cantidad.multiply(moneda.conversion_rate());

        System.out.println(cantidad+" "+moneda.base_code() +" = "+ resulltado+" "+moneda.target_code());
    }

    public static void convertirOtraMoneda( ConsultarMoneda consulta){
        String base_code;
        String target_code;
        Scanner lectura = new Scanner(System.in);

        System.out.println("Ingrese el código de la moneda base: ");
        base_code = lectura.nextLine().toUpperCase();
        System.out.println("Ingrese el código de la moneda a la que desea convertir: ");
        target_code = lectura.nextLine().toUpperCase();

        Moneda moneda = consulta.consultarMoneda(base_code, target_code);
        System.out.println("\nLa tasa de conversion para hoy es: 1"+moneda.base_code()+" = "+moneda.conversion_rate()+" "+moneda.target_code());

        System.out.println("\nIngrese la cantidad de dinero que desea convertir: ");
        var cantidad = BigDecimal.valueOf(Integer.valueOf(lectura.nextLine()));
        BigDecimal resulltado = cantidad.multiply(moneda.conversion_rate());
        System.out.println(cantidad+" "+moneda.base_code() +" = "+ resulltado+" "+moneda.target_code());
    }
}
