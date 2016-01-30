package sauvegfile;

import java.util.HashMap;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;
import exception.MauvaisCheminException;

/**
 * Contient toutes les données nécessaires.
 *
 * @author Maxime BLAISE.
 */
public class Data {

    /**
     * Par exemple, associe l'extension GDOC aux extensions .DOC, .ODT, etc.
     */
    public static HashMap<String, ArrayList<String>> liaisonsExtensions;

    /**
     * Données de configuration, externalisées dans un fichier.
     */
    public static HashMap<String, String> config;

    /**
     * Initialise toutes les données nécessaires.
     */
    public static void initToutesLesDonnees() {
        // Extensions
        initLiaisonsExtensions();
        // Configuration
        initConfig();
    }

    /**
     * Initialise les données de configuration.
     */
    public static void initConfig() {
        config = new HashMap<>();
        try {
            // Lecture du fichier
            BufferedReader br = new BufferedReader(new FileReader("data/config.txt"));
            while(br.ready()) {
                String line = br.readLine();
                String[] lines = line.split("=>");
                // Ajout à notre map
                if(lines.length == 2) {
                    config.put(lines[0], lines[1]);
                }
            }
            br.close();
        } catch(FileNotFoundException e1) {
            System.err.println("Erreur: fichier de configuration non trouvée.");
        } catch(IOException e2) {
            System.err.println("Erreur: problème de lecture du fichier de configuration");
        }
    }
    
    /**
     * Initialise les liaisons entre les extensions.
     */
    public static void initLiaisonsExtensions() {
        liaisonsExtensions = new HashMap<>();
        // GDOC
        ArrayList<String> listeGDOC = new ArrayList<>();
        listeGDOC.add(".docx");
        listeGDOC.add(".doc");
        listeGDOC.add(".odt");
        liaisonsExtensions.put(".gdoc", listeGDOC);
        // GSHEET
        ArrayList<String> listeGSHEET = new ArrayList<>();
        listeGSHEET.add(".xlsx");
        listeGSHEET.add(".xls");
        liaisonsExtensions.put(".gsheet", listeGSHEET);
        // GSLIDES
        ArrayList<String> listeGSLIDES = new ArrayList<>();
        listeGSLIDES.add(".ppt");
        listeGSLIDES.add(".pptx");
        liaisonsExtensions.put(".gslides", listeGSLIDES);
    }

    /**
     * Récupère le chemin d'accès vers le dossier Google.
     *
     * @return Chemin
     */
    public static String cheminVersGoogle() throws MauvaisCheminException {
        return getChemin("cheminVersGoogle");
    }

    /**
     * Récupère le chemin d'accès vers le dossier OneDrive
     *
     * @return Chemin
     */
    public static String cheminVersOneDrive() throws MauvaisCheminException {
        return getChemin("cheminVersOneDrive");
    }

    /**
     * Récupère le chemin en fonction d'une clé
     *
     * @param key Clé
     * @return Chemin
     */
    public static String getChemin(String key) throws MauvaisCheminException {
        if(Data.config == null) {
            throw new MauvaisCheminException();
        }
        if(!Data.config.containsKey(key)) {
            throw new MauvaisCheminException();
        }
        String chemin = Data.config.get(key);
        File f = new File(chemin);
        if(f.exists()) {
            return chemin;
        } else {
            throw new MauvaisCheminException();
        }
    }
}
