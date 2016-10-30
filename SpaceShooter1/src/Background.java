import java.awt.Graphics;
import javax.swing.ImageIcon;
 
public class Background {
    private ImageIcon image;
 
    private int x;
    private int y;
 
    
 
    public Background(int x, int y, ImageIcon bg) {
        this.x = x;
        this.y = y;
        this.image = bg;
 
        
    }
 
    /**
     * Method that draws the image onto the Graphics object passed
     * @param window
     */
    public void paint(Graphics g) {
 
   
        g.drawImage(image.getImage(), getX(), getY(), 1000, 1000, null);
 
 
        this.y += 1;
 
        if (this.y >= 1 * 1000) {
 
            this.y = this.y - 1000 * 2;
        }
 
    }
 
    public void setX(int x) {
        this.x = x;
    }
    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }
 
 
    
 
}