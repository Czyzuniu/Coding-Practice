import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;


public class EnemyBullet {

private int xPos;
private int yPos;
private int width;
private int height;
private int ySpeed;
private Game game;
private boolean isDestroyed;

public EnemyBullet(Game game, int xPos, int yPos)
{
	this.game = game;
	this.setxPos(xPos);
	this.setyPos(yPos);
	setWidth(34);
	setHeight(34);
	setySpeed(3);
	setDestroyed(false);
	
}




public void move()
{
	
	yPos = yPos + ySpeed;
	if (yPos + ySpeed > game.getHeight() + height) {
		setDestroyed(true);
	}
}




public void paint(Graphics g)
{
	g.setColor(Color.white);
	g.fillRect(xPos, yPos, 5, 10);

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

public int getySpeed() {
	return ySpeed;
}

public void setySpeed(int ySpeed) {
	this.ySpeed = ySpeed;
}

public boolean isDestroyed() {
	return isDestroyed;
}

public void setDestroyed(boolean isDestroyed) {
	this.isDestroyed = isDestroyed;
}

public Rectangle bounds()
{
	return (new Rectangle(getxPos(),getyPos(),getWidth(),getHeight()));
}
}
