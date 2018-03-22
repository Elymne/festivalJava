
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
        getVue().getJButtonQuitter().addActionListener(this);
        getVue().getJButtonRepresentation().addActionListener(this);
        getVue().getJButtonAuthentification().addActionListener(this);
    }
    
    /*
        Fermeture de l'application lors d'une action sur le bouton "Quitter"
    */
    public void quitterMenu(){
        //  2 chaines de caractère, une pour l'affichage du texte, l'autre pour nommer le menu.
        int  a = JOptionPane.showConfirmDialog(getVue(), "Quitter l'application\nEtes-vous sûr(e) ?", "Festival",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (a == JOptionPane.YES_OPTION) {
            // mettre fin à l'application
            this.getCtrlPrincipal().action(EnumAction.MENU_QUITTER);
        }
    }
    
    /*
    Ouverture Menu Reprensentation
    */
    public void representationAcces(){
        this.getCtrlPrincipal().action(EnumAction.MENU_REPRESENTATION);
    }
    
    public void authentificationAcces(){
        this.getCtrlPrincipal().action(EnumAction.MENU_AUTHENTIFICATION);
    }
    
    @Override
    public VueMenu getVue() {
        return (VueMenu) vue;
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(getVue().getJButtonQuitter())){
            quitterMenu();
        }else{
            if(e.getSource().equals(getVue().getJButtonRepresentation())){
            representationAcces();
            }
            if(e.getSource().equals(getVue().getJButtonAuthentification())){
            authentificationAcces();
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
