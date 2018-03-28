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
import java.util.Properties;
import javax.swing.JOptionPane;
/**
 *
 * @author btssio
 */
public class CtrlAuthentification extends CtrlGenerique implements WindowListener,ActionListener,MouseListener{
    
    public CtrlAuthentification(CtrlPrincipal ctrlPrincipal){
        super(ctrlPrincipal);
        vue = new VueAuthentification();
        
        vue.addWindowListener(this);
        ((VueAuthentification) vue).getJButtonConnexion().addActionListener(this);
    }
    
    public void verification(){
        final Properties prop = new Properties();
        InputStream input = null;
        try{
            
        
            input = new FileInputStream("src/config/accesBdd.properties");
            // load a properties file
            prop.load(input);
            // get the property value and print it out
            String loggin = prop.getProperty("user.loggin");
            String password = prop.getProperty("user.password");
            if( (((VueAuthentification) vue).getJTextFieldLogin().getText()) != loggin || (((VueAuthentification) vue).getJTextFieldMdp().getText()) != password ){
                JOptionPane.showMessageDialog(null,"Mot de compte ou mot de passe incorecte","Inane error",JOptionPane.ERROR_MESSAGE);
            }else{
                accesMenu();
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
    
    public void accesMenu(){
        this.getCtrlPrincipal().action(EnumAction.REPRESENTATION_VENTE);
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
       if (e.getSource().equals(((VueAuthentification) vue).getJButtonConnexion())){
           verification();
           System.out.println("MDR SA MARSH OU PA ?");
       }
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
