package Main;

import modele.dao.Jdbc;
import vue.*;
import controleur.*;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author cmetrot
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Jdbc.creer("com.mysql.jdbc.Driver", "jdbc:mysql:", "//localhost/", "festivalbilleterie", "festival", "secret");
        try {
            Jdbc.getInstance().connecter();
            /*VueLesAdresses uneVue = new VueLesAdresses();
            CtrlLesAdresses unControleur = new CtrlLesAdresses(uneVue);*/
            VueLesClients uneVue = new VueLesClients();
            CtrlLesClients unControleur = new CtrlLesClients(uneVue);
            // afficher la vue
            uneVue.setVisible(true);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Main - classe JDBC non trouvée");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Main - échec de connexion");
        }

    }

}
