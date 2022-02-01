import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PaintFrame extends JFrame {
    JPanel painelDesenho = new JPanel();
    Forma formaAtual = new FormaCirculo();
    Color corAtual = Color.YELLOW;
    Integer tamanhoAtual = 20;

    ActionListener atualizaCor = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton botao = (JButton) e.getSource();
            corAtual = botao.getBackground();
        }
    };

    ActionListener atualizaForma = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton botao = (JButton) e.getSource();

            if (botao.getText().equals("Quadrado")) {
                formaAtual = new FormaQuadrado();
                return;
            }
            if (botao.getText().equals("Retângulo")) {
                formaAtual = new FormaRetangulo();
                return;
            }
            if (botao.getText().equals("Círculo")) {
                formaAtual = new FormaCirculo();
                return;
            }
            formaAtual = new FormaTriangulo();
        }
    };

    ActionListener limparTela = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            painelDesenho.repaint();
        }
    };

    ActionListener atualizaTamanho = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton botao = (JButton) e.getSource();

            if (botao.getText().equals("P")) {
                tamanhoAtual = 10;
                return;
            }
            if (botao.getText().equals("M")) {
                tamanhoAtual = 20;
                return;
            }
            tamanhoAtual = 40;
        }
    };

    MouseAdapter ma = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);

            Graphics2D g = (Graphics2D) painelDesenho.getGraphics();
            formaAtual.setTamanho(tamanhoAtual);
            formaAtual.setCor(corAtual);
            formaAtual.desenha(e.getX(), e.getY(), g);
        }
    };

    public void configuraJanela(){
        setSize(800, 600);
        setLocationRelativeTo(null);
        setTitle("Paint BETA 1.0");
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void adicionaElementos() {

        JPanel menuCores = new JPanel();
        menuCores.setLayout(new BoxLayout(menuCores, BoxLayout.Y_AXIS));

        JButton btnVermelho = new JButton(".....");
        JButton btnVerde = new JButton(".....");
        JButton btnAzul = new JButton(".....");
        JButton btnAmarelo = new JButton(".....");

        btnVermelho.setBackground(Color.RED);
        btnVerde.setBackground(Color.GREEN);
        btnAzul.setBackground(Color.BLUE);
        btnAmarelo.setBackground(Color.YELLOW);

        btnVermelho.addActionListener(atualizaCor);
        btnVerde.addActionListener(atualizaCor);
        btnAzul.addActionListener(atualizaCor);
        btnAmarelo.addActionListener(atualizaCor);

        menuCores.add(btnVermelho);
        menuCores.add(btnVerde);
        menuCores.add(btnAzul);
        menuCores.add(btnAmarelo);
        getContentPane().add(menuCores, BorderLayout.WEST);

        JPanel menuFormas = new JPanel(new FlowLayout(FlowLayout.LEFT));

        JButton btnQuadrado = new JButton("Quadrado");
        JButton btnRetangulo = new JButton("Retângulo");
        JButton btnCirculo = new JButton("Círculo");
        JButton btnTriangulo = new JButton("Triângulo");
        JButton btnLimpaTela = new JButton("Limpar");
        JButton btnP = new JButton("P");
        JButton btnM = new JButton("M");
        JButton btnG = new JButton("G");

        btnQuadrado.addActionListener(atualizaForma);
        btnRetangulo.addActionListener(atualizaForma);
        btnCirculo.addActionListener(atualizaForma);
        btnTriangulo.addActionListener(atualizaForma);
        btnLimpaTela.addActionListener(limparTela);
        btnP.addActionListener(atualizaTamanho);
        btnM.addActionListener(atualizaTamanho);
        btnG.addActionListener(atualizaTamanho);

        menuFormas.add(btnQuadrado);
        menuFormas.add(btnRetangulo);
        menuFormas.add(btnCirculo);
        menuFormas.add(btnTriangulo);
        menuFormas.add(btnLimpaTela);
        menuFormas.add(btnP);
        menuFormas.add(btnM);
        menuFormas.add(btnG);
        getContentPane().add(menuFormas, BorderLayout.SOUTH);

        painelDesenho.addMouseListener(ma);
        painelDesenho.setBackground(Color.WHITE);

        getContentPane().add(painelDesenho, BorderLayout.CENTER);

    }
}
