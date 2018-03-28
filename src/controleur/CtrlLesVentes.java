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
    
    public CtrlLesVentes(CtrlPrincipal ctrlPrincipal, String groupe) {
        super(ctrlPrincipal);
        vue = new VueLesVentes();
        venteAfficher(groupe);
        ((VueLesVentes) vue).getJButtonRetour().addActionListener(this);
        ((VueLesVentes) vue).getjButtonCommande().addActionListener(this);
        
    }
    
    
    public void venteAfficher(String groupe) {
        String msg = ""; // message à afficher en cas d'erreur
        try {
            Groupe nomGroupe = GroupeDao.selectOneByName(groupe);
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
    
    public void venteSoustraire() throws SQLException{
        int vente = Integer.parseInt(((VueLesVentes) vue).getjTextFieldCommande().getText());

        RepresentationDao.update(uneRep.getId(), vente);
        reinitialisation();
        venteAfficher(uneRep.getGroupe().getNom());
    }
    
    public void reinitialisation(){
        ((VueLesVentes) vue).getJTextFieldNom().setText(uneRep.getGroupe().getNom());
            ((VueLesVentes) vue).getJTextFieldLieu().setText("");
            ((VueLesVentes) vue).getJTextFieldDate().setText("");
            ((VueLesVentes) vue).getJTextFieldHeureDebut().setText("");
            ((VueLesVentes) vue).getJTextFieldHeureFin().setText("");
            ((VueLesVentes) vue).getjTextFieldNbPlace().setText("");
    }
    
    public void  venteQuitter(){
        reinitialisation();
        this.getCtrlPrincipal().action(EnumAction.REPRESENTATION_VENTE_QUITTER);
        System.out.print("QUITTER VUE VENTE");
    }

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
        venteQuitter();
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
        if(e.getSource().equals(((VueLesVentes) vue).getJButtonRetour())){
            venteQuitter();
        }else{
            if(e.getSource().equals(((VueLesVentes) vue).getjButtonCommande())){
                if(uneRep.getLieu().getCapacite() - uneRep.getNbPlacesDispo() < Integer.parseInt(((VueLesVentes) vue).getjTextFieldCommande().getText())){
                    JOptionPane.showMessageDialog(null,"Pas assez de place disponible, veuillez saisir un nombre de place inférieur à "+ (uneRep.getLieu().getCapacite() - uneRep.getNbPlacesDispo()),"Inane error",JOptionPane.ERROR_MESSAGE);
                }else{
                    if(Integer.parseInt(((VueLesVentes) vue).getjTextFieldCommande().getText()) < 0){
                        JOptionPane.showMessageDialog(null,"Il n'est pas possible d'insérer une valeur inférieur à 0","Inane error",JOptionPane.ERROR_MESSAGE);
                    }else{
                        if (JOptionPane.showConfirmDialog(null, "Vous êtes sûr ?", "WARNING", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                            try {
                                venteSoustraire();
                            } catch (SQLException ex) {
                                Logger.getLogger(CtrlLesVentes.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }else{
                        // no option
                        }
                    }
                }
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
