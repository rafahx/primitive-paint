import java.awt.*;

public class FormaRetangulo extends Forma {
    Integer largura, altura;

    public FormaRetangulo(){
        nome = "Retangulo";
        setLargura(getTamanho() * 2);
        setAltura(getTamanho());
    }

    @Override
    public void setTamanho(Integer tamanho) {
        this.tamanho = tamanho;
        setLargura(tamanho * 2);
        setAltura(tamanho);
    }

    @Override
    public Integer getTamanho() {
        return this.tamanho;
    }

    public void setAltura(Integer altura) {
        this.altura = altura;
    }

    public void setLargura(Integer largura) {
        this.largura = largura;
    }

    @Override
    public void setCor(Color c) {
        corForma = c;
    }

    @Override
    public Color getCor() {
        return this.corForma;
    }

    public Integer getAltura() {
        return altura;
    }

    public Integer getLargura() {
        return largura;
    }

    @Override
    public void desenha(Integer x, Integer y, Graphics2D g2d) {
        g2d.setColor(getCor());
        g2d.fillRect(x - getLargura() / 2, y - getAltura() / 2, getLargura(), getAltura());
    }
}
