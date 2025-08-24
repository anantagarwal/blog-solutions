package me.anantagarwal.model;

public class BankTransferPayment extends Payment {
    private String accountNumber;
    private String routingNumber;
    private String bankName;

    // Constructors
    public BankTransferPayment() {
    }

    public BankTransferPayment(String id, double amount, String currency, String status,
                               String accountNumber, String routingNumber, String bankName) {
        super(id, amount, currency, status);
        this.accountNumber = accountNumber;
        this.routingNumber = routingNumber;
        this.bankName = bankName;
    }

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