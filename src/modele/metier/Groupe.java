package modele.metier;

/**
 *
 * @author sacha djurdjevic
 */
public class Groupe {

    private String id;
    private String nom;
    private String identite;
    private String adresse;
    private int nbPers;
    private String nomPays;
    private String hebergement;

    /**
     *
     * @param id
     * @param nom
     * @param identite
     * @param adresse
     * @param nbPers
     * @param nomPays
     * @param hebergement
     */
    public Groupe(String id, String nom, String identite, String adresse, int nbPers, String nomPays, String hebergement) {
        this.id = id;
        this.nom = nom;
        this.adresse = adresse;
        this.identite = identite;
        this.nbPers = nbPers;
        this.nomPays = nomPays;
        this.hebergement = hebergement;
    }

    /**
     * Constructeur inutile?
     */
    public Groupe() {

    }

    /**
     *
     * @return Une chaine de caractères
     */
    public String toString() {
        return ("Groupe{Id: " + this.getId() + "\tNom: " + this.getNom() + "\tIdentite: " + this.getIdentite() + "\tAdresse: " + this.getAdresse() + "\tNbPers: " + this.getNbPers() + "\tNomPays: " + this.getNomPays() + "\tHebergement: " + this.getHebergement()) + "}";
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the identite
     */
    public String getIdentite() {
        return identite;
    }

    /**
     * @param identite the identite to set
     */
    public void setIdentite(String identite) {
        this.identite = identite;
    }

    /**
     * @return the adresse
     */
    public String getAdresse() {
        return adresse;
    }

    /**
     * @param adresse the adresse to set
     */
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    /**
     * @return the nbPers
     */
    public int getNbPers() {
        return nbPers;
    }

    /**
     * @param nbPers the nbPers to set
     */
    public void setNbPers(int nbPers) {
        this.nbPers = nbPers;
    }

    /**
     * @return the nomPays
     */
    public String getNomPays() {
        return nomPays;
    }

    /**
     * @param nomPays the nomPays to set
     */
    public void setNomPays(String nomPays) {
        this.nomPays = nomPays;
    }

    /**
     * @return the hebergement
     */
    public String getHebergement() {
        return hebergement;
    }

    /**
     * @param hebergement the hebergement to set
     */
    public void setHebergement(String hebergement) {
        this.hebergement = hebergement;
    }

}
