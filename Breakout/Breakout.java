import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.util.ArrayList;


public class Breakout extends JPanel {
    private GameWindow game; 
    // instance variable
    private int speed = 2; 
    // private Paddle paddle;
    private int lives = 3; 
    private Ball ball;
    private int score = 0 ; 
    private Paddle paddle;
    private Brick brick; 
    private ArrayList<Brick> bricks; // Capitalized means its a class and has methods
    private ArrayList<Color> colors;

    public Breakout(GameWindow g) {
        game = g;
        setBounds(25, 75, 435, 525);
        speed += 2;
        

        ball = new Ball(this, speed);
        paddle = new Paddle(this);
        bricks = new ArrayList<Brick>();

        int OffsetX = 0; 
        int OffsetY = 0;


        for (int row = 0; row < 5; row++){
            OffsetX = 0;
            for (int col = 0; col <10; col++){
                bricks.add(new Brick(OffsetX, OffsetY, new Color((int)(Math.random() * 256), (int)(Math.random() * 256), (int)(Math.random() * 256))));
                OffsetX += 44; 
            }
            OffsetY += 21; 
        }

        

        addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                paddle.keyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                paddle.keyReleased(e);
            }

        });
        setFocusable(true);
    }

    public Breakout() {
	}

	public void paint(Graphics g) {
        super.paint(g);
        ball.paint(g);
        paddle.paint(g);
        for (int x = 0; x < bricks.size(); x++){ 
            check();
            bricks.get(x).paint(g);
            if(ball.collision(x)) { 
                ball.setSpeedY(speed);
                bricks.remove(bricks.get(x));
                x--;
                
                score += 5;
                speed+= 1; 
                if (speed>7){ 
                    speed = 7; 
                }
                
                if (score != 0){ 
                    paddle.paint(g);
                    
                }
                
                game.getScoreBoard().setText("Score: " + score + ", lives: " + ball.lifechange());
                if (score == 250){ 
                    game.getScoreBoard().setText("Score: " + score + ", Won, Lives: " + lives);
                    speed = 0;
                }
                
                
            }
        }

        if (paddle.collision()) {
            ball.setSpeedY(-speed); 
        }
    }
    

    public void check(){ 
        if (ball.print() == true){
            game.getScoreBoard().setText("Score: " + score + ", lives: " + ball.lifechange()); 
        } 

        if ((getBall().getBounds().y) > 510 && ball.lifechange() == 0){
            game.getScoreBoard().setText("Score: " + score + ", Lost, lives: " + ball.lifechange());
        }
    }
    
    
    public void move() {
        ball.move();
        paddle.move();
        
    }
    public int getlives(){ 
        return lives;
    }
    public int getscore(){ 
        return score;
    }
    // getters: allows to get instance variables from other classes 
    public Ball getBall() { 
        return ball; 
    }

    public Paddle getPaddle() { 
        return paddle; 
    }
    
    public ArrayList<Brick> getBricks() { 
        return bricks;
    }
    
    public int getSpeed(){ 
        return speed;
    }
}
