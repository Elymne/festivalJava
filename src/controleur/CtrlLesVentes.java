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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modele.dao.GroupeDao;
import modele.dao.RepresentationDao;
import modele.metier.Groupe;
import modele.metier.Representation;
import vue.VueLesVentes;

/**
 *
 * @author btssio
 */
public class CtrlLesVentes extends CtrlGenerique  implements WindowListener,ActionListener,MouseListener{
    
    private final RepresentationDao daoRepresentation = new RepresentationDao();
    private Representation uneRep;
    
    public CtrlLesVentes(CtrlPrincipal ctrlPrincipal) {
        super(ctrlPrincipal);
        vue = new VueLesVentes();
        venteAfficher();
        
    }
    
    
    public void venteAfficher() {
        String msg = ""; // message à afficher en cas d'erreur
        try {
            Groupe nomGroupe = GroupeDao.selectOneByName("Boxty");
            uneRep = RepresentationDao.selectOneByIdGroupe(nomGroupe.getId());
            ((VueLesVentes) vue).getJTextFieldNom().setText(uneRep.getGroupe().getNom());
            ((VueLesVentes) vue).getJTextFieldLieu().setText(uneRep.getLieu().getNom());
            ((VueLesVentes) vue).getJTextFieldDate().setText(uneRep.getDateRep());
            ((VueLesVentes) vue).getJTextFieldHeureDebut().setText(uneRep.getHeureDebut());
            ((VueLesVentes) vue).getJTextFieldHeureFin().setText(uneRep.getHeureFin());
            ((VueLesVentes) vue).getjTextFieldNbPlace().setText(Integer.toString(uneRep.getLieu().getCapacite() - uneRep.getNbPlacesDispo()));
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

    @Override
    public void actionPerformed(ActionEvent e) {
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
