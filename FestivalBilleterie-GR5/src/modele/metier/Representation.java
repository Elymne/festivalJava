
package modele.metier;

import java.util.Map.Entry;

/**
 * @author cmetrot
 */
public class Representation {
    private int id;
    private String dateRep;
    private String heureDebut;
    private String heureFin;
    private Groupe groupe;
    private Lieu lieu;
    
    public Representation(int id, String dateRep,String heureDebut, String heureFin, Groupe groupe, Lieu lieu){
        this.id = id;
        this.dateRep = dateRep;
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
        this.groupe = groupe;
        this.lieu = lieu;
    }
    
    public String toString(){
        return "id = " + id + ", dateRep " + dateRep + ", heureDebut : " + heureDebut + ", heureFin : " + heureFin + ", groupe : " + groupe.toString() + ", lieu : " + lieu.toString();
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
     * @return the dateRep
     */
    public String getDateRep() {
        return dateRep;
    }

    /**
     * @param dateRep the dateRep to set
     */
    public void setDateRep(String dateRep) {
        this.dateRep = dateRep;
    }

    /**
     * @return the heureDebut
     */
    public String getHeureDebut() {
        return heureDebut;
    }

    /**
     * @param heureDebut the heureDebut to set
     */
    public void setHeureDebut(String heureDebut) {
        this.heureDebut = heureDebut;
    }

    /**
     * @return the heureFin
     */
    public String getHeureFin() {
        return heureFin;
    }

    /**
     * @param heureFin the heureFin to set
     */
    public void setHeureFin(String heureFin) {
        this.heureFin = heureFin;
    }

    /**
     * @return the groupe
     */
    public Groupe getGroupe() {
        return groupe;
    }

    /**
     * @param groupe the groupe to set
     */
    public void setGroupe(Groupe groupe) {
        this.groupe = groupe;
    }

    /**
     * @return the lieu
     */
    public Lieu getLieu() {
        return lieu;
    }

    /**
     * @param lieu the lieu to set
     */
    public void setLieu(Lieu lieu) {
        this.lieu = lieu;
    }
    
    
}
