package sauvegfile;

import java.util.HashMap;
import java.util.ArrayList;

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
     * Initialise toutes les données nécessaires.
     */
    public static void initToutesLesDonnees() {
        // Extensions
        initLiaisonsExtensions();
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
}
