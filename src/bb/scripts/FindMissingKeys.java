package bb.scripts;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
import java.util.Set;
import java.util.logging.Logger;

public class FindMissingKeys {


  /**
   * Take 2 properties files
   * Keys present in fileEn and not in fileFr will be wrote inside a new file
   * * Input file : Messages_en.properties
   * * Input file : Messages_fr.properties
   * * Output file : Missing_keys.properties
   */
	public void findMissingKeysAndWriteToNewFile() {
		System.out.println("----- Start script -----");
		
		// File location
		String filesLocation = "./src/bb/files/";
		String fileEn = "Messages_en.properties";
		String fileFr = "Messages_fr.properties";
		
		String filesLocationOutput = "./src/bb/filesoutput/";
		String fileOutput = "Missing_keys.properties";
		
		// Wanted files (lang)
		File englishFileLocation = new File(filesLocation + fileEn);
		File frenchFileLocation = new File(filesLocation+ fileFr);
		
		InputStream streamEn, streamFr;
		
		Properties propEn = new Properties();    
		Properties propFr = new Properties();
		
		Properties propOutputMissingKeys = new Properties();
		
		/**
		 * Loading files
		 */
		try {
			streamEn = new FileInputStream(englishFileLocation);
			streamFr = new FileInputStream(frenchFileLocation);
			propEn.load(streamEn);
			propFr.load(streamFr);
			streamEn.close();
			streamFr.close();
			System.out.println("+ Successfully loaded file's content");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("ERROR * Failed to find file");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("ERROR * Failed to load file");
		}
		
		Set<String> setEn = propEn.stringPropertyNames();
		Set<String> setFr = propFr.stringPropertyNames();
		Set<String> finalSet = setEn;

		// Remove the keys present in both files
		finalSet.removeAll(setFr);
		
	  /**
	   * Writte each key inside new file
	   */
	  try(OutputStream outputStream = new FileOutputStream(filesLocationOutput + fileOutput)) {
		  for (String key : finalSet) {
			  propOutputMissingKeys.setProperty(key, propEn.getProperty(key));
		  }
		  propOutputMissingKeys.store(outputStream, null);
		  outputStream.close();
		  System.out.println("+ Successfully written inside file");
	  } catch (IOException e) {
	      e.printStackTrace();
			System.out.println("ERROR * Failed to write file inside File : propOutputMissingKeys");
	  }
	    
	  System.out.println("----- Successfully ended script -----");
	}
	
}


//
//log.info("connecting ... ftp server:" + serverFtpIp + ":" + serverFtpPort);
//log.error("connect failed ... ftp server:" + serverFtpIp + ":" + serverFtpPort);
//log.info("connect successful ... ftp server:" + serverFtpIp + ":" + serverFtpPort);
//




		
// Doc : 
// Voir le path
//File directory = new File("/src/optical/files/");
//System.out.println(directory.getAbsolutePath());

//-----------------
// Iterating properties using For-Each
//Set<String> keys = propFr.stringPropertyNames();
//for (String key : keys) {
//  System.out.println(key + " : " + propFr.getProperty(key));
//}

//- -------------------------
// Ecrire dans fichier properties
//Properties properties = new Properties();
//try(OutputStream outputStream = new FileOutputStream(filesLocationOutput + fileOutputOne)){  
//    properties.setProperty("prop1", "Value1");
//    properties.setProperty("prop2", "Value2");
//    properties.store(outputStream, " Key from file 1 not present inside file 2");
//} catch (IOException e) {
//    e.printStackTrace();
//}


		
	
	
	
  
