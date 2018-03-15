package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


import modele.dao.GroupeDao;
import modele.dao.RepresentationDao;
import modele.metier.Groupe;
import modele.metier.Representation;
import vue.VueLesRepresentations;

public class CtrlLesRepresentations extends CtrlGenerique implements WindowListener,ActionListener,MouseListener{
    
    private final RepresentationDao daoRepresentation = new RepresentationDao();
    private ArrayList<Representation> lesRepresentations;
   
    public CtrlLesRepresentations(CtrlPrincipal ctrlPrincipal) {
        super(ctrlPrincipal);
        vue = new VueLesRepresentations();
        representationAfficher();
        
        vue.addWindowListener(this);
        ((VueLesRepresentations) vue).getJButtonRetour().addActionListener(this);
         ((VueLesRepresentations) vue).getTableRepresentation().addMouseListener(this);
    }
    
    public void  representationQuitter(){
        ResetGroupe();
        this.getCtrlPrincipal().action(EnumAction.MENU_REPRESENTATION_QUITTER);
    }
    
    
   public void representationAfficher() {
        String msg = ""; // message à afficher en cas d'erreur
        ((VueLesRepresentations) vue).getModeleTableRepresentation().setRowCount(0);
        String[] titresColonnes = {"Groupe"};
        ((VueLesRepresentations) vue).getModeleTableRepresentation().setColumnIdentifiers(titresColonnes);
        try {
            String[] ligneDonnees = new String[1];
            lesRepresentations = RepresentationDao.selectAll();
            for (Representation representation : lesRepresentations) {
                ligneDonnees[0] = representation.getGroupe().getNom();
                ((VueLesRepresentations) vue).getModeleTableRepresentation().addRow(ligneDonnees);
            }
        } catch (Exception ex) {
            msg = "Erreur dans la methode representationAfficher" + ex.getMessage();
            JOptionPane.showMessageDialog(vue, "", msg, JOptionPane.ERROR_MESSAGE);
        }
    }
   
   public void reinitialisationGroupe(){
        int ligne = ((VueLesRepresentations) vue).getTableRepresentation().getSelectedRow();
        int colonne = ((VueLesRepresentations) vue).getTableRepresentation().getSelectedColumn();
        if (ligne != -1 && colonne != -1){
            String cellule = (String) ((VueLesRepresentations) vue).getModeleTableRepresentation().getValueAt(ligne,colonne);
            try {
                Groupe nomGroupe = GroupeDao.selectOneByName(cellule);
                Representation representation = RepresentationDao.selectOneByIdGroupe(nomGroupe.getId());
                
                //Insérer les valeurs d'un groupe sélectionné.
                ((VueLesRepresentations) vue).getJTextFieldNom().setText(representation.getGroupe().getNom());
                ((VueLesRepresentations) vue).getJTextFieldLieu().setText(representation.getLieu().getNom());
                ((VueLesRepresentations) vue).getJTextFieldDate().setText(representation.getDateRep());
                ((VueLesRepresentations) vue).getJTextFieldHeureDebut().setText(representation.getHeureDebut());
                ((VueLesRepresentations) vue).getJTextFieldHeureFin().setText(representation.getHeureFin());
            } catch (SQLException ex) {
                Logger.getLogger(CtrlLesRepresentations.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
   }
   
   public void ResetGroupe(){
                ((VueLesRepresentations) vue).getJTextFieldNom().setText("");
                ((VueLesRepresentations) vue).getJTextFieldLieu().setText("");
                ((VueLesRepresentations) vue).getJTextFieldDate().setText("");
                ((VueLesRepresentations) vue).getJTextFieldHeureDebut().setText("");
                ((VueLesRepresentations) vue).getJTextFieldHeureFin().setText("");
   }
   
   

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
        ResetGroupe();
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

    @Override
    public void mouseClicked(MouseEvent e) {
        reinitialisationGroupe();
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
