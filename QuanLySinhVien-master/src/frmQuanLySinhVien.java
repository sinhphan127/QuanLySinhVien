import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.Event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Vector;

import com.toedter.calendar.JDateChooser;

public class frmQuanLySinhVien {
    JFrame frmMain;
    JTextField txtID, txtHo,txtTen,txtDiaChi,txtSDT;
    JDateChooser txtNgaySinh;
    JRadioButton Nam,Nu;
    JLabel anh;
    JButton btnBrown,btnThem,btnSua,btnXoa,btnLuu,btnReload,btnTroVe;
    JTable table;
    String filename;
    Connection conn;
    PreparedStatement stmt;
    ResultSet rs;
    Vector Col;
    boolean isInsert, isUpdate;
    public frmQuanLySinhVien(){
        conn = DBConnection.Ketnoi();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();
        frmMain = new JFrame("Quản lý sinh viên");
        frmMain.setBounds((int) width/2-500,(int)height/2-400,1000,800);
        frmMain.setLayout(new BorderLayout());
        frmMain.setVisible(true);
        frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel1 = new JPanel();
        JLabel lblID = new JLabel("Mã SV:");
        txtID = new JTextField();
        JLabel lblHo = new JLabel("Họ:");
        txtHo = new JTextField();
        JLabel lblTen = new JLabel("Tên:");
        txtTen = new JTextField();
        JLabel lblSDT = new JLabel("Số ĐT:");
        txtSDT = new JTextField();
        JLabel lblGioiTinh = new JLabel("Giới tính: ");
        Nam = new JRadioButton();
        Nu = new JRadioButton();
        ButtonGroup GioiTinh = new ButtonGroup();
        GioiTinh.add(Nam);
        GioiTinh.add(Nu);
        JPanel PanelGioiTinh = new JPanel();
        JLabel lblNam = new JLabel("Nam");
        JLabel lblNu = new JLabel("Nữ");
        PanelGioiTinh.setLayout(new BoxLayout(PanelGioiTinh,BoxLayout.X_AXIS));
        PanelGioiTinh.add(lblNam);
        PanelGioiTinh.add(Nam);
        PanelGioiTinh.add(lblNu);
        PanelGioiTinh.add(Nu);
        JLabel lblNgaySinh = new JLabel("Ngày Sinh:");
        txtNgaySinh = new JDateChooser();
        JLabel lblDiaChi = new JLabel("Địa Chỉ:");
        txtDiaChi = new JTextField();

        Col = new Vector();
        Col.addElement("Mã SV");
        Col.addElement("Họ");
        Col.addElement("Tên");
        Col.addElement("SDT");
        Col.addElement("Giới tính");
        Col.addElement("Ngày Sinh");
        Col.addElement("Địa chỉ");
        Col.addElement("Hình");

        GroupLayout layout = new GroupLayout(panel1);
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(lblID)
                    .addComponent(lblHo)
                    .addComponent(lblSDT)
                    .addComponent(lblNgaySinh))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(txtID)
                    .addComponent(txtHo)
                    .addComponent(txtSDT)
                    .addComponent(txtNgaySinh))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(lblTen)
                    .addComponent(lblGioiTinh)
                    .addComponent(lblDiaChi))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(txtTen)
                    .addComponent(PanelGioiTinh)
                    .addComponent(txtDiaChi)));
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lblID)
                    .addComponent(txtID))
                .addGap(5)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHo)
                    .addComponent(txtHo)
                    .addComponent(lblTen)
                    .addComponent(txtTen))
                .addGap(5)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSDT)
                    .addComponent(txtSDT)
                    .addComponent(lblGioiTinh)
                    .addComponent(PanelGioiTinh))
                .addGap(5)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNgaySinh)
                    .addComponent(txtNgaySinh)
                    .addComponent(lblDiaChi)
                    .addComponent(txtDiaChi)));
        panel1.setLayout(layout);
        panel1.setPreferredSize(new Dimension(450,100));

        JPanel panel2 = new JPanel(new BorderLayout());
        anh = new JLabel();
        anh.setBorder(new TitledBorder(null,"Hình"));
        btnBrown = new JButton("Chọn Hình");
        panel2.add(anh,BorderLayout.CENTER);
        panel2.add(btnBrown,BorderLayout.SOUTH);
        panel2.setPreferredSize(new Dimension(200,200));
        JPanel totalPanel = new JPanel(new FlowLayout());
        totalPanel.add(panel1);
        totalPanel.add(panel2);

        frmMain.add(totalPanel,BorderLayout.NORTH);

        table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        frmMain.add(scrollPane,BorderLayout.CENTER);

        btnThem = new JButton("Thêm");
        btnThem.setPreferredSize(new Dimension(80,40));
        btnSua = new JButton("Sửa");
        btnSua.setPreferredSize(new Dimension(80,40));
        btnXoa = new JButton("Xóa");
        btnXoa.setPreferredSize(new Dimension(80,40));
        btnLuu = new JButton("Lưu");
        btnLuu.setPreferredSize(new Dimension(80,40));
        btnReload = new JButton("Reload");
        btnReload.setPreferredSize(new Dimension(90,40));
        btnTroVe = new JButton("Trở về");
        btnTroVe.setPreferredSize(new Dimension(80,40));

        JPanel SouthPanel = new JPanel(new FlowLayout());
        SouthPanel.add(btnThem);
        SouthPanel.add(btnSua);
        SouthPanel.add(btnXoa);
        SouthPanel.add(btnLuu);
        SouthPanel.add(btnReload);
        SouthPanel.add(btnTroVe);

        frmMain.add(SouthPanel,BorderLayout.SOUTH);

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = table.getSelectedRow();
                txtID.setText(table.getValueAt(row,0).toString());
                txtHo.setText(table.getValueAt(row,1).toString());
                txtTen.setText(table.getValueAt(row,2).toString());
                txtSDT.setText(table.getValueAt(row,3).toString());
                if(table.getValueAt(row,4).toString().equals("Nam"))
                    Nam.setSelected(true);
                else
                    Nu.setSelected(true);
                String dateOuput = table.getValueAt(row,5).toString();
                try {
                    java.util.Date date = new SimpleDateFormat("dd-MM-yyyy").parse(dateOuput);
                    txtNgaySinh.setDate(date);
                } catch (ParseException e1) {
                    e1.printStackTrace();
                }
                txtDiaChi.setText(table.getValueAt(row,6).toString());
                String sql = "Select anh from SinhVien where id=?";
                try{
                    stmt = conn.prepareStatement(sql);
                    stmt.setInt(1,Integer.parseInt(txtID.getText()));
                    rs=stmt.executeQuery();
                    rs.next();
                    byte[] bytes = rs.getBytes("anh");
                    ImageIcon icon = new ImageIcon(new ImageIcon(bytes).getImage().getScaledInstance(anh.getWidth(),anh.getHeight()-15,Image.SCALE_DEFAULT));
                    anh.setIcon(icon);
                }catch (Exception ex){

                }
            }
        });
        btnBrown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter("Images","jpg","png");
                fileChooser.setFileFilter(filter);
                int i=fileChooser.showOpenDialog(frmMain);
                if(i==JFileChooser.APPROVE_OPTION){
                    File file = fileChooser.getSelectedFile();
                    filename = file.getAbsolutePath();//lưu đường dẫn file, dùng để truy vấn đưa ảnh vào database sau này
                    try{
                            BufferedImage bi = ImageIO.read(file);
                            ImageIcon icon = new ImageIcon(new ImageIcon(bi).getImage().getScaledInstance(anh.getWidth(),anh.getHeight()-15,Image.SCALE_DEFAULT));
                            anh.setIcon(icon);
                    }catch (IOException e1){

                    }catch (Exception ex){

                    }
                }
            }
        });
        btnThem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtID.enable();
                txtHo.enable();
                txtTen.enable();
                txtNgaySinh.setEnabled(true);
                txtDiaChi.enable();
                txtSDT.enable();
                btnBrown.setEnabled(true);
                btnThem.setEnabled(false);
                btnSua.setEnabled(true);
                isInsert=true;
                isUpdate=false;
            }
        });
        btnSua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!txtID.getText().equals("")){
                    txtID.disable();
                    txtHo.enable();
                    txtTen.enable();
                    txtNgaySinh.setEnabled(true);
                    txtDiaChi.enable();
                    txtSDT.enable();
                    btnBrown.setEnabled(true);
                    btnThem.setEnabled(true);
                    btnSua.setEnabled(false);
                    isInsert=false;
                    isUpdate=true;
                }
            }
        });
        btnLuu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(isInsert){
                    String sql = "Insert into SinhVien (ID,Ho,Ten,SDT,GioiTinh,NgaySinh,DiaChi,Anh) Values(?,?,?,?,?,?,?,?)";
                    try{
                        stmt = conn.prepareStatement(sql);
                        stmt.setInt(1,Integer.parseInt(txtID.getText()));
                        stmt.setString(2,txtHo.getText());
                        stmt.setString(3,txtTen.getText());
                        stmt.setInt(4,Integer.parseInt(txtSDT.getText()));
                        if(Nam.isSelected())
                            stmt.setString(5,"Nam");
                        else
                            stmt.setString(5,"Nữ");
                        java.util.Date date = txtNgaySinh.getDate();
                        String DateInput = new SimpleDateFormat("yyyy-dd-MM").format(date);
                        stmt.setString(6,DateInput);
                        stmt.setString(7,txtDiaChi.getText());
                        File imgFile = new File(filename);
                        FileInputStream fis = new FileInputStream(imgFile);
                        stmt.setBinaryStream(8,fis,imgFile.length());
                        stmt.executeUpdate();
                        JOptionPane.showMessageDialog(frmMain,"Thêm hồ sơ thành công","Thông báo",JOptionPane.INFORMATION_MESSAGE);
                        LoadData();
                    }catch (Exception ex){
                            System.out.println(ex.getMessage());
                    }
                }
                if(isUpdate){
                    String sql = "Update SinhVien set ho=?, ten=?, SDT=?, GioiTinh=?,NgaySinh=?, DiaChi=? where ID=?";
                    try{
                        stmt=conn.prepareStatement(sql);
                        stmt.setString(1,txtHo.getText());
                        stmt.setString(2,txtTen.getText());
                        stmt.setInt(3,Integer.parseInt(txtSDT.getText()));
                        if(Nam.isSelected())
                            stmt.setString(4,"Nam");
                        else
                            stmt.setString(4,"Nữ");
                        java.util.Date date = txtNgaySinh.getDate();
                        String DateInput = new SimpleDateFormat("yyyy-dd-MM").format(date);
                        stmt.setString(5,DateInput);
                        stmt.setString(6,txtDiaChi.getText());
                        stmt.setInt(7,Integer.parseInt(txtID.getText()));
                        stmt.executeUpdate();
                        if(filename!=null){
                            String sql1 = "Update SinhVien set anh=? where id=?";
                            stmt=conn.prepareStatement(sql1);
                            File imgFile = new File(filename);
                            FileInputStream fis = new FileInputStream(imgFile);
                            stmt.setBinaryStream(1,fis,imgFile.length());
                            stmt.setInt(2,Integer.parseInt(txtID.getText()));
                            stmt.executeUpdate();
                        }
                        JOptionPane.showMessageDialog(frmMain,"Sửa thành công","Thông báo",JOptionPane.INFORMATION_MESSAGE);
                        LoadData();
                    }catch (Exception ex){
                        System.out.println(ex.getMessage());
                    }
                }
            }
        });
        btnXoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();
                int ID = Integer.parseInt(table.getValueAt(row,0).toString());
                int i=JOptionPane.showConfirmDialog(frmMain,"Bạn có xóa không","Xóa hồ sơ",JOptionPane.YES_NO_OPTION);
                if(i==JOptionPane.YES_OPTION){
                    String sql = "Delete from SinhVien where ID=?";
                    try{
                        stmt=conn.prepareStatement(sql);
                        stmt.setInt(1,ID);
                        stmt.executeUpdate();
                        JOptionPane.showMessageDialog(frmMain,"Thông tin đã xóa","Thông báo",JOptionPane.INFORMATION_MESSAGE);
                        LoadData();
                    }catch (Exception ex){
                        System.out.println(ex.getMessage());
                    }


                }
            }
        });
        btnReload.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoadData();
            }
        });
        btnTroVe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frmMain.dispose();
                frmDangNhap form = new frmDangNhap();
            }
        });
        LoadData();
    }
    void LoadData(){
        txtID.setText("");
        txtHo.setText("");
        txtTen.setText("");
        txtDiaChi.setText("");
        txtSDT.setText("");
        txtNgaySinh.setDate(null);
        Nam.setSelected(true);
        txtID.disable();
        txtDiaChi.disable();
        txtNgaySinh.setEnabled(false);
        txtHo.disable();
        txtTen.disable();
        txtSDT.disable();
        btnBrown.setEnabled(false);
        btnThem.setEnabled(true);
        btnSua.setEnabled(true);
        isInsert=false;
        isUpdate=false;
        filename=null;
        anh.setIcon(null);
        String sql = "Select * from SinhVien";
        try{
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            Vector Data = new Vector();
            while(rs.next()){
                Vector sinhvien = new Vector();
                sinhvien.addElement(rs.getInt("ID"));
                sinhvien.addElement(rs.getString("Ho"));
                sinhvien.addElement(rs.getString("Ten"));
                sinhvien.addElement(rs.getInt("SDT"));
                sinhvien.addElement(rs.getString("GioiTinh"));
                sinhvien.addElement(rs.getString("NgaySinh"));
                sinhvien.addElement(rs.getString("DiaChi"));
                sinhvien.addElement(rs.getString("Anh"));
                Data.addElement(sinhvien);
            }
            table.setModel(new DefaultTableModel(Data,Col));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

}
