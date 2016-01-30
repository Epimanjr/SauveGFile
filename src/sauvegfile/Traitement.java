package sauvegfile;

import java.io.File;
import java.util.Set;
import java.util.Iterator;

/**
 * Classe de traitement.
 *
 * @author Maxime BLAISE
 */
public class Traitement {

    /**
     * Chemin vers le fichier de résultat .
     */
    public static String cheminVersFichierResultat = "data/resultat.txt";

    /**
     * Chemin vers le dossier de Google.
     */
    private String cheminVersGoogle;

    /**
     * Chemin vers le dossier de OneDrive.
     */
    private String cheminVersOneDrive;


    /**
     * Créer un traitement.
     *
     * @param cheminVersGoogle Chemin
     * @param cheminVersOneDrive Chemin
     */
    public Traitement(String cheminVersGoogle, String cheminVersOneDrive) {
        this.cheminVersGoogle = cheminVersGoogle;
        this.cheminVersOneDrive = cheminVersOneDrive;
    }


    public void traiter() {
        traiter(this.cheminVersGoogle, this.cheminVersOneDrive, "");
    }

    public void traiter(String google, String onedrive, String memoire) {
        File f = new File(google + memoire);
        for(File file : f.listFiles()) {
            if(file.isDirectory()) {
                // Récursivité
                traiter(google, onedrive, memoire + "/" + file.getName());
            } else {
                // Traitement du fichier
                Set set = Data.liaisonsExtensions.keySet();
                Iterator it = set.iterator();
                while(it.hasNext()) {
                    String str = it.next().toString();
                    if(file.getName().endsWith(str)) {
                        boolean existeSurOneDrive = false;
                        for(String extension : Data.liaisonsExtensions.get(str)) {
                            String tmp = file.getName().replaceAll(str, extension);
                            File fileOneDrive = new File(onedrive + memoire + "/" + tmp);
                            if(fileOneDrive.exists()) {
                                existeSurOneDrive = true;
                                break;
                            }
                        }
                        if(!existeSurOneDrive) {
                            // Ecriture du path
                            System.err.println(memoire + "/" + file.getName());
                        }
                        break;
                    }
                }
            }
        }
    }
}
