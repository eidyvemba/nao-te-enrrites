/*
 * Eidy Vemba :D
 * 2019
 * adyvemba@gmail.com
 * : Fun is a way back, when you learn, you transmit to more people than you think. Fun is contagious.. 
 * Objectivo: posiciona os players vo jogo
 * File: CriaJogador.java
 */
package handlers;

import java.awt.Graphics2D;
import entity.Player;

public class CriaJogador {
    
    public Player[] pl=new Player[4]; 
    int[][] inicialx= {
        {1,1,3,3},
        {10,10,12,12},
        {10,10,12,12},
        {1,1,3,3}
    };

    int[][] inicialy= {
        {1,3,1,3},
        {1,3,1,3},
        {10,12,10,12},
        {10,12,10,12}
    };

    public CriaJogador(int altura, int largura) {
        for(int i=0;i<4;i++) { pl[i]=new Player(altura,largura); }
    }
    public void draw(Graphics2D g) {
        for(int i=0;i<4;i++) {
            for(int j=0;j<4;j++) { pl[i].bloqueio[j].draw(g,inicialx[i][j],inicialy[i][j],i); }
        }
    }
}
