import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.Event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class frmDangNhap {
    JFrame main;
    JTextField txtUser;
    JPasswordField txtPass;
    JButton btnDangNhap, btnThoat;
    Connection conn;
    PreparedStatement stmt;
    ResultSet rs;
    public frmDangNhap(){
        conn=DBConnection.Ketnoi();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();

        main = new JFrame("Đăng Nhập");
        main.setBounds((int) width/2-250,(int)height/2-200,500,400);
        main.setResizable(false);
        main.setLayout(null);
        main.setVisible(true);
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("Quản Lý Sinh Viên");
        label.setFont(new Font("Courier New",Font.BOLD,25));
        label.setBounds(130,20,400,50);
        main.add(label);

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(null,"Viết tên đăng nhập"));
        panel.setBounds(50,100,400,150);
        panel.setLayout(null);
        JLabel label1 = new JLabel("Tên người dùng:");
        label1.setBounds(10,40,150,20);
        JLabel label2 = new JLabel("Mật khẩu:");
        label2.setBounds(10,70,150,20);
        panel.add(label1);
        panel.add(label2);
        txtUser = new JTextField();
        txtUser.setBounds(170,40,200,20);
        txtPass = new JPasswordField();
        txtPass.setBounds(170,70,200,20);
        panel.add(txtUser);
        panel.add(txtPass);
        main.add(panel);

        btnDangNhap = new JButton("Đăng Nhập");
        btnDangNhap.setBounds(80,260,120,60);
        btnThoat = new JButton("Thoát");
        btnThoat.setBounds(280,260,120,60);
        main.add(btnDangNhap);
        main.add(btnThoat);

        txtPass.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_ENTER){
                    DangNhap();
                }
            }
        });
        btnDangNhap.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DangNhap();
            }
        });
        btnThoat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
    void DangNhap(){
        String sql = "Select count(*) From TaiKhoan where ten=? and matkhau=?";
        int count=0;
        try{
            stmt = conn.prepareStatement(sql);//đưu câu truy vấn sql vào trong stmt
            stmt.setString(1,txtUser.getText().trim());//thay thế dấu chấm hỏi đầu tiên bằng giá trị txtUser
            stmt.setString(2,txtPass.getText().trim());
            rs=stmt.executeQuery();//thực hiện câu truy vấn vào đưa kết quả vào trong rs
            rs.next();
            count=rs.getInt(1);
            if(count>0){
                JOptionPane.showMessageDialog(null,"Đăng nhập thành công","Thông báo",JOptionPane.INFORMATION_MESSAGE);
                main.dispose();
                frmQuanLySinhVien form = new frmQuanLySinhVien();
            }else{
                JOptionPane.showMessageDialog(null,"Không có tài khoản phù hợp","Thông báo",JOptionPane.INFORMATION_MESSAGE);
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Lỗi Đăng Nhập","Lỗi",JOptionPane.ERROR_MESSAGE);
        }
    }
    public static void main(String args[]){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                frmDangNhap form = new frmDangNhap();
            }
        });
    }
}
