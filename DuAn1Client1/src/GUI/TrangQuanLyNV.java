/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import static ClientServer.ClientController.ClientServer.handleSocket;
import static GUI.FormKhachHang.model;
import Model.KhachHang;
import Model.LoaiMA;
import Model.MonAn;
import Model.NhanVien;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

/**
 *
 * @author PhamNgocMinh
 */
public class TrangQuanLyNV extends javax.swing.JFrame implements Runnable {
    public static NhanVien nhanVien;
    public static DatMonJPanel datmonJPanel1;
    CardLayout CardLayout;
//    boolean closeThread = true;

    public TrangQuanLyNV() {
        initComponents();
        CardLayout = (CardLayout) jPanel2.getLayout();
        this.getContentPane().setBackground(Color.white);
        datmonJPanel1 = datMonJPanel1;
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
             @Override
             public void windowClosing(WindowEvent e) {
                         handleSocket.write("close");

             }
        });
//        this.setExtendedState(TrangQuanLyNV.MAXIMIZED_BOTH);
        this.setResizable(false);
        setLocationRelativeTo(null);
//        LoadData();
//        setsize();
    }
    public void setupDatMonJpanel(ArrayList<MonAn> dsMA,ArrayList<LoaiMA> dsLoai,NhanVien nhanVien){
        datmonJPanel1.dsMonAn = dsMA;
        datmonJPanel1.dsLoai = dsLoai;
        this.nhanVien = nhanVien;
        datmonJPanel1.ResetPanelMonAn();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
//    public void LoadData() {
//        ArrayList<KhachHang> ds = new KhachHangDao().GetArrayListAll();
//        model.setColumnIdentifiers(new Object[]{"Mã Khách Hàng", "Tên Khách hàng", "SDT", "Ngày Tạo", "LastActive", "Mã Người Tạo"});
//        model.setRowCount(0);
//        for (int i = 0; i < ds.size(); i++) {
//            model.addRow(new Object[]{
//                ds.get(i).getMaKH(),
//                ds.get(i).getTenKH(),
//                ds.get(i).getSDT(),
//                ds.get(i).getNgayTao(),
//                ds.get(i).getLastActive(),
//                ds.get(i).getMaNguoiTao()
//            });
//        }
//    }

    public void failConection() {
        JOptionPane.showMessageDialog(this, "Mất kết nối máy chủ");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btgDaodien = new javax.swing.ButtonGroup();
        buttonGroup1 = new javax.swing.ButtonGroup();
        TimePanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        PanelMain = new javax.swing.JPanel();
        PanelMenu = new javax.swing.JPanel();
        btnSanPham = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        btnKhachHang = new javax.swing.JToggleButton();
        btnBanHang = new javax.swing.JToggleButton();
        btnHoaDon = new javax.swing.JToggleButton();
        btnPhanHoi2 = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();
        btnPhanHoi3 = new javax.swing.JToggleButton();
        jPanel2 = new javax.swing.JPanel();
        datMonJPanel1 = new GUI.DatMonJPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TimePanel.setBackground(new java.awt.Color(102, 102, 102));
        TimePanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("jLabel2");

        javax.swing.GroupLayout TimePanelLayout = new javax.swing.GroupLayout(TimePanel);
        TimePanel.setLayout(TimePanelLayout);
        TimePanelLayout.setHorizontalGroup(
            TimePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TimePanelLayout.createSequentialGroup()
                .addGap(504, 504, 504)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        TimePanelLayout.setVerticalGroup(
            TimePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TimePanelLayout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(0, 17, Short.MAX_VALUE))
        );

        PanelMain.setOpaque(false);

        PanelMenu.setBackground(new java.awt.Color(51, 51, 51));
        PanelMenu.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btgDaodien.add(btnSanPham);
        btnSanPham.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        btnSanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/products.png"))); // NOI18N
        btnSanPham.setText("Sản Phẩm");
        btnSanPham.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSanPhamActionPerformed(evt);
            }
        });

        jToggleButton2.setText("jToggleButton1");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });

        btgDaodien.add(btnKhachHang);
        btnKhachHang.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        btnKhachHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/rating.png"))); // NOI18N
        btnKhachHang.setText("Khách Hàng");
        btnKhachHang.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnKhachHang.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhachHangActionPerformed(evt);
            }
        });

        btgDaodien.add(btnBanHang);
        btnBanHang.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        btnBanHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/coupon.png"))); // NOI18N
        btnBanHang.setText("Bán Hàng");
        btnBanHang.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnBanHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBanHangActionPerformed(evt);
            }
        });

        btgDaodien.add(btnHoaDon);
        btnHoaDon.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        btnHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/bill.png"))); // NOI18N
        btnHoaDon.setText("In Hoá Đơn");
        btnHoaDon.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHoaDonActionPerformed(evt);
            }
        });

        btgDaodien.add(btnPhanHoi2);
        btnPhanHoi2.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        btnPhanHoi2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/chat.png"))); // NOI18N
        btnPhanHoi2.setText("Phản Hồi");
        btnPhanHoi2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnPhanHoi2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPhanHoi2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/user.png"))); // NOI18N
        jLabel1.setText("Nhân Viên");

        btgDaodien.add(btnPhanHoi3);
        btnPhanHoi3.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        btnPhanHoi3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/logout.png"))); // NOI18N
        btnPhanHoi3.setText("Đăng Xuất");
        btnPhanHoi3.setToolTipText("");
        btnPhanHoi3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnPhanHoi3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPhanHoi3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelMenuLayout = new javax.swing.GroupLayout(PanelMenu);
        PanelMenu.setLayout(PanelMenuLayout);
        PanelMenuLayout.setHorizontalGroup(
            PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnSanPham, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnBanHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnHoaDon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnPhanHoi2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(PanelMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(btnPhanHoi3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PanelMenuLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jToggleButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        PanelMenuLayout.setVerticalGroup(
            PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMenuLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addComponent(btnKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBanHang, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPhanHoi2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPhanHoi3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PanelMenuLayout.createSequentialGroup()
                    .addGap(54, 54, 54)
                    .addComponent(jToggleButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(488, Short.MAX_VALUE)))
        );

        PanelMenuLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnBanHang, btnHoaDon, btnKhachHang, btnPhanHoi2, btnSanPham});

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setOpaque(false);
        jPanel2.setPreferredSize(new java.awt.Dimension(1050, 700));
        jPanel2.setLayout(new java.awt.CardLayout());
        jPanel2.add(datMonJPanel1, "card2");

        javax.swing.GroupLayout PanelMainLayout = new javax.swing.GroupLayout(PanelMain);
        PanelMain.setLayout(PanelMainLayout);
        PanelMainLayout.setHorizontalGroup(
            PanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1050, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        PanelMainLayout.setVerticalGroup(
            PanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelMainLayout.createSequentialGroup()
                .addGroup(PanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 702, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TimePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PanelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(TimePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSanPhamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSanPhamActionPerformed

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void btnKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhachHangActionPerformed
        CardLayout.show(jPanel2, "cardKhachHang");
    }//GEN-LAST:event_btnKhachHangActionPerformed

    private void btnBanHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBanHangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBanHangActionPerformed

    private void btnHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHoaDonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHoaDonActionPerformed

    private void btnPhanHoi2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPhanHoi2ActionPerformed
        JOptionPane.showMessageDialog(this, "Đang trong quá trình thử nghiệm!!");
    }//GEN-LAST:event_btnPhanHoi2ActionPerformed

    private void btnPhanHoi3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPhanHoi3ActionPerformed
        // TODO add your handling code here:
        handleSocket.write("close");
        this.dispose();
    }//GEN-LAST:event_btnPhanHoi3ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelMain;
    private javax.swing.JPanel PanelMenu;
    private javax.swing.JPanel TimePanel;
    private javax.swing.ButtonGroup btgDaodien;
    private javax.swing.JToggleButton btnBanHang;
    private javax.swing.JToggleButton btnHoaDon;
    private javax.swing.JToggleButton btnKhachHang;
    private javax.swing.JToggleButton btnPhanHoi2;
    private javax.swing.JToggleButton btnPhanHoi3;
    private javax.swing.JToggleButton btnSanPham;
    private javax.swing.ButtonGroup buttonGroup1;
    private GUI.DatMonJPanel datMonJPanel1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JToggleButton jToggleButton2;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        this.setVisible(true);
    }
}
