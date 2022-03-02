package bb.scripts;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class FindKeyWithString {
	
	/**
	 * Take 1 properties file
     * Keys with "combox" are removed and written in new file
	 * @throws IOException 

	 */
	public void findKeyByString() throws IOException {
		System.out.println("----- Start script -----");

		// File location
		String filesLocation = "./src/bb/files/";
		String fileEn = "Messages_en.properties";
		
		String filesLocationOutput = "./src/bb/filesoutput/";
		String fileOutput = "File_without_combox_keys.properties";
		String fileOutputCombox = "File_combox_keys.properties";
		
		// Wanted files (lang)
		File englishFileLocation = new File(filesLocation + fileEn);
		
		InputStream streamEn;
		Properties propEn = new Properties();    
		Properties propOutput = new Properties();    
		Properties propOutputCombox = new Properties();    
		
		/**
		 * Loading files
		 */
		try {
			streamEn = new FileInputStream(englishFileLocation);
			propEn.load(streamEn);
			streamEn.close();
			
			System.out.println("+ Successfully loaded file's content");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("ERROR * Failed to find file");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("ERROR * Failed to load file");
		}
		
		  /**
		   * Writte each key inside new file
		   */
		OutputStream outputStreamCombox = new FileOutputStream(filesLocationOutput + fileOutputCombox);
		OutputStream outputStream = new FileOutputStream(filesLocationOutput + fileOutput);
		  
	   for (Object key: propEn.keySet()) {
            System.out.println(key + ": " + propEn.getProperty(key.toString()));
//			Check if String Contains a Substring
            if (key.toString().contains("combox")) {
            	System.out.println("+++++++++++");
            	System.out.println(key.toString());
            	System.out.println(propEn.getProperty(key.toString()));
            	System.out.println("+++++++++++");
            	propOutputCombox.setProperty(key.toString(), propEn.getProperty(key.toString()));
            } else {
            	System.out.println("----------");
            	System.out.println(key.toString());
            	System.out.println(propEn.getProperty(key.toString()));
            	System.out.println("----------");
            	propOutput.setProperty(key.toString(), propEn.getProperty(key.toString()));
            }
        }
		   propOutputCombox.store(outputStreamCombox, null);
		   propOutput.store(outputStream, null);
		   outputStreamCombox.close();
		   outputStream.close();
		   System.out.println("+ Successfully written inside file");
		
		
		
		   System.out.println("----- Successfully ended script -----");

		
	}

}

//for (String key : setEn) {
//
//System.out.println("----");
//System.out.println(propEn.getProperty(key) );
//System.out.println(propEn.containsKey("combox") );
////if (propEn.getProperty(key).equals(propFr.getProperty(key))) {
////	  propEn.setProperty(key, "");
////}
//}
