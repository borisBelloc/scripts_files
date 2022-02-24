package optical.scriptone;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;

public class ScriptOne {

  public static void main(String[] args) {
    System.out.println("Hello World, Java app");
      
    ScriptOne sc = new ScriptOne();
    
    sc.getIt();
  }
  
 
	public void getIt() {
		// Test : voir le path
//		File directory = new File("/src/optical/files/");
//		System.out.println(directory.getAbsolutePath());
		
		Properties propEn = new Properties();    
		Properties propFr = new Properties();    

		// File location
		String filesLocation = "./src/optical/files/";
		String fileEn = "Messages_en.properties";
		String fileFr = "Messages_fr.properties";
		
		// Wanted files (lang)
		File englishFileLocation = new File(filesLocation + fileEn);
		File frenchFileLocation = new File(filesLocation+ fileFr);
		
		InputStream streamEn, streamFr;
		/** 
		 * get all files
		 * */
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
		
//		System.out.println(propEn);
		System.out.println("------ FR -------");
		System.out.println(propFr);
		System.out.println("-------------");
		
// -----------------
	    // Iterating properties using For-Each

	    Set<String> keys = propFr.stringPropertyNames();
	    for (String key : keys) {
	      System.out.println(key + " : " + propFr.getProperty(key));
	    }
		
		
		
		
	}
	
}
		
		
	
	
	
  
