package webDevDirBuilder;

import java.awt.*;
import java.awt.event.*;
import java.io.File;

import javax.swing.*;

import webDevDirBuilder.Card;

public class Menu implements ItemListener {

	static JPanel cards; //a panel that uses CardLayout
	// add titles for JPanels here as final static Strings
    final static String BUTTONPANEL = "JPanel with JButtons";
    final static String ABOUTTEXT = "AboutText";

    public void addComponentToPane(Container pane) {
        //Create the cards
        // CARD1: external card built in another class
        JPanel card1 = new Card().getCard();

        // CARD2 = About
        JPanel card2 = new JPanel();
        card2.setBackground(Color.WHITE);
        JTextArea aboutText = new JTextArea();
        aboutText.setPreferredSize(new Dimension(400, 600));
        aboutText.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        aboutText.setAlignmentX(Component.LEFT_ALIGNMENT);
        aboutText.setWrapStyleWord(true);
        aboutText.setEditable(false);
        aboutText.setLineWrap(true);
        aboutText.setText("WDDB - webDevDirBuilder\n");
        aboutText.append("----------------------------------------------\n");
        aboutText.append("\n");
        aboutText.append("Der 'WDDB' soll Dir das erstellen von PHP/HTML/CSS/JS-Webanwendungen erleichtern.\n");
        aboutText.append("\n");
        aboutText.append("'WDDB' erstellt einen neuen Projekt-Ordner mit der darunterliegenden Struktur");
        aboutText.append("Das Programm liest die Verzeichnisstruktur aus der 'config.properties'-Datei aus.\n");
        aboutText.append("\n");
        aboutText.append("Standardmäßig legt das Programm folgende Verzeichnisstruktur an: ");
        aboutText.append("\n");
        aboutText.append("[d] Projektname/\n" +
        				 "[d] |  app/\n" +
        				 "[d] |  |  config/\n" +
        				 "[d] |  |  log/\n" +
        				 "[d] |  |  MVC/\n" +
        				 "[d] |  |  |  Controller/\n" +
        				 "[d] |  |  |  Model/\n" +
        				 "[d] |  |  |  View/\n" +
        				 "[d] |  web/\n" +
        				 "[d] |  |  css/\n" +
        				 "[d] |  |  img/\n" +
        				 "[d] |  |  js/\n" +
        				 "[f]  |  |  index.php\n" +
        				 "[f]  |  |  index.html\n" +
		        		 "[d] |  tests/\n");
        aboutText.append("\n");
        aboutText.append("HOW-TO-USE:\n");
        aboutText.append("1. Gib einen Projektnamen an.\n");
        aboutText.append("2. Wähle das Verzeichnis aus, in welchem das Projekt angelegt werden soll, indem Du auf das Ordner-Icon klickst.\n");
        aboutText.append("3. Fertig. Importiere das angelegte Verzeichnis als bestehendes Projekt in die IDE Deiner Wahl.");
        aboutText.append("----------------------------------------------\n");
        aboutText.append("© 2016 - F.Petruschke\n");
        card2.add(aboutText);
        
        JButton backBtn = new JButton("zurück");
        backBtn.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent ev) {
		    	CardLayout cl = (CardLayout)(cards.getLayout());//get layout of cards from card panel
		    	cl.show(cards, BUTTONPANEL);//show another card
		    }
		});
        card2.add(backBtn, BorderLayout.PAGE_END);
        
        //Create the panel that contains the "cards".
        cards = new JPanel(new CardLayout());
        cards.add(card1, BUTTONPANEL);
        cards.add(card2, ABOUTTEXT);

        //pane.add(comboBoxPane, BorderLayout.PAGE_START);
        pane.add(cards, BorderLayout.PAGE_START);
        
    }

    public void itemStateChanged(ItemEvent evt) {
        CardLayout cl = (CardLayout)(cards.getLayout());
        cl.show(cards, (String)evt.getItem());
    }

    /**
     * Create the GUI and show it.
     */
    private static void createAndShowGUI() {
        //Create and set up the main window - which is a JFrame
    	
    	// main window title
        JFrame frame = new JFrame("WDDB - webDevDirBuilder");
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        frame.setBackground(SystemColor.activeCaptionBorder);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    // setting the position of the frame to the middle of the screen
	    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	    frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    // setting up the Menubar
	    JMenuBar jmb = new JMenuBar();
	    JMenu jmMenu = new JMenu("Menü");
	    JMenuItem jmiAbout = new JMenuItem("Über");
	    JMenuItem jmiExit = new JMenuItem("Beenden");
	    jmiAbout.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent ev) {
		    	CardLayout cl = (CardLayout)(cards.getLayout());//get layout of cards from card panel
		    	cl.show(cards, ABOUTTEXT);//show another card
		    }
		});
	    jmiExit.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent ev) {
		            System.exit(0);
		    }
		});
	    jmMenu.add(jmiAbout);
	    jmMenu.addSeparator();
	    jmMenu.add(jmiExit);
	    jmb.add(jmMenu);

        //Create and set up the content pane.
        Menu demo = new Menu();
        // get's the correct content pane
        demo.addComponentToPane(frame.getContentPane());

        //Display the window.
        frame.pack();
        frame.setJMenuBar(jmb);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });

    }
}
