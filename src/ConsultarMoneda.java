import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultarMoneda {



    public Moneda consultarMoneda(String moneda_base, String moneda_cambio) {
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/"+ utils.APIKEY+"/pair/" +moneda_base+"/"+moneda_cambio);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(String.valueOf(direccion)))
                .build();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String responseBody = response.body();

            if (response.statusCode() != 200) {
                JsonObject jsonObject = JsonParser.parseString(responseBody).getAsJsonObject();
                if (jsonObject.has("error-type") && "unsupported-code".equals(jsonObject.get("error-type").getAsString())) {
                    // Si el error es por código de moneda no soportado, lanzamos una excepción específica
                    throw new MonedaInvalidaException("Código de moneda no soportado: " + moneda_base + " o " + moneda_cambio);
                } else {
                    // Si hay otro tipo de error, lanzamos una RuntimeException
                    throw new RuntimeException("Error en la respuesta de la API: " + responseBody);
                }
            }

            Moneda moneda = new Gson().fromJson(responseBody, Moneda.class);

            return moneda;
        }catch (Exception e){
            throw new RuntimeException("No se encontró la moneda: " + e.getMessage(), e);
        }

    }

}
