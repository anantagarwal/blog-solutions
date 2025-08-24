package me.anantagarwal.dto;


import jakarta.validation.constraints.NotBlank;

public class BankTransferPaymentRequest extends PaymentRequest {
    @NotBlank
    private String accountNumber;

    @NotBlank
    private String routingNumber;

    private String bankName;

    // Getters and setters
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getRoutingNumber() {
        return routingNumber;
    }

    public void setRoutingNumber(String routingNumber) {
        this.routingNumber = routingNumber;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
}