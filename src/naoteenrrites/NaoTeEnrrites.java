/*
 * Eidy Vemba :D
 * 2019
 * adyvemba@gmail.com
 * : Fun is a way back, when you learn, you transmit to more people than you think. Fun is contagious.. 
 * Objectivo: abertura inicial do jogo
 * File: NaoTeEnrrites.java
 */
package naoteenrrites;

import javax.swing.JFrame;
import gamestates.Movimentos;
public class NaoTeEnrrites {

    public static void main(String[] args) {
       JFrame jframe = new JFrame();
        jframe.setBounds(10,10,1200,600);
        jframe.setTitle("Não Te Enrrites");
        jframe.setResizable(false);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Movimentos movimentos = new Movimentos();
        movimentos.setFocusable(true);
        movimentos.addKeyListener(movimentos);
        movimentos.addMouseListener(movimentos);
        jframe.add(movimentos);
        jframe.setVisible(true);
    }
    
}
