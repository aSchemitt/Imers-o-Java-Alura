import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class ExtratorConteudoNasa implements ExtratorConteudo {
    
    public List<Conteudo> extraiConteudo(String json){
        
        // extrair os dados que interessam
        JsonParser parser = new JsonParser();
        List<Map<String,String>> listaAtributos = parser.parse(json);

        List<Conteudo> conteudos = new ArrayList<>();

        //popular a lista
        for (Map<String,String> atributos : listaAtributos) {
            String titulo = atributos.get("title");
            String urlImage = atributos.get("url");
            var conteudo = new Conteudo(titulo, urlImage);
            conteudos.add(conteudo);
        }


        return conteudos;
    }
}
