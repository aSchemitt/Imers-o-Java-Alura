import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        //System.out.println("Hello, World!");

        // criar uma conexão http e salvar numa string
        //urls dos filmes
        //String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        //String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopTVs.json";
        //ExtratorConteudo extrator = new ExtratorConteudoImdb();

        //urls da nasa
        String url = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&start_date=2022-06-12&end_date=2022-06-14";
         ExtratorConteudo extrator = new ExtratorConteudoNasa();
       
        var http = new ClienteHTTP();
        String json = http.buscaDados(url);

        
        List<Conteudo> conteudos = extrator.extraiConteudo(json);

        


        // manipular e exibir os dados
        var fig = new CriaFigurinha();
        System.out.println();
        for (Conteudo c : conteudos) {
            
            String nomeArquivo = "saida/" + c.getTitulo() + ".png";
            InputStream inpstr = new URL(c.getUrlImage()).openStream();
            
            System.out.println(nomeArquivo);
            
            fig.cria(inpstr, nomeArquivo);

            System.out.printf("Titulo: %s\n",c.getTitulo());
        }
    }
}
