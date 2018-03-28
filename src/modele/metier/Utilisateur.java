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
    
    public Utilisateur(int id, String pseudo, String password){
        this.id = id;
        this.pseudo = pseudo;
        this.password = password;
    }
    
    public String toString(){
        return "id = "+ id +", pseudo :"+ pseudo + ", password :"+ password;
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
}
