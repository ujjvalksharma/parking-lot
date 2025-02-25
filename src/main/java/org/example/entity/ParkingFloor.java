package org.example.entity;

import java.util.List;

public class ParkingFloor {
  int id;
  List<ParkingSpot> parkingSpot;

  public ParkingFloor(int id, List<ParkingSpot> parkingSpot) {
    this.id = id;
    this.parkingSpot = parkingSpot;
  }

  public int getId() {
    return id;
  }

  public List<ParkingSpot> getParkingSpot() {
    return parkingSpot;
  }

  @Override
  public String toString() {
    return "ParkingFloor{" +
            "id=" + id +
            ", parkingSpot=" + parkingSpot +
            '}';
  }
}
