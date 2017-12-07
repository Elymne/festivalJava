package controleur;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modele.dao.RepresentationDao;
import modele.metier.Representation;
import vue.VueLesRepresentations;

public class CtrlLesRepresentations extends CtrlGenerique implements WindowListener{
    
    private final RepresentationDao daoRepresentation = new RepresentationDao();
    private ArrayList<Representation> lesRepresentations;
   
    public CtrlLesRepresentations(CtrlPrincipal ctrlPrincipal) {
        super(ctrlPrincipal);
        vue = new VueLesRepresentations();
        representationAfficher();
        vue.addWindowListener(this);
    }
    
    public void  representationQuitter(){
        this.getCtrlPrincipal().action(EnumAction.MENU_REPRESENTATION_QUITTER);
    }
    
    
    public void representationAfficher() {
        String msg = ""; // message à afficher en cas d'erreur
        ((VueLesRepresentations) vue).getModeleTableRepresentation().setRowCount(0);
        String[] titresColonnes = {"Groupe", "Lieu", "Date","Heure de debut","Heure de fin"};
        ((VueLesRepresentations) vue).getModeleTableRepresentation().setColumnIdentifiers(titresColonnes);
        try {
            String[] ligneDonnees = new String[5];
            lesRepresentations = RepresentationDao.selectAll();
            for (Representation representation : lesRepresentations) {
                ligneDonnees[0] = representation.getGroupe().getNom();
                ligneDonnees[1] = representation.getLieu().getNom();
                ligneDonnees[2] = representation.getDateRep();
                ligneDonnees[3] = representation.getHeureDebut();
                ligneDonnees[4] = representation.getHeureFin();
                ((VueLesRepresentations) vue).getModeleTableRepresentation().addRow(ligneDonnees);
            }
        } catch (Exception ex) {
            msg = "Erreur dans la methode representationAfficher" + ex.getMessage();
            JOptionPane.showMessageDialog(vue, "", msg, JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
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
    
}
