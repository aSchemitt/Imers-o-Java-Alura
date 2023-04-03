import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class Aula1 {
    public static void main(String[] args) throws Exception {
        //System.out.println("Hello, World!");

        // criar uma conexão http e salvar numa string
        //String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopTVs.json";
        URI end = URI.create(url);
        HttpClient httpC = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(end).GET().build();
        HttpResponse<String> response = httpC.send(request, BodyHandlers.ofString());
        String body = response.body();

        //System.out.println(body);

        // extrair os dados que interessam
        JsonParser parser = new JsonParser();
        List<Map<String,String>> listaFilmes = parser.parse(body);

       // System.out.println(listaFilmes.size());
        //System.out.println(listaFilmes.get(0));

        // manipular e exibir os dados
        System.out.println();
        for (Map<String,String> filme : listaFilmes) {
            System.out.printf("Titulo: %s, ranking: %s, Image: %s\n",filme.get("title"),filme.get("imDbRating"),filme.get("image"));
        }
    }
}
