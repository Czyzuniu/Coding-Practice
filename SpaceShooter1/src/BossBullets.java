
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.ImageIcon;



public class BossBullets {

private int xPos;
private int yPos;
private int width;
private int height;
private int ySpeed;
private Game game;
private boolean isDestroyed;
private int xSpeed;

public BossBullets(Game game, int xPos, int yPos)
{
	this.game = game;
	this.setxPos(xPos);
	this.setyPos(yPos);
	setWidth(34);
	setHeight(34);
	setySpeed(3);
	xSpeed = 0;
	setDestroyed(false);
	
}




public void move()
{
	
	yPos = yPos + ySpeed;
	xPos = xPos + xSpeed;
	if (yPos + ySpeed > game.getHeight() + height) {
		setDestroyed(true);
	}
	
	switch(game.getLevel())
	{
	case 1: xSpeed = 0;
	break;
		
	case 2: 
	break;
	}
}




public void paint(Graphics g)
{
	ImageIcon fire = new ImageIcon("../SpaceShooter1/src/fire.gif");
	
	
	switch(game.getLevel())
	{
	case 1:
		g.fillRect(getxPos(), getyPos(), 10, 20);
		break;
	case 2: 
		g.drawImage(fire.getImage(), getxPos(), getyPos(), getWidth(), getHeight(), null);
		break;
		
	case 3: 
		g.drawImage(fire.getImage(), getxPos(), getyPos(), getWidth(), getHeight(), null);
		break;
	case 4: 
		g.drawImage(fire.getImage(), getxPos(), getyPos(), getWidth(), getHeight(), null);
		break;
	case 5: 
		g.drawImage(fire.getImage(), getxPos(), getyPos(), getWidth(), getHeight(), null);
		break;
	case 6: 
		g.drawImage(fire.getImage(), getxPos(), getyPos(), getWidth(), getHeight(), null);
		break;	
	case 7: 
		g.drawImage(fire.getImage(), getxPos(), getyPos(), getWidth(), getHeight(), null);
		break;
	case 8: 
		g.drawImage(fire.getImage(), getxPos(), getyPos(), getWidth(), getHeight(), null);
		break;
	case 9: 
		g.drawImage(fire.getImage(), getxPos(), getyPos(), getWidth(), getHeight(), null);
		break;	
	
	case 10: 
		g.drawImage(fire.getImage(), getxPos(), getyPos(), getWidth(), getHeight(), null);
		break;
		
	}

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
