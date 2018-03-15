
package test.modele.dao;

import java.sql.*;
import java.util.List;
import modele.dao.*;
import modele.jdbc.Jdbc;
import modele.metier.*;

/**
 * @author Sacha Djurdjevic
 */
public class RepresentationDaoTest {
    public static void main(String[] args) {

        java.sql.Connection cnx = null;

        try {
            test0_Connexion();
            System.out.println("Test0 effectué : connexion\n");
            test1_SelectUnique(5);
            System.out.println("Test1 effectué : Sélection des données de l'id 1\n");
            test2_SelectMultiple();
            System.out.println("Test2 effectué : sélection multiple\n");
            test3_SelectUnique("g003");
            System.out.println("Test3 effectué : sélection Unique par nom de groupe\n");
            test4_Update(1,5);
            System.out.println("Test4 effectué : Update du nombre de place = 5\n");
            test1_SelectUnique(1);
            System.out.println("Test1 effectué : Sélection des données de l'id 1 ( avec le nombre de place vendu augmenté de 5\n");
            test4_Update(1,-5);
            System.out.println("Test4 effectué : Update du nombre de place = 0\n");
        } catch (ClassNotFoundException e) {
            System.err.println("Erreur de pilote JDBC : " + e);
        } catch (SQLException e) {
            System.err.println("Erreur SQL : " + e);
        } finally {
            try {
                if (cnx != null) {
                    cnx.close();
                }
            } catch (SQLException e) {
                System.err.println("Erreur de fermeture de la connexion JDBC : " + e);
            }
        }

    }

    /**
     * Vérifie qu'une connexion peut être ouverte sur le SGBD
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static void test0_Connexion() throws ClassNotFoundException, SQLException {
        Jdbc.creer("com.mysql.jdbc.Driver", "jdbc:mysql:", "//localhost/", "festivalbilleterie", "festival", "secret");
        Jdbc.getInstance().connecter();
        Connection cnx = Jdbc.getInstance().getConnexion();
    }

    /**
     * Affiche une adresse d'après son identifiant
     * @throws SQLException
     */
    public static void test1_SelectUnique(int idRepresentation) throws SQLException {
        Representation representation = RepresentationDao.selectOneById(idRepresentation);
        System.out.println("Representation n° : "+idRepresentation+" : "+representation.toString());
    }

    /**
     * Affiche toutes les villes
     * @throws SQLException
     */
    public static void test2_SelectMultiple() throws SQLException {
        List<Representation> desRepresentations = RepresentationDao.selectAll();
        System.out.println("Les Representations");
        for(Representation representation : desRepresentations){
            System.out.println("Representation : " + representation);
        }
    }
    
    public static void test3_SelectUnique(String idGroupe) throws SQLException{
        Representation representation = RepresentationDao.selectOneByIdGroupe(idGroupe);
        System.out.println("Reprensentation du groupe : "+idGroupe+" : "+representation.toString());
    }    
    
    public static void test4_Update(int idRep, int nbPlaces) throws SQLException{
        RepresentationDao.update(idRep,nbPlaces);    
    }
    
    public static void test5_Insert(int id_rep, int id_lieu, String id_groupe, int nbPlacesDispo, String date_rep, String heure_deb, String heure_fin) throws SQLException{
        RepresentationDao.insert(id_rep, id_lieu, id_groupe, nbPlacesDispo, date_rep, heure_deb, heure_fin);
    }
    
}
