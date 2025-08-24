package me.anantagarwal.dto;

public class BankTransferPaymentResponse extends PaymentResponse {
    private String accountNumberLastFour;
    private String routingNumber;
    private String bankName;

    // Getters and setters
    public String getAccountNumberLastFour() {
        return accountNumberLastFour;
    }

    public void setAccountNumberLastFour(String accountNumberLastFour) {
        this.accountNumberLastFour = accountNumberLastFour;
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