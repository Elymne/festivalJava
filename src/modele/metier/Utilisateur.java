/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.metier;

/**
 *
 * @author btssio
 */
public class Utilisateur {
     private int id;
    private String pseudo;
    private String password;
    private Groupe groupe;
    private Lieu lieu;
    private Representation representation;
    
    public Utilisateur(int id, String pseudo, String password,Groupe groupe, Lieu lieu, Representation Representation){
        this.id = id;
        this.pseudo = pseudo;
        this.password = password;
        this.groupe = groupe;
        this.lieu = lieu;
        this.representation = representation;
    }
    
    public String toString(){
        return "id = "+ id +", pseudo :"+ pseudo + ", password :"+ password + ", groupe : " + groupe.toString() + ", lieu : " + lieu.toString() + ", representation :" + representation.toString();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Groupe getGroupe() {
        return groupe;
    }

    public void setGroupe(Groupe groupe) {
        this.groupe = groupe;
    }

    public Lieu getLieu() {
        return lieu;
    }

    public void setLieu(Lieu lieu) {
        this.lieu = lieu;
    }

    public Representation getRepresentation() {
        return representation;
    }

    public void setRepresentation(Representation representation) {
        this.representation = representation;
    }
    
    
}
