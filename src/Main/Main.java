package Main;

import modele.jdbc.Jdbc;
import controleur.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Properties;
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

        final Properties prop = new Properties();
        InputStream input = null;

        try {

            input = new FileInputStream("src/config/accesBdd.properties");

            // load a properties file
            prop.load(input);

            // get the property value and print it out                       
            Jdbc.creer(
                    prop.getProperty("sgbd.driver"),
                    prop.getProperty("sgbd.jdbc"),
                    prop.getProperty("sgbd.pass"),
                    prop.getProperty("sgbd.databasename"),
                    prop.getProperty("sgbd.loggin"),
                    prop.getProperty("sgbd.password")
            );

        } catch (final IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (final IOException e) {
                    e.printStackTrace();
                }
            }
        }

        CtrlPrincipal ctrlPrincipal;

        try {
            Jdbc.getInstance().connecter();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Lanceur Main - connexion à la BDD - pilote JDBC non trouvé", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Lanceur Main - connexion à la BDD", JOptionPane.ERROR_MESSAGE);
        }

        // Pour lancer l'application, instancier le contrôleur principal
        ctrlPrincipal = new CtrlPrincipal();
        ctrlPrincipal.action();
    }
}