package BaiTapVeNha1.src.Encapsulation;

public class Main {
    public static void main(String[] agrs) {

        String owner = "LinhTran";
        double balance = 1000;
        BankAccount bankAccount = new BankAccount(owner,balance);
        bankAccount.napTien(500);
        bankAccount.rutTien(200);
        System.out.println("So tien con lai la: " + balance );
    }
}
