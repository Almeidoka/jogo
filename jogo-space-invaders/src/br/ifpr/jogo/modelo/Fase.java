package br.ifpr.jogo.modelo;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

//toda classe em java herda da classe Object direta ou indiretamente
public class Fase extends JPanel implements ActionListener {
    private Personagem personagem;
    private Image imagemDeFundo;
    private Timer timer;
    private List<Inimigo> inimigo;

    public static final int DESLOCAMENTO = 3;
    public static final int DELEY = 10;

    public Fase() {
        setFocusable(true);
        setDoubleBuffered(true);
        ImageIcon carregando = new ImageIcon("arquivos\\template.png");
        this.imagemDeFundo = carregando.getImage();
        this.personagem = new Personagem();
        this.personagem.carregar();
        addKeyListener(new TecladoAdapter());
        timer = new Timer(DELEY, this);
        timer.start();

        inicializarinimigo();

    }
    public void inicializarinimigo(){
        int cordenadas []= new int [40];
        inimigo = new ArrayList<Inimigo>();
        for(int i = 0;i < cordenadas.length; i++){
            int x = (int)(Math.random()*8000+500);
            int y = (int)(Math.random()*318+30);
            inimigo.add(new Inimigo(x, y));
        }
    }

    public void paint(Graphics g) {
        Graphics2D graficos = (Graphics2D) g;
        graficos.drawImage(this.imagemDeFundo, 0, 0, null);
        graficos.drawImage(personagem.getImagemPersonagem(), personagem.getPosicaoX(), personagem.getPosicaoY(), this);
        //implementando o tiro no personagem
        List<Tiro> tiro = personagem.getTiro();
        for(int i=0;i<tiro.size();i++){
            Tiro m = tiro.get(i);
            m.load();
            graficos.drawImage(m.getImagem(), m.getX(), m.getY(),this);
        }
        //implementando inimigos
        for(int j=0;j < inimigo.size(); j++){
            Inimigo in = inimigo.get(j);
            in.load();
            graficos.drawImage(in.getImagem(),in.getX(),in.getY(),this);
        }
        
        g.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        personagem.update();
        List<Tiro> tiro = personagem.getTiro();
        for(int i=0;i<tiro.size();i++){
            Tiro m = tiro.get(i);
            if(m.isVisivel()){
                m.update();
            }else{
                tiro.remove(i);
            }
        }
        
        for(int j=0;j < inimigo.size(); j++){
            Inimigo in = inimigo.get(j);
            if(in.isVisivel()){
                in.update();
            }else{
               inimigo.remove(j); 
            }
        }
        
        repaint();
    }
    public void checarColisoes(){
        Rectangle formaNave = personagem.getBounds();
        Rectangle formaInimigo;
        Rectangle formaTiro;

        for(int i=0;i<inimigo.size();i++){
            Inimigo tempInimigo = inimigo.get(i);
            formaInimigo = tempInimigo.getBounds();
                if(formaNave.intersects(formaInimigo)){
                    personagem.setIsVisivel(false);
                    tempInimigo.setVisivel(false);
                }
        }
    }

    private class TecladoAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            personagem.keyPressed(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            personagem.keyReleased(e);
        }
    }
}