import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.ImageIcon;


public class Bullet {

private int xPos;
private int yPos;
private int width;
private int height;
private int ySpeed;
private Game game;
private boolean isDestroyed;
private Gun gun = new Gun(game);

public Bullet(Game game, int xPos, int yPos, String weapon)
{
	
	this.setGame(game);
	this.setxPos(xPos);
	this.setyPos(yPos);
	//setWidth(5);
	//setHeight(10);
	setySpeed(4);
	setDestroyed(false);
	weapon = gun.getGun();
	
	
}




public void move()
{
	if (yPos + ySpeed < 0) {
		setDestroyed(true);
	}
	yPos = yPos - ySpeed;
}





public void paint(Graphics g)
{

	ImageIcon rockets = new ImageIcon("../Images/rocket.png");
	ImageIcon fire = new ImageIcon("../Images/fire.gif");
	
	switch(game.currentGun())
	{
	case "Missiles":  
		width = 5;
		height = 10;
		g.fillRect(getxPos(), getyPos(), width,height);
	
	//System.out.println(gun.getGun());
	break;
	
	case "Rocket Launcher": 
		width = 5;
		height = 40;
		g.fillRect(getxPos(), getyPos(), width,height);
	break;
	
	case "Fireballs":  
		width = 64;
		height = 64;
		g.drawImage(fire.getImage(), getxPos() - 30, getyPos() - 64, width, height, null);
	//System.out.println(gun.getGun());
	break;
	
	case "Double Missile":  
		
		width = 5;
		height = 10;
		g.fillRect(getxPos() - 10, getyPos(), width, height);
		g.fillRect(getxPos() + 20, getyPos(), width, height);
	//System.out.println(gun.getGun());
							
	break;
	
	case "Plasma":  
		width = 60;
		height = 60;
		g.fillArc(getxPos() - 30, getyPos() - 64, width, height, 0, 360);
	System.out.println(gun.getGun());
	break;
	
	}
	g.setColor(Color.green);
	//g.fillRect(getxPos(), getyPos(), getWidth(), getHeight());

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
	 
	return (new Rectangle(xPos,yPos,width,height));
	
	
	
}




public Game getGame() {
	return game;
}




public void setGame(Game game) {
	this.game = game;
}
}
