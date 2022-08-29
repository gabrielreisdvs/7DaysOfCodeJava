import java.io.IOException;
import java.net.URI;
import java.net.http.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        String url = "https://imdb-api.com/en/API/Top250Movies/k_lo1tm5nf";

        var client = HttpClient.newHttpClient();

        // adicionando comentario

        var request = HttpRequest
                                    .newBuilder(URI.create(url))
                                    .GET()
                                    .build();

        // ASSYNC
        /*
         client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(String::toString)
                .join();

         */

        //SYNC

        String json = client.send(request, HttpResponse.BodyHandlers.ofString()).body();

        //System.out.println(json);

        var parser = new JsonParser();

        List<Map<String, String>> ListaFilmes = parser.parse(json);

        List<String> titles = new ArrayList<>();
        List<String> UrlImages = new ArrayList<>();
        List<String> rates = new ArrayList<>();


        for (Map<String, String> filme: ListaFilmes) {
            titles.add(filme.get("title"));
            UrlImages.add(filme.get("image"));
            rates.add(filme.get("imDbRating"));
            //System.out.println(filme);
        }


    }
}
