import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
<<<<<<< HEAD
import java.util.Objects;
=======
import java.util.List;
>>>>>>> 80e9590 (끗)
import java.util.Random;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        String apiUrl = "https://pokeapi.co/api/v2/pokemon/%d";
        HttpClient client = HttpClient.newHttpClient();
        Random rand = new Random();
        int pokemonId = rand.nextInt(1, 152);
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(apiUrl.formatted(pokemonId))).GET().build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//        System.out.println(response.body());
        ObjectMapper mapper = new ObjectMapper();
<<<<<<< HEAD
        Pokemon pokemon = mapper.readValue(response.body(),Pokemon.class);
        System.out.println(pokemon.sprites.frontDefault);

=======
//        System.out.println(response.body());
        Pokemon pokemon = mapper.readValue(response.body(), Pokemon.class);
        System.out.println(pokemon.sprites.frontDefault);

        String apiUrl2 = "https://pokeapi.co/api/v2/pokemon-species/%d";
        HttpRequest request2 = HttpRequest.newBuilder().uri(URI.create(apiUrl2.formatted(pokemonId))).GET().build();
        HttpResponse<String> response2 = client.send(request2, HttpResponse.BodyHandlers.ofString());

//        System.out.println(response2.body());
        PokemonSpecies pokemonSpecies = mapper.readValue(response2.body(), PokemonSpecies.class);
        // 여러 이름이 나와 -> filter -> language.name == ko -> map -> el.name
        // 1개 -> findFirst -> Optional (Wrapper) -> 없으면 오류내 (orElseThrow)
        System.out.println(pokemonSpecies.names
                .stream()
                .filter(el -> el.language.name.equals("ko"))
                .map(el -> el.name)
                .findFirst().orElseThrow());
>>>>>>> 80e9590 (끗)
    }
}

@JsonIgnoreProperties(ignoreUnknown = true)
class Pokemon {
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Sprites {
        @JsonProperty("front_default")
        public String frontDefault;
<<<<<<< HEAD
    };

    public Sprites sprites;
}
=======
    }
    public Sprites sprites;
}

@JsonIgnoreProperties(ignoreUnknown = true) // 추가
class PokemonSpecies {
    @JsonIgnoreProperties(ignoreUnknown = true) // 추
    public static class Name {
        public String name;
        @JsonIgnoreProperties(ignoreUnknown = true) //
        public static class Language {
            public String name;
        }
        public Language language;
    }
    public List<Name> names;
}
>>>>>>> 80e9590 (끗)
