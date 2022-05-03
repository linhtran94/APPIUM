package BaiTapVeNha1.src.Inheritance;

public class CongNhan extends CanBo{
    int bac;
    public CongNhan(String hoTen, int tuoi, String gioiTinh, String diaChi, int bac) {
        super(hoTen, tuoi, gioiTinh, diaChi);
        this.bac = bac;
    }

    @Override
    public String toString() {
        return "CongNhan{" +
                "hoTen='" + hoTen + '\'' +
                ", tuoi=" + tuoi +
                ", gioiTinh='" + gioiTinh + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", bac=" + bac +
                '}';
    }
}
