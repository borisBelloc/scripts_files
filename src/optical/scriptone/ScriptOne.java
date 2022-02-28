package optical.scriptone;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
import java.util.Set;

public class ScriptOne {

  public static void main(String[] args) {
    System.out.println("Hello World, Java app");
      
    ScriptOne sc = new ScriptOne();
    
    sc.getIt();
  }

//  -----------
//  [ ] Prendre toutes les clées du fichier FR non présente dans fichier EN et les ajouter dans fichier EN
//  [ ] Comparer Fichier FR et EN et virer les lignes identiques (non traduite)
//  [ ] Extraire les clés BE "combox" pour faire un autre fichier (pas à traduire)
//  -----------
  
  
  // [ ] Parcourir 2 fichiers
  // [ ] Comparer 2 fichier
  // [ ] ecrire dans un fichiers
 
	public void getIt() {
		// Test : voir le path
//		File directory = new File("/src/optical/files/");
//		System.out.println(directory.getAbsolutePath());
		

		// File location
		String filesLocation = "./src/optical/files/";
		String filesLocationOutput = "./src/optical/filesoutput/";
		
		String fileEn = "Messages_en.properties";
		String fileFr = "Messages_fr.properties";
		
		String fileOutputOne = "Output_one.properties";
		
		// Wanted files (lang)
		File englishFileLocation = new File(filesLocation + fileEn);
		File frenchFileLocation = new File(filesLocation+ fileFr);
		
		InputStream streamEn, streamFr;
		
		Properties propEn = new Properties();    
		Properties propFr = new Properties();    
		try {
			streamEn = new FileInputStream(englishFileLocation);
			propEn.load(streamEn);
			
			streamFr = new FileInputStream(frenchFileLocation);
			propFr.load(streamFr);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("------ FR² -------");
//		System.out.println(propEn);
		System.out.println(propFr);
		System.out.println("-------------");
		
// -----------------
	    // Iterating properties using For-Each

	    Set<String> keys = propFr.stringPropertyNames();
	    for (String key : keys) {
	      System.out.println(key + " : " + propFr.getProperty(key));
	    }
		
//- -------------------------
	    // Ecrire dans fichier properties
	    Properties properties = new Properties();
	    try(OutputStream outputStream = new FileOutputStream(filesLocationOutput + fileOutputOne)){  
	        properties.setProperty("prop1", "Value1");
	        properties.setProperty("prop2", "Value2");
//	        properties.store(outputStream, null);
	        properties.store(outputStream, "oris");
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    
		
		
	}
	
}
		
		
	
	
	
  
