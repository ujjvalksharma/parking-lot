package org.example.entity;

import org.example.constant.PaymentType;

import java.sql.Timestamp;

public class Payment {
  int id;
  PaymentType paymentType;
  long amount;
  Timestamp paymentTimestamp;

  Ticket ticket;

  public Payment(int id, PaymentType paymentType, long amount, Timestamp paymentTimestamp, Ticket ticket) {
    this.id = id;
    this.paymentType = paymentType;
    this.amount = amount;
    this.paymentTimestamp = paymentTimestamp;
    this.ticket = ticket;
  }

  public int getId() {
    return id;
  }

  public PaymentType getPaymentType() {
    return paymentType;
  }

  public long getAmount() {
    return amount;
  }

  public Timestamp getPaymentTimestamp() {
    return paymentTimestamp;
  }

  @Override
  public String toString() {
    return "Payment{" +
            "id=" + id +
            ", paymentType=" + paymentType +
            ", amount=" + amount +
            ", paymentTimestamp=" + paymentTimestamp +
            '}';
  }
}
