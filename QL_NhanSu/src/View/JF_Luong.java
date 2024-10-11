package View;

import controller.getDataSalary;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.BangLuong;
import model.NhanVien;

public class JF_Luong extends javax.swing.JFrame {

    public JF_Luong() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        btn_back = new javax.swing.JButton();
        btn_sortup = new javax.swing.JButton();
        btn_sortdown = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Họ tên", "Lương"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable);

        btn_back.setText("Back");
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });

        btn_sortup.setText("Sort tăng");
        btn_sortup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sortupActionPerformed(evt);
            }
        });

        btn_sortdown.setText("Sort giảm");
        btn_sortdown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sortdownActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(btn_sortup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(55, 55, 55)
                .addComponent(btn_sortdown, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(55, 55, 55)
                .addComponent(btn_back, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(100, 100, 100))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_sortdown)
                    .addComponent(btn_sortup)
                    .addComponent(btn_back))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //hàm lấy value cho jtable từ file txt
    public void insertTable(List<BangLuong> listnbl) {
        try {

            DefaultTableModel model = (DefaultTableModel) jTable.getModel();

            model.setRowCount(0);

            for (BangLuong bl : listnbl) {
                Object[] row = {
                    bl.getHoten(),
                    bl.getLuong()
                };
                model.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Không thể get data!!!");
        }
    }

    //bút back
    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        dispose();
        JF_Menu jf = new JF_Menu();
        jf.mainrun();
    }//GEN-LAST:event_btn_backActionPerformed

    //bút sortup
    private void btn_sortupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sortupActionPerformed
        getDataSalary db = new getDataSalary();
        List<BangLuong> list = list = db.sortUp();
        insertTable(list);
    }//GEN-LAST:event_btn_sortupActionPerformed

    //nút sortdown
    private void btn_sortdownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sortdownActionPerformed
        getDataSalary db = new getDataSalary();
        List<BangLuong> list = list = db.sortDown();
        insertTable(list);
    }//GEN-LAST:event_btn_sortdownActionPerformed

    public void mainrun() {
        JF_Luong jf = new JF_Luong();
        jf.setTitle("Salary");

        getDataSalary db = new getDataSalary();
        List<BangLuong> list = db.getDataSalary();
        jf.insertTable(list);

        jf.setDefaultCloseOperation(jf.DISPOSE_ON_CLOSE);
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);

        //set sự kiện khi click nút close của windown
        jf.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                jf.dispose();
                JF_Menu jfmn = new JF_Menu();
                jfmn.mainrun();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_back;
    private javax.swing.JButton btn_sortdown;
    private javax.swing.JButton btn_sortup;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    // End of variables declaration//GEN-END:variables
}
