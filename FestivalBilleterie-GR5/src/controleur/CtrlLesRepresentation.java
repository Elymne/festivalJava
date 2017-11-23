package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import vue.VueLesRepresentations;



public class CtrlLesRepresentation implements WindowListener,ActionListener {
    
    private VueLesRepresentations vue;
    
    public CtrlLesRepresentation(VueLesRepresentations vue) {
        
        this.vue = vue;
        // le contrôleur écoute la vue
        this.vue.addWindowListener(this);
        // préparer l'état iniitial de la vue
        
        List<Representation> lesRepresentations = null;
        try {
            lesRepresentations = DaoRepresentation.selectAll();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(getVue(), "CtrlLesAdresses - échec de sélection des adresses");
        }
        afficherLesRepresentations(lesRepresentations);
    }
    
    private void quitter() {
        // Confirmer avant de quitter
        int rep = JOptionPane.showConfirmDialog(getVue(), "Quitter l'application\nEtes-vous sûr(e) ?", "AGENCEB", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (rep == JOptionPane.YES_OPTION) {
            // mettre fin à l'application
            System.exit(0);
        }
    }
    
    // contrôle de la vue
    /**
     * Remplir le composant JTable avec les adresses
     *
     * @param desRepresentations liste des adresses à afficher
     */
    private final void afficherLesRepresentation(List<Representation> desRepresentations) {
        getVue().getModeleTableRepresentation().setRowCount(0);
        String[] titresColonnes = {"Representation","Lieu","Date", "Heure Début", "Heure Fin"};
        getVue().getModeleTableRepresentation().setColumnIdentifiers(titresColonnes);
        String[] ligneDonnees = new String[5];
        for (Representation uneRepresentation : desRepresentations) {
            ligneDonnees[0] = uneRepresentation.getRue();
            ligneDonnees[1] = uneRepresentation.getCp();
            ligneDonnees[2] = uneRepresentation.getVille();
            ligneDonnees[3] = uneRepresentation.getVille();
            ligneDonnees[4] = uneRepresentation.getVille();
            getVue().getModeleTableRepresentation().addRow(ligneDonnees);            
        } 
    }
    
    // ACCESSEURS et MUTATEURS
    public VueLesRepresentations getVue() {
        return vue;
    }
    
    public void setVue(VueLesRepresentations vue) {
        this.vue = vue;
    }
    

    @Override
    public void windowOpened(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowClosing(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowClosed(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowIconified(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowActivated(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
