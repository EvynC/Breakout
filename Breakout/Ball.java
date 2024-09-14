    import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle; 


public class Ball { 
    private Breakout breakout;
    private int x, y;
    private int lives; 
    private int speedX, speedY, speed;
    private Color color;
    private final int SIZE = 10;
    private boolean m;
    
    

    public Ball(Breakout b, int s) {
        breakout = b;
        x = 225;
        y = 225;
        m = false;
        speed = s;
        lives = breakout.getlives();
        speedX = speed;
        speedY = speed;
        color = Color.decode("#123456"); // hex
        // rgb color = new Color(15, 75, 223);
    }

    public void paint(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, SIZE, SIZE);
    }

    public void move() {
        if (x + speedX < 0) {
            speedX =  breakout.getSpeed();
        }
        if (x + speedX > breakout.getWidth() - SIZE) {
            speedX = - breakout.getSpeed();
        }
        if (y + speedY < 0) {
            speedY = breakout.getSpeed();
        }
        if (y + speedY > breakout.getHeight() - SIZE) {
            speedY = - breakout.getSpeed();
            lives -= 1; 
            m = true;
            //System.out.println(lives);
            if (lives == 0){
                speedY = 0;
                speedX = 0; 
                breakout.check();
                m = false;
            }
            
            
        }
        x += speedX;
        y += speedY; 
        }
        
        public Rectangle getBounds() { 
            return new Rectangle(x, y, SIZE, SIZE);
        }
        
        public boolean collision(int x) { 
            return getBounds().intersects(breakout.getBricks().get(x).getBounds());
        }
        public int lifechange(){ 
            m = false;
            return lives;
        }
        public void setSpeedY(int s){ 
            speedY = s;
        }
        public boolean print(){
            return m;
        }
}
