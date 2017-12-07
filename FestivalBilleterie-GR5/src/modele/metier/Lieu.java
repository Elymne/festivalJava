package modele.metier;

/**
 *
 * @author cmetrot
 */
public class Lieu {
    
    private int idLieu;
    private String nomLieu;
    private String adrLieu;
    private int capacite;

    public Lieu(int idLieu, String nomLieu, String adrLieu, int capacite) {
        this.idLieu = idLieu;
        this.nomLieu = nomLieu;
        this.adrLieu = adrLieu;
        this.capacite = capacite;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdr() {
        return adr;
    }

    public void setAdr(String adr) {
        this.adr = adr;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }
    
    
    
}
