package org.example.service;

import org.example.entity.Entrance;
import org.example.entity.ParkingLot;
import org.example.entity.ParkingSpot;
import org.example.entity.Person;
import org.example.entity.Ticket;
import org.example.entity.Vehicle;
import org.example.repository.ParkingLotRepository;
import org.example.repository.TicketRepository;
import org.example.strategy.parking.NearestParkingSpotStrategy;
import org.example.strategy.parking.ParkingStrategy;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class EntranceService {
  private static EntranceService entranceService = new EntranceService();
  private ParkingLotRepository parkingLotRepository;
  private ParkingStrategy parkingStrategy;
  private AtomicInteger counter = new AtomicInteger();
  private TicketRepository ticketRepository;
  private ParkingLotService parkingLotService;
  public static EntranceService getInstance() {
    return entranceService;
  }

  private EntranceService() {
    this.parkingLotRepository = ParkingLotRepository.getInstance();
    this.parkingLotService = ParkingLotService.getInstance();
    this.parkingStrategy = new NearestParkingSpotStrategy();
    this.ticketRepository = TicketRepository.getInstance();
  }

  public void setParkingStrategy(ParkingStrategy strategy) {
    this.parkingStrategy = strategy;
  }

  public Ticket parkVehicle(Vehicle vehicle, Person person, Entrance entrance) {
    Optional<ParkingLot> optionalParkingLot = parkingLotRepository.findByEntranceId(entrance.getId());
    if(optionalParkingLot.isEmpty()) {
      throw new IllegalArgumentException("This entrance is not mapped to any parkinglot");
    }
    ParkingLot parkingLot = optionalParkingLot.get();

    if(parkingLotService.isParkingLotFull(parkingLot.getId())) {
      throw new IllegalArgumentException("Parking lot if full");
    }
    List<ParkingSpot> allParkingSpot = parkingLot
            .getParkingFloorList()
            .stream()
            .flatMap((parkingFloor) -> parkingFloor.getParkingSpot().stream())
            .collect(Collectors.toList());
    ParkingSpot nearestParkingSpot = parkingStrategy.findParkingSpot(entrance.getLocation(), allParkingSpot, vehicle);
    nearestParkingSpot.setAvailable(false);
    Ticket ticket = new Ticket(counter.getAndIncrement(), nearestParkingSpot, vehicle, person);
    ticketRepository.save(ticket);
    return ticket;
  }

}
