package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class connectDB {

    public boolean connect() {
        boolean flag = false;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://VINHGIANG\\SQLEXPRESS:1433;databaseName=Employee;encrypt=true;trustServerCertificate=true";
            String userName = "sa";
            String password = "123456789";

            Connection connection = DriverManager.getConnection(url, userName, password);
            String sql = "select * from employeeman";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                System.out.println(rs.getInt(1));
                System.out.println(rs.getString(2));
                System.out.println(rs.getString(3));
            }

            flag = true;
            System.out.println("Connect success");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
    
    public static void main(String[] args) {
        connectDB db = new connectDB();
        db.connect();
    }
}
