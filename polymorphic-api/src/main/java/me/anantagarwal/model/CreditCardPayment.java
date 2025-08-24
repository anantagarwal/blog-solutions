package me.anantagarwal.model;

public class CreditCardPayment extends Payment {
    private String cardNumber;
    private String expiryDate;
    private String cvv;

    // Constructors
    public CreditCardPayment() {
    }

    public CreditCardPayment(String id, double amount, String currency, String status,
                             String cardNumber, String expiryDate, String cvv) {
        super(id, amount, currency, status);
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
    }

    // Getters and setters
    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }
}