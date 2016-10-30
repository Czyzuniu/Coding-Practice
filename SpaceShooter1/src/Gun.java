import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;



public class Gun {

	
private ArrayList<String>guns;
private String gun;
private int gunIndex = 0;
@SuppressWarnings("unused")
private Game game;

public Gun(Game game)
{
	
	this.game = game;
	guns = new ArrayList<String>();
	guns.add("Missiles");
	guns.add("Rocket Launcher");
	guns.add("Fireballs");
	guns.add("Double Missile");
	guns.add("Plasma");
	
}




public Gun() {
	guns = new ArrayList<String>();
	//guns.add("Missiles");
	guns.add("Rocket Launcher");
	guns.add("Fireballs");
	guns.add("Double Missile");
	guns.add("Plasma");
}




public String getGun()
{
	return guns.get(gunIndex);
}


public void paint(Graphics g)
{
	g.setColor(Color.WHITE);
	g.drawString("Current Gun : " + getGun(), 600, 50);

}



public void keyPressed(KeyEvent e)
{
	if(e.getKeyCode() == KeyEvent.VK_UP)
	{
		System.out.println(gunIndex);
		gunIndex++;
		if(gunIndex == guns.size())
		{
			gunIndex = 0;
		}
	}
	if(e.getKeyCode() == KeyEvent.VK_DOWN)
	{
		gunIndex--;
		if(gunIndex == -1)
		{
			gunIndex = 4;
		}
		System.out.println(gunIndex);
	}
}

}
