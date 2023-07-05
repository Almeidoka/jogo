package br.ifpr.jogo.principal;

import br.ifpr.jogo.modelo.Fase;
import javax.swing.JFrame;

public class Principal extends JFrame {
    public Principal() {
        Fase fase = new Fase();
        super.add(fase);
        setVisible(true);
        setSize(500, 318);
        setTitle("Space Invaders");
        setLocationRelativeTo((null));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        Principal principal = new Principal();
    }
}
