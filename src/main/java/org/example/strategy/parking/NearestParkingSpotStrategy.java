package org.example.strategy.parking;

import org.example.entity.Location;
import org.example.entity.ParkingSpot;
import org.example.entity.Vehicle;
import org.example.util.Pair;

import java.util.List;

public class NearestParkingSpotStrategy implements ParkingStrategy {
  @Override
  public ParkingSpot findParkingSpot(Location location, List<ParkingSpot> parkingSpotList, Vehicle vehicle) {
    return parkingSpotList
            .stream()
            .filter((parkingSpot) -> vehicle.canFitIn(parkingSpot))
            .map(parkingSpot ->  new Pair<Integer, ParkingSpot>(getDistance(location, parkingSpot.getLocation()), parkingSpot))
            .sorted((a,b) -> a.getK() - b.getK())
            .findFirst()
            .get()
            .getV();
  }

  private Integer getDistance(Location location1, Location location2) {
    int Xdistance = location2.getX() - location1.getX();
    Xdistance = Xdistance * Xdistance;
    int Ydistance = location2.getY() - location1.getY();
    Ydistance = Ydistance * Ydistance;
    return Ydistance + Xdistance;
  }
}
