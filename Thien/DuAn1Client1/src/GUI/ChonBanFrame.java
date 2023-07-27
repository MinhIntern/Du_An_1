/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 *
 * @author lethi
 */
public class ChonBanFrame extends javax.swing.JFrame implements Runnable {
//    ChonBanFrame mainframe = new ChonBanFrame();

    public static DatMonJPanel datMonJPanel;
    int soluongban = 26;

    /**
     * Creates new form ChonBan
     */
    public ChonBanFrame() {
        initComponents();
        setTitle("Chọn bàn");
    }

    MouseAdapter banDaChon = new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent e) {
            JLabel j = (JLabel) e.getSource();
            datMonJPanel.chonBan(j.getText());
            dispose();
        }
    };

    public void createJframe(ArrayList<String> listTableSelectedAll, ArrayList<String> listTableSelected) {
        ArrayList<JLabel> dsban = new ArrayList<>();
        panel.removeAll();
        panel.setLayout(new GridLayout(soluongban / 5 + 1, 5));
        for (int i = 1; i <= soluongban; i++) {
            JLabel banLabel = new JLabel();
            banLabel.setBackground(Color.white);
            banLabel.setOpaque(true);
            banLabel.setText("Bàn" + i);
            banLabel.setBorder(new LineBorder(Color.black, 2));
            banLabel.setHorizontalAlignment(SwingConstants.CENTER);
            banLabel.addMouseListener(banDaChon);
            banLabel.setPreferredSize(new Dimension(panel.getWidth()/(soluongban / 5 + 1), panel.getHeight()/5));
            panel.add(banLabel);
            banLabel.setPreferredSize(new Dimension(banLabel.getParent().getWidth(), banLabel.getParent().getHeight()));

            dsban.add(banLabel);
        }

        for (String in : listTableSelectedAll) {
            for (JLabel label : dsban) {
                if (label.getText().equalsIgnoreCase(in)) {
                    label.setBackground(Color.red);
                    label.removeMouseListener(banDaChon);
                }
            }
        }
        for (String in : listTableSelected) {
            for (JLabel label : dsban) {
                if (label.getText().equalsIgnoreCase(in)) {
                    label.setBackground(Color.green);
                    label.addMouseListener(banDaChon);
                }
            }
        }

        for (int i = 0; i < (soluongban / 5 + 1) * 5 - soluongban; i++) {
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