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

    /**
     * Lire un enrengistrement de la table <b>representation</b>
     *
     * @param idRep
     * @return
     * @throws SQLException
     */
    public static Representation selectOneById(int idRep) throws SQLException {
        Representation representation = null;
        ResultSet rs = null;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "SELECT * FROM representation WHERE ID_REP = ?";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        pstmt.setInt(1, idRep);
        rs = pstmt.executeQuery();
        if (rs.next()) {
            representation = RepresentationDao.RepresentationFromResultSet(rs);
        }
        return representation;
    }

    /**
     * Lire un enrengistrement de la table <b>representation</b>
     *
     * @param numGroupe
     * @return
     * @throws SQLException
     */
    public static Representation selectOneByIdGroupe(String numGroupe) throws SQLException {
        Representation representation = null;
        ResultSet rs = null;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "SELECT * FROM representation WHERE ID_GROUPE= ?";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        pstmt.setString(1, numGroupe);
        rs = pstmt.executeQuery();
        if (rs.next()) {
            representation = RepresentationDao.RepresentationFromResultSet(rs);
        }
        return representation;
    }

    /**
     * lire tous les enregistrements de la table <b>representation</b>
     *
     * @return
     * @throws SQLException
     */
    public static ArrayList<Representation> selectAll() throws SQLException {
        ArrayList<Representation> lesRepresentations = new ArrayList<Representation>();
        Representation lieu = null;
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "SELECT * FROM representation";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        rs = pstmt.executeQuery();
        while (rs.next()) {
            lieu = RepresentationDao.RepresentationFromResultSet(rs);
            lesRepresentations.add(lieu);
        }
        return lesRepresentations;
    }

    /**
     * Modifier un enrengistrement de la table <b>representation</b>
     *
     * @param idRep
     * @param nbPlaces
     * @throws SQLException
     */
    public static void update(int idRep, int nbPlaces) throws SQLException {
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "UPDATE representation SET NBPLACESDISPO = NBPLACESDISPO + ? WHERE ID_REP = ?";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        pstmt.setInt(1, nbPlaces);
        pstmt.setInt(2, idRep);
        pstmt.executeUpdate();
    }

    /**
     * Insérer un nouvel enrengistrement dans la table <b>representation</b>
     *
     * @param id_rep
     * @param id_lieu
     * @param id_groupe
     * @param nbPlacesDispo
     * @param date_rep
     * @param heure_deb
     * @param heure_fin
     * @return
     * @throws SQLException
     */
    public static Representation insert(int id_rep, int id_lieu, String id_groupe, int nbPlacesDispo, String date_rep, String heure_deb, String heure_fin) throws SQLException {
        Representation representation = null;
        ResultSet rs = null;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "INSERT INTO representation VALUES (?,?,?,?,?,?,?)";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        pstmt.setInt(1, id_rep);
        pstmt.setInt(2, id_lieu);
        pstmt.setString(3, id_groupe);
        pstmt.setInt(4, nbPlacesDispo);
        pstmt.setString(5, date_rep);
        pstmt.setString(6, heure_deb);
        pstmt.setString(7, heure_fin);
        rs = pstmt.executeQuery();
        if (rs.next()) {
            representation = RepresentationDao.RepresentationFromResultSet(rs);
        }
        return representation;
    }

    /**
     * Supprimer un enrengistrement dans la table <b>representation</b>
     *
     * @param idRep
     * @throws SQLException
     */
    public static void delete(int idRep) throws SQLException {
        ResultSet rs = null;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "DELETE FROM Representation WHERE ID_REP = ?";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        pstmt.setInt(1, idRep);
        rs = pstmt.executeQuery();
    }

    private static Representation RepresentationFromResultSet(ResultSet rs) throws SQLException {
        Representation clt = null;
        int id = rs.getInt("ID_REP");
        String idGroupe = rs.getString("ID_GROUPE");
        int idLieu = rs.getInt("ID_LIEU");
        int nbPlacesDispo = rs.getInt("NBPLACESDISPO");
        String dateRep = rs.getString("DATE_REP");
        String heureDebut = rs.getString("HEURE_DEB");
        String heureFin = rs.getString("HEURE_FIN");

        Groupe objetGroupe = GroupeDao.selectOneById(idGroupe);
        Lieu objetLieu = LieuDao.selectOneById(idLieu);
        clt = new Representation(id, dateRep, heureDebut, heureFin, objetGroupe, objetLieu, nbPlacesDispo);
        return clt;
    }

}
