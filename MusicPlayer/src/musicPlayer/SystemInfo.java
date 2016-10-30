package musicPlayer;




import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class SystemInfo extends JTextArea {

private Theme theme;


public SystemInfo()
{
	Font font = new Font("Arial", Font.BOLD, 13);
	Dimension size = getPreferredSize();
	size.width = 275;
	setBorder(BorderFactory.createTitledBorder("System information"));
	setPreferredSize(size);
	setFont(font);
	
	
	
	setLayout(new BorderLayout());
	
	
	(new Thread(theme = new Theme())).start();
	add(theme, BorderLayout.SOUTH);
	
}

private class Theme extends JPanel implements Runnable
{
	
	
	
	public Theme()
	{
		Dimension size = getPreferredSize();
		size.height = 250;
		setPreferredSize(size);
		
		
	}
	
	public void paint(Graphics g)
	{
		super.paintComponent(g);
		
		ImageIcon nowe_rzeczy = new ImageIcon("img/albums/0.jpg");
	
		
		if(HomePanel.getAlbumSelected() == "nowe_rzeczy")
		{
			g.drawImage(nowe_rzeczy.getImage(), 0, 0, 270, 270, null);
		}
			
		
		
		
		
		
		
	}

	
	public void run() {
		
	while(true)
	{
		revalidate();
		repaint();
	}
		
	}
	
	
}


	
	
	
}

