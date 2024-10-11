package model;

public class BangLuong {

    private String hoten;
    private double luong;

    public BangLuong(String hoten, double luong) {
        this.hoten = hoten;
        this.luong = luong;
    }

    public String getHoten() {
        return hoten;
    }

    public double getLuong() {
        return luong;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public void setLuong(double luong) {
        this.luong = luong;
    }

    public void in() {
        System.out.println(this.getHoten());
        System.out.println(this.getLuong());
    }

    @Override
    public String toString() {
        return "\n"+this.getHoten() + ":" + this.getLuong()+"\n";
    }
}
