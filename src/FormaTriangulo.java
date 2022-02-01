import java.awt.*;

public class FormaTriangulo extends Forma{

    public FormaTriangulo(){
        nome = "Triangulo";
    }

    @Override
    public void setTamanho(Integer tamanho) {
        this.tamanho = tamanho;
    }

    @Override
    public Integer getTamanho() {
        return this.tamanho;
    }

    @Override
    public void setCor(Color c) {
        corForma = c;
    }

    @Override
    public Color getCor() {
        return this.corForma;
    }

    @Override
    public void desenha(Integer x, Integer y, Graphics2D g2d) {
        g2d.setColor(getCor());
        g2d.fillPolygon(new int[] {x - getTamanho() / 2, x, x + getTamanho() / 2},
                        new int[] {y + getTamanho() / 2, y - getTamanho() / 2, y + getTamanho() / 2}, 3);
    }
}
