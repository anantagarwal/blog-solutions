package me.anantagarwal.dto;

public class CreditCardPaymentResponse extends PaymentResponse {
    private String maskedCardNumber;
    private String expiryDate;

    // Getters and setters
    public String getMaskedCardNumber() {
        return maskedCardNumber;
    }

    public void setMaskedCardNumber(String maskedCardNumber) {
        this.maskedCardNumber = maskedCardNumber;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }
}