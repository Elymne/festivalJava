package modele.metier;

/**
 *
 * @author cmetrot
 */

public class Representation {
    
    private int idRep;
    private Lieu lieu;
    private Groupe groupe;
    private String dateRep;
    private String heureDeb;
    private String heureFin;

    public Representation(int idRep, Lieu lieu, Groupe groupe, String dateRep, String heureDeb, String heureFin) {
        this.idRep = idRep;
        this.lieu = lieu;
        this.groupe = groupe;
        this.dateRep = dateRep;
        this.heureDeb = heureDeb;
        this.heureFin = heureFin;
    }

    public int getIdRep() {
        return idRep;
    }

    public void setIdRep(int idRep) {
        this.idRep = idRep;
    }

    public Lieu getLieu() {
        return lieu;
    }

    public void setLieu(Lieu lieu) {
        this.lieu = lieu;
    }

    public Groupe getGroupe() {
        return groupe;
    }

    public void setGroupe(Groupe groupe) {
        this.groupe = groupe;
    }

    public String getDateRep() {
        return dateRep;
    }

    public void setDateRep(String dateRep) {
        this.dateRep = dateRep;
    }

    public String getHeureDeb() {
        return heureDeb;
    }

    public void setHeureDeb(String heureDeb) {
        this.heureDeb = heureDeb;
    }

    public String getHeureFin() {
        return heureFin;
    }

    public void setHeureFin(String heureFin) {
        this.heureFin = heureFin;
    }
    
    
    
}

