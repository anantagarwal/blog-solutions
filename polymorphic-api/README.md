# Polymorphic APIs

This repository is a reference implementation about the concept of `polymorphic api` as articulated in
my [blog post](https://anantagarwal.me/posts/api/polymorphic-api/)

## API Endpoints

- POST /payments - Create a new payment
- GET /payments/{id} - Retrieve a payment by ID

##

Example Requests

### Create Credit Card Payment

```bash
curl -X POST http://localhost:8080/payments \
-H "Content-Type: application/json" \
-d '{
"type": "credit_card",
"amount": 100.50,
"currency": "USD",
"cardNumber": "4111111111111111",
"expiryDate": "12/25",
"cvv": "123"
}'
```

### Create Bank Transfer Payment
```bash
curl -X POST http://localhost:8080/payments \
-H "Content-Type: application/json" \
-d '{
"type": "bank_transfer",
"amount": 250.75,
"currency": "USD",
"accountNumber": "1234567890",
"routingNumber": "021000021",
"bankName": "JP Morgan Chase"
}'
```

### Get Payment
```bash
curl http://localhost:8080/payments/{payment-id}
```