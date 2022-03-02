package bb.scripts;

public class Main {
	  public static void main(String[] args) {

//		      FindMissingKeys sc = new FindMissingKeys();
//		      sc.findMissingKeysAndWriteToNewFile();
		  
		      FindDuplicateLines fdl = new FindDuplicateLines();
		      fdl.findDuplicateLineAndRemoveFromNewFile();
		      
		    }

}


//-----------
//[x] Prendre toutes les clées du fichier FR non présente dans fichier EN et les ajouter dans un nouveau fichier
//[x] Comparer Fichier FR et EN et virer les lignes identiques (non traduite)
//[ ] Extraire les clés BE "combox" pour faire un autre fichier (pas à traduire)
//-----------
