package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JOptionPane;
import vue.VueMenu;

/**
 * @author Sacha Djurdjevic
 */
public class CtrlMenu extends CtrlGenerique implements ActionListener, WindowListener {

    public CtrlMenu(CtrlPrincipal ctrlPrincipal) {
        super(ctrlPrincipal);
        vue = new VueMenu();
        vue.addWindowListener(this);
        getVue().getJButtonRepresentation().addActionListener(this);
        getVue().getJButtonAuthentification().addActionListener(this);
    }

    /**
     * Execute la méthode action de la classe ctrlPrincipal Avec le paramètre
     * suivant : EnumAction.MENU_QUITTER Résumé : cette méthode permet de
     * quitter l'application
     */
    public void quitterMenu() {
        int a = JOptionPane.showConfirmDialog(getVue(), "Quitter l'application\nEtes-vous sûr(e) ?", "Festival", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (a == JOptionPane.YES_OPTION) {
            this.getCtrlPrincipal().action(EnumAction.MENU_QUITTER);
        }
    }

    /**
     * Execute la méthode action de la classe ctrlPrincipal Avec le paramètre
     * suivant : EnumAction.MENU_REPRESENTATION Résumé : cette méthode permet de
     * passer à la vue des représentations
     */
    public void representationAcces() {
        this.getCtrlPrincipal().action(EnumAction.MENU_REPRESENTATION);
    }

    /**
     * Execute la méthode action de la classe ctrlPrincipal Avec le paramètre
     * suivant : EnumAction.MENU_DECONNEXION Résumé : cette méthode permet de
     * passer à la vue de connexion
     */
    public void deconnexionMenu() {
        this.getCtrlPrincipal().action(EnumAction.MENU_DECONNEXION);
    }

    @Override
    public VueMenu getVue() {
        return (VueMenu) vue;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(getVue().getJButtonRepresentation())) {
            representationAcces();
        } else {
            if (e.getSource().equals(getVue().getJButtonAuthentification())) {
                deconnexionMenu();
            }
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
        quitterMenu();
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
