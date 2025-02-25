package org.example.service;

import org.example.entity.ParkingLot;
import org.example.entity.Ticket;
import org.example.entity.Vehicle;
import org.example.repository.ParkingLotRepository;

public class ParkingLotService {

  private static ParkingLotService parkingLotService = new ParkingLotService();
  private ParkingLotRepository parkingLotRepository;
  public static ParkingLotService getInstance() {
    return parkingLotService;
  }

  private ParkingLotService() {
    this.parkingLotRepository = ParkingLotRepository.getInstance();
  }
  public boolean isParkingLotFull(int parkingLotId) {
    long count = parkingLotRepository
            .findById(parkingLotId)
            .getParkingFloorList()
            .stream()
            .flatMap(plFloor -> plFloor.getParkingSpot().stream())
            .filter(parkingSpot -> parkingSpot.isAvailable())
            .findFirst()
            .stream()
            .count();
    return count == 0;
  }

}
