package org.example.repository;

import org.example.entity.Person;
import org.example.entity.Ticket;

import java.util.HashMap;
import java.util.Map;

public class TicketRepository implements IBaseRepository<Ticket> {

  private static TicketRepository baseRepository = new TicketRepository();
  Map<Integer, Ticket> db = new HashMap<>();
  public static TicketRepository  getInstance() {
    return baseRepository;
  }

  @Override
  public Ticket save(Ticket ticket) {
    return db.put(ticket.getId(), ticket);
  }

  @Override
  public Ticket findById(int id) {
    return db.get(id);
  }

  @Override
  public Ticket deleteById(int id) {
    return db.remove(id);
  }
}
