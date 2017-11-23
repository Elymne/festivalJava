package test.modele.metier;

import modele.metier.*;

public class TestRepresentation {
    
    public static void main(String[] args) {
        
        Reprensetation rep1, rep2, rep3;
        System.out.println("\nTest n°1 : instanciation et accesseurs");
        rep1 = new (1, "141 route de Clisson", "44230", "Saint Sébastien sur Loire");
        System.out.println(rep1);
        System.out.println("\nTest n°2 : mutateurs");
        rep1.setRue("56 boulevard de la Prairie aux Ducs");
        rep1.setCp("44265");
        rep1.setVille("Nantes");
        System.out.println(rep1);
        rep2 = new Reprensetation(1,null, null, null);
        System.out.println(rep2.equals(rep1));
        rep3 = new Reprensetation(2,null, null, null);
        System.out.println(rep2.equals(rep3));
    }
    
}