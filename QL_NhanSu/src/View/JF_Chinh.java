package View;

import controller.getDataNhanVien;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.BangLuong;
import model.NhanVien;

public class JF_Chinh extends javax.swing.JFrame {

    private String[] job = {"Dev", "Designer", "Engineer", "Manager", "Accountant", "Marketing", "HR", "Analyst"};
    private int position = -1;
    private int flag = -1;

//    private List<NhanVien> listnv;
//    private List<BangLuong> listsl;
    public JF_Chinh() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtHoten = new javax.swing.JTextField();
        txtBirth = new javax.swing.JTextField();
        txtBank = new javax.swing.JTextField();
        txtStk = new javax.swing.JTextField();
        btnInsert = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        btn_clear = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtJob = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                { new Double(1.089789),  new Long(89), "hhhh", null, "Dev", null, null},
                { new Double(2.0), null, "Giang", null, "dev", null, null},
                { new Double(8.0), null, "ubj", null, "jb", null, null},
                { new Double(7.0), null, "jhkk", null, "98", null, null},
                { new Double(98.0), null, "98", null, "0", null, null},
                { new Double(97.0), null, "97", null, "80", null, null},
                { new Double(87.0), null, "987", null, "987", null, null},
                { new Double(987.0), null, "987", null, "89", null, null},
                { new Double(7.0), null, "89789", null, "89", null, null},
                { new Double(97.0),  new Long(97), "97", null, "8978", null, null},
                { new Double(787.0),  new Long(87), "87", null, "8787", null, null},
                { new Double(0.0),  new Long(97), "879", null, "09", null, null},
                { new Double(908.0),  new Long(98), "8989898", null, "9", null, null}
            },
            new String [] {
                "STT", "ID", "Họ Tên", "Năm sinh", "Bộ phận", "Ngân Hàng", "STK"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Double.class, java.lang.Long.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Long.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable);

        jLabel1.setText("Họ Tên");

        jLabel2.setText("Năm sinh");

        jLabel3.setText("Ngân hàng");

        jLabel4.setText("STK");

        txtBirth.setToolTipText("");

        btnInsert.setText("Thêm");
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });

        btnUpdate.setText("Sửa");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setText("Xoá");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnSearch.setText("Tìm kiếm");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btn_clear.setText("Clear");
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });

        jLabel5.setText("Bộ Phận");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 715, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtStk)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtHoten, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtBirth, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                                    .addComponent(txtJob, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtBank, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_clear)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtHoten, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtBank, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtBirth, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtStk, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnInsert)
                            .addComponent(btnUpdate)
                            .addComponent(jLabel5)
                            .addComponent(txtJob, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDelete)
                            .addComponent(btnSearch))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btn_clear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void reset() {
        txtHoten.setText("");
        txtBirth.setText("");
        txtBank.setText("");
        txtStk.setText("");
        txtJob.setText("");
        position = -1;
    }

    //hàm chèn value từ file txt cho jtable
    public void insertTable(List<NhanVien> listnv) {
        try {

            DefaultTableModel model = (DefaultTableModel) jTable.getModel();

            model.setRowCount(0);

            for (NhanVien nv : listnv) {
                Object[] row = {
                    nv.getSTT(),
                    nv.getID(),
                    nv.getHoTen(),
                    nv.getNamSinh(),
                    nv.getBoPhan(),
                    nv.getBank(),
                    nv.getStk()
                };
                model.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Không thể get data!!!");
        }
    }

    //hàm thay đổi value trong jtable
    public void changeTable() {
        try {
            getDataNhanVien nv = new getDataNhanVien();

            String hoTen = txtHoten.getText().trim();
            int namSinh = Integer.parseInt(txtBirth.getText());
            String boPhan = txtJob.getText().trim();
            String bank = txtBank.getText();
            Long stk = Long.valueOf(txtStk.getText());

            nv.change(position, hoTen, namSinh, boPhan, bank, stk);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Không thể change data!!!");
        }
        List<NhanVien> list = getDataNhanVien.getData();
        insertTable(list);
        reset();
    }

    //hàm thêm sự kiện click chuột cho row của jtable
    public void addEventTableRow() {
        jTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = jTable.getSelectedRow(); // Lấy chỉ số của hàng được chọn
                position = row;
                if (row >= 0) {
                    // Lấy giá trị từ các cột tương ứng của hàng được chọn và gán vào các TextField
                    txtHoten.setText(jTable.getValueAt(row, 2).toString());
                    txtBirth.setText(jTable.getValueAt(row, 3).toString());
                    txtJob.setText(jTable.getValueAt(row, 4).toString());
                    txtBank.setText(jTable.getValueAt(row, 5).toString());
                    txtStk.setText(jTable.getValueAt(row, 6).toString());
                }
            }
        });
    }

    //hàm thêm nhân viên
    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        getDataNhanVien db = new getDataNhanVien();
        String hoTen = txtHoten.getText().trim();
        int namSinh = -1;
        if (!txtBirth.getText().isEmpty()) {
            namSinh = Integer.parseInt(txtBirth.getText());
        }

        int flagjob = -1;
        String boPhan = txtJob.getText().trim();
        for (String x : job) {
            if (x.equalsIgnoreCase(boPhan)) {
                flagjob = 1;
                break;
            }
        }

        String bank = txtBank.getText();

        Long stk = -1L;

        if (!txtStk.getText().isEmpty()) {
            stk = Long.valueOf(txtStk.getText());
        }

        if (flagjob == -1) {
            JOptionPane.showMessageDialog(null, "Công ti không có bộ phận bạn nhập", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
        } else {
            if (!hoTen.equals("") && namSinh != -1 && !boPhan.equals("") && !bank.equals("") && -1 != stk) {
                int response = JOptionPane.showConfirmDialog(null,
                        "Bạn có chắc chắn muốn thêm?",
                        "Xác nhận",
                        JOptionPane.YES_NO_OPTION);

                if (response == JOptionPane.YES_OPTION) {

                    db.insert(hoTen, namSinh, boPhan, bank, stk);

                    List<NhanVien> list = getDataNhanVien.getData();
                    insertTable(list);
                    reset();
                }

            } else {
                JOptionPane.showMessageDialog(null, "Hãy nhập đủ thông tin đối tượng cần thêm", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            }
        }

    }//GEN-LAST:event_btnInsertActionPerformed

    //hàm tìm kiếm nhân viên
    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        List<NhanVien> nv = getDataNhanVien.getData();

        String hoTen = txtHoten.getText().trim();
        int namSinh = -1;
        if (!txtBirth.getText().isEmpty()) {
            namSinh = Integer.parseInt(txtBirth.getText());
        }

        String boPhan = txtJob.getText().trim();
        String bank = txtBank.getText();

        Long stk = -1L;

        if (!txtStk.getText().isEmpty()) {
            stk = Long.valueOf(txtStk.getText());
        }

        List<NhanVien> nv1 = getDataNhanVien.search(hoTen, namSinh, boPhan, bank, stk);
        System.out.println(nv1.size());
        if (!nv1.isEmpty()) {
            insertTable(nv1);
            flag = 1;
            position = 1;
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập / kiểm tra lại đối tượng bạn muốn search!!!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    //hàm clear
    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
        reset();
        if (flag == 1) {
            List<NhanVien> list = getDataNhanVien.getData();
            insertTable(list);
            flag = -1;
        }
    }//GEN-LAST:event_btn_clearActionPerformed

    //hàm update thông tin
    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed

        boolean check = true;
        if (!txtHoten.getText().isEmpty() && !txtBank.getText().isEmpty() && !txtBirth.getText().isEmpty() && !txtStk.getText().isEmpty() && !txtJob.getText().isEmpty()) {
            try {
                for (char c : txtHoten.getText().toString().toCharArray()) {
                    if (Character.isDigit(c)) {
                        check = false;
                    }
                }

                for (char c : txtJob.getText().toString().toCharArray()) {
                    if (Character.isDigit(c)) {
                        check = false;
                    }
                }
            } catch (Exception e) {
                check = false;
            }
            try {
                Integer.parseInt(txtBirth.getText());
            } catch (Exception e) {
                check = false;
            }
            try {
                Long.parseLong(txtStk.getText());
            } catch (Exception e) {
                check = false;
            }
        } else {
            check = false;
        }

        if (check) {
            int response = JOptionPane.showConfirmDialog(null,
                    "Bạn có chắc chắn muốn sửa?",
                    "Xác nhận",
                    JOptionPane.YES_NO_OPTION);

            if (response == JOptionPane.YES_OPTION) {
                int flagjob = -1;
                for (String x : job) {
                    if (x.equalsIgnoreCase(txtJob.getText())) {
                        flagjob = 1;
                        break;
                    }
                }

                if (flagjob == -1) {
                    JOptionPane.showMessageDialog(null, "Công ti không có bộ phận bạn nhập", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
                } else {
                    changeTable();
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng không bỏ trống và đúng format", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    //hàm xoá nhân viên
    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        if (position != -1) {
            int response = JOptionPane.showConfirmDialog(null,
                    "Bạn có chắc chắn muốn xoá?",
                    "Xác nhận",
                    JOptionPane.YES_NO_OPTION);

            if (response == JOptionPane.YES_OPTION) {
                getDataNhanVien db = new getDataNhanVien();
                db.remove(position);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Hãy chọn đối tượng cần xoá!!!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
        }
        List<NhanVien> list = getDataNhanVien.getData();
        insertTable(list);
        reset();
    }//GEN-LAST:event_btnDeleteActionPerformed

    public void mainrun() {
        JF_Chinh jfchinh = new JF_Chinh();
        jfchinh.setLocationRelativeTo(null);
        jfchinh.setDefaultCloseOperation(jfchinh.DISPOSE_ON_CLOSE);

        //lắng nghe sự kiện click nút close của windown
        jfchinh.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                jfchinh.dispose();
            }
        });

        List<NhanVien> list = getDataNhanVien.getData();
        jfchinh.insertTable(list);
        jfchinh.setVisible(true);
        jfchinh.addEventTableRow();

        jfchinh.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                jfchinh.dispose();
                JF_Menu jf = new JF_Menu();
                jf.mainrun();
            }
        });
    }

//    public static void main(String[] args) {
//        JF_Chinh jf = new JF_Chinh();
//        jf.mainrun();
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btn_clear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    private javax.swing.JTextField txtBank;
    private javax.swing.JTextField txtBirth;
    private javax.swing.JTextField txtHoten;
    private javax.swing.JTextField txtJob;
    private javax.swing.JTextField txtStk;
    // End of variables declaration//GEN-END:variables
}
