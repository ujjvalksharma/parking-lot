package org.example.entity;

import java.sql.Timestamp;
import java.time.Instant;

public class Ticket {
  int id;
  ParkingSpot parkingSpot;
  Vehicle vehicle;
  Person person;
  Timestamp issuedTimeStamp;

  public Ticket(int id, ParkingSpot parkingSpot, Vehicle vehicle, Person person) {
    this.id = id;
    this.parkingSpot = parkingSpot;
    this.vehicle = vehicle;
    this.person = person;
    this.issuedTimeStamp = Timestamp.from(Instant.now());
  }

  public int getId() {
    return id;
  }

  public ParkingSpot getParkingSpot() {
    return parkingSpot;
  }

  public Vehicle getVehicle() {
    return vehicle;
  }

  public Person getPerson() {
    return person;
  }

  public Timestamp getIssuedTimeStamp() {
    return issuedTimeStamp;
  }

  @Override
  public String toString() {
    return "Ticket{" +
            "id=" + id +
            ", parkingLot=" + parkingSpot +
            ", vehicle=" + vehicle +
            ", person=" + person +
            ", issuedTimeStamp=" + issuedTimeStamp +
            '}';
  }
}
