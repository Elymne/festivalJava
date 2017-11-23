package test.modele.metier;

import modele.metier.*;

public class TestGroupe {
    
    public static void main(String[] args) {
        Groupe grp, grp2, grp3;
        System.out.println("\nTest n°1 : instanciation et accesseurs");
        grp = new (1, "141 route de Clisson", "44230", "Saint Sébastien sur Loire");
        System.out.println(grp);
        System.out.println("\nTest n°2 : mutateurs");
        grp.setRue("56 boulevard de la Prairie aux Ducs");
        grp.setCp("44265");
        grp.setVille("Nantes");
        System.out.println(grp);
        grp2 = new Groupe(1,null, null, null);
        System.out.println(grp2.equals(grp));
        grp3 = new Groupe(2,null, null, null);
        System.out.println(grp2.equals(grp3));
    }
    
}