package com.flashcard.swing;

import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;

import java.awt.event.ActionEvent;

import com.flashcard.event.TableActionEvent;
import com.flashcard.model.StatusType;

public class CellStatus extends javax.swing.JPanel {

    private StatusType statusType;

    public CellStatus(StatusType type) {
        initComponents();
        this.statusType = type; 
    }

    public CellStatus() {
        initComponents();
    }

    public void initEvent(TableActionEvent event, int row) {
        cmdEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                event.onEdit(row);
            }
        });
        cmdDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                event.onDelete(row);
            }
        });
        cmdView.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                event.onView(row);
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmdDelete = new com.flashcard.swing.ActionButton();
        cmdEdit = new com.flashcard.swing.ActionButton();
        cmdView = new com.flashcard.swing.ActionButton();

        setBackground(new java.awt.Color(255, 255, 255));

        //cmdDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/FlashCard/icon/delete.png")));
        String deletePath = "src/com/flashcard/icon/delete.png";
        File deleteFile = new File(deletePath);
        if (deleteFile.exists()) {
        	cmdDelete.setIcon(new ImageIcon(deleteFile.getAbsolutePath()));
        } else {
            System.out.println("Icon not found at " + deletePath);
        }
        
        
        //cmdEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/FlashCard/icon/edit.png")));
        String editPath = "src/com/flashcard/icon/edit.png";
        File editFile = new File(editPath);
        if (editFile.exists()) {
        	cmdEdit.setIcon(new ImageIcon(editFile.getAbsolutePath()));
        } else {
            System.out.println("Icon not found at " + editPath);
        }
        
        
        //cmdView.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/FlashCard/icon/view.png")));
        String viewPath = "src/com/flashcard/icon/view.png";
        File viewFile = new File(viewPath);
        if (viewFile.exists()) {
        	cmdView.setIcon(new ImageIcon(viewFile.getAbsolutePath()));
        } else {
            System.out.println("Icon not found at " + viewPath);
        }
        
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cmdEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmdDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmdView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cmdView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.flashcard.swing.ActionButton cmdDelete;
    private com.flashcard.swing.ActionButton cmdEdit;
    private com.flashcard.swing.ActionButton cmdView;
    // End of variables declaration//GEN-END:variables
}
