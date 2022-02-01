import java.awt.*;

public abstract class Forma {
    Integer tamanho = 20;
    Color corForma = Color.YELLOW;
    String nome = "";

    public abstract void desenha(Integer x, Integer y, Graphics2D g2d);
    public abstract void setCor(Color c);
    public abstract Color getCor();
    public abstract void setTamanho(Integer tamanho);
    public abstract Integer getTamanho();

}
