import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Objects;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        String apiUrl = "https://pokeapi.co/api/v2/pokemon/%d";
        HttpClient client = HttpClient.newHttpClient();
        Random rand = new Random();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(apiUrl.formatted(rand.nextInt(1,152)))).GET().build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//        System.out.println(response.body());
        ObjectMapper mapper = new ObjectMapper();
        Pokemon pokemon = mapper.readValue(response.body(),Pokemon.class);
        System.out.println(pokemon.sprites.frontDefault);

    }
}

@JsonIgnoreProperties(ignoreUnknown = true)
class Pokemon {
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Sprites {
        @JsonProperty("front_default")
        public String frontDefault;
    };

    public Sprites sprites;
}

