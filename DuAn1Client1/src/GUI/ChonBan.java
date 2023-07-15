/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JToggleButton;

/**
 *
 * @author lethi
 */
public class ChonBan extends javax.swing.JFrame implements Runnable{
//    ChonBan mainframe = new ChonBan();
    static DatMonJPanel datMonJPanel;
    int soluongban = 20;
    ArrayList<Integer> tableIsSelected = new ArrayList<>();
    /**
     * Creates new form ChonBan
     */
    public ChonBan() {
        initComponents();
        setTitle("Chọn bàn");
    }
    ActionListener banChuaChon = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JToggleButtonBan j = (JToggleButtonBan) e.getSource();
                    datMonJPanel.chonBan(j.getText());
                    dispose();
                }
            };
    public void createJframe(ArrayList<Integer> ds, int soluongban){
        ArrayList<JToggleButtonBan> dsban=new ArrayList<>();
        panel.removeAll();
        panel.setLayout(new GridLayout(soluongban/5+1, 5));
        for(int i =1;i<=soluongban;i++){
            JToggleButtonBan button = new JToggleButtonBan();
            button.setColorSelected(Color.red);
            button.setColorNotSelected(Color.white);
            button.setText("Bàn"+ i);
            button.addActionListener(banChuaChon);
            panel.add(button);
            dsban.add(button);
        }
        for(Integer in : ds){ 
            dsban.get(in-1).setSelected(true);
            dsban.get(in-1).removeActionListener(banChuaChon);
            dsban.get(in-1).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dsban.get(in-1).setSelected(true);
                }
            });
        }
        for(int i = 0;i<(soluongban/5+1)*5-soluongban;i++){
            panel.add(new Panel());
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 776, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 575, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panel;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        this.setVisible(true);
    }
    
}
