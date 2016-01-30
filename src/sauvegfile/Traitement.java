package sauvegfile;

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
     * Memoire temporaire.
     */
    private String memoire="";

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
        traiter(this.cheminVersGoogle, this.cheminVersOneDrive, this.memoire);
    }

    public void traiter(String google, String onedrive, String memoire) {

    }
}
