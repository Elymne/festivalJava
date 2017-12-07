
package modele.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modele.jdbc.Jdbc;
import modele.metier.Groupe;
import modele.metier.Lieu;
import modele.metier.Representation;

/**
 * @author Sacha Djurdjevic
 */
public class RepresentationDao {
    
    public static Representation selectOneById(int numLieu) throws SQLException {
        Representation representation = null;
        ResultSet rs = null;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "SELECT * FROM REPRESENTATION WHERE ID= ?";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        pstmt.setInt(1, numLieu);
        rs = pstmt.executeQuery();
        if (rs.next()) {
            representation = RepresentationDao.RepresentationFromResultSet(rs);
        }
        return representation;
    }
    
    public static ArrayList<Representation> selectAll() throws SQLException {
        ArrayList<Representation> lesRepresentations = new ArrayList<Representation>();
        Representation lieu = null;
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "SELECT * FROM REPRESENTATION";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        rs = pstmt.executeQuery();
        while (rs.next()) {
            lieu = RepresentationDao.RepresentationFromResultSet(rs);
            lesRepresentations.add(lieu);
        }
        return lesRepresentations;
    }
    
    
     private static Representation RepresentationFromResultSet(ResultSet rs) throws SQLException {
        Representation clt = null;
        int id = rs.getInt("ID");
        String idGroupe = rs.getString("ID_GROUPE");
        int idLieu = rs.getInt("ID_LIEU");
        String dateRep = rs.getString("DATE_REP");
        String heureDebut = rs.getString("HEUREDEBUT");
        String heureFin = rs.getString("HEUREFIN");
        
        Groupe objetGroupe = GroupeDao.selectOneById(idGroupe);
        Lieu objetLieu = LieuDao.selectOneById(idLieu);
        clt = new Representation(id,dateRep,heureDebut,heureFin, objetGroupe,objetLieu);
        return clt;
    }
    
}
