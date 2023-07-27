/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import ClientController.Client;
import ClientController.HandleSocket;
import Model.LoaiMA;
import Model.MonAn;
import Utils.WrapLayout;
import raven.scroll.win11.*;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.JScrollPane;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.border.Border;
import javax.swing.plaf.ScrollBarUI;

/**
 *
 * @author lethi
 */
public class DatMonJPanel extends javax.swing.JPanel {

    public static ChonBanFrame chonBanFrame = new ChonBanFrame();
    String banDaChon = "";
    public static ArrayList<MonAn> dsMonAn;
    public static ArrayList<LoaiMA> dsLoai;
    ArrayList<MonAn> dsmonByLoai = new ArrayList<>();
    ArrayList<Object[]> dsKhachChon = new ArrayList<>();
    ArrayList<Object[]> dsSoLanKhachChon = new ArrayList<>();

    /**
     * Creates new form DatMonJPanel
     */
    public DatMonJPanel() {
        initComponents();
        danhsachtext.setEditable(false);
        chonBanFrame = new ChonBanFrame();
        chonBanFrame.datMonJPanel = this;
    }

    void ResetPanelMonAn() {
        jTabbedPane1.removeAll();
        for (LoaiMA loai : dsLoai) {
            dsmonByLoai.clear();
            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

            JScrollPane jScrollPane1 = new JScrollPane();

            jScrollPane1.setViewportView(panel);
            jScrollPane1.getHorizontalScrollBar().setUI(new ScrollBarWin11UI());
            jScrollPane1.getVerticalScrollBar().setUI(new ScrollBarWin11UI());
            jScrollPane1.revalidate();
//            panel.setPreferredSize(new Dimension(800, 700));
            jScrollPane1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            jScrollPane1.getVerticalScrollBar().setUnitIncrement(20);

            panel.setName(loai.getID());
            for (MonAn monan : dsMonAn) {
                if (monan.getIDloai().equalsIgnoreCase(loai.getID())) {
                    dsmonByLoai.add(monan);
                }
            }
            for (int i = 0; i < dsmonByLoai.size(); i = i + 5) {
                JPanel panelmain = createpanel(dsmonByLoai.size(), i);
                panel.add(panelmain);
            }
            jTabbedPane1.addTab(loai.getTEN(), jScrollPane1);
        }
    }

    JPanel createpanel(int soproduct, int i) {
        int row = 5;
        int column = 1;
        int totalproduct = row * column;
        JPanel MonAnPanel = new JPanel();
        MonAnPanel.setOpaque(false);
        MonAnPanel.setPreferredSize(new Dimension(800, 700));//(800-30)/4
        MonAnPanel.setLayout(new GridLayout(row, column, 10, 10));
        MonAnPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10));
        if ((soproduct - i) / totalproduct > 0) {
            for (int j = i; j < i + totalproduct; j++) {
                JPanel panel = new JPanel();
                panel.setSize(new Dimension(800, (700 - 20) / totalproduct));
                MonAnPanel.add(panel);
                panelMonAn("src/IMG/hinhtrasua.png", dsmonByLoai.get(j).getID(), dsmonByLoai.get(j).getTen(), dsmonByLoai.get(j).getDongia().toString(), String.valueOf(dsmonByLoai.get(j).getSoluong()), panel);
            }
        } else {
            for (int j = i; j < soproduct; j++) {

                JPanel panel = new JPanel();
                panel.setSize(new Dimension(800, (700 - 20) / totalproduct));
                MonAnPanel.add(panel);
                panelMonAn("src/IMG/hinhtrasua.png", dsmonByLoai.get(j).getID(), dsmonByLoai.get(j).getTen(), dsmonByLoai.get(j).getDongia().toString(), String.valueOf(dsmonByLoai.get(j).getSoluong()), panel);
            }
            for (int j = 0; j < totalproduct - (soproduct - i); j++) {
                MonAnPanel.add(new JPanel());
            }
        }
        return MonAnPanel;
    }

    ActionListener jButtonTangGiam = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton x = (JButton) e.getSource();
            JPanel xpanel = (JPanel) x.getParent();
            JPanel giapanel = (JPanel) xpanel.getParent();
            JPanel paneltong = (JPanel) giapanel.getParent();
            String gia = "";
            String ten = "";
            for (Component c : giapanel.getComponents()) {
                if ((c instanceof JLabel) && c.getName().equalsIgnoreCase("gia")) {
                    gia = ((JLabel) c).getText().substring(0, ((JLabel) c).getText().indexOf(" "));
                }
            }

            for (Component c : paneltong.getComponents()) {
                if ((c instanceof JLabel) && c.getName().equalsIgnoreCase("ten")) {
                    ten = ((JLabel) c).getText();
                }
            }

            JLabel labelsoluong = new JLabel();//thay đổi label số lượng
            for (Component c : xpanel.getComponents()) {
                if (c instanceof JLabel) {
                    labelsoluong = (JLabel) c;
                    if (((JLabel) c).getText().equals("0")) {
                        Object[] o = new Object[]{x.getName(), "0", gia, ten};
                        dsKhachChon.add(o);
                    }
                }
            }
            String text = x.getText();

            if (text.equals("+")) {
                labelsoluong.setText(String.valueOf(Integer.parseInt(labelsoluong.getText()) + 1));
                for (Object[] o : dsKhachChon) {
                    if (o[0].equals(x.getName())) {
                        o[1] = String.valueOf(Integer.parseInt(String.valueOf(o[1])) + 1);
                        if (Integer.parseInt(o[1].toString()) <= 0) {
                            dsKhachChon.remove(o);
                            labelsoluong.setText("0");
                        }
                        break;
                    }
                }
            }
            if (text.equals("-")) {
                for (Object[] o : dsKhachChon) {
                    if (o[0].equals(x.getName())) {
                        labelsoluong.setText(String.valueOf(Integer.parseInt(labelsoluong.getText()) - 1));
                        o[1] = String.valueOf(Integer.parseInt(String.valueOf(o[1])) - 1);
                        if (Integer.parseInt(o[1].toString()) <= 0) {
                            dsKhachChon.remove(o);
                            labelsoluong.setText("0");
                        }
                        break;
                    }
                }
            }
            danhSachKhachChon(dsKhachChon);
        }
    };

    void panelMonAn(String imgURL, String IDmon, String ten, String gia, String soluong, JPanel panel) {
        panel.setBorder(BorderFactory.createLineBorder(Color.black));
        panel.setOpaque(false);
        int width = panel.getWidth();
        int height = panel.getHeight();
        //  
        panel.setLayout(new BorderLayout(20, 0));

        //imglabel
        JLabel imglabel = new JLabel();
        imglabel.setOpaque(true);
        imglabel.setSize(width / 5, height);
        ImageIcon imageIcon = new ImageIcon(new ImageIcon(imgURL).getImage().getScaledInstance(imglabel.getWidth(), imglabel.getHeight(), Image.SCALE_DEFAULT));
        imglabel.setIcon(imageIcon);

        //tenlabel
        JLabel tenlabel = new JLabel();
        tenlabel.setFont(new Font("Aria", Font.BOLD, 20));
        tenlabel.setSize(width * 4 / 5 - 10, height / 2 - 5);
        tenlabel.setText(ten);
        tenlabel.setName("ten");

        //giaPanel
        JPanel giaPanel = new JPanel(new BorderLayout());
        giaPanel.setPreferredSize(new Dimension(width * 4 / 5 - 1, height / 2 - 5));

        JLabel giaLabel = new JLabel();
        giaLabel.setFont(new Font("Aria", Font.BOLD, 16));
        giaLabel.setText(gia + " VND");
        giaLabel.setName("gia");

        JPanel soluongPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        JLabel soluongLabel = new JLabel();
        soluongLabel.setSize(width, height);
        soluongLabel.setHorizontalAlignment(SwingConstants.CENTER);
        soluongLabel.setText("0");
        soluongLabel.setName("soluong");

        //2 button
        JButton tangButton = new JButton();
        tangButton.setText("+");
        tangButton.setName(IDmon);
        tangButton.addActionListener(jButtonTangGiam);

        JButton giamButton = new JButton();
        giamButton.setText("-");
        giamButton.setName(IDmon);
        giamButton.addActionListener(jButtonTangGiam);

        soluongPanel.add(tangButton);
        soluongPanel.add(soluongLabel);
        soluongPanel.add(giamButton);

        giaPanel.add(giaLabel, BorderLayout.WEST);
        giaPanel.add(soluongPanel, BorderLayout.EAST);

        JPanel tenPanel = new JPanel(new GridLayout(2, 1));
        tenPanel.setPreferredSize(new Dimension(width * 4 / 5 - 50, height));
        tenPanel.add(tenlabel);
        tenPanel.add(giaPanel);

        //
        panel.add(imglabel, BorderLayout.WEST);
        panel.add(tenPanel, BorderLayout.EAST);

    }

    void danhSachKhachChon(ArrayList<Object[]> ds) {
        double total = 0;
        danhsachtext.setText("");
        for (Object[] o : ds) {
            String x = danhsachtext.getText();
            danhsachtext.setText(x + " - Tên:" + o[3] + "\n" + " - Số lượng: " + o[1] + "\n - Đơn giá: " + o[2] + "\n -------------------------------\n");
            total = total + Double.valueOf(String.valueOf(o[2])) * Double.valueOf(String.valueOf(o[1]));
        }
        totaltext.setText(String.valueOf(total));
    }

    public void chonBan(String x) {
        banDaChon = x;
        banLabel.setText(x);
    }

    public void orderSuccesfull() {
        JOptionPane.showMessageDialog(this, "Order thành công");
        danhsachtext.setText("");
        dsKhachChon.clear();
        banDaChon = "";
        banLabel.setText("");
        ResetPanelMonAn();
        totaltext.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        danhsachtext = new javax.swing.JTextArea();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jLabel1 = new javax.swing.JLabel();
        totaltext = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        banLabel = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1050, 700));

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        danhsachtext.setColumns(20);
        danhsachtext.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        danhsachtext.setLineWrap(true);
        danhsachtext.setRows(5);
        jScrollPane1.setViewportView(danhsachtext);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Tổng tiền:");

        totaltext.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        totaltext.setForeground(new java.awt.Color(255, 51, 51));

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setText("CHỌN BÀN");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setText("ORDER");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("BÀN:");

        banLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 798, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jButton1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(totaltext, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jButton2))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(banLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 2, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 698, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(banLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(totaltext, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(3, 3, 3)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
//        chonBanFrame.datMonJPanel = this;
        ArrayList<String> idclient = new ArrayList<>();
        idclient.add(Client.clientID);
        Map<String, ArrayList<?>> clMap = new HashMap<>();
        clMap.put("idclient", idclient);
        HandleSocket.write("SoBanDaChon_Request", clMap);
        System.out.println(Client.clientID + " đang gửi request bàn");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if (banDaChon.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Chưa chọn bàn");
        } else if (dsKhachChon.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Chưa chọn món");
        } else {
            boolean flag = true;
            Object[] o = null;
            for (Object[] ob : dsSoLanKhachChon) {
                if (ob[0].equals(banDaChon)) {
                    ob[1] = Integer.parseInt(ob[1].toString()) + 1;
                    flag = false;
                    o = ob;
                    break;
                }
            }
            if (flag) {
                o = new Object[]{banDaChon, "1"};
                dsSoLanKhachChon.add(o);
            }
            TrangQuanLyNV.listTableSelected.add(banDaChon);
            Map<String, ArrayList<?>> maparr = new HashMap<>();
            ArrayList<Object[]> arrBan = new ArrayList<>();
            arrBan.add(o);

            maparr.put("table", arrBan);
            maparr.put("dsKhachChon", dsKhachChon);
            HandleSocket.write("Create-order", maparr);

            System.out.println(dsKhachChon.toString());
        }


    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel banLabel;
    private javax.swing.JTextArea danhsachtext;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel totaltext;
    // End of variables declaration//GEN-END:variables

    private Object ClientServer() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
