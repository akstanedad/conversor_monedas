import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaConversion {

    public String buscaConversion(String monedaBase, String monedaObjetivo, double cantidad) {

        try {

            URI direccion = URI.create("https://v6.exchangerate-api.com/v6/7a2d47f7b5486e83f53e4ee6/pair/" + monedaBase + "/" + monedaObjetivo + "/" + cantidad);

            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(direccion)
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            var json = response.body();
            JsonElement jsonElement = JsonParser.parseString(json);
            JsonObject jsonObject = jsonElement.getAsJsonObject();

            return jsonObject.get("conversion_result").getAsString();

        } catch (NumberFormatException | IOException | InterruptedException e) {
            System.out.println("Ocurrio un error: ");
            throw new RuntimeException("Error" + e.getMessage());
        }

    }
}
