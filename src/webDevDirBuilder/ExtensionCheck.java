package webDevDirBuilder;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class ExtensionCheck {
	
	public ExtensionCheck(String extension, String file) throws FileNotFoundException, UnsupportedEncodingException {
		
		System.out.println(extension);
		switch(extension) {
			case("php"):
				PrintWriter phpWriter = new PrintWriter(file, "UTF-8");
				phpWriter.println("<?php");
				phpWriter.println("/**");
				phpWriter.println(" *");
				phpWriter.println(" * I'm a php-file.");
				phpWriter.println(" *");
				phpWriter.println(" **/");
				phpWriter.close();
				break;
			case("html"):
				PrintWriter htmlWriter = new PrintWriter(file, "UTF-8");
				htmlWriter.println("<!doctype=html>");
				htmlWriter.println("<html>");
				htmlWriter.println("    <head>");
				htmlWriter.println("        <title>Testpage</title>");
				htmlWriter.println("    </head>");
				htmlWriter.println("    <body>");
				htmlWriter.println("        <h1>Hello World!</h1>");
				htmlWriter.println("    </body>");
				htmlWriter.println("</html>");
				htmlWriter.close();
				break;
			default:
				PrintWriter defaultWriter = new PrintWriter(file, "UTF-8");
				defaultWriter.println("#############################");
				defaultWriter.println("# webDevDirBuilder built me #");
				defaultWriter.println("#############################");
				defaultWriter.close();
				break;
		}
		
		
	}
}
