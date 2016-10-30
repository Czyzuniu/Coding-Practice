package musicPlayer;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

import javafx.scene.media.MediaPlayer.Status;

@SuppressWarnings("serial")
public class GUI extends JFrame {

private Container container;	
private SystemInfo textArea;
private MusicPlayer musicPlayer;
private HomePanel homePanel;

public GUI(MusicPlayer musicPlayer, HomePanel homePanel)
{
		this.musicPlayer = musicPlayer;
		this.homePanel = homePanel;
		
		container = getContentPane();
	
		createBottomBar();
		container.add(homePanel, BorderLayout.WEST);
		container.add(musicPlayer);
		

		
		
		
		
		
}

public void createBottomBar()
{
	
	
	JMenuBar bottomMenu = new JMenuBar();
	
	JMenu home = new JMenu("Home");
	home.setIcon(new ImageIcon("img/home_icon.png"));
	home.setIconTextGap(10);
	home.setToolTipText("Home Panel");
	home.addMenuListener(new HomeAction(musicPlayer, homePanel));
	
	JMenu gap1 = new JMenu("    	            ");
	gap1.setEnabled(false);
	
	
	JMenu music = new JMenu("My music");
	
	
	music.setIcon( new ImageIcon("img/music_icon.png"));
	music.setIconTextGap(10);
	music.setToolTipText("My music");
	
	music.addMenuListener(new MusicAction(musicPlayer, homePanel));
	
	
	JMenu gap2 = new JMenu("    	            ");
	gap2.setEnabled(false);
	
	JMenu search = new JMenu("Search");
	search.setIcon(new ImageIcon("img/search_icon.png"));
	search.setIconTextGap(10);
	search.setToolTipText("Look for songs");
	
	JMenu gap3 = new JMenu("    	            ");
	gap3.setEnabled(false);
	
	bottomMenu.add(gap1);
	bottomMenu.add(home);
	bottomMenu.add(gap2);
	bottomMenu.add(music);
	bottomMenu.add(gap3);
	bottomMenu.add(search);



	container.add(bottomMenu, BorderLayout.SOUTH);
	
	
	revalidate();
	repaint();
}

public void createInfoBar()
{
	textArea = new SystemInfo();
	container.add(textArea, BorderLayout.EAST);
}

}
