package musicPlayer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import javafx.scene.media.Media;

@SuppressWarnings("serial")
public class HomePanel extends JPanel{

	private static String albumSelected;

public HomePanel(MusicPlayer musicPlayer)
{
		
		albumSelected = null;
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createTitledBorder("Home"));
		Dimension size = getPreferredSize();
		size.width = 595;
		
		setPreferredSize(size);
		setBackground(Color.WHITE);

		AlbumPanel albumPanel = new AlbumPanel(this, musicPlayer);
		
		
		
		add(albumPanel, BorderLayout.SOUTH);
	
		
		
		
		
		
		
		
		
		
		
	}
	
	
	public static String getAlbumSelected() {
	return albumSelected;
}


	public static void setAlbumSelected(String albumSelected) {
	HomePanel.albumSelected = albumSelected;
}


	private class AlbumPanel extends JPanel{
		
		private ArrayList<ImageIcon>covers = new ArrayList<ImageIcon>();
		private ArrayList<JButton>buttons = new ArrayList<JButton>();
		
		
		public AlbumPanel(HomePanel homePanel, MusicPlayer musicPlayer)
		{
			
			this.setLayout(new GridLayout(2,4,8,8));
			setPreferredSize(new Dimension(300,300));
			setBackground(Color.WHITE);
			
			
			
			loadImages();
			
			
			for(int i = 0; i < 8;i++)
			{
				buttons.add(new JButton());
				buttons.get(i).setIcon(covers.get(i));
				
			
				
				buttons.get(i).addActionListener(new ActionListener(){

				
					public void actionPerformed(ActionEvent e) {
					
						
						
						if(buttons.get(0) == e.getSource())
						{
							setAlbumSelected("nowe_rzeczy");
							loadChosenAlbum();
						}
						else
						{
							System.out.println("the album you were trying to choose is not loaded");
						}
						
						homePanel.setVisible(false);
						musicPlayer.setVisible(true);
						
					}
					
					
				});
				
				add(buttons.get(i));
				
				
			}
			
			
			
			
		}
		
		public void loadImages()
		{
			
			for(int i = 0; i < 16;i++)
			{
				
				covers.add(new ImageIcon("img/albums/" + i + ".jpg"));
				Image img = covers.get(i).getImage();
				Image fixedSizeImage = img.getScaledInstance(150, 150,  java.awt.Image.SCALE_SMOOTH);
				covers.remove(i);
				covers.add(new ImageIcon(fixedSizeImage));
			
			}
			
			
				
			
		}
		
		public void loadChosenAlbum()
		{
			MusicPlayer.getListModel().clear();
			MusicPlayer.getSongs().clear();
			MusicPlayer.getMusic().clear();
			MusicPlayer.getListModel().addElement("1. Zmysły");
			MusicPlayer.getListModel().addElement("2. Młody Polak");
			MusicPlayer.getListModel().addElement("3. W dół kieliszki");
			MusicPlayer.getListModel().addElement("4. Niezrzeszony");
			MusicPlayer.getListModel().addElement("5. Pamięć zostaje");
			MusicPlayer.getListModel().addElement("6. Świadomość");
			MusicPlayer.getListModel().addElement("7. To co mam");
			MusicPlayer.getListModel().addElement("8. Nie bądź zły");
			MusicPlayer.getListModel().addElement("9. Wyjebane (tak mocno)");
			MusicPlayer.getListModel().addElement("10. Sprawy ważne");
			MusicPlayer.getListModel().addElement("11. Czasem muszę");
			MusicPlayer.getListModel().addElement("12. Fajnie");
			MusicPlayer.getListModel().addElement("13. Było Blisko");
			
			
			MusicPlayer.getSongs().add(new File("musicAlbums/nowe_rzeczy/01 Zmysły.mp3").toURI().toString());
			MusicPlayer.getSongs().add(new File("musicAlbums/nowe_rzeczy/02 Młody Polak.mp3").toURI().toString());
			MusicPlayer.getSongs().add(new File("musicAlbums/nowe_rzeczy/03 W Dół Kieliszki (WuDeKa).mp3").toURI().toString());
			MusicPlayer.getSongs().add(new File("musicAlbums/nowe_rzeczy/04 Niezrzeszony.mp3").toURI().toString());
			MusicPlayer.getSongs().add(new File("musicAlbums/nowe_rzeczy/05 Pamięć Zostaje.mp3").toURI().toString());
			MusicPlayer.getSongs().add(new File("musicAlbums/nowe_rzeczy/06 Świadomość.mp3").toURI().toString());
			MusicPlayer.getSongs().add(new File("musicAlbums/nowe_rzeczy/07 To Co Mam.mp3").toURI().toString());
			MusicPlayer.getSongs().add(new File("musicAlbums/nowe_rzeczy/08 Nie Bądź Zły.mp3").toURI().toString());
			MusicPlayer.getSongs().add(new File("musicAlbums/nowe_rzeczy/09 Wyjebane (Tak Mocno).mp3").toURI().toString());
			MusicPlayer.getSongs().add(new File("musicAlbums/nowe_rzeczy/10 Sprawy Ważne.mp3").toURI().toString());
			MusicPlayer.getSongs().add(new File("musicAlbums/nowe_rzeczy/11 Czasem Muszę.mp3").toURI().toString());
			MusicPlayer.getSongs().add(new File("musicAlbums/nowe_rzeczy/12 Fajnie.mp3").toURI().toString());
			MusicPlayer.getSongs().add(new File("musicAlbums/nowe_rzeczy/13 Było Blisko.mp3").toURI().toString());
			
			for(int i = 0; i < MusicPlayer.getSongs().size(); i++)
			{
				MusicPlayer.getMusic().add(new Media(MusicPlayer.getMusic(i)));
			}
			
		}
	}
}
