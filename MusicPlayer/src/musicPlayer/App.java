package musicPlayer;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class App extends JFrame implements Runnable {

	private JFrame frame;
	private MusicPlayer musicPlayer;
	
	
	
	public void createMenuBar()
	{
		JMenuBar menuBar = new JMenuBar();
		
		
		
		JMenu fileMenu = new JMenu("File");
		JMenu editMenu = new JMenu("Edit");
		JMenu helpMenu = new JMenu("Help");
		
		menuBar.add(fileMenu);
		
		JMenuItem newFile = new JMenuItem("New " + frame.getTitle());
		JMenu playerTab = new JMenu("MusicPlayer");
		
		
		fileMenu.add(newFile);
		fileMenu.add(playerTab);
		
		
	
		
		JMenuItem addSong = new JMenuItem("Add song");
		
		addSong.addActionListener(new AddSong());
		
		JMenuItem removeSong = new JMenuItem("Remove song");
		
	
		
		playerTab.add(addSong);
		playerTab.add(removeSong);
		
		menuBar.add(editMenu);
		menuBar.add(helpMenu);
		frame.setJMenuBar(menuBar);

		
	}
	public void run() {
		
		frame = new GUI(musicPlayer = new MusicPlayer(), new HomePanel(musicPlayer));
		frame.setSize(600, 600);
		ImageIcon windowIcon = new ImageIcon("img/music_icon.png");
		frame.setIconImage(windowIcon.getImage());
		frame.setPreferredSize(new Dimension(600,600));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setTitle("MusicPlayer");
		createMenuBar();
		frame.pack();
		frame.setResizable(false);
		frame.setVisible(true);
		
		
	
		
		
		
	}
	
	public static void main(String[] args)
	{
		
		
	 new Thread(new App()).start();
	
		
		
	}

	



}
