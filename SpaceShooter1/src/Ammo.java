import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;


public class Ammo {

private int ammo;
@SuppressWarnings("unused")
private Game game;

public Ammo(Game game)
{
	this.game = game;
	addAmmo(50);
	
}




public int getAmmo()
{
	return ammo;
}

public void addAmmo(int ammo)
{
	this.ammo = ammo;
}

public void takeAway(int a)
{
	ammo = ammo - a;
}

public void paint(Graphics g)
{
	g.setColor(Color.WHITE);
	g.drawString("Ammo left: " + getAmmo(), 50, 50);

}

public void keyPressed(KeyEvent e)
{
	if(e.getKeyCode() == KeyEvent.VK_R && getAmmo() < 1)
	{
		addAmmo(50);// reload
	}
}

}
