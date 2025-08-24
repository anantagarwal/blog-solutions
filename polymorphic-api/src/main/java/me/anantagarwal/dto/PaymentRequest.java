package me.anantagarwal.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = CreditCardPaymentRequest.class, name = "credit_card"),
        @JsonSubTypes.Type(value = BankTransferPaymentRequest.class, name = "bank_transfer")
})
public abstract class PaymentRequest {
    @NotNull
    @Positive
    private Double amount;

    @NotNull
    private String currency;

    // Getters and setters
    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
