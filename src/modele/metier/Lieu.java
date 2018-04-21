package modele.metier;

import java.util.Map;

/**
 * @author Sacha Djurdjevic
 */
public class Lieu {

    private int id;
    private String nom;
    private String adr;
    private int capacite;

    public Lieu(int id, String nom, String adr, int capacite) {
        this.nom = nom;
        this.id = id;
        this.adr = adr;
        this.capacite = capacite;
    }

    @Override
    public String toString() {
        return "id : " + id + ", nom :" + nom + ",adr : " + adr + ", capacite : " + capacite;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
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
     * @return the adr
     */
    public String getAdr() {
        return adr;
    }

    /**
     * @param adr the adr to set
     */
    public void setAdr(String adr) {
        this.adr = adr;
    }

    /**
     * @return the capacite
     */
    public int getCapacite() {
        return capacite;
    }

    /**
     * @param capacite the capacite to set
     */
    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

}
