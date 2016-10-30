import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Menu extends JPanel {


public Menu()
{
	game = new Game();
}
	
public void paint(Graphics g)
{
	ImageIcon menu_background = new ImageIcon("../SpaceShooter1/src/bg2.png");
	g.drawImage(menu_background.getImage(), 0, 0, null);
}




public void draw()
{

	
	Menu menu = new Menu();
	JFrame window = new JFrame();
	window.setSize(1000,1000);
	window.setLayout(new BorderLayout());
	window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	window.setLocationRelativeTo(null);
	
	
	JButton newGame = new JButton("New Game");
	newGame.setFont(new Font("Arial", Font.BOLD, 35 ));
	newGame.setBounds(250, 200, 500,80);
	newGame.addActionListener( new ActionListener()
	{
	    public void actionPerformed(ActionEvent e)
	    {
	    	
	    menu.startGame();
	    
	    	
	    }
	});
	
	
	JButton LoadGame = new JButton("Load Game");
	LoadGame.setFont(new Font("Arial", Font.BOLD, 35 ));
	LoadGame.setBounds(250, 350, 500,80);
	
	
	JButton Options = new JButton("Options");
	Options.setFont(new Font("Arial", Font.BOLD, 35 ));
	Options.setBounds(250, 500, 500,80);
	
	JButton Exit = new JButton("Exit");
	Exit.setFont(new Font("Arial", Font.BOLD, 35 ));
	Exit.setBounds(250, 650, 500,80);
	Exit.addActionListener( new ActionListener()
	{
	    public void actionPerformed(ActionEvent e)
	    {
	    
	    window.dispose();
	    window.setVisible(false);
	    	
	    }
	});
	
	
	
	window.add(newGame);
	window.add(LoadGame);
	window.add(Options);
	window.add(Exit);
	window.add(menu);
	
	
	window.setVisible(true);
	
}

public static void main(String[] args) throws InterruptedException
	{
	
	Menu menu = new Menu();
	menu.draw();
	
	}


	
}
	
	
