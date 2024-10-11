package model;

public class NhanVien {

    private int STT;
    private Long ID;
    private String hoTen;
    private int namSinh;
    private String boPhan;
    private String bank;
    private Long stk;

    public NhanVien(int STT, Long ID, String hoTen, int namSinh, String boPhan, String bank, Long stk) {
        this.STT = STT;
        this.ID = ID;
        this.hoTen = hoTen;
        this.namSinh = namSinh;
        this.boPhan = boPhan;
        this.bank = bank;
        this.stk = stk;
    }

    public int getSTT() {
        return STT;
    }

    public Long getID() {
        return ID;
    }

    public String getHoTen() {
        return hoTen;
    }

    public int getNamSinh() {
        return namSinh;
    }

    public String getBoPhan() {
        return boPhan;
    }

    public String getBank() {
        return bank;
    }

    public Long getStk() {
        return stk;
    }

    public void setSTT(int STT) {
        this.STT = STT;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public void setNamSinh(int namSinh) {
        this.namSinh = namSinh;
    }

    public void setBoPhan(String boPhan) {
        this.boPhan = boPhan;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public void setStk(Long stk) {
        this.stk = stk;
    }

    @Override
    public String toString() {
        return "\n"+this.getSTT() + ":" + this.getID() + ":" + this.getHoTen() + ":" + this.getNamSinh() + ":" + this.getBoPhan() + ":" + this.getBank() + ":" + this.getStk();
    }

    public void in() {
        System.out.print(this.getSTT());
        System.out.print(this.getID());
        System.out.print(this.getHoTen());
        System.out.print(this.getNamSinh());
        System.out.print(this.getBoPhan());
        System.out.print(this.getBank());
        System.out.println(this.getStk());

    }

}
