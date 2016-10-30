package musicPlayer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javafx.scene.media.Media;

public class AlbumButtonAction implements ActionListener {


	public void actionPerformed(ActionEvent e) {
		
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
