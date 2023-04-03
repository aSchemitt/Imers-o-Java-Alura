import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class CriaFigurinha {

    public static void main(String[] args) {
        /*
         * var geradora = new CriaFigurinha();
         * try {
         * geradora.cria(
         * "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopTVs_2.jpg"
         * );
         * } catch (IOException e) {
         * // TODO Auto-generated catch block
         * e.printStackTrace();
         * }
         */
    }

    public void cria(InputStream inpstr, String nomeArquivo) throws IOException {

        // leitura da imagem
        // InputStream inpstr = new FileInputStream(new File("src/filme.jpg"));
        //InputStream inpstr = new URL(url).openStream();
        BufferedImage imgOriginal = ImageIO.read(inpstr);

        // cria nova imagem em memoria com transparencia e tamanho diferente
        int largura = imgOriginal.getWidth();
        int altura = imgOriginal.getHeight();
        int novaAltura = altura + 200;

        BufferedImage novaImg = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        // copiar a imagem original para nova imagem (em memoria)
        Graphics2D graphics = (Graphics2D) novaImg.getGraphics();
        graphics.drawImage(imgOriginal, 0, 0, null);

        // configurar fonte
        var font = new Font(Font.SANS_SERIF, Font.BOLD, 100);
        graphics.setFont(font);
        graphics.setColor(Color.CYAN);

        // escrever uma frase na nova imagem

        graphics.drawString("muito Legal", 15, novaAltura - 100);

        // salvar a imagem em um arquivo
        ImageIO.write(novaImg, "png", new File(nomeArquivo));
    }
}
