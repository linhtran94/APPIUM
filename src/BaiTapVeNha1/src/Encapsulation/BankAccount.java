package BaiTapVeNha1.src.Encapsulation;

public class BankAccount {
    private String owner;
    private double balance;

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void napTien(double soTien) {
        balance = balance + soTien;
    }

    public void rutTien(double soTien) {
        balance = balance - soTien;
    }

    public BankAccount(String owner, double balance) {
        this.owner = owner;
        this.balance = balance;
        System.out.println("Ban da nap tien thanh cong");
    }

    public void ruttien_return_msg(BankAccount bankAccount, double balance) {
        if(balance <= bankAccount.getBalance()) {
            System.out.println("Ban da rut tien thanh cong");
            double current_balance = bankAccount.getBalance() - balance;
            System.out.println("So tien con lai la: " + current_balance);
        }
        else {
            System.out.println("Ban khong du tien de rut tien");
        }
    }
}
