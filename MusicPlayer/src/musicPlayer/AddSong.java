package musicPlayer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.DefaultListModel;

import javafx.scene.media.Media;

public class AddSong implements ActionListener {

	
	public void actionPerformed(ActionEvent e) {
		
		MusicPlayer.getSongs().add(new File("songs/Song of elune.mp3").toURI().toString());
		MusicPlayer.getSongs().add(new File("songs/Uncharted 4 A Thiefs End - Nates Theme 4.0.mp3").toURI().toString());
		
		MusicPlayer.getMusic().add(new Media(MusicPlayer.getSongs().get(0)));
		MusicPlayer.getMusic().add(new Media(MusicPlayer.getSongs().get(1)));
		
		DefaultListModel<String> listModel = MusicPlayer.getListModel();
		
		listModel.addElement("Song of Elune");
		listModel.addElement("Uncharted 4");
		
		System.out.println("song added");
		
	}

}
