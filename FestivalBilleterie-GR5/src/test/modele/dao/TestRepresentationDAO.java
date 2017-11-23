package test.modele.dao;

import java.sql.*;
import java.util.List;
import modele.dao.*;
import modele.dao.Jdbc;
import modele.metier.*;

public class TestRepresentationDAO {
    
    public static void main(String[] args) {
        
        java.sql.Connection cnx = null;
        
        try {
            test0_Connexion();
            System.out.println("Test0 effectué : connexion\n");
            test1_SelectUnique(1);
            System.out.println("Test1 effectué : sélection unique\n");
            test2_SelectMultiple();
            System.out.println("Test2_2 effectué : sélection multiple avec filtrage sur le nom de ville\n");
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
        Jdbc.creer("com.mysql.jdbc.Driver", "jdbc:mysql://", "localhost/", "festivalbilleterie", "festival", "secret");
        Jdbc.getInstance().connecter();
        Connection cnx = Jdbc.getInstance().getConnexion();
    }
    
    /**
     * Affiche un Groupe d'après son identifiant
     * @throws SQLException
     */
    public static void test1_SelectUnique(int idRepresentation) throws SQLException {
        Representation cetteRepresentation = DaoRepresentation.selectOne(idRepresentation);
        System.out.println("Representation d'id : "+idRepresentation+" : "+cetteRepresentation.toString());
    }
    
    /**
     * Affiche tous les Groupes
     * @throws SQLException
     */
    public static void test2_SelectMultiple() throws SQLException {
        List<Representation> desRepresentations = DaoRepresentation.selectAll();
        System.out.println("Les Representations lues : "+desRepresentations.toString());
    }
}