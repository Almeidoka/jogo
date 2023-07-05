package br.ifpr.jogo.modelo;

import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class Personagem {
    private int posicaoX;
    private int posicaoY;
    private int deslocamentoX;
    private int deslocamentoY;
    private Image imagemPersonagem;
    private int larguraImagem;
    private int alturaImagem;
    private List <Tiro> tiro;
    private boolean isVisivel;

    /* Criação de constante */
    private static final int POSICAO_INICIAL_X = 100;
    private static final int POSICAO_INICIAL_Y = 100;
    private static final int VELOCIDADE_DE_DESLOCAMENTO = 3;

    public Personagem() {
        this.posicaoX = POSICAO_INICIAL_X;
        this.posicaoY = POSICAO_INICIAL_Y;
        isVisivel=true;

        //
        tiro = new ArrayList<Tiro>();

    }

    public void carregar() {
        ImageIcon carregar = new ImageIcon(
                "arquivos\\psg_1.png");
        this.imagemPersonagem = carregar.getImage();
        this.alturaImagem = this.imagemPersonagem.getWidth(null);
        this.larguraImagem = this.imagemPersonagem.getHeight(null);
    }

    //código de movimentação e códgo extra para adicionar colisão (Adaptado)
    public void update() {

        if (posicaoX < 1) {
            this.posicaoX = posicaoX + 3;
        } else if (posicaoX > 440) {
            this.posicaoX = posicaoX - 3;
        } else if (posicaoY < 1) {
            this.posicaoY = posicaoY + 3;
        } else if (posicaoY > 240) {
            this.posicaoY = posicaoY - 3;
        } else {
            this.posicaoX += this.deslocamentoX;
            this.posicaoY += this.deslocamentoY;
        }

    }

    //crição de um novo tiro, que será utilizado dentro do keypressed
    public void tiros(){
        this.tiro.add(new Tiro(posicaoX+larguraImagem, (posicaoY+alturaImagem/2)));
    }

    public Rectangle getBounds(){
        return new Rectangle(posicaoX, posicaoY, larguraImagem, alturaImagem);
    }

    public void keyPressed(KeyEvent tecla) {
        int movimentacao = tecla.getKeyCode();
        if (movimentacao == KeyEvent.VK_W || movimentacao == KeyEvent.VK_UP) {
            this.deslocamentoY -= VELOCIDADE_DE_DESLOCAMENTO;
        }
        if (movimentacao == KeyEvent.VK_S || movimentacao == KeyEvent.VK_DOWN) {
            this.deslocamentoY += VELOCIDADE_DE_DESLOCAMENTO;
        }
        if (movimentacao == KeyEvent.VK_A || movimentacao == KeyEvent.VK_LEFT) {
            this.deslocamentoX -= VELOCIDADE_DE_DESLOCAMENTO;
        }
        if (movimentacao == KeyEvent.VK_D || movimentacao == KeyEvent.VK_RIGHT) {
            this.deslocamentoX += VELOCIDADE_DE_DESLOCAMENTO;
        }
        if (movimentacao == KeyEvent.VK_SPACE) {
            tiros();
        }

    }

    public void keyReleased(KeyEvent tecla) {
        int movimentacao = tecla.getKeyCode();
        if (movimentacao == KeyEvent.VK_W || movimentacao == KeyEvent.VK_UP) {
            setDeslocamentoY(0);
        } else if (movimentacao == KeyEvent.VK_S || movimentacao == KeyEvent.VK_DOWN) {
            setDeslocamentoY(0);
        } else if (movimentacao == KeyEvent.VK_A || movimentacao == KeyEvent.VK_LEFT) {
            setDeslocamentoX(0);
        } else if (movimentacao == KeyEvent.VK_D || movimentacao == KeyEvent.VK_RIGHT) {
            setDeslocamentoX(0);
        }

    }

    public int getPosicaoX() {
        return this.posicaoX;
    }

    public void setPosicaoX(int posicaoX) {
        this.posicaoX = posicaoX;
    }

    public int getPosicaoY() {
        return this.posicaoY;
    }

    public void setPosicaoY(int posicaoY) {
        this.posicaoY = posicaoY;
    }

    public int getDeslocamentoX() {
        return this.deslocamentoX;
    }

    public void setDeslocamentoX(int deslocamentoX) {
        this.deslocamentoX = deslocamentoX;
    }

    public int getDeslocamentoY() {
        return this.deslocamentoY;
    }

    public void setDeslocamentoY(int deslocamentoY) {
        this.deslocamentoY = deslocamentoY;
    }

    public Image getImagemPersonagem() {
        return this.imagemPersonagem;
    }

    public void setImagemPersonagem(Image imagemPersonagem) {
        this.imagemPersonagem = imagemPersonagem;
    }

    public int getLarguraImagem() {
        return this.larguraImagem;
    }

    public void setLarguraImagem(int larguraImagem) {
        this.larguraImagem = larguraImagem;
    }

    public int getAlturaImagem() {
        return this.alturaImagem;
    }

    public void setAlturaImagem(int alturaImagem) {
        this.alturaImagem = alturaImagem;
    }

    public List<Tiro> getTiro() {
        return tiro;
    }

    public void setTiro(List<Tiro> tiro) {
        this.tiro = tiro;
    }


    public boolean isIsVisivel() {
        return this.isVisivel;
    }

    public boolean getIsVisivel() {
        return this.isVisivel;
    }

    public void setIsVisivel(boolean isVisible) {
        this.isVisivel = isVisible;
    }
    

}
