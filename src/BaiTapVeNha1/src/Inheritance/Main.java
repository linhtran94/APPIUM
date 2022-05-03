package BaiTapVeNha1.src.Inheritance;

public class Main {

    public static void main(String[] agrs) {
        CanBo canBo1 = new CanBo("Tien", 25, "Nam", "SG");
        CanBo canBo2 = new CanBo("Khai", 25, "Nam", "SG", 4);
        CanBo canBo3 = new CanBo("Bao", 29, "Nam", "SG", "CNTT");


        QLCB qlcbSystem = new QLCB();

        qlcbSystem.themCanBo(canBo1);
        qlcbSystem.themCanBo(canBo2);
        qlcbSystem.themCanBo(canBo3);

        qlcbSystem.hienThiCanBo();
    }
}
