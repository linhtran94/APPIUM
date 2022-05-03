public class Main {
    static Student student;

    public static void main(String[] args) {
//        student = new Student();
//        student.setId(10);
//        System.out.println(student.getId());
//        System.out.println("-------------");
//        Student student2 = new Student(91, "nguyen van hai", 31);
//
//        System.out.println(student2.getId());
//        student2.setId(90);
//        System.out.println(student2.getId());
        int carNumber = 54;
        String carName = "hai";


        Card card = new Card(1234, "nguyen hai");
        inputCardNumber(card.getCardNumber());
        inputCardName(card.getChuTK());
        inputCardNumber(carNumber);
        inputCardName(carName);

    }

    private static void inputCardName(String chuTK) {
        System.out.println("chuTK = " + chuTK);
    }

    private static void inputCardNumber(int cardNumber) {
        System.out.println("cardNumber = " + cardNumber);
    }
}
