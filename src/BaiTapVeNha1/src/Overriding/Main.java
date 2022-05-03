package BaiTapVeNha1.src.Overriding;

public class Main {

    public static void main(String[] agrs) {
        Vietcombank vietcomBank = new Vietcombank();
        vietcomBank.laiSuat();

        Techcombank techcomBank = new Techcombank();
        techcomBank.laiSuat();
    }
}
