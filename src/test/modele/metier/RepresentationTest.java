/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.modele.metier;

import modele.metier.*;

/**
 * @author Djurdjevic Sacha
 */
public class RepresentationTest {
        public static void main(String[] args) {
        
        Groupe grp = new Groupe("id","nomGroupe","identite","adresse",40,"nomPays","hebergement");
        Lieu lieu = new Lieu(1,"nomLieu","ad",1111111110);
        Representation rep = new Representation(2,"dateRep","heureDebut", "heureFin",grp,lieu,1000);
        System.out.println("\nTest n°1 : instanciation et accesseurs");
        
        System.out.println(rep.toString());
        System.out.println("\nTest n°2 : mutateurs changement de date : Nouvelle Date -> Nouvelle valeur");
        rep.setDateRep("Nouvelle Date");
        System.out.println(rep.toString());
        }
}
