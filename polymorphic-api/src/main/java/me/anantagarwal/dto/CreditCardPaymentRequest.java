package me.anantagarwal.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;


public class CreditCardPaymentRequest extends PaymentRequest {
    @NotBlank
    private String cardNumber;

    @NotBlank
    @Pattern(regexp = "^(0[1-9]|1[0-2])\\/?([0-9]{2})$", message = "Invalid expiry date format")
    private String expiryDate;

    @NotBlank
    @Size(min = 3, max = 4)
    private String cvv;

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