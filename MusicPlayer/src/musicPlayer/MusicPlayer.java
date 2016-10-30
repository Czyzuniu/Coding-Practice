package musicPlayer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.Timer;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;

@SuppressWarnings("serial")
public class MusicPlayer extends JPanel {

	private static MediaPlayer mediaPlayer;
	private static Media media;
	private static JList<String> list;
	private static DefaultListModel<String> model;
	
	private static ArrayList<String> songs = new ArrayList<String>();
	private static ArrayList<Media> music = new ArrayList<Media>();
	private static int position;
	private static JButton playButton;
	private SystemInfo textArea;

	
	
	public MusicPlayer() {
		
		Dimension size = getPreferredSize();
		size.width = 400;

		setPreferredSize(size);
		setBackground(Color.WHITE);

		setBorder(BorderFactory.createTitledBorder("My music"));

		load();
		createList();
		createInfoBar();
		createPlayButton();
		
		
	
		
		setVisible(false);

	}
	
	
	
	public void createInfoBar()
	{
		textArea = new SystemInfo();
		add(textArea, BorderLayout.EAST);
	}

	public void createList() {
		model = new DefaultListModel<String>();
		list = new JList<String>(model);
		JScrollPane pane = new JScrollPane(list);
		
		
		setLayout(new BorderLayout());

		add(pane);

		
		
		
		position = list.getSelectedIndex();
		
		list.addListSelectionListener(new ListSelectionListener() {

			public void valueChanged(ListSelectionEvent e) {
				
			position = list.getSelectedIndex();
			
			
			createPlayer();
			
			
				
			}

		});

	}
	
	public void createPlayButton()
	{
		playButton = new JButton("Play!");
		playButton.setToolTipText("Select a song and play it!" );
		
		add(playButton, BorderLayout.SOUTH);
		playButton.addActionListener(new ActionListener(){

			Timer timer = new Timer(1500, new ActionListener(){

				
				public void actionPerformed(ActionEvent e) {
					
					textArea.setText("");
					
				
				}
				
			});
			

			Timer timer1 = new Timer(500, new ActionListener(){

				
				public void actionPerformed(ActionEvent e) {
					
					textArea.append("Now Playing: " + MusicPlayer.getSelectedTrack() + "\n");
					
				
				}
				
			});
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				
				
				timer.start();
				timer1.start();
				
				
				if(MusicPlayer.getPosition() >= 0)
				{
					
					
					if(MusicPlayer.Status() == Status.READY || MusicPlayer.Status() == Status.PAUSED)
					{
						textArea.setText("");
						MusicPlayer.play();
						textArea.append("Now Playing: " + MusicPlayer.getSelectedTrack() + "\n");
						playButton.setText("Pause!");
						playButton.setToolTipText("Pause " +  MusicPlayer.getSelectedTrack());
					}
					else if(MusicPlayer.Status() == Status.PLAYING)
					{
						playButton.setText("Play!");
						MusicPlayer.pause();
						playButton.setToolTipText("Resume " +  MusicPlayer.getSelectedTrack());
					}
					
				}
				else
				{
					textArea.setText("");
					textArea.append("No song Selected!\n");
					
					
				}
				
				
				
			}
			
		
			
		});
	}
	
	public static String getSelectedTrack()
	{
		return list.getSelectedValue();
	}

	public static void load() {

		new javafx.embed.swing.JFXPanel();
		//getSongs().add(new File("songs/Eminem - Not Afraid.mp3").toURI().toString());
		//getSongs().add(new File("songs/KęKę - Presja prod. Uraz.mp3").toURI().toString());
		//getSongs().add(new File("songs/Uncharted 4 A Thiefs End - Nates Theme 4.0.mp3").toURI().toString());

		for (int i = 0; i < getSongs().size(); i++) {
			getMusic().add(new Media(getSongs().get(i)));
			
		}

		
		

	}
	
	public static void createPlayer()
	{
		mediaPlayer = new MediaPlayer(getMusic().get(position));
	}
	
	public static int getPosition()
	{
		return position;
	}


	public static void play() {

	mediaPlayer.play();
	


	}
	
	public static Status Status()
	{
		return mediaPlayer.getStatus();
	}
	
	
	

	

	public static void pause() {
		
		mediaPlayer.pause();
		
	}
	
	public static void stop()
	{
		mediaPlayer.stop();
	}

	public static String getMusic(int index) {
		return getSongs().get(index);
	}

	public static ArrayList<String> getSongs() {
		return songs;
	}

	public static void setSongs(ArrayList<String> songs) {
		MusicPlayer.songs = songs;
	}

	
	public static DefaultListModel<String> getListModel()
	{
		return model;
	}

	public static ArrayList<Media> getMusic() {
		return music;
	}

	public static void setMusic(ArrayList<Media> music) {
		MusicPlayer.music = music;
	}



	
	

}
