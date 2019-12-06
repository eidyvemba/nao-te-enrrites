/*
 * Eidy Vemba :D
 * 2019
 * adyvemba@gmail.com
 * : Fun is a way back, when you learn, you transmit to more people than you think. Fun is contagious.. 
 * Objectivo: layout do jogo
 * File: Layout.java
 */
package handlers;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class Layout {
    public int x,y,largura,altura;
    public Layout(int xi,int yi) {
        x=xi;
        y=yi;
        largura=30;
        altura=30;
    }
    public void draw(Graphics2D g){
        g.setColor(Color.WHITE);
        g.fillRect(x,y,15*largura,15*altura);
        for(int i=0;i<6;i++) {
            g.setColor(Color.RED);
            g.fillRect(x+(i*largura),y, largura, altura);
            g.fillRect(x, y+(i*altura), largura, altura);
            g.fillRect(x+(i*largura),y+(5*altura), largura, altura);
            g.fillRect(x+(5*largura), y+(i*altura), largura, altura);
            g.setColor(Color.GREEN);
            g.fillRect(x+((i+9)*largura),y, largura, altura);
            g.fillRect(x+(9*largura), y+(i*altura), largura, altura);
            g.fillRect(x+((i+9)*largura),y+(5*altura), largura, altura);
            g.fillRect(x+(14*largura), y+(i*altura), largura, altura);
            g.setColor(Color.YELLOW);
            g.fillRect(x+((i+9)*largura),y+(9*altura), largura, altura);
            g.fillRect(x+(9*largura), y+((i+9)*altura), largura, altura);
            g.fillRect(x+((i+9)*largura),y+(14*altura), largura, altura);
            g.fillRect(x+(14*largura), y+((i+9)*altura), largura, altura);
            g.setColor(Color.BLUE);
            g.fillRect(x+(i*largura),y+(9*altura), largura, altura);
            g.fillRect(x, y+((i+9)*altura), largura, altura);
            g.fillRect(x+(i*largura),y+(14*altura), largura, altura);
            g.fillRect(x+(5*largura), y+((i+9)*altura), largura, altura);
        }
        for(int i=1;i<6;i++) {
            g.setColor(Color.RED);
            g.fillRect(x+(i*largura),y+(7*altura), largura, altura);
            g.setColor(Color.YELLOW);
            g.fillRect(x+((8+i)*largura),y+(7*altura), largura, altura);
            g.setColor(Color.GREEN);
            g.fillRect(x+(7*largura),y+(i*altura), largura, altura);
            g.setColor(Color.BLUE);
            g.fillRect(x+((7)*largura),y+((8+i)*altura), largura, altura);
        }
        
        g.setColor(Color.RED);
    	g.fillRect(x+(1*largura),y+(6*altura), largura, altura);
    	g.setColor(Color.YELLOW);
    	g.fillRect(x+((13)*largura),y+(8*altura), largura, altura);
    	g.setColor(Color.GREEN);
    	g.fillRect(x+(8*largura),y+(1*altura), largura, altura);
    	g.setColor(Color.BLUE);
    	g.fillRect(x+((6)*largura),y+((13)*altura), largura, altura);
        
    	int temp1=x+45,temp2=y+45;
        
    	for(int i=0;i<2;i++) {
            for(int j=0;j<2;j++) {
                g.setColor(Color.RED);
                g.fillRect(temp1+(2*i*largura),temp2+(2*j*altura), largura, altura);
                g.setColor(Color.YELLOW);
                g.fillRect(temp1+(2*i*largura)+9*largura,temp2+(2*j*altura)+9*altura, largura, altura);
                g.setColor(Color.GREEN);
                g.fillRect(temp1+(2*i*largura)+9*largura,temp2+(2*j*altura)+0*altura, largura, altura);
                g.setColor(Color.BLUE);
                g.fillRect(temp1+(2*i*largura)+0*largura,temp2+(2*j*altura)+9*altura, largura, altura);
            }
    	}
        
    	g.setColor(Color.RED);
    	int xpontos0[] = {x+(6*largura),x+(6*largura), x+15+(7*largura)};
        int ypontos0[] = {y+(6*altura),y+(9*altura),y+15+(7*largura)};
        int npontos = 3;
        
        g.fillPolygon(xpontos0, ypontos0, npontos);
    	g.setColor(Color.YELLOW);
    	int xpontos1[] = {x+(9*largura),x+(9*largura), x+15+(7*largura)};
        int ypontos1[] = {y+(6*altura),y+(9*altura),y+15+(7*largura)};
        int npontos1= 3;
        g.fillPolygon(xpontos1, ypontos1, npontos1);
    	g.setColor(Color.GREEN);
        
    	int xpontos2[] = {x+(6*largura),x+(9*largura), x+15+(7*largura)};
        int ypontos2[] = {y+(6*altura),y+(6*altura),y+15+(7*largura)};
        int npontos2= 3;
        
        g.fillPolygon(xpontos2, ypontos2, npontos2);
    	g.setColor(Color.BLUE);
        
    	int xpontos3[] = {x+(6*largura),x+(9*largura), x+15+(7*largura)};
        int ypontos3[] = {y+(9*altura),y+(9*altura),y+15+(7*largura)};
        int npontos3= 3;
        
        g.fillPolygon(xpontos3, ypontos3, npontos3);
    	g.setStroke(new BasicStroke(2));
    	g.setColor(Color.BLACK);
        
    	for(int i=0;i<3;i++) {
            for(int j=0;j<6;j++) {
                g.drawRect(x+((i+6)*largura),y+(j*altura), largura, altura);
                g.drawRect(x+((j)*largura),y+((i+6)*altura), largura, altura);
                g.drawRect(x+((i+6)*largura),y+((j+9)*altura), largura, altura);
                g.drawRect(x+((j+9)*largura),y+((i+6)*altura), largura, altura);
            }
    	}
        
    	g.drawRect(x+((1)*largura),y+(1*altura),4*largura,4*altura);
    	g.drawRect(x+((10)*largura),y+(1*altura),4*largura,4*altura);
    	g.drawRect(x+((1)*largura),y+(10*altura),4*largura,4*altura);
    	g.drawRect(x+((10)*largura),y+(10*altura),4*largura,4*altura);
        g.drawRect(x,y,15*largura,15*altura);
        
        for(int i=0;i<2;i++) {
            for(int j=0;j<2;j++) {
    	    	g.drawRect(temp1+(2*i*largura),temp2+(2*j*altura), largura, altura);
    	    	g.drawRect(temp1+(2*i*largura)+9*largura,temp2+(2*j*altura)+9*altura, largura, altura);
    	    	g.drawRect(temp1+(2*i*largura)+9*largura,temp2+(2*j*altura)+0*altura, largura, altura);
    	    	g.drawRect(temp1+(2*i*largura)+0*largura,temp2+(2*j*altura)+9*altura, largura, altura);
            }
    	}
        
        g.drawPolygon(xpontos0, ypontos0, npontos);
        g.drawPolygon(xpontos1, ypontos1, npontos1);
        g.drawPolygon(xpontos2, ypontos2, npontos2);
        g.drawPolygon(xpontos3, ypontos3, npontos3);
        
        g.drawOval(x+5+(6*largura),y+5+(2*altura),largura-10,altura-10);
        g.drawOval(x+5+(12*largura),y+5+(6*altura),largura-10,altura-10);
        g.drawOval(x+5+(8*largura),y+5+(12*altura),largura-10,altura-10);
        g.drawOval(x+5+(2*largura),y+5+(8*altura),largura-10,altura-10);
        
        g.setFont(new Font("serif", Font.BOLD, 40));
        g.drawString("Jogador 1", 90, 35);
        g.drawString("Jogador 2", 370, 35);
        g.drawString("Jogador 4", 90, 540);
        g.drawString("Jogador 3", 370, 540);
        g.drawString("Instrução:", 550,300);
        g.drawString("1.Precionar enter para lançar o dado.", 550,350);
        g.drawString("2.Clicar na peça para jogar.", 550,400);
    }
}
