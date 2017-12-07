
package modele.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modele.jdbc.Jdbc;
import modele.metier.Lieu;

/**
 * @author Sacha Djurdjevic
 */
public class LieuDao {
    
   
    
    public static Lieu selectOneById(int numLieu) throws SQLException {
        Lieu lieu = null;
        ResultSet rs = null;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "SELECT * FROM lieu WHERE ID= ?";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        pstmt.setInt(1, numLieu);
        rs = pstmt.executeQuery();
        if (rs.next()) {
            lieu = LieuDao.lieuFromResultSet(rs);
        }
        return lieu;
    }
    
    public static ArrayList<Lieu> selectAll() throws SQLException {
        ArrayList<Lieu> lesLieux = new ArrayList<Lieu>();
        Lieu lieu = null;
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "SELECT * FROM lieu";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        rs = pstmt.executeQuery();
        while (rs.next()) {
            lieu = LieuDao.lieuFromResultSet(rs);
            lesLieux.add(lieu);
        }
        return lesLieux;
    }
    
    
     private static Lieu lieuFromResultSet(ResultSet rs) throws SQLException {
        Lieu clt = null;
        int id = rs.getInt("ID");
        String nom = rs.getString("NOM");
        String adr = rs.getString("ADR");
        int capacite = rs.getInt("CAPACITE");
        clt = new Lieu(id, nom,adr, capacite);
        return clt;
    }
}
