package org.example.strategy.payment;

import java.sql.Timestamp;

public interface PaymentStrategy {
  long getTotalAmount(Timestamp startTime, Timestamp endTime);
}
