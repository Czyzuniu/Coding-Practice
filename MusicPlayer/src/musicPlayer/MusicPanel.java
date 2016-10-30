package musicPlayer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.TextArea;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class MusicPanel extends JPanel{

private JList<String> list;
private DefaultListModel<String> model;
private SystemInfo textArea;

	
public MusicPanel()
{
	Dimension size = getPreferredSize();
	size.width = 400;

	setPreferredSize(size);
	setBackground(Color.WHITE);
	
	setBorder(BorderFactory.createTitledBorder("Album"));
	
	model = new DefaultListModel<String>();
	list = new JList<String>(model);
	JScrollPane pane = new JScrollPane(list);
	
	model.addElement("Eminem - Not Afraid");
	model.addElement("Keke - Presja");
	model.addElement("Uncharted 4 - Nate's Theme");
	
	textArea = new SystemInfo();
	
	
	
	setLayout(new BorderLayout());
	
	add(pane);
	add(textArea, BorderLayout.EAST);
	
}

public int getSelected()
{
	return list.getSelectedIndex();
}
}
