package modele.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modele.metier.Lieu;

/**
 *
 * @author cmetrot
 */
public class DaoLieu {
    
        /**
     * Extraction d'une adresse, sur son identifiant
     * @param id identifiant
     * @return objet Lieu
     * @throws SQLException 
     */
    public static Lieu selectOne(int idLieu) throws SQLException {
        Lieu unLieu = null;
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "SELECT * FROM LIEU WHERE ID= ?";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        pstmt.setInt(1, id);
        rs = pstmt.executeQuery();
        if (rs.next()) {
            int id = rs.getInt("ID");
            String rue = rs.getString("NOM");
            String cdp = rs.getString("ADR");
            String ville = rs.getString("CAPACITE");
            uneAdresse = new Adresse(id, rue, cdp, ville);
        }
        return uneAdresse;
    }

    /**
     * Extraction de toutes les adresses
     * @return collection d'adresses
     * @throws SQLException 
     */
    public static List<Adresse> selectAll() throws SQLException {
        List<Adresse> lesAdresses = new ArrayList<Adresse>();
        Adresse uneAdresse;
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "SELECT * FROM ADRESSE";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        rs = pstmt.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("ID");
            String rue = rs.getString("RUE");
            String cdp = rs.getString("CDP");
            String ville = rs.getString("VILLE");
            uneAdresse = new Adresse(id, rue, cdp, ville);
            lesAdresses.add(uneAdresse);
        }
        return lesAdresses;
    }
    
        /**
     * Extraction de toutes les adresses dont le nom de ville contient la chaîne recherchée
     * @param extraitNomVille
     * @return collection d'adresses
     * @throws SQLException 
     */
    public static List<Adresse> selectAllByVille(String extraitNomVille) throws SQLException {
        List<Adresse> lesAdresses = new ArrayList<Adresse>();
        Adresse uneAdresse;
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "SELECT * FROM ADRESSE WHERE ville LIKE ?";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        pstmt.setString(1, "%"+extraitNomVille+"%");
        rs = pstmt.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("ID");
            String rue = rs.getString("RUE");
            String cdp = rs.getString("CDP");
            String ville = rs.getString("VILLE");
            uneAdresse = new Adresse(id, rue, cdp, ville);
            lesAdresses.add(uneAdresse);
        }
        return lesAdresses;
    }    

    /**
     * Extraction de toutes les adresses, ordonnées
     * @param cleTri 1=>ID ; 2=>VILLE
     * @param ordreTri 1=>ASC ; 2=>DESC
     * @return collection d'adresses
     * @throws SQLException 
     */
    public static List<Adresse> selectAll(int cleTri, int ordreTri) throws SQLException {
        List<Adresse> lesAdresses = new ArrayList<Adresse>();
        Adresse uneAdresse;
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "SELECT * FROM ADRESSE";
        switch (cleTri) {
            case 1: // Tri par Id
                requete += " ORDER BY ID";
                break;
            case 2: // Tri par ville
                requete += " ORDER BY VILLE";
                break;
        }
        if (cleTri == 1 || cleTri == 2) {
            switch (ordreTri) {
                case 1: // Tri croissant
                    requete += " ASC";
                    break;
                case 2: // Tri décroissant
                    requete += " DESC";
                    break;
            }
        }
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        rs = pstmt.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("ID");
            String rue = rs.getString("RUE");
            String cdp = rs.getString("CDP");
            String ville = rs.getString("VILLE");
            uneAdresse = new Adresse(id, rue, cdp, ville);
            lesAdresses.add(uneAdresse);
        }
        return lesAdresses;
    }

    public static int insert(int idAdresse, Adresse uneAdresse) throws SQLException {
        int nb;
        Jdbc jdbc = Jdbc.getInstance();
        String requete;
        ResultSet rs;
        PreparedStatement pstmt;
        requete = "INSERT INTO ADRESSE (ID, RUE, CDP , VILLE) VALUES (?, ?, ?, ?)";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        pstmt.setInt(1, idAdresse);
        pstmt.setString(2, uneAdresse.getRue());
        pstmt.setString(3, uneAdresse.getCp());
        pstmt.setString(4, uneAdresse.getVille());
        nb = pstmt.executeUpdate();
        return nb;
    }

    public static int update(int idAdresse, Adresse uneAdresse) throws SQLException {
        int nb;
        Jdbc jdbc = Jdbc.getInstance();
        String requete;
        ResultSet rs;
        PreparedStatement pstmt;
        requete = "UPDATE ADRESSE SET RUE = ? , CDP = ? , VILLE = ? WHERE ID = ?";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        pstmt.setString(1, uneAdresse.getRue());
        pstmt.setString(2, uneAdresse.getCp());
        pstmt.setString(3, uneAdresse.getVille());
        pstmt.setInt(4, idAdresse);
        nb = pstmt.executeUpdate();
        return nb;
    }

    public static int delete(int idAdresse) throws SQLException {
        int nb;
        Jdbc jdbc = Jdbc.getInstance();
        String requete;
        ResultSet rs;
        PreparedStatement pstmt;
        requete = "DELETE FROM LIEU WHERE ID = ?";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        pstmt.setInt(1, idAdresse);
        nb = pstmt.executeUpdate();
        return nb;
    }
    
}
