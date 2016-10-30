import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class Player {

private int xPos;
private int yPos;
private int width;
private int height;
private int xSpeed;
private Game game;
private int HP;

public Player(Game game, int xPos, int yPos)
{
	this.game = game;
	this.setxPos(xPos);
	this.setyPos(yPos);
	setWidth(70);
	setHeight(80);
	setxSpeed(0);
	setHP(1000);
}

public void move()
{
	if (xPos + xSpeed < 0) {
		xSpeed = 0;
	}

	else if (xPos + xSpeed > game.getWidth() - width) {
		xSpeed = -0;
	}
	
	xPos = xPos + xSpeed;
	
	if(getHP() <= 0)
	{
		game.gameOver();
	}
}

public void keyPressed(KeyEvent e)
{
	if(e.getKeyCode() == KeyEvent.VK_RIGHT)
	{
		setxSpeed(5);
	}
	if(e.getKeyCode() == KeyEvent.VK_LEFT)
	{
		setxSpeed(-5);
	}
}

public void keyReleased(KeyEvent e)
{
	setxSpeed(0);
}

public void loseHP(int hp)
{
	HP = HP - hp;
}



public void paint(Graphics g)
{
	ImageIcon player = new ImageIcon("../Images/spaceship.png");
	g.drawImage(player.getImage(), getxPos(), getyPos(), getWidth(), getHeight(), null);
	g.setFont(new Font("Arial", Font.BOLD, 25));
	g.setColor(Color.orange);
	g.drawString("HP: " + getHP(), xPos , yPos - 15);
}

public int getxPos() {
	return xPos;
}

public void setxPos(int xPos) {
	this.xPos = xPos;
}

public int getyPos() {
	return yPos;
}

public void setyPos(int yPos) {
	this.yPos = yPos;
}

public int getWidth() {
	return width;
}

public void setWidth(int width) {
	this.width = width;
}

public int getHeight() {
	return height;
}

public void setHeight(int height) {
	this.height = height;
}

public int getxSpeed() {
	return xSpeed;
}

public void setxSpeed(int xSpeed) {
	this.xSpeed = xSpeed;
}

public Rectangle bounds()
{
	return (new Rectangle(getxPos(),getyPos(),getWidth(),getHeight()));
}

public int getHP() {
	return HP;
}

public void setHP(int hP) {
	HP = hP;
}
}
