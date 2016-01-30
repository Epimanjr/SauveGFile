package sauvegfile;

import exception.MauvaisCheminException;

/**
 * Classe principale
 * 
 * @author Maxime BLAISE
 */
public class Main {

    /**
     * Méthode principale.
     *
     * @param args Arguments
     */
    public static void main(String[] args) {
    	try {
    		Data.initToutesLesDonnees();
    		String cheminVersGoogle = Data.cheminVersGoogle();
    		String cheminVersOneDrive = Data.cheminVersOneDrive();
    		Traitement t = new Traitement(cheminVersGoogle, cheminVersOneDrive);
    		t.traiter();
    	} catch(MauvaisCheminException e) {
    		System.err.println("Erreur: initialisation des chemins.");
    	}
    }
}
