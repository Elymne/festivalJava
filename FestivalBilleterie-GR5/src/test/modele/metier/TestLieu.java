package test.modele.metier;

import modele.metier.*;

public class TestLieu {
    
    public static void main(String[] args) {
        Lieu lieu1, lieu2, lieu3;
        System.out.println("\nTest n°1 : instanciation et accesseurs");
        lieu1 = new (1, "141 route de Clisson", "44230", "Saint Sébastien sur Loire");
        System.out.println(lieu1);
        System.out.println("\nTest n°2 : mutateurs");
        lieu1.setRue("56 boulevard de la Prairie aux Ducs");
        lieu1.setCp("44265");
        lieu1.setVille("Nantes");
        System.out.println(lieu1);
        lieu2 = new Lieu(1,null, null, null);
        System.out.println(lieu2.equals(lieu1));
        lieu3 = new Lieu(2,null, null, null);
        System.out.println(lieu2.equals(lieu3));
    }
    
}