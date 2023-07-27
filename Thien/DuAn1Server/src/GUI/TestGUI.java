/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import ServerController.Server;
import ServerController.ServerThread;
import Dao.MonAnDAO;
import Model.NhanVien;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

/**
 *
 * @author lethi
 */
public class TestGUI extends javax.swing.JFrame implements Runnable {
    public static ArrayList<String> listOrder = new ArrayList<>();
    public static ArrayList<String> dsban = new ArrayList<>();
    NhanVien nv = new NhanVien();
    MonAnDAO monAnDAO = new MonAnDAO();

    /**
     * Creates new form TestGUI
     */
    public TestGUI() {
        initComponents();
        setResizable(false);
       jLabel1.setText("<html><u>Text with Underline</u></html>");

//        Server adminSever = new Server();
//        adminSever.GUIadmin = this;
//        adminSever.SetAdminServer();
    }

    public void createOrder(Object[] x, ArrayList<Object[]> ds) {
        
        String idorder = new SimpleDateFormat("đMMyy").format(new Date())+ listOrder.size();
        listOrder.add(idorder);
        int width = 200;
        int height = 513;
        JPanel order = new JPanel(new BorderLayout());
//        order.setPreferredSize(new Dimension(width, height));
//        order.setBorder(new EmptyBorder(10, 10, 10, 10));
        order.setBackground(Color.white);

        JPanel sobanJPanel =new JPanel(new FlowLayout(FlowLayout.CENTER));
        sobanJPanel.setPreferredSize(new Dimension(width,100));
        
        JLabel soban = new JLabel(x[0].toString());
        soban.setHorizontalAlignment(SwingConstants.CENTER);
        soban.setPreferredSize(new Dimension(width, 50));
        soban.setFont(new Font("Aria", Font.BOLD, 16));
        
        JLabel solan = new JLabel("Hoá đơn: "+x[1].toString());
        soban.setHorizontalAlignment(SwingConstants.CENTER);
        soban.setPreferredSize(new Dimension(width, 50));
        soban.setFont(new Font("Aria", Font.BOLD, 16));
        sobanJPanel.add(soban);
        sobanJPanel.add(solan);
        
        JPanel monan = new JPanel(new FlowLayout(FlowLayout.LEFT));
        monan.setOpaque(false);
        monan.setPreferredSize(new Dimension(width, height - 10));
        for (Object[] o : ds) {
            String mon = monAnDAO.getObjectByID(o[0].toString()).getTen();
            JLabel tenlabel = new JLabel(" *** Tên: " + mon);
            tenlabel.setPreferredSize(new Dimension(width, 16));

            JLabel soluonglabel = new JLabel(" *** Số lượng: " + o[1]);
            soluonglabel.setPreferredSize(new Dimension(width, 16));
            
            JLabel line = new JLabel("--------------------------------------");
            soluonglabel.setPreferredSize(new Dimension(width, 16));
            monan.add(tenlabel);
            monan.add(soluonglabel);
            monan.add(line);
            
        }
        JButton doneButton = new JButton();
        doneButton.setText("Hoàn thành đơn");
        doneButton.setPreferredSize(new Dimension(width,20));
        doneButton.addActionListener(doneAction);
        doneButton.setName(idorder); //Tạo id Order
        
        order.add(sobanJPanel, BorderLayout.NORTH);
        order.add(monan, BorderLayout.CENTER);
        order.add(doneButton,BorderLayout.SOUTH);
        JScrollPane scroll = new JScrollPane(order);
        scroll.setPreferredSize(new Dimension(width, height));
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scroll.getVerticalScrollBar().setUnitIncrement(20);
        
        Danhsachbanpanel.add(scroll);
        dsban.add(x[0].toString());
//        ServerThread.write("Order-Succesful");
//        ServerThread.write(dsban);
        
    }

    ActionListener doneAction = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button = new JButton();
            button = (JButton) e.getSource();
//            ServerThread.write("Order-Done");
//            ServerThread.write(button.getName());
           
        }
    };
    /**ds
     * 
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Danhsachbanpanel = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jToggleButton1 = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setPreferredSize(new java.awt.Dimension(1050, 700));

        Danhsachbanpanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        jScrollPane1.setViewportView(Danhsachbanpanel);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );

        jTabbedPane1.addTab("ORDER", jPanel2);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab2", jPanel3);

        jToggleButton1.setText("jToggleButton1");

        jLabel1.setText("thien");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jToggleButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Danhsachbanpanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        this.setVisible(true);
    }
}
