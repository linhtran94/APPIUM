public class Card {
    private int cardNumber;
    private String chuTK;

    public Card(int cardNumber, String chuTK) {
        this.cardNumber = cardNumber;
        this.chuTK = chuTK;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getChuTK() {
        return chuTK;
    }

    public void setChuTK(String chuTK) {
        this.chuTK = chuTK;
    }
}
