import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class App {
    public static void main(String[] args) throws Exception {
        //System.out.println("Hello, World!");

        // criar uma conexão http e salvar numa string
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        URI end = URI.create(url);
        HttpClient httpC = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(end).GET().build();
        HttpResponse<String> response = httpC.send(request, BodyHandlers.ofString());
        String body = response.body();

        System.out.println(body);
        // extrair os dados que interessam
        


        // manipular e exibir os dados
    }
}
