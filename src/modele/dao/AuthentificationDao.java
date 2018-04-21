/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modele.jdbc.Jdbc;
import modele.metier.Utilisateur;

/**
 * @author Sacha Djurdjevic
 */
public class AuthentificationDao {

    /**
     * Lire un enrengistrement de la table <b>user</b>
     *
     * @param nomUser
     * @return Une variable de type Utilisateur
     * @throws SQLException
     */
    public static Utilisateur selectOneByName(String nomUser) throws SQLException {
        Utilisateur utilisateur = null;
        ResultSet rs = null;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        String requete = "SELECT * FROM user WHERE LOGGIN= ?";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        pstmt.setString(1, nomUser);
        rs = pstmt.executeQuery();
        if (rs.next()) {
            utilisateur = AuthentificationDao.utilisateurFromResultSet(rs);
        }
        return utilisateur;
    }

    /**
     * lire tous les enregistrements de la table <b>user</b>
     *
     * @return une collection d'instances de la classe Utilisateur
     * @throws SQLException
     */
    public static ArrayList<Utilisateur> selectAll() throws SQLException {
        ArrayList<Utilisateur> lesUtilisateurs = new ArrayList<Utilisateur>();
        Utilisateur utilisateur = null;
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        String requete = "SELECT * FROM user";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        rs = pstmt.executeQuery();
        while (rs.next()) {
            utilisateur = AuthentificationDao.utilisateurFromResultSet(rs);
            lesUtilisateurs.add(utilisateur);
        }
        return lesUtilisateurs;
    }

    private static Utilisateur utilisateurFromResultSet(ResultSet rs) throws SQLException {
        Utilisateur clt = null;
        int id = rs.getInt("ID");
        String loggin = rs.getString("LOGGIN");
        String password = rs.getString("PASSWORD");
        clt = new Utilisateur(id, loggin, password);
        return clt;
    }
}
