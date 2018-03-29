
package test.modele.dao;

import java.sql.SQLException;
import java.sql.*;
import java.util.List;
import modele.dao.*;
import modele.jdbc.Jdbc;
import modele.metier.*;

/**
 *
 * @author Elymne
 */
public class AuthentificationDaoTest {
    public static void main(String[] args) {

        java.sql.Connection cnx = null;
        
        try {
            test0_Connexion();
            System.out.println("Test0 effectué : connexion\n");
            test1_SelectUnique("btssio");
            System.out.println("Test1 effectué : Nom loggin -> btssio\n");
            test2_SelectMultiple();
            System.out.println("Test2 effectué : Liste des utilisateurs\n");
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
    
    // LISTE METHODE DE TEST
    
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
        * Affiche un user grace à son loggin
        * @throws SQLException
        */
        public static void test1_SelectUnique(String loggin) throws SQLException {
            Utilisateur utilisateur = Authentification.selectOneByName(loggin);
            System.out.println("Representation de l'utilisateur suivant : "+loggin+" : "+utilisateur.toString());
        }
        
        /**
        * Affiche tous les utilisateurs
        * @throws SQLException
        */
        public static void test2_SelectMultiple() throws SQLException {
            List<Utilisateur> desUtilisateurs = Authentification.selectAll();
            System.out.println("Les utilisateurs");
            for(Utilisateur utilisateur : desUtilisateurs){
                System.out.println("Representation : " + utilisateur);
            }
        }
    
}
