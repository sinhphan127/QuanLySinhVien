package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import model.BangLuong;
import model.NhanVien;

public class getDataSalary {

    private String[] job = {"Dev", "Designer", "Enginer", "Manager", "Accountant", "Marketing", "HR", "Analyst"};

    //đọc dữ liệu txt
    public List<BangLuong> getDataSalary() {
        List<BangLuong> list = new ArrayList<>();
        try {
            FileReader fr = new FileReader("database\\salary.txt");
            BufferedReader br = new BufferedReader(fr);
            String lineRead = "";
            while ((lineRead = br.readLine()) != null) {
                String[] str = lineRead.split(":", 2);
                if (str.length == 2) {
                    String hoten = str[0];
                    double luong = Double.parseDouble(str[1]);
                    BangLuong sl = new BangLuong(hoten, luong);
                    list.add(sl);
                    sl.in();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Không thể đọc data!!!");
        }
        return list;
    }

    //ghi file
    public void writeData(List<NhanVien> list) {
        list = getDataNhanVien.getData();
        double luong = 0.0;
        try {
            FileWriter fw = new FileWriter("database\\salary.txt");
            BufferedWriter bw = new BufferedWriter(fw);

            for (NhanVien nv : list) {
                if (nv.getBoPhan().equalsIgnoreCase(job[0])) {
                    luong = 1200;
                }
                if (nv.getBoPhan().equalsIgnoreCase(job[1])) {
                    luong = 1000;
                }
                if (nv.getBoPhan().equalsIgnoreCase(job[2])) {
                    luong = 2000;
                }
                if (nv.getBoPhan().equalsIgnoreCase(job[3])) {
                    luong = 2250;
                }
                if (nv.getBoPhan().equalsIgnoreCase(job[4])) {
                    luong = 750;
                }
                if (nv.getBoPhan().equalsIgnoreCase(job[5])) {
                    luong = 800;
                }
                if (nv.getBoPhan().equalsIgnoreCase(job[6])) {
                    luong = 1800;
                }
                if (nv.getBoPhan().equalsIgnoreCase(job[7])) {
                    luong = 1100;
                }

                BangLuong sl = new BangLuong(nv.getHoTen(), luong);
                bw.write(sl.toString());
            }

            bw.newLine();
            bw.close();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Không thể ghi data!!!");
        }
    }

    //sortup
    public static List<BangLuong> sortUp() {
        getDataSalary db = new getDataSalary();
        List<BangLuong> list = db.getDataSalary();
        list.sort(Comparator.comparing(BangLuong::getLuong));

        return list;
    }

    //sortdown
    public static List<BangLuong> sortDown() {
        getDataSalary db = new getDataSalary();
        List<BangLuong> list = db.getDataSalary();
        list.sort(Comparator.comparing(BangLuong::getLuong).reversed());

        return list;
    }
}
