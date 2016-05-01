package webDevDirBuilder;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Card {

	public JPanel card;
	public JLabel icon;
	public JLabel notification;
	
	public Card() {
		//JPanel card = new JPanel();
        //card.setBackground(Color.CYAN);
		final JPanel card1 = new JPanel();
        card1.setBackground(Color.WHITE);
        
        // label for input field project name
        JLabel projectNameLabel = new JLabel("Wie soll das Projekt heißen?");
        card1.add(projectNameLabel);
        // input field project name
        final JTextField projectName = new JTextField(20);
        card1.add(projectName);
        
        JLabel notification = new JLabel();
        setNotification(card1, notification);
	    
        // create icon for directory chooser
        setIcon(new JLabel(new ImageIcon("src/tools.png")));
	    icon.addMouseListener(new MouseAdapter() {
			private Object successfullyCreatedDirStructure;
			public void mouseClicked(MouseEvent e)   
	        {   
				if(projectName.getText().isEmpty()) {
					setIcon(new JLabel(new ImageIcon("src/failure.jpg")));
            		JLabel notification = new JLabel("Du musst einen Projektnamen angeben.");
            		setNotification(card1, notification);
				} else {
		        	JFileChooser chooser = new JFileChooser();
		            chooser.setCurrentDirectory(new java.io.File("."));
		            chooser.setDialogTitle("Wähle das Verzeichnis, in dem das Projekt angelegt werden soll.");
		            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		            chooser.setAcceptAllFileFilterUsed(false);
		            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
		            	StructureCreator creator = new StructureCreator(chooser, projectName);
		            	if(creator.getStatus()) {
		            		JLabel successIcon = new JLabel(new ImageIcon("src/success.jpg"));
		            		JLabel successNotification = new JLabel("Das Erstellen für " + projectName.getText() + " war erfolgreich.");
		            		card1.add(successIcon);
		                    card1.add(successNotification);
		            	} else {
		            		JLabel failureIcon = new JLabel(new ImageIcon("src/failure.jpg"));
		            		JLabel failureNotification = new JLabel("Das Erstellen für " + projectName.getText() + " ist fehlgeschlagen.");
		            		card1.add(failureIcon);
		                    card1.add(failureNotification);
		            	}
		            } else {
		            	System.out.println("NONE");
		            }
				}
	        }   
	    });
	    card1.add(getIcon());
        card1.add(getNotification());
        this.card = card1;
	}
	
	public JPanel getCard() {
		return this.card;
	}
	
	public void setIcon(JLabel labelWithIcon) {
		this.icon = labelWithIcon;
	}
	
	public JLabel getIcon() {
		return this.icon;
	}
	
	public void setNotification(JPanel panelToPutNotificationOn, JLabel jlabelWithNote) {
		this.notification = jlabelWithNote;
		this.notification.repaint();
	}
	
	public JLabel getNotification() {
		return this.notification;
	}
}
