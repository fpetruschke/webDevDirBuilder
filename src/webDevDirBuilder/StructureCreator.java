package webDevDirBuilder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Enumeration;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class StructureCreator {

	public Boolean status = false;
	
	public StructureCreator(JFileChooser chooser, JTextField projectName) {
		
		Properties prop = new Properties();
		InputStream input = null;
		
		try {
			String filename = "config.properties";
			input = getClass().getClassLoader().getResourceAsStream(filename);
			if (input == null) {
				System.out.println("Sorry, unable to find " + filename);
				return;
			}
	
				prop.load(input);
				Enumeration<?> e = prop.propertyNames();
				while (e.hasMoreElements()) {
					// key and value from the properties file
					String key = (String) e.nextElement();
					String value = prop.getProperty(key);

					// create the path for the new directory
					File workingDir = chooser.getSelectedFile();					
					String path = workingDir + "/" + projectName.getText() + value;
					
					// check if project already exists
					File newDirectory = new File(path);
					if (newDirectory.isDirectory()) {
		        		System.out.println("NOTICE: Directory or file ( "+ path +" ) already exists. Processsing on...");
		        	}
					// make directory or file
					if(value.contains(".")) {
						System.out.println("Ich bin eine Datei: " + value);
						String[] file = value.split("\\.");
						String filePathAndName = file[0];
						String fileExtension = file[1];
						new ExtensionCheck(fileExtension, path);
						this.status = true;
					} else  {
						Boolean successfullyCreatedDirStructure = (newDirectory.mkdirs());
						// check if directory exists after creating
			        	if (!newDirectory.isDirectory()) {
			        		System.out.println("FAILURE while creating: " + path);
			        		this.status = false;
			        	} else {
			        		this.status = true;
			        	}
					}
				}
	
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public boolean getStatus() {
		return this.status;
	}
	
	/*public StructureCreator(JFileChooser chooser, JTextField projectName) throws FileNotFoundException, IOException {
		try (BufferedReader br = new BufferedReader(new FileReader(this.filename))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		    	System.out.println(line);
		       if("PROJECTNAME" == line) {
		    	   File workingDir = chooser.getSelectedFile();
	            	Boolean successfullyCreatedDirStructure = (new File(workingDir + "/" + projectName.getText())).mkdir();
	            	if(!successfullyCreatedDirStructure) {
	            		//return false;
	            		/*setIcon(new JLabel(new ImageIcon("src/failure.jpg")));
	            		JLabel notification = new JLabel("Das Erstellen für " + projectName.getText() + " ist fehlgeschlagen.");
	            		setNotification(card1, notification);*
	            	} else {
	            		//return true;
	            		/*setIcon(new JLabel(new ImageIcon("src/success.jpg")));
	            		JLabel notification = new JLabel("Das Erstellen für " + projectName.getText() + " war erfolgreich.");
	            		setNotification(card1, notification);*
	            	}
		       }
		       if(line.startsWith("#")) {
		    	   line = line.replace("#", "");
		    	   File workingDir = chooser.getSelectedFile();
		    	   Boolean successfullyCreatedDirStructure = (new File(workingDir + "/" + projectName.getText() + "/" + line)).mkdir();
		       }
		    }
		}
		
	}*/
	
}
