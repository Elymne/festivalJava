
package modele.dao;

import java.sql.*;
import java.util.*;
import modele.jdbc.Jdbc;
import modele.metier.*;

/**
 * @author Sacha Djurdjevic
 */
public class GroupeDao{

    public static Groupe selectOneById(String numGroupe) throws SQLException {
        Groupe groupe = null;
        ResultSet rs = null;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "SELECT * FROM groupe WHERE ID= ?";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        pstmt.setString(1, numGroupe);
        rs = pstmt.executeQuery();
        if (rs.next()) {
            groupe = GroupeDao.groupeFromResultSet(rs);
        }
        return groupe;
    }
    
    public static Groupe selectOneByName(String nomGroupe) throws SQLException {
        Groupe groupe = null;
        ResultSet rs = null;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "SELECT * FROM groupe WHERE NOM= ?";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        pstmt.setString(1, nomGroupe);
        rs = pstmt.executeQuery();
        if (rs.next()) {
            groupe = GroupeDao.groupeFromResultSet(rs);
        }
        return groupe;
    }

    /**
     * lire tous les enregistrements de la table CLIENT
     *
     * @return une collection d'instances de la classe Client
     * @throws SQLException
     */
    public static ArrayList<Groupe> selectAll() throws SQLException {
        ArrayList<Groupe> lesGroupes = new ArrayList<Groupe>();
        Groupe groupe = null;
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "SELECT * FROM groupe";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        rs = pstmt.executeQuery();
        while (rs.next()) {
            groupe = GroupeDao.groupeFromResultSet(rs);
            lesGroupes.add(groupe);
        }
        return lesGroupes;
    }
    
    //Pas Demandé
    public int insert(Groupe objetMetier) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    //Pas Demandé
    public int update(Integer idMetier, Groupe objetMetier) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    //Pas Demandé
    public int delete(Integer idMetier) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    private static Groupe groupeFromResultSet(ResultSet rs) throws SQLException {
        Groupe clt = null;
        String id = rs.getString("ID");
        String nom = rs.getString("NOM");
        String identiteRes = rs.getString("IDENTITERESPONSABLE");
        String adr = rs.getString("ADRESSEPOSTALE");
        int nbPers = rs.getInt("NOMBREPERSONNES");
        String nomPays = rs.getString("NOMPAYS");
        String hebergement = rs.getString("HEBERGEMENT");
        clt = new Groupe(id, nom, identiteRes, adr, nbPers,nomPays,hebergement);
        return clt;
    }
    
}
