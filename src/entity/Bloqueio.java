/*
 * Eidy Vemba :D
 * 2019
 * adyvemba@gmail.com
 * : Fun is a way back, when you learn, you transmit to more people than you think. Fun is contagious.. 
 * Objectivo: bloqueio dos jogadores e definição de cores e posição
 * File: Bloqueio.java
 */
package entity;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class Bloqueio {
    public int x,y;
    public int atual;
    public int altura,largura;
    public Bloqueio(int h,int w){
        atual=-1;
        x=-1;
        y=-1;
        altura=h;
        largura=w;
    }
    public void draw(Graphics2D g, int i, int j,int play) {
            
        if(atual==-1) {
            int temp1=80+(altura/2),temp2=50+(largura/2);
            x=i;
            y=j;
            
            if(play==0) { g.setColor(Color.RED); }
            else if(play==1) { g.setColor(Color.GREEN); }
            else if(play==2) { g.setColor(Color.YELLOW); }
            else if(play==3) { g.setColor(Color.BLUE); }
            
            g.fillOval(temp1+5+(i*largura),temp2+5+(j*altura),largura-10,altura-10);
            g.setStroke(new BasicStroke(2));
            g.setColor(Color.BLACK);
            g.drawOval(temp1+5+(i*largura),temp2+5+(j*altura),largura-10,altura-10);
        }
        else {
            int temp1=80,temp2=50;
            x=Trilha.ax[play][atual];
            y=Trilha.ay[play][atual];
            
            if(play==0) { g.setColor(Color.RED); }
            else if(play==1) { g.setColor(Color.GREEN); }
            else if(play==2) { g.setColor(Color.YELLOW); }
            else if(play==3) { g.setColor(Color.BLUE); }
            
            g.fillOval(temp1+5+(x*largura),temp2+5+(y*altura),largura-10,altura-10);
            g.setStroke(new BasicStroke(2));
            g.setColor(Color.BLACK);
            g.drawOval(temp1+5+(x*largura),temp2+5+(y*altura),largura-10,altura-10);
        }
    }
}
