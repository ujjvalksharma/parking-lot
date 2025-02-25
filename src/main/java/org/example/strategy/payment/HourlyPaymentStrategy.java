package org.example.strategy.payment;

import java.sql.Timestamp;

public class HourlyPaymentStrategy implements PaymentStrategy {
  @Override
  public long getTotalAmount(Timestamp startTime, Timestamp endTime) {
    return 5 * (endTime.getTime() - startTime.getTime());
  }
}
