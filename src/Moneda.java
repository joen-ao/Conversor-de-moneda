import java.math.BigDecimal;

public record Moneda(String base_code, //Hay que tener en cuenta que el nombre de las variables debe ser igual al nombre de las variables que se encuentran en el JSON
                     String target_code,
                     BigDecimal conversion_rate) {
}
