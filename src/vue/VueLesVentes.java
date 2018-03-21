/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Elymne
 */
public class VueLesVentes extends VueGenerique {

    /**
     * Creates new form VueLesVentes
     */
    public VueLesVentes()
    {
        super();
        initComponents();
    }
    
    public JTextField getjTextFieldNbPlace(){
        return jTextFieldNbPlace;
    }
    
    public JTextField getjTextFieldCommande(){
        return jTextFieldCommande;
    }
    
    public JButton getjButtonCommande(){
        return jButtonCommande;
    }
    
    public JButton getJButtonRetour(){
        return jButtonRetour;
    }
    
    public JTextField getJTextFieldNom(){
        return jTextFieldNom;
    }
    
    public JTextField getJTextFieldLieu(){
        return jTextFieldLieu;
    }
    
    public JTextField getJTextFieldDate(){
        return jTextFieldDate;
    }
    
    public JTextField getJTextFieldHeureDebut(){
        return jTextFieldHeureDebut;
    }
    
    public JTextField getJTextFieldHeureFin(){
        return jTextFieldHeureFin;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelVente = new javax.swing.JLabel();
        jPanelVente = new javax.swing.JPanel();
        jLabelGroupe = new javax.swing.JLabel();
        jLabelLieu = new javax.swing.JLabel();
        jLabelDate = new javax.swing.JLabel();
        jLabelHeureDebut = new javax.swing.JLabel();
        jLabelHeureFin = new javax.swing.JLabel();
        jTextFieldNom = new javax.swing.JTextField();
        jTextFieldLieu = new javax.swing.JTextField();
        jTextFieldDate = new javax.swing.JTextField();
        jTextFieldHeureDebut = new javax.swing.JTextField();
        jTextFieldHeureFin = new javax.swing.JTextField();
        jButtonRetour = new javax.swing.JButton();
        jLabelPlace = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jTextFieldNbPlace = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldCommande = new javax.swing.JTextField();
        jButtonCommande = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelVente.setText("VENTE DE PLACE");
        jLabelVente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanelVente.setBackground(new java.awt.Color(255, 255, 255));
        jPanelVente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelGroupe.setForeground(new java.awt.Color(0, 0, 0));
        jLabelGroupe.setText("Groupe");

        jLabelLieu.setForeground(new java.awt.Color(0, 0, 0));
        jLabelLieu.setText("Lieu");

        jLabelDate.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDate.setText("Date");

        jLabelHeureDebut.setForeground(new java.awt.Color(0, 0, 0));
        jLabelHeureDebut.setText("Heure Début");

        jLabelHeureFin.setForeground(new java.awt.Color(0, 0, 0));
        jLabelHeureFin.setText("Heure Fin");

        jTextFieldNom.setEditable(false);

        jTextFieldLieu.setEditable(false);

        jTextFieldDate.setEditable(false);

        jTextFieldHeureDebut.setEditable(false);

        jTextFieldHeureFin.setEditable(false);

        javax.swing.GroupLayout jPanelVenteLayout = new javax.swing.GroupLayout(jPanelVente);
        jPanelVente.setLayout(jPanelVenteLayout);
        jPanelVenteLayout.setHorizontalGroup(
            jPanelVenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelVenteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelVenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelHeureDebut)
                    .addComponent(jLabelDate)
                    .addComponent(jLabelLieu)
                    .addComponent(jLabelGroupe)
                    .addComponent(jLabelHeureFin))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelVenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldHeureFin, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                    .addComponent(jTextFieldNom)
                    .addComponent(jTextFieldLieu)
                    .addComponent(jTextFieldDate)
                    .addComponent(jTextFieldHeureDebut))
                .addContainerGap())
        );
        jPanelVenteLayout.setVerticalGroup(
            jPanelVenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelVenteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelVenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelGroupe)
                    .addComponent(jTextFieldNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelVenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelLieu)
                    .addComponent(jTextFieldLieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelVenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDate)
                    .addComponent(jTextFieldDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelVenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelHeureDebut)
                    .addComponent(jTextFieldHeureDebut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelVenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelHeureFin)
                    .addComponent(jTextFieldHeureFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButtonRetour.setText("Retour");
        jButtonRetour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRetourActionPerformed(evt);
            }
        });

        jLabelPlace.setText("Nombre de place Restantes");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jTextFieldNbPlace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNbPlaceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextFieldNbPlace)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTextFieldNbPlace, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
        );

        jLabel2.setText("Commande de place");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setText("Nombre de place à vendre");

        jTextFieldCommande.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCommandeActionPerformed(evt);
            }
        });

        jButtonCommande.setText("VENDRE");
        jButtonCommande.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCommandeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jTextFieldCommande)
                    .addComponent(jButtonCommande, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldCommande, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonCommande)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanelVente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabelPlace, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jButtonRetour)
                    .addComponent(jLabelVente))
                .addContainerGap(88, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelVente, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelPlace)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanelVente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(jButtonRetour)
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonRetourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRetourActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonRetourActionPerformed

    private void jTextFieldNbPlaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNbPlaceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNbPlaceActionPerformed

    private void jButtonCommandeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCommandeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonCommandeActionPerformed

    private void jTextFieldCommandeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCommandeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCommandeActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VueLesVentes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VueLesVentes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VueLesVentes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VueLesVentes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VueLesVentes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCommande;
    private javax.swing.JButton jButtonRetour;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelDate;
    private javax.swing.JLabel jLabelGroupe;
    private javax.swing.JLabel jLabelHeureDebut;
    private javax.swing.JLabel jLabelHeureFin;
    private javax.swing.JLabel jLabelLieu;
    private javax.swing.JLabel jLabelPlace;
    private javax.swing.JLabel jLabelVente;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanelVente;
    private javax.swing.JTextField jTextFieldCommande;
    private javax.swing.JTextField jTextFieldDate;
    private javax.swing.JTextField jTextFieldHeureDebut;
    private javax.swing.JTextField jTextFieldHeureFin;
    private javax.swing.JTextField jTextFieldLieu;
    private javax.swing.JTextField jTextFieldNbPlace;
    private javax.swing.JTextField jTextFieldNom;
    // End of variables declaration//GEN-END:variables
}
