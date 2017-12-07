package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modele.dao.RepresentationDao;
import modele.metier.Representation;
import vue.VueLesRepresentations;

public class CtrlLesRepresentations extends CtrlGenerique implements WindowListener,ActionListener{
    
    private final RepresentationDao daoRepresentation = new RepresentationDao();
    private ArrayList<Representation> lesRepresentations;
   
    public CtrlLesRepresentations(CtrlPrincipal ctrlPrincipal) {
        super(ctrlPrincipal);
        vue = new VueLesRepresentations();
        representationAfficher();
        vue.addWindowListener(this);
        ((VueLesRepresentations) vue).getJButtonRetour().addActionListener(this);
    }
    
    public void  representationQuitter(){
        this.getCtrlPrincipal().action(EnumAction.MENU_REPRESENTATION_QUITTER);
    }
    
    
   public void representationAfficher() {
        String msg = ""; // message à afficher en cas d'erreur
        ((VueLesRepresentations) vue).getModeleTableRepresentation().setRowCount(0);
        String[] titresColonnes = {"Nom", "Prenom", "Volontaire"};
        ((VueLesRepresentations) vue).getModeleTableRepresentation().setColumnIdentifiers(titresColonnes);
        try {
            String[] ligneDonnees = new String[2];
            lesRepresentations = RepresentationDao.selectAll();
            for (Representation representation : lesRepresentations) {
                ligneDonnees[0] = representation.getDateRep();
                ligneDonnees[1] = representation.getHeureDebut();
                ((VueLesRepresentations) vue).getModeleTableRepresentation().addRow(ligneDonnees);
            }
        } catch (Exception ex) {
            msg = "CtrlEquipiers - equipiersAfficher() - " + ex.getMessage();
            JOptionPane.showMessageDialog(vue, msg, "Affichage des équipiers", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
        representationQuitter();
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
        if (e.getSource().equals(((VueLesRepresentations) vue).getJButtonRetour())){
            representationQuitter();
        }
    }
    
}
