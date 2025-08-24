package me.anantagarwal.service;

import me.anantagarwal.dto.*;
import me.anantagarwal.model.BankTransferPayment;
import me.anantagarwal.model.CreditCardPayment;
import me.anantagarwal.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    public PaymentResponse processPayment(PaymentRequest paymentRequest) {
        if (paymentRequest instanceof CreditCardPaymentRequest) {
            CreditCardPaymentRequest request = (CreditCardPaymentRequest) paymentRequest;
            CreditCardPayment payment = new CreditCardPayment();
            payment.setAmount(request.getAmount());
            payment.setCurrency(request.getCurrency());
            payment.setCardNumber(request.getCardNumber());
            payment.setExpiryDate(request.getExpiryDate());
            payment.setCvv(request.getCvv());
            payment.setStatus("PROCESSING");

            CreditCardPayment savedPayment = (CreditCardPayment) paymentRepository.save(payment);

            CreditCardPaymentResponse response = new CreditCardPaymentResponse();
            response.setId(savedPayment.getId());
            response.setAmount(savedPayment.getAmount());
            response.setCurrency(savedPayment.getCurrency());
            response.setStatus(savedPayment.getStatus());
            response.setMaskedCardNumber(maskCardNumber(savedPayment.getCardNumber()));
            response.setExpiryDate(savedPayment.getExpiryDate());

            return response;
        } else if (paymentRequest instanceof BankTransferPaymentRequest) {
            BankTransferPaymentRequest request = (BankTransferPaymentRequest) paymentRequest;
            BankTransferPayment payment = new BankTransferPayment();
            payment.setAmount(request.getAmount());
            payment.setCurrency(request.getCurrency());
            payment.setAccountNumber(request.getAccountNumber());
            payment.setRoutingNumber(request.getRoutingNumber());
            payment.setBankName(request.getBankName());
            payment.setStatus("PROCESSING");

            BankTransferPayment savedPayment = (BankTransferPayment) paymentRepository.save(payment);

            BankTransferPaymentResponse response = new BankTransferPaymentResponse();
            response.setId(savedPayment.getId());
            response.setAmount(savedPayment.getAmount());
            response.setCurrency(savedPayment.getCurrency());
            response.setStatus(savedPayment.getStatus());
            response.setAccountNumberLastFour(getLastFourDigits(savedPayment.getAccountNumber()));
            response.setRoutingNumber(savedPayment.getRoutingNumber());
            response.setBankName(savedPayment.getBankName());

            return response;
        }

        throw new IllegalArgumentException("Unsupported payment type");
    }

    public Optional<PaymentResponse> getPayment(String id) {
        return paymentRepository.findById(id).map(payment -> {
            if (payment instanceof CreditCardPayment) {
                CreditCardPayment ccPayment = (CreditCardPayment) payment;
                CreditCardPaymentResponse response = new CreditCardPaymentResponse();
                response.setId(ccPayment.getId());
                response.setAmount(ccPayment.getAmount());
                response.setCurrency(ccPayment.getCurrency());
                response.setStatus(ccPayment.getStatus());
                response.setMaskedCardNumber(maskCardNumber(ccPayment.getCardNumber()));
                response.setExpiryDate(ccPayment.getExpiryDate());
                return response;
            } else if (payment instanceof BankTransferPayment) {
                BankTransferPayment btPayment = (BankTransferPayment) payment;
                BankTransferPaymentResponse response = new BankTransferPaymentResponse();
                response.setId(btPayment.getId());
                response.setAmount(btPayment.getAmount());
                response.setCurrency(btPayment.getCurrency());
                response.setStatus(btPayment.getStatus());
                response.setAccountNumberLastFour(getLastFourDigits(btPayment.getAccountNumber()));
                response.setRoutingNumber(btPayment.getRoutingNumber());
                response.setBankName(btPayment.getBankName());
                return response;
            }
            return null;
        });
    }

    private String maskCardNumber(String cardNumber) {
        if (cardNumber == null || cardNumber.length() < 4) {
            return "****";
        }
        return "**** **** **** " + cardNumber.substring(cardNumber.length() - 4);
    }

    private String getLastFourDigits(String accountNumber) {
        if (accountNumber == null || accountNumber.length() < 4) {
            return "****";
        }
        return accountNumber.substring(accountNumber.length() - 4);
    }
}