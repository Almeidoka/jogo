package br.ifpr.jogo.modelo;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Inimigo {
    private Image imagem;
    private int x,y;
    private int largura, altura;
    private boolean isVisivel;

    //largura pro tiro sumir da tela
    //private static final int LARGURA= 938;
    //Velocidade do Tiro
    private static int VELOCIDADE = 5;

    //Contrutor do tiro, informando que sempre que o tiro for chamado na classe personagem o x e o y informados serão os informados
    public Inimigo(int x, int y){
        this.x = x;
        this.y=y;
        isVisivel=true;
    }

    //carregando a imagem do tido e extraindo sua altura e largura
    public void load(){
        ImageIcon referencia = new ImageIcon("arquivos\\inimigo.png");
        imagem =referencia.getImage();
        this.largura=imagem.getWidth(null);
        this.altura=imagem.getHeight(null);
    }
    //método para atualizar o tiro almentando o seu x de acordo com a velocidade para ele se movimentar e já implementando o isVisible para false caso ele passe do tamanha informado;
    public void update(){
        this.x -= VELOCIDADE;
        //if(this.x>LARGURA){
            //isVisivel=false;
        //}
    }

    public Rectangle getBounds(){
        return new Rectangle(x, y, largura, altura);
    }
    
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public boolean isVisivel() {
        return isVisivel;
    }
    public void setVisivel(boolean isVisivel) {
        this.isVisivel = isVisivel;
    }
    public static int getVELOCIDADE() {
        return VELOCIDADE;
    }
    public static void setVELOCIDADE(int vELOCIDADE) {
        VELOCIDADE = vELOCIDADE;
    }
    public Image getImagem() {
        return imagem;
    }
    
}
