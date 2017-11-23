package test.modele.metier;

import modele.metier.*;

public class TestGroupe {
    
    public static void main(String[] args) {
        Groupe grp1, grp2, grp3;
        System.out.println("\nTest n°1 : instanciation et accesseurs");
        grp1 = new ();
        System.out.println(grp1);
        System.out.println("\nTest n°2 : mutateurs");
        grp1.setRue("56 boulevard de la Prairie aux Ducs");
        grp1.setCp("44265");
        grp1.setVille("Nantes");
        System.out.println(grp1);
        grp2 = new Groupe(1,null, null, null);
        System.out.println(grp2.equals(grp1));
        grp3 = new Groupe(2,null, null, null);
        System.out.println(grp2.equals(grp3));
    }
    
}