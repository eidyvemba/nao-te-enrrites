/*
 * Eidy Vemba :D
 * 2019
 * adyvemba@gmail.com
 * : Fun is a way back, when you learn, you transmit to more people than you think. Fun is contagious.. 
 * Objectivo: desenha as fichas dos jogadores
 * File: Player.java
 */

package entity;

import java.awt.Graphics2D;

public class Player {
    public int altura,largura,status,coin;
    public Bloqueio[] bloqueio = new Bloqueio[4];
    
    public Player(int altura,int largura) {
        status=-1;
        coin=0;
        for(int i=0;i<4;i++) { bloqueio[i]=new Bloqueio(altura,largura); }
    }
    public void draw(Graphics2D g) { }
}
