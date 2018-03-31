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
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;
import javax.swing.JOptionPane;
import modele.dao.*;
import modele.metier.*;
/**
 *
 * @author btssio
 */
public class CtrlAuthentification extends CtrlGenerique implements WindowListener,ActionListener,MouseListener{
    
    private final Authentification daoAuthentification = new Authentification();
    private ArrayList<Utilisateur> lesUtilisateurs;
    
    public CtrlAuthentification(CtrlPrincipal ctrlPrincipal){
        super(ctrlPrincipal);
        vue = new VueAuthentification();
        
        vue.addWindowListener(this);
        ((VueAuthentification) vue).getJButtonConnexion().addActionListener(this);
        ((VueAuthentification) vue).getJButtonQuitter().addActionListener(this);
    }
    
        public void quitterMenu(){
        //  2 chaines de caractère, une pour l'affichage du texte, l'autre pour nommer le menu.
        int  a = JOptionPane.showConfirmDialog(getVue(), "Quitter l'application\nEtes-vous sûr(e) ?", "Festival",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (a == JOptionPane.YES_OPTION) {
            // mettre fin à l'application
            this.getCtrlPrincipal().action(EnumAction.MENU_QUITTER);
        }
    }
    
    public void verificationProperties(){
        final Properties prop = new Properties();
        InputStream input = null;
        try{
            
            input = new FileInputStream("src/config/accesBdd.properties");
            // load a properties file
            prop.load(input);
            if( ((VueAuthentification) vue).getJTextFieldLogin().getText().equals( "" )){
                JOptionPane.showMessageDialog(null,"Renseignez le Loggin","Inane error",JOptionPane.ERROR_MESSAGE);
            }else{
                if( ((VueAuthentification) vue).getJTextFieldMdp().getText().equals( "" )){
                    JOptionPane.showMessageDialog(null,"Renseignez le Mot de Passe","Inane error",JOptionPane.ERROR_MESSAGE);
                }else{
                    if( prop.getProperty("user.loggin").equals( ((VueAuthentification) vue).getJTextFieldLogin().getText() ) 
                        && prop.getProperty("user.password").equals(((VueAuthentification) vue).getJTextFieldMdp().getText()) ){     
                        accesMenu();
                    }else{
                        JOptionPane.showMessageDialog(null,"Mot de compte ou mot de passe incorecte","Inane error",JOptionPane.ERROR_MESSAGE);
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
    
    public void verificationBDD(){
        
        try{
            if( ((VueAuthentification) vue).getJTextFieldLogin().getText().equals( "" )){
                JOptionPane.showMessageDialog(null,"Renseignez le Loggin","Inane error",JOptionPane.ERROR_MESSAGE);
            }else{
                Utilisateur utilisateur = Authentification.selectOneByName(((VueAuthentification) vue).getJTextFieldLogin().getText());
                if( ((VueAuthentification) vue).getJTextFieldMdp().getText().equals( "" )){
                    JOptionPane.showMessageDialog(null,"Renseignez le Mot de Passe","Inane error",JOptionPane.ERROR_MESSAGE);
                }else{
                    if( utilisateur.getPseudo().equals( ((VueAuthentification) vue).getJTextFieldLogin().getText() ) 
                        && utilisateur.getPassword().equals(((VueAuthentification) vue).getJTextFieldMdp().getText()) ){     
                        accesMenu();
                    }else{
                        JOptionPane.showMessageDialog(null,"Mot de compte ou mot de passe incorecte","Inane error",JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Mot de compte ou mot de passe incorecte","Inane error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void accesMenu(){
        this.getCtrlPrincipal().action(EnumAction.MENU_CONNEXION);
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
        if (e.getSource().equals(((VueAuthentification) vue).getJButtonConnexion())){
           //verificationProperties();
           verificationBDD();
       } 
       if(e.getSource().equals(((VueAuthentification) vue).getJButtonQuitter())){
           quitterMenu();
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
