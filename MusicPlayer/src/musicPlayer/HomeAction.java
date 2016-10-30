package musicPlayer;

import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;


public class HomeAction implements MenuListener {

	protected MusicPlayer musicPlayer;
	protected HomePanel homePanel;
public HomeAction(MusicPlayer musicPlayer, HomePanel homePanel)
{
	this.musicPlayer = musicPlayer;
	this.homePanel = homePanel;
}
	


@Override
public void menuCanceled(MenuEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void menuDeselected(MenuEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void menuSelected(MenuEvent e) {
	
	
	
	musicPlayer.setVisible(false);
	homePanel.setVisible(true);
	
	
	
}
}
