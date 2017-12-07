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
        lesRepresentationsAfficher();
        vue.addWindowListener(this);
    }
    
    public void  representationQuitter(){
        this.getCtrlPrincipal().action(EnumAction.MENU_REPRESENTATION_QUITTER);
    }
    
    
    public void representationAfficher() {
        String msg = ""; // message à afficher en cas d'erreur
        ((VueRepresentation) vue).getModeleTableEquipier().setRowCount(0);
        String[] titresColonnes = {"Nom", "Prenom", "Volontaire"};
        ((VueEquipiers) vue).getModeleTableEquipier().setColumnIdentifiers(titresColonnes);
        try {
            String[] ligneDonnees = new String[3];
            lesEquipiers = daoEquipier.getAll();
            for (Equipier unEquipier : lesEquipiers) {
                ligneDonnees[0] = unEquipier.getNom();
                ligneDonnees[1] = unEquipier.getPrenom();
                ligneDonnees[2] = (unEquipier.isDimanche() ? "OUI" : "");
                ((VueEquipiers) vue).getModeleTableEquipier().addRow(ligneDonnees);
            }
        } catch (Exception ex) {
            msg = "CtrlEquipiers - equipiersAfficher() - " + ex.getMessage();
            JOptionPane.showMessageDialog(vue, msg, "Affichage des équipiers", JOptionPane.ERROR_MESSAGE);
        }
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
    
}
