import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;   

    public class Brick {
        private Color color;
        private int x , y; 
        private final int WIDTH = 43; 
        private final int HEIGHT = 20;  

    public Brick(int xPos, int yPos, Color c) {
        color = c; 
        x = xPos;
        y = yPos;
    }

    public void paint(Graphics g) {
        g.setColor(Color.black);
        g.drawRect(x, y, WIDTH, HEIGHT);
        g.setColor(color);
        g.fillRect(x, y, WIDTH, HEIGHT);

    }

    public Rectangle getBounds() { 
        return new Rectangle(x, y, WIDTH, HEIGHT);
    }
    
}