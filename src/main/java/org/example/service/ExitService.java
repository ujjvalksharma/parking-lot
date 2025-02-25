package org.example.service;

import org.example.constant.PaymentType;
import org.example.entity.Payment;
import org.example.entity.Ticket;
import org.example.repository.TicketRepository;
import org.example.strategy.payment.HourlyPaymentStrategy;
import org.example.strategy.payment.PaymentStrategy;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.concurrent.atomic.AtomicInteger;

public class ExitService {

  private static ExitService exitService = new ExitService();
  AtomicInteger counter = new AtomicInteger();
  TicketRepository ticketRepository;
  PaymentStrategy paymentStrategy;

  private ExitService() {
    this.ticketRepository = TicketRepository.getInstance();
    this.paymentStrategy = new HourlyPaymentStrategy();
  }

  public static ExitService getInstance() {
    return exitService;
  }

  public Payment processExit(int ticketId, PaymentType paymentType) {
    Ticket ticket = ticketRepository.findById(ticketId);
    Timestamp paymentTimestamp = Timestamp.from(Instant.now());
    long amount = paymentStrategy.getTotalAmount(ticket.getIssuedTimeStamp(), paymentTimestamp);
    Payment payment = new Payment(counter.getAndIncrement(),  paymentType, amount, paymentTimestamp, ticket);
    return payment;
  }


}
