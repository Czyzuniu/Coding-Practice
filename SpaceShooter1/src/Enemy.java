import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class Enemy {

private int xPos;
private int yPos;
private int width;
private int height;
private int xSpeed;
private int ySpeed;
private Game game;
private boolean isDestroyed;
private int hp;
private int startY;

public Enemy(Game game, int xPos, int yPos)
{
	this.game = game;
	this.setxPos(xPos);
	this.setyPos(yPos);
	setWidth(52);
	setHeight(52);
	setxSpeed(0);
	setDestroyed(false);
	setHp(100);
	ySpeed = 2;
	startY = yPos;
	
}

public void attack()
{
	
}


public void move()
{
	/*
	if (xPos + xSpeed < 0) {
		xSpeed = 1;
	}

	else if (xPos + xSpeed > game.getWidth() - width) {
		ySpeed = -1;
		xSpeed = -1;
		
	}
	
	else if(yPos - ySpeed > game.getHeight() - 300  - height)
	{
		ySpeed = 0;
		xSpeed = 1;
	}
	
	if (yPos - 50 +ySpeed < 0) {
		ySpeed = 1;
		xSpeed = -1;
		
	}
	
	
	xPos = xPos + xSpeed;
	*/
	yPos = yPos + ySpeed;
}



public void paint(Graphics g)
{
	ImageIcon boss = new ImageIcon("../Images/boss.png");
	//ImageIcon boss1 = new ImageIcon("../Images/boss2.png");
	ImageIcon boss2 = new ImageIcon("../Images/boss3.png");
	ImageIcon boss3 = new ImageIcon("../Images/boss4.png");
	ImageIcon boss4 = new ImageIcon("../Images/boss5.png");
	ImageIcon boss5 = new ImageIcon("../Images/boss6.png");
	ImageIcon boss6 = new ImageIcon("../Images/boss7.png");
	ImageIcon boss7 = new ImageIcon("../Images/boss8.png");
	ImageIcon boss8 = new ImageIcon("../Images/boss9.png");
	ImageIcon boss9 = new ImageIcon("../Images/boss10.png");
	ImageIcon boss_end = new ImageIcon("../Images/boss_end.png");
	
	switch(game.getLevel())
	{
	case 1:
		g.drawImage(boss.getImage(), getxPos(), getyPos(), getWidth(), getHeight(), null);
		
		break;
	case 2: 
		g.drawImage(boss2.getImage(), getxPos(), getyPos(), getWidth(), getHeight(), null);
		break;
		
	case 3: 
		g.drawImage(boss3.getImage(), getxPos(), getyPos(), getWidth(), getHeight(), null);
		
		break;
	case 4: 
		g.drawImage(boss4.getImage(), getxPos(), getyPos(), getWidth(), getHeight(), null);
		
		break;
	case 5: 
		g.drawImage(boss5.getImage(), getxPos(), getyPos(), getWidth(), getHeight(), null);
		
		break;
	case 6: 
		g.drawImage(boss6.getImage(), getxPos(), getyPos(), getWidth(), getHeight(), null);
		
		break;	
	case 7: 
	
		g.drawImage(boss7.getImage(), getxPos(), getyPos(), getWidth(), getHeight(), null);
		break;
	case 8: 
		
		g.drawImage(boss8.getImage(), getxPos(), getyPos(), getWidth(), getHeight(), null);
		break;
	case 9: 
		
		g.drawImage(boss9.getImage(), getxPos(), getyPos(), getWidth(), getHeight(), null);
		break;	
	
	case 10: 
		
		g.drawImage(boss_end.getImage(), getxPos(), getyPos(), getWidth(), getHeight(), null);
		break;
		
	}
		
		
	g.setColor(Color.orange);
	g.drawString("HP : " + getHp(), xPos - 10 , yPos - 15);
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

public int getHp() {
	return hp;
}

public void setHp(int hp) {
	this.hp = hp;
}

public void loseHP(int hp)
{
	this.hp = this.hp - hp;
	if(getHp() <= 0)
	{
		setDestroyed(true);
	}
}

public void checkOfScreen()
{
	if(yPos > 1050)
	{
		yPos = startY;
	}
	}
}




