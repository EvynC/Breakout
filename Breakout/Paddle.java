import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent; 
import java.awt.Rectangle;  
    // instance variables
    public class Paddle {
        private Breakout breakout;
        private int x;
        private final int y = 475; 
        private int speedX, speed;
        private Color color;
        private final int WIDTH = 100;
        private final int HEIGHT = 15;
    
    public Paddle(Breakout b) {
        breakout = b; 
        x = breakout.getWidth() / 2 - 50; 
        color = new Color((int)(Math.random() * 256), (int)(Math.random() * 256), (int)(Math.random() * 256), (int)(Math.random() * 256));
        speed =  breakout.getSpeed(); 
        speedX = 0;
    }

    public void paint(Graphics g) {
        color = new Color((int)(Math.random() * 256), (int)(Math.random() * 256), (int)(Math.random() * 256), (int)(Math.random() * 256));
        g.setColor(color);
        g.fillRect(x, y, WIDTH, HEIGHT);
    }
    
    public void move() { 
        if (x + speedX > 0 && x + speedX < breakout.getWidth() - WIDTH) {
            x += speedX;
        }
        
    }
    
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_A) {
            speedX = -speed - 5; 
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            speedX = -speed - 5; 
        }


        if (e.getKeyCode() == KeyEvent.VK_D) {
            speedX = speed + 5; 
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            speedX = speed + 5; 
        }
    }   
    
    public void keyReleased(KeyEvent e) { 
        speedX = 0;
    }

    public Rectangle getBounds() { 
        return new Rectangle(x, y, WIDTH, HEIGHT);
    }

    public boolean collision() { 
        return getBounds().intersects(breakout.getBall().getBounds());
    }


}