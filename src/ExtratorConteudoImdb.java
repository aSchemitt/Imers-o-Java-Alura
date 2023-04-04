import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorConteudoImdb {
    
    public ArrayList<Conteudo> extraiConteudo(String json){

        // extrair os dados que interessam
        JsonParser parser = new JsonParser();
        List<Map<String,String>> listaAtributos = parser.parse(json);

        ArrayList<Conteudo> conteudos = new ArrayList<>();

        //popular a lista
        for (Map<String,String> atributos : listaAtributos) {
            String titulo = atributos.get("title");
            String urlImage = atributos.get("image");
            var conteudo = new Conteudo(titulo, urlImage);
            conteudos.add(conteudo);
        }


        return conteudos;
    }

}
