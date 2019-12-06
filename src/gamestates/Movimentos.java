/*
 * Eidy Vemba :D
 * 2019
 * adyvemba@gmail.com
 * : Fun is a way back, when you learn, you transmit to more people than you think. Fun is contagious.. 
 * Objectivo: movimentos do jogo
 * File: Movimentos.java
 */

package gamestates;

import entity.Trilha;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Timer;
import javax.swing.JPanel;
import handlers.Layout;
import handlers.CriaJogador;

public class Movimentos extends JPanel implements KeyListener, ActionListener,MouseListener{
    private static final long serialVersionUID = 1L;
    Layout la;
    CriaJogador p;
    Timer time;
    int delay=10;
    int jogador_atual,dado;
    int flag=0,roll,kill=0;

    public Movimentos() {
        setFocusTraversalKeysEnabled(false);
        requestFocus();
        jogador_atual=0;
        la = new Layout(80,50);
        p = new CriaJogador(la.altura,la.largura);
        dado=0;
        flag=0;
        roll=0;
        kill=0;
    }

    @Override
    public void paint(Graphics g) {
    	la.draw((Graphics2D)g);
    	p.draw((Graphics2D)g);
    	if (p.pl[jogador_atual].coin==4) {
            g.setColor(Color.WHITE);
            g.fillRect(590, 100, 380,130);
            if (jogador_atual==0) { g.setColor(Color.RED); }
            else if (jogador_atual==1) { g.setColor(Color.GREEN); }
            else if (jogador_atual==2) { g.setColor(Color.YELLOW); }
            else if (jogador_atual==3) { g.setColor(Color.BLUE); }
                
                
            g.setFont(new Font("serif ", Font.BOLD, 40));
            g.drawString("Player "+(jogador_atual+1)+" wins.", 600, 150);
            g.drawString("Congratulations.", 600, 200);
            
            jogador_atual=0;
            
            la = new Layout(80,50);
            
            p=new CriaJogador(la.altura,la.largura);
            
            dado=0;
            flag=0;
            roll=0;
            kill=0;
    	}
    	else if (dado!=0) {
            g.setColor(Color.WHITE);
            g.fillRect(590, 100, 380,130);
            if (jogador_atual==0) { g.setColor(Color.RED); }
            else if (jogador_atual==1) { g.setColor(Color.GREEN); }
            else if (jogador_atual==2) { g.setColor(Color.YELLOW); }
            else if (jogador_atual==3) { g.setColor(Color.BLUE); }
            
            g.setFont(new Font("serif ", Font.BOLD, 40));
            g.drawString("Jogador "+(jogador_atual+1), 600, 150);
            g.drawString("Número do dado: "+dado, 600, 200);
    	}
    	if (flag==0&&dado!=0&&dado!=6&&kill==0) { jogador_atual=(jogador_atual+1)%4; }
    	kill=0;
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        if  (e.getKeyCode() == KeyEvent.VK_ENTER&&flag==0) {
            roll=0;
            dado=1 + (int)(Math.random() * 6);
            repaint();
            for (int i=0;i<4;i++) {
                if (p.pl[jogador_atual].bloqueio[i].atual!=-1&&p.pl[jogador_atual].bloqueio[i].atual!=56&&(p.pl[jogador_atual].bloqueio[i].atual+dado)<=56) {
                    flag=1;
                    break;
                }
            }
            
            if (flag==0&&dado==6) {
                for (int i=0;i<4;i++) {
                    if (p.pl[jogador_atual].bloqueio[i].atual==-1) {
                        flag=1;
                        break;
                    }
                }
            }
        }
    }
	
    public void mouseClicked(MouseEvent e) {
        if (flag==1) {
            int x=e.getX();
            int y=e.getY();
            x=x-80;
            y=y-50;
            x=x/30;
            y=y/30;
            int posicao=-1;
            
            //System.out.println(x+" "+y);
            
            if (dado==6) {
                for (int i=0;i<4;i++) {
                    if (p.pl[jogador_atual].bloqueio[i].x==x&&p.pl[jogador_atual].bloqueio[i].y==y&&(p.pl[jogador_atual].bloqueio[i].atual+dado)<=56) {
                        posicao=i;
                        flag=0;
                        break;
                    }	
                }
                if (posicao!=-1) {
                    p.pl[jogador_atual].bloqueio[posicao].atual+=dado;
                    if (p.pl[jogador_atual].bloqueio[posicao].atual==56) {
                        p.pl[jogador_atual].coin++;
                    }
                    
                    int k=0;
                    
                    int hou=p.pl[jogador_atual].bloqueio[posicao].atual;
                    
                    if ((hou%13)!=0&&(hou%13)!=8&&hou<51)
                    {
                        for (int i=0;i<4;i++) {
                            if (i!=jogador_atual) {
                                for (int j=0;j<4;j++) {
                                    int tem1= Trilha.ax[jogador_atual][p.pl[jogador_atual].bloqueio[posicao].atual],tem2=Trilha.ay[jogador_atual][p.pl[jogador_atual].bloqueio[posicao].atual];
                                    if (p.pl[i].bloqueio[j].x==tem1&&p.pl[i].bloqueio[j].y==tem2) {
                                        p.pl[i].bloqueio[j].atual=-1;
                                        kill=1;
                                        k=1;
                                        break;
                                    }
                                }
                            }
                            if (k==1) {break; }
                        }
                    }
                    else {
                        for (int i=0;i<4;i++) {
                            if (p.pl[jogador_atual].bloqueio[i].atual==-1) {
                                p.pl[jogador_atual].bloqueio[i].atual=0;
                                flag=0;
                                break;
                            }	
                       }
                    }
                }
                else {
                    for (int i=0;i<4;i++) {
                        if (p.pl[jogador_atual].bloqueio[i].x==x&&p.pl[jogador_atual].bloqueio[i].y==y&&(p.pl[jogador_atual].bloqueio[i].atual+dado)<=56) {
                            posicao=i;
                            flag=0;
                            break;
                        }	
                    }
                    if (posicao!=-1) {
                        p.pl[jogador_atual].bloqueio[posicao].atual+=dado;
                        
                        if (p.pl[jogador_atual].bloqueio[posicao].atual==56) {
                                p.pl[jogador_atual].coin++;
                        }
                        int k=0;
                        int hou=p.pl[jogador_atual].bloqueio[posicao].atual;
                        
                        if ((hou%13)!=0&&(hou%13)!=8&&hou<51)
                        {
                            for (int i=0;i<4;i++) {
                                if (i!=jogador_atual) {
                                    for (int j=0;j<4;j++) {
                                        int tem1=Trilha.ax[jogador_atual][p.pl[jogador_atual].bloqueio[posicao].atual],tem2=Trilha.ay[jogador_atual][p.pl[jogador_atual].bloqueio[posicao].atual];
                                        if (p.pl[i].bloqueio[j].x==tem1&&p.pl[i].bloqueio[j].y==tem2) {
                                            p.pl[i].bloqueio[j].atual=-1;
                                            kill=1;
                                            k=1;
                                            break;
                                        }
                                    }
                                }
                                if (k==1) break;
                            }
                        }
                    }
                }
                repaint();
            }
        }
    }

    //@Override
    public void actionPerformed(ActionEvent e) { }

    @Override
    public void keyReleased(KeyEvent arg0) { }

    @Override
    public void keyTyped(KeyEvent arg0) { }

    @Override
    public void mouseEntered(MouseEvent arg0) { }

    @Override
    public void mouseExited(MouseEvent arg0) { }

    @Override
    public void mousePressed(MouseEvent e) { }

    @Override
    public void mouseReleased(MouseEvent arg0) { }
}
