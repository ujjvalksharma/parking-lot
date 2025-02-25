package org.example.strategy.parking;

import org.example.entity.Location;
import org.example.entity.ParkingSpot;
import org.example.entity.Vehicle;

import java.util.List;

public interface ParkingStrategy {
  ParkingSpot findParkingSpot(Location location, List<ParkingSpot> parkingSpotList, Vehicle vehicle);
}
