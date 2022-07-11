import java.io.IOException;
import java.net.URI;
import java.net.http.*;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        var client = HttpClient.newHttpClient();

        var request = HttpRequest
                                    .newBuilder(URI.create("https://imdb-api.com/en/API/Top250Movies/k_lo1tm5nf"))
                                    .GET()
                                    .build();

        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(System.out::println)
                .join();
    }
}
