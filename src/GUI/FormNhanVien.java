/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import ActionButton.TableCellRender;
import Dao.NhanVienDao;
import Method.DeleteNhanvien;
import Model.NhanVien;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PhamNgocMinh
 */
public class FormNhanVien extends javax.swing.JPanel {

    /**
     * Creates new form FormNhanVien
     */
    public static DefaultTableModel model = new DefaultTableModel();
    ArrayList<NhanVien> ds = new NhanVienDao().GetArrayListAll();
    int i;
    boolean sapxepTangGiam = true;

    public FormNhanVien() {
        initComponents();
        model.setColumnIdentifiers(new Object[]{"Mã Nhân Viên", "Tên Nhân Viên", "Ngày sinh", "Giới Tính", "Địa Chỉ", "SĐT", "Email", "Chức Vụ", "Lương", "Ngày nhận việc", "Ngày nghỉ việc", "Hành Động"});
        model = (DefaultTableModel) tblNhanVien.getModel();
        txtTongNV.setText(new NhanVienDao().SumNV());
        LoadData();
        danhsach();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    public void LoadData() {
        model.setRowCount(0);
        ds = new NhanVienDao().GetArrayListAll();
        for (int i = 0; i < ds.size(); i++) {
            model.addRow(new Object[]{
                ds.get(i).getManv(),
                ds.get(i).getHoten(),
                ds.get(i).getNgaysinh(),
                ds.get(i).isGioitinh() ? "Nam" : "Nữ",
                ds.get(i).getDiachi(),
                ds.get(i).getSdt(),
                ds.get(i).getEmail(),
                ds.get(i).isChucvu() ? "Nhân viên" : "Quản lý",
                ds.get(i).getLuong(),
                ds.get(i).getNgaytao(),
                ds.get(i).getNgayketthuc(),});
            tblNhanVien.setModel(model);
        }
        tblNhanVien.getColumnModel().getColumn(11).setCellRenderer(new TableCellRender());
    }

    public void sapxep() {
//        lương
//ngày kết thúc
//ngày nhận viêc
//Ngày sinh

        if (sapxepTangGiam) {
            sapxepTangGiam = false;
        } else {
            sapxepTangGiam = true;
        }
        String sapxep = "";
        if (cbsapxep.getSelectedItem().toString().equalsIgnoreCase("Lương")) {
            sapxep = "luong";
        } else if (cbsapxep.getSelectedItem().toString().equalsIgnoreCase("ngày kết thúc")) {
            sapxep = "ngayketthuc";
        } else if (cbsapxep.getSelectedItem().toString().equalsIgnoreCase("ngày nhận viêc")) {
            sapxep = "NgayKetThuc";
        } else {
            sapxep = "ngaysinh";
        }
        model.setRowCount(0);
        ds = new NhanVienDao().GetArrayListoderByDESC(sapxep, sapxepTangGiam);
        for (int i = 0; i < ds.size(); i++) {
            model.addRow(new Object[]{
                ds.get(i).getManv(),
                ds.get(i).getHoten(),
                ds.get(i).getNgaysinh(),
                ds.get(i).isGioitinh() ? "Nam" : "Nữ",
                ds.get(i).getDiachi(),
                ds.get(i).getSdt(),
                ds.get(i).getEmail(),
                ds.get(i).isChucvu() ? "Nhân viên" : "Quản lý",
                ds.get(i).getLuong(),
                ds.get(i).getNgaytao(),
                ds.get(i).getNgayketthuc(),});
            tblNhanVien.setModel(model);
        }
        tblNhanVien.getColumnModel().getColumn(11).setCellRenderer(new TableCellRender());
    }

    public void DeleteNhanvien() {
        //action
        if (tblNhanVien.getSelectedColumn() == 11) {
            int row = tblNhanVien.getSelectedRow();
            if (row != -1) {
                if (tblNhanVien.isEditing()) {
                    tblNhanVien.getCellEditor().stopCellEditing();
                }
                String a = String.valueOf(model.getValueAt(row, 0));
                String nhanvien = String.valueOf(model.getValueAt(row, 1));
                int option = JOptionPane.showConfirmDialog(this, "Cho nhân viên ' " + nhanvien + " ' nghỉ việc", "Xác nhận", JOptionPane.YES_NO_OPTION);
                switch (option) {
                    case JOptionPane.YES_OPTION -> {
                        new DeleteNhanvien().DeleteNhanvien(a);
                        LoadData();
                        break;
                    }
                    case JOptionPane.NO_OPTION -> {
                        break;
                    }
                    default -> {
                        break;
                    }
                }
            }

        }
    }

    public void show(int i) {
        String manv = (String) tblNhanVien.getValueAt(i, 0);
        String Tennv = tblNhanVien.getValueAt(i, 1).toString();
        String Ngaysinh = tblNhanVien.getValueAt(i, 2).toString();
        String Gioitinh = tblNhanVien.getValueAt(i, 3).toString();
        String Diachi = tblNhanVien.getValueAt(i, 4).toString();
        String SDT = tblNhanVien.getValueAt(i, 5).toString();
        String Email = tblNhanVien.getValueAt(i, 6).toString();
        String Chucvu = tblNhanVien.getValueAt(i, 7).toString();
        String Luong = tblNhanVien.getValueAt(i, 8).toString();
        String NgayNhanviec = tblNhanVien.getValueAt(i, 9).toString();
        txtManv.setEditable(false);
        txtManv.setText(manv);
        txtTennv.setText(Tennv);
        txtNgaysinh.setText(Ngaysinh);
        if (Gioitinh.equalsIgnoreCase("Nam")) {
            rdoNam.setSelected(true);
        } else if (Gioitinh.equalsIgnoreCase("Nữ")) {
            rdoNu.setSelected(true);
        }
        txtDiachi.setText(Diachi);
        txtSDT.setText(SDT);
        txtEmail.setText(Email);
        txtLuong.setText(Luong);
        txtNgayNhanViec.setText(NgayNhanviec);
        int b = 0;
        if (Chucvu.equalsIgnoreCase("Quản Lý")) {
            b = 1;
        } else if (Chucvu.equalsIgnoreCase("Nhân viên")) {
            b = 0;
        }
        rdoChucvu.setSelectedIndex(b);
    }

    public void danhsach() {
        model.setRowCount(0);
        String selectedOption = ComboboxArrayList.getSelectedItem().toString();
        if (selectedOption.equalsIgnoreCase("Tất cả")) {
            ds = new NhanVienDao().GetArrayListAll();
        } else if (selectedOption.equalsIgnoreCase("Còn làm việc")) {
            ds = new NhanVienDao().GetArrayListByID("Còn làm việc");
        } else if (selectedOption.equalsIgnoreCase("Đã nghỉ việc")) {
            ds = new NhanVienDao().GetArrayListByID("Đã nghỉ việc");
        }
        for (int i = 0; i < ds.size(); i++) {
            model.addRow(new Object[]{
                ds.get(i).getManv(),
                ds.get(i).getHoten(),
                ds.get(i).getNgaysinh(),
                ds.get(i).isGioitinh() ? "Nam" : "Nữ",
                ds.get(i).getDiachi(),
                ds.get(i).getSdt(),
                ds.get(i).getEmail(),
                ds.get(i).isChucvu() ? "Nhân viên" : "Quản lý",
                ds.get(i).getLuong(),
                ds.get(i).getNgaytao(),
                ds.get(i).getNgayketthuc(),});
        }
        tblNhanVien.setModel(model);
        tblNhanVien.getColumnModel().getColumn(11).setCellRenderer(new TableCellRender());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNhanVien = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtManv = new javax.swing.JTextField();
        txtTennv = new javax.swing.JTextField();
        txtNgaysinh = new javax.swing.JTextField();
        txtDiachi = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtLuong = new javax.swing.JTextField();
        txtNgayNhanViec = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        btnsapxep = new javax.swing.JButton();
        btnThemNV = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        rdoChucvu = new javax.swing.JComboBox<>();
        rdoNu = new javax.swing.JRadioButton();
        rdoNam = new javax.swing.JRadioButton();
        jLabel12 = new javax.swing.JLabel();
        ComboboxArrayList = new javax.swing.JComboBox<>();
        txtTongNV = new javax.swing.JLabel();
        cbsapxep = new javax.swing.JComboBox<>();

        jButton2.setText("Thêm NV ");

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        tblNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã NV", "Tên NV", "Ngày Sinh", "Giới Tính", "Địa Chỉ", "SĐT", "Email", "Chức Vụ", "Lương", "Ngày Nhận Việc", "Ngày Nghỉ Việc", "Hành Động"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblNhanVien.setRowHeight(35);
        tblNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNhanVienMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblNhanVienMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblNhanVien);
        if (tblNhanVien.getColumnModel().getColumnCount() > 0) {
            tblNhanVien.getColumnModel().getColumn(0).setResizable(false);
            tblNhanVien.getColumnModel().getColumn(1).setResizable(false);
            tblNhanVien.getColumnModel().getColumn(2).setResizable(false);
            tblNhanVien.getColumnModel().getColumn(3).setResizable(false);
            tblNhanVien.getColumnModel().getColumn(4).setResizable(false);
            tblNhanVien.getColumnModel().getColumn(5).setResizable(false);
            tblNhanVien.getColumnModel().getColumn(6).setResizable(false);
            tblNhanVien.getColumnModel().getColumn(7).setResizable(false);
            tblNhanVien.getColumnModel().getColumn(8).setResizable(false);
            tblNhanVien.getColumnModel().getColumn(9).setResizable(false);
            tblNhanVien.getColumnModel().getColumn(10).setResizable(false);
            tblNhanVien.getColumnModel().getColumn(11).setResizable(false);
        }

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 36)); // NOI18N
        jLabel1.setText("Quản Lý Nhân Viên");

        txtManv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtManvActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Mã NV");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Tên NV");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Giới tính");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Ngày sinh");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Địa Chỉ");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Email");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("Lương");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("Chức Vụ");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setText("Ngày nhận việc");

        txtSDT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSDTActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setText("SĐT");

        btnsapxep.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnsapxep.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/arrange.png"))); // NOI18N
        btnsapxep.setText("Sắp xếp");
        btnsapxep.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnsapxep.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnsapxep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsapxepActionPerformed(evt);
            }
        });

        btnThemNV.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnThemNV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/diskette.png"))); // NOI18N
        btnThemNV.setText("Thêm NV ");
        btnThemNV.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnThemNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemNVActionPerformed(evt);
            }
        });

        btnSua.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/updated.png"))); // NOI18N
        btnSua.setText("Sửa");
        btnSua.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnSua.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        rdoChucvu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rdoChucvu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nhân Viên", "Quản Lý", " ", " " }));

        buttonGroup1.add(rdoNu);
        rdoNu.setText("Nữ");

        buttonGroup1.add(rdoNam);
        rdoNam.setText("Nam");

        jLabel12.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel12.setText("Tổng Nhân Viên");

        ComboboxArrayList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất Cả", "Còn Làm Việc", "Đã Nghỉ Việc", " " }));
        ComboboxArrayList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboboxArrayListActionPerformed(evt);
            }
        });

        txtTongNV.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        cbsapxep.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "lương", "ngày kết thúc", "ngày nhận viêc", "Ngày sinh", " " }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(133, 133, 133)
                .addComponent(jLabel12)
                .addGap(26, 26, 26)
                .addComponent(txtTongNV, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtManv, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTennv, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNgaysinh, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDiachi, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rdoNam)
                                .addGap(33, 33, 33)
                                .addComponent(rdoNu)))
                        .addGap(104, 104, 104)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNgayNhanViec, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rdoChucvu, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnThemNV, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ComboboxArrayList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnsapxep, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbsapxep, 0, 103, Short.MAX_VALUE))))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {ComboboxArrayList, btnsapxep});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txtTongNV, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtManv, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTennv, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNgaysinh, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rdoNu)
                            .addComponent(rdoNam))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDiachi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rdoChucvu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNgayNhanViec, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnThemNV, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbsapxep)
                            .addComponent(btnsapxep, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ComboboxArrayList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {ComboboxArrayList, btnsapxep});

    }// </editor-fold>//GEN-END:initComponents

    private void txtManvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtManvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtManvActionPerformed

    private void txtSDTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSDTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSDTActionPerformed

    private void btnsapxepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsapxepActionPerformed
        sapxep();
    }//GEN-LAST:event_btnsapxepActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
      
        int a = tblNhanVien.getSelectedRow();
        if (a != -1) {
            FormSuaNhanVien snv = new FormSuaNhanVien();
            snv.NV = this;
            String manv = (String) tblNhanVien.getValueAt(a, 0);
            String Tennv = tblNhanVien.getValueAt(a, 1).toString();
            Date ngaysinh = (Date) tblNhanVien.getValueAt(a, 2);
            String gioitinh = tblNhanVien.getValueAt(a, 3).toString();
            String Diachi = tblNhanVien.getValueAt(i, 4).toString();
            String SDT = tblNhanVien.getValueAt(i, 5).toString();
            String Email = tblNhanVien.getValueAt(i, 6).toString();
            String Chucvu = tblNhanVien.getValueAt(i, 7).toString();
            String Luong = tblNhanVien.getValueAt(i, 8).toString();
            snv.Show(manv, Tennv, ngaysinh, gioitinh, SDT, Diachi, Chucvu, Luong, Email);
            snv.setAlwaysOnTop(true);
            snv.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "vui lòng chọn 1 nhân viên để sửa");
        }

    }//GEN-LAST:event_btnSuaActionPerformed

    private void tblNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhanVienMouseClicked
        i = tblNhanVien.getSelectedRow();
        show(i);
    }//GEN-LAST:event_tblNhanVienMouseClicked

    private void tblNhanVienMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhanVienMousePressed
        DeleteNhanvien();
    }//GEN-LAST:event_tblNhanVienMousePressed

    private void btnThemNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemNVActionPerformed

        Formthemnhanvien fnv = new Formthemnhanvien();
        fnv.NV = this;
        fnv.setAlwaysOnTop(true);
        fnv.setVisible(true);
    }//GEN-LAST:event_btnThemNVActionPerformed

    private void ComboboxArrayListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboboxArrayListActionPerformed
        danhsach();
    }//GEN-LAST:event_ComboboxArrayListActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboboxArrayList;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThemNV;
    private javax.swing.JButton btnsapxep;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbsapxep;
    private javax.swing.JButton jButton2;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> rdoChucvu;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JTable tblNhanVien;
    private javax.swing.JTextField txtDiachi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtLuong;
    private javax.swing.JTextField txtManv;
    private javax.swing.JTextField txtNgayNhanViec;
    private javax.swing.JTextField txtNgaysinh;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTennv;
    private javax.swing.JLabel txtTongNV;
    // End of variables declaration//GEN-END:variables
}