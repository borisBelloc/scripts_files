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

public class FindDuplicateLines {
	
	/**
	 * fileEn is the intial file for the output file
	 */
	public void findDuplicateLineAndRemoveFromNewFile() {
		System.out.println("----- Start script -----");
		
		// File location
		String filesLocation = "./src/bb/files/";
		String fileEn = "Messages_en.properties";
		String fileFr = "Messages_fr.properties";
		
		String filesLocationOutput = "./src/bb/filesoutput/";
		String fileOutput = "File_without_duplicate_keys.properties";
		
		// Wanted files (lang)
		File englishFileLocation = new File(filesLocation + fileEn);
		File frenchFileLocation = new File(filesLocation+ fileFr);
		
		InputStream streamEn, streamFr, streamOutput;
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
			// Ini propOutputMissingKeys with properties from FileEn
			streamOutput = new FileInputStream(englishFileLocation);
			propOutputMissingKeys.load(streamOutput);
			
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
		

		//[ ] Comparer Fichier FR et EN
		// dans fichier EN, enlever value des ligne identique au fichier fr
		
		
		Set<String> setEn = propEn.stringPropertyNames();
//		Set<String> setFr = propFr.stringPropertyNames();
//		Set<String> finalProp = setEn;
		
		System.out.println("-------");
		System.out.println(propEn);
		System.out.println(propFr);
		System.out.println(propOutputMissingKeys);
		
		  /**
		   * Writte each key inside new file
		   */
		  try(OutputStream outputStream = new FileOutputStream(filesLocationOutput + fileOutput)) {
			  
//			  propOutputMissingKeys.store(outputStream, null);

			  
			  for (String key : setEn) {
				  if (propEn.getProperty(key).equals(propFr.getProperty(key))) {
					  propOutputMissingKeys.setProperty(key, "");
				  }
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
