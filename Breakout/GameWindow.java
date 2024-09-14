import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import javax.swing.JFrame;

public class GameWindow extends JFrame{
    private JLabel scoreBoard;
    private int score;
    private Color color; 
    public GameWindow() throws InterruptedException {
        
        setSize(500, 650);
        setTitle("Breakout - Evyn Catton");
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(Color.LIGHT_GRAY);
        Breakout breakout = new Breakout(this);
        add(breakout);
        score = 0;
        color = new Color((int)(Math.random() * 256), (int)(Math.random() * 256), (int)(Math.random() * 256), (int)(Math.random() * 256));
        scoreBoard = new JLabel();
        scoreBoard.setText("Score: " + score);
        scoreBoard.setBounds(25, 10, 435, 50);
        scoreBoard.setForeground(Color.BLACK);
        scoreBoard.setFont(new Font("Arial", Font.BOLD, 35));
        add(scoreBoard);
        setVisible(true);

        // game loop
        while(true) {
            breakout.repaint();
            breakout.move();
            Thread.sleep(10);
        }
    }

    public int getScore() {
        return score;
    }
    public JLabel getScoreBoard() {
        return scoreBoard;
    }
    public void setScore(int s){ 
        score = s;
    }


}
