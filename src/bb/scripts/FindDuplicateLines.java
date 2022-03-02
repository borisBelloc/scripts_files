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
	 * Take 2 properties files
     * Keys present in both folder will have their value set to empty strinng inside output file
	 * fileEn is the intial file for the output file
	   * * Input file : Messages_en.properties
	   * * Input file : Messages_fr.properties
	   * * Output file : File_without_duplicate_keys.properties
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
		
		InputStream streamEn, streamFr;
		Properties propEn = new Properties();    
		Properties propFr = new Properties();
		
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
		// Convert prop file to Set<string> to browse keys
		Set<String> setEn = propEn.stringPropertyNames();
		
		  /**
		   * Writte each key inside new file
		   */
		  try(OutputStream outputStream = new FileOutputStream(filesLocationOutput + fileOutput)) {
			  for (String key : setEn) {
				  if (propEn.getProperty(key).equals(propFr.getProperty(key))) {
					  propEn.setProperty(key, "");
				  }
			  }
			  propEn.store(outputStream, null);
			  outputStream.close();
			  System.out.println("+ Successfully written inside file");
		  } catch (IOException e) {
		      e.printStackTrace();
				System.out.println("ERROR * Failed to write file inside File : propOutputMissingKeys");
		  }
		
		System.out.println("----- Successfully ended script -----");
	}


}
