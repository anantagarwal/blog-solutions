package me.anantagarwal.repository;

import me.anantagarwal.model.Payment;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Repository
public class PaymentRepository {
    private final Map<String, Payment> payments = new HashMap<>();

    public Payment save(Payment payment) {
        String id = UUID.randomUUID().toString();
        payment.setId(id);
        payments.put(id, payment);
        return payment;
    }

    public Optional<Payment> findById(String id) {
        return Optional.ofNullable(payments.get(id));
    }

    public Map<String, Payment> findAll() {
        return new HashMap<>(payments);
    }
}