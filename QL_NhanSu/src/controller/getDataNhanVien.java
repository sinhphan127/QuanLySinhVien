package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import model.NhanVien;

public class getDataNhanVien {

    private String[] job = {"Dev", "Designer", "Enginer", "Manager", "Accountant", "Marketing", "HR", "Analyst"};

    //lấy dữ liệu từ txt
    public static List<NhanVien> getData() {
        List<NhanVien> list = new ArrayList<>();

        try {
            FileReader fr = new FileReader("database\\employee.txt");
            BufferedReader br = new BufferedReader(fr);
            String lineRead = "";
            while ((lineRead = br.readLine()) != null) {
                String[] str = lineRead.split(":", 7);
                if (str.length == 7) {
                    int stt = Integer.parseInt(str[0].trim());
                    Long ID = Long.parseLong(str[1].trim());
                    String hoten = str[2].trim();
                    int namSinh = Integer.parseInt(str[3].trim());
                    String boPhan = str[4].trim();
                    String bank = str[5].trim();
                    Long stk = Long.parseLong(str[6].trim());

                    NhanVien nv = new NhanVien(stt, ID, hoten, namSinh, boPhan, bank, stk);
                    list.add(nv);
                }
            }

            br.close();
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Không thể đọc data!!!");
        }
        return list;
    }

    //ghi file
    public void writeData(List<NhanVien> list) {
        try {
            FileWriter fw = new FileWriter("database\\employee.txt", false);
            BufferedWriter bw = new BufferedWriter(fw);

            for (NhanVien nv : list) {
                nv.setSTT(list.indexOf(nv) + 1);
                bw.write(nv.toString());
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Không thể ghi data!!!");
        }

        getDataSalary sl = new getDataSalary();
        sl.writeData(list);
    }

    //chèn dữ liệu
    public void insert(String hoTen, int namSinh, String boPhan, String bank, Long stk) {
        List<NhanVien> list = getData();
        try {
            FileWriter fw = new FileWriter("database\\employee.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            int stt = list.size() + 1;
            Long ID = (Long) list.get(list.size() - 1).getID() + 1;
            NhanVien nv = new NhanVien(stt, ID, hoTen, namSinh, boPhan, bank, stk);
            list.add(nv);
            bw.write(nv.toString());
            bw.newLine();
            bw.close();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Không thể ghi data!!!");
        }

        getDataSalary sl = new getDataSalary();
        sl.writeData(list);
    }

    //thay đổi dữ liệu txt
    public void change(int position, String hoTen, int namSinh, String boPhan, String bank, Long stk) {
        List<NhanVien> list = getData();
        try {
            FileWriter fw = new FileWriter("database\\employee.txt");
            BufferedWriter bw = new BufferedWriter(fw);

            for (int i = 0; i < list.size(); i++) {
                if (i == position) {
                    list.get(i).setHoTen(hoTen);
                    list.get(i).setNamSinh(namSinh);
                    list.get(i).setBoPhan(boPhan);
                    list.get(i).setBank(bank);
                    list.get(i).setStk(stk);
                }
            }

            for (NhanVien nv : list) {
                bw.write(nv.toString());
                bw.newLine();
            }

            bw.close();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Không thể ghi data!!!");
        }

        getDataSalary sl = new getDataSalary();
        sl.writeData(list);
    }

    //xoá item và ghi lại file txt
    public void remove(int position) {
        List<NhanVien> list = getData();
        list.remove(position);
        writeData(list);

        getDataSalary sl = new getDataSalary();
        sl.writeData(list);
    }

    //tìm kiếm
    public static List<NhanVien> search(String hoTen, int namSinh, String boPhan, String bank, Long stk) {
        List<NhanVien> nv1 = getData();
        List<NhanVien> nv2 = new ArrayList<>();

        try {
            for (NhanVien nv : nv1) {
                if (nv.getHoTen().equalsIgnoreCase(hoTen) || nv.getNamSinh() == namSinh || nv.getBoPhan().equalsIgnoreCase(boPhan) || nv.getBank().equalsIgnoreCase(bank) || Objects.equals(nv.getStk(), stk)) {
                    nv2.add(nv);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Lỗi tìm kiếm");
        }

        return nv2;
    }
}
