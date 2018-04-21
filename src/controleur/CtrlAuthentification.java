/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import vue.VueAuthentification;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modele.dao.*;
import modele.jdbc.Jdbc;
import modele.metier.*;

/**
 *
 * @author btssio
 */
public class CtrlAuthentification extends CtrlGenerique implements WindowListener, ActionListener, MouseListener {

    private final AuthentificationDao daoAuthentification = new AuthentificationDao();
    private ArrayList<Utilisateur> lesUtilisateurs;

    public CtrlAuthentification(CtrlPrincipal ctrlPrincipal) {
        super(ctrlPrincipal);
        vue = new VueAuthentification();
        vue.addWindowListener(this);
        ((VueAuthentification) vue).getJButtonConnexion().addActionListener(this);
        ((VueAuthentification) vue).getJButtonQuitter().addActionListener(this);
        ((VueAuthentification) vue).getJButtonMode().addActionListener(this);
        ((VueAuthentification) vue).getJTextFieldMode().setText("Connexion Locale");
    }

    /**
     * Ferme l'application
     */
    public void quitterMenu() {
        int a = JOptionPane.showConfirmDialog(getVue(), "Quitter l'application\nEtes-vous sûr(e) ?", "Festival", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (a == JOptionPane.YES_OPTION) {
            this.getCtrlPrincipal().action(EnumAction.MENU_QUITTER);
        }
    }

    /**
     * Méthode inutilisé Permettait l'accès à l'application grâce des
     * identifiants contenu dans un fichier properties
     */
    public void verificationProperties() {
        final Properties prop = new Properties();
        InputStream input = null;
        try {
            input = new FileInputStream("src/config/accesBdd.properties");
            prop.load(input);
            if (((VueAuthentification) vue).getJTextFieldLoggin().getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Renseignez le Loggin", "Inane error", JOptionPane.ERROR_MESSAGE);
            } else {
                if (((VueAuthentification) vue).getJTextFieldMdp().getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Renseignez le Mot de Passe", "Inane error", JOptionPane.ERROR_MESSAGE);
                } else {
                    if (prop.getProperty("user.loggin").equals(((VueAuthentification) vue).getJTextFieldLoggin().getText())
                            && prop.getProperty("user.password").equals(((VueAuthentification) vue).getJTextFieldMdp().getText())) {
                        accesMenu();
                    } else {
                        JOptionPane.showMessageDialog(null, "Mot de compte ou mot de passe incorecte", "Inane error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
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
    }

    /**
     * Vérifie si l'utilisateur rentre le bon loggin et mot de passe pour
     * exécuter la méthode suivante : accesMenu() Si l'utilisateur n'a rien
     * rentré : Erreur Si l'utilisateur rentre un loggin ou un mdp incorecte :
     * Erreur
     */
    public void verificationBDD() {
        try {
            if (((VueAuthentification) vue).getJTextFieldLoggin().getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Renseignez le Loggin", "Inane error", JOptionPane.ERROR_MESSAGE);
            } else {
                Utilisateur utilisateur = AuthentificationDao.selectOneByName(((VueAuthentification) vue).getJTextFieldLoggin().getText());
                if (((VueAuthentification) vue).getJTextFieldMdp().getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Renseignez le Mot de Passe", "Inane error", JOptionPane.ERROR_MESSAGE);
                } else {
                    if (utilisateur.getPseudo().equals(((VueAuthentification) vue).getJTextFieldLoggin().getText())
                            && utilisateur.getPassword().equals(((VueAuthentification) vue).getJTextFieldMdp().getText())) {
                        accesMenu();
                    } else {
                        JOptionPane.showMessageDialog(null, "Mot de compte ou mot de passe incorecte", "Inane error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Mot de compte ou mot de passe incorecte", "Inane error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Connexion à la base de données Locale
     *
     * @throws FileNotFoundException
     * @throws IOException
     * @throws SQLException
     */
    public void connexionLocale() throws FileNotFoundException, IOException, SQLException {
        final Properties prop = new Properties();
        InputStream input = null;
        try {
            input = new FileInputStream("src/config/accesBdd.properties");
            prop.load(input);
            Jdbc.getInstance().setPiloteJdbc(prop.getProperty("sgbd.driver"));
            Jdbc.getInstance().setProtocoleJdbc(prop.getProperty("sgbd.jdbc"));
            Jdbc.getInstance().setServeurBd(prop.getProperty("sgbd.pass"));
            Jdbc.getInstance().setNomBd(prop.getProperty("sgbd.databasename"));
            Jdbc.getInstance().setLoginSgbd(prop.getProperty("sgbd.loggin"));
            Jdbc.getInstance().setMdpSgbd(prop.getProperty("sgbd.password"));
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
        try {
            Jdbc.getInstance().connecter();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Lanceur Main - connexion à la BDD - pilote JDBC non trouvé", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Lanceur Main - connexion à la BDD", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Connexion à la base de données Distante
     *
     * @throws FileNotFoundException
     * @throws IOException
     * @throws SQLException
     */
    public void connexionDistante() throws FileNotFoundException, IOException, SQLException {
        final Properties prop = new Properties();
        InputStream input = null;
        try {
            input = new FileInputStream("src/config/accesBdd.properties");
            prop.load(input);
            Jdbc.getInstance().setPiloteJdbc(prop.getProperty("sgbd.driverdist"));
            Jdbc.getInstance().setProtocoleJdbc(prop.getProperty("sgbd.jdbcdist"));
            Jdbc.getInstance().setServeurBd(prop.getProperty("sgbd.passdist"));
            Jdbc.getInstance().setNomBd(prop.getProperty("sgbd.databasenamedist"));
            Jdbc.getInstance().setLoginSgbd(prop.getProperty("sgbd.loggindist"));
            Jdbc.getInstance().setMdpSgbd(prop.getProperty("sgbd.passworddist"));
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
        try {
            Jdbc.getInstance().connecter();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Lanceur Main - connexion à la BDD - pilote JDBC non trouvé", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Lanceur Main - connexion à la BDD", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Modifie le fichier mode.properties la donnée connexion aura comme valeur
     * : "distante"
     */
    public void setConnexionDistante() {
        final Properties prop = new Properties();
        OutputStream output = null;
        try {
            output = new FileOutputStream("src/config/mode.properties");
            prop.setProperty("connexion", "distante");
            prop.store(output, null);
        } catch (final IOException io) {
            io.printStackTrace();
        } finally {
            if (output != null) {
                try {
                    output.close();
                } catch (final IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Modifie le fichier mode.preperties La donnée connexion aura comme valeur
     * : "locale"
     */
    public void setConnexionLocale() {
        final Properties prop = new Properties();
        OutputStream output = null;
        try {
            output = new FileOutputStream("src/config/mode.properties");
            prop.setProperty("connexion", "locale");
            prop.store(output, null);
        } catch (final IOException io) {
            io.printStackTrace();
        } finally {
            if (output != null) {
                try {
                    output.close();
                } catch (final IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    /**
     * Permet de récupérer la valeur de la donnée connexion du fichier
     * mode.properties
     *
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    public String getTypeConnexion() throws FileNotFoundException, IOException {
        final Properties prop = new Properties();
        InputStream input = null;
        input = new FileInputStream("src/config/mode.properties");
        prop.load(input);
        String connexion = prop.getProperty("connexion");
        return connexion;
    }

    /**
     * Permet d'accéder à la vue VueMenu
     */
    public void accesMenu() {
        this.getCtrlPrincipal().action(EnumAction.MENU_CONNEXION);
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        setConnexionLocale();
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(((VueAuthentification) vue).getJButtonConnexion())) {
            verificationBDD();
        }
        if (e.getSource().equals(((VueAuthentification) vue).getJButtonQuitter())) {
            setConnexionLocale();
            quitterMenu();
        }
        if (e.getSource().equals(((VueAuthentification) vue).getJButtonMode())) {
            try {
                if (getTypeConnexion().equals("locale")) {
                    connexionDistante();
                    setConnexionDistante();
                    ((VueAuthentification) vue).getJTextFieldMode().setText("Connexion Distante");
                } else {
                    if (getTypeConnexion().equals("distante")) {
                        connexionLocale();
                        setConnexionLocale();
                        ((VueAuthentification) vue).getJTextFieldMode().setText("Connexion Locale");
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(CtrlAuthentification.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(CtrlAuthentification.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
