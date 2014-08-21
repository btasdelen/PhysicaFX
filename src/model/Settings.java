package model;

import java.io.*;

import javafx.scene.text.Font;

/**
 * @author furkan
 *
 */

public class Settings {
	
	private static String str = "";
	private static String fontName;
	private static Font font;
	private static int fontSize;
	private static String graphics;
	private static File file = new File("settings");

	public Settings() throws IOException
	{
		
		Reader reader = new FileReader(file);

	    int data = reader.read();
	    while(data != -1){
	        char dataChar = (char) data;
	        str += dataChar;
	        data = reader.read();
	    }
	    reader.close();
	    
	    fontName = str.substring(str.indexOf('[', str.indexOf("Font")) + 1, str.indexOf(']', str.indexOf("Font")));
	    fontSize = Integer.parseInt(str.substring(str.indexOf('[', str.indexOf("FontSize")) + 1, str.indexOf(']', str.indexOf("FontSize"))));
	    font = new Font(fontName, fontSize);
	    if (str.substring(str.indexOf('[', str.indexOf("graphics")) + 1, str.indexOf(']', str.indexOf("AntiAlias"))).equals("2D")) {
	    	graphics = "2D";
	    }
	    else {
	    	graphics = "3D";
	    }

	}
	
	public static Font getFont() {
		font = new Font(fontName, fontSize);
		return font;
	}
	public static void setFont(String fontname, String fontsize) {
		str = str.replace(fontName, fontname);
		str = str.replace("" + fontSize, fontsize);
		fontName = fontname;
		fontSize = Integer.parseInt(fontsize);
	}
	
	public static void graphics(String g){
		str = str.replace(graphics, g);
		graphics = g;
	}
	
	public static String graphics() {
		return graphics;
	}
	
	public static void saveSettings() throws IOException {
		Writer writer = new FileWriter(file);
		writer.write(str);
		writer.close();
	}
}