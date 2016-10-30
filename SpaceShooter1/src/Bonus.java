
import java.awt.*;
import javax.swing.ImageIcon;

public class Bonus {

	Game game;
	int xPosition;
	int yPosition;
	int ySpeed = 2;
	boolean fall = false;
	boolean isBad = false;
	boolean isLife = false;
	boolean isMegaBonus = false;

	public Bonus(Game game, int d, int e) {
		this.game = game;
		xPosition = d;
		yPosition = e;

	}

	public Bonus(Game game, int a, int b, boolean x) {
		this.game = game;
		xPosition = a;
		yPosition = b;
		isMegaBonus = x;

	}

	public double getX() {
		return xPosition;
	}

	public double getY() {
		return xPosition;
	}

	public void move() {

		yPosition = yPosition + ySpeed;

	}

	public void paint(Graphics g)  {
	
		ImageIcon bonus = new ImageIcon("../Images/coin.gif");
		g.drawImage(bonus.getImage(), xPosition, yPosition, null);
	}

	public Rectangle bounds() {
		return (new Rectangle(xPosition, yPosition, 25, 25));
	}

	public boolean fallDown() {
		if (yPosition + ySpeed > game.getHeight() - 25) {
			fall = true;
		}
		return fall;

	}

	public void badBonus() {
		isBad = true;
	}

	public boolean isBad() {
		return isBad;
	}

	public boolean isLife() {
		return isLife;
	}

	public void Life() {
		isLife = true;
	}
}
