package vue;

import javax.swing.JButton;

/**
 *
 * @author hppc
 */
public class VueMenu extends VueGenerique {

    public VueMenu() {
        super();
        initComponents();
    }
    
    public JButton getJButtonQuitter(){
        return jButtonQuitter;
    }
    
    public JButton getJButtonRepresentation(){
        return jButtonRepresentation;
    }
    
    public JButton getJButtonAuthentification(){
        return jButtonAuthentification;
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButtonQuitter = new javax.swing.JButton();
        jButtonRepresentation = new javax.swing.JButton();
        jLabelMenu = new javax.swing.JLabel();
        jButtonAuthentification = new javax.swing.JButton();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 51, 51));

        jButtonQuitter.setText("Quitter");
        jButtonQuitter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonQuitterActionPerformed(evt);
            }
        });

        jButtonRepresentation.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jButtonRepresentation.setText("Representation");
        jButtonRepresentation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRepresentationActionPerformed(evt);
            }
        });

        jLabelMenu.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabelMenu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMenu.setText("MENU");
        jLabelMenu.setToolTipText("");
        jLabelMenu.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jLabelMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jButtonAuthentification.setText("Authentification Locale");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonQuitter)
                .addContainerGap(312, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButtonRepresentation, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonAuthentification, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAuthentification, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonRepresentation, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(297, 297, 297)
                .addComponent(jButtonQuitter, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonQuitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonQuitterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonQuitterActionPerformed

    private void jButtonRepresentationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRepresentationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonRepresentationActionPerformed
 
    private void jButtonAuthentificationActionPerformed(java.awt.event.ActionEvent evt) {                                                      
        // TODO add your handling code here:
    }   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAuthentification;
    private javax.swing.JButton jButtonQuitter;
    private javax.swing.JButton jButtonRepresentation;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabelMenu;
    // End of variables declaration//GEN-END:variables



//Innutilisé
    /*
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VueMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VueMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VueMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VueMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VueMenu().setVisible(true);
            }
        });
    }
    */

}
