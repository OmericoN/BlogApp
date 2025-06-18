package io.github.omericon.blogapp;

import org.springframework.stereotype.Service;

@Service
public interface PaymentService {
    void processPayment(double amount);
}
