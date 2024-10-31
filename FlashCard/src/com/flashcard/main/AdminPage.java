package com.flashcard.main;

import com.flashcard.model.ModelUser;
import com.flashcard.componet.PanelSlide;
import java.awt.Color;
import javax.swing.JPanel;

public class AdminPage extends javax.swing.JFrame {

    private final ModelUser user;
    private final PanelSlide panelSlide;

    public AdminPage(ModelUser user) {
        this.user = user;
        initComponents();
        getContentPane().setBackground(new Color(255, 255, 255));
        lbUser.setText(user.getUserName());
       
        
        // Initialize and configure PanelSlide
        panelSlide = new PanelSlide();
        panelSlide.setSize(400, 300); // Set appropriate size for your sliding panel
        panelSlide.setAnimate(5); // Customize animation speed if needed
        
        // Add components to PanelSlide for demonstration
        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.RED);
        
        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.BLUE);

        JPanel panel3 = new JPanel();
        panel3.setBackground(Color.GREEN);
        
        panelSlide.init(panel1, panel2, panel3);

        // Add PanelSlide to MainSystem's layout
        add(panelSlide);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbUser = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbUser.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lbUser.setForeground(new java.awt.Color(77, 77, 77));
        lbUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbUser.setText("User Name");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(518, 518, 518)
                .addComponent(lbUser, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(543, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(311, 311, 311)
                .addComponent(lbUser, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(350, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(ModelUser user) {
    	
        java.awt.EventQueue.invokeLater(() -> {
        	
            new AdminPage(user).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbUser;
    // End of variables declaration//GEN-END:variables
}
