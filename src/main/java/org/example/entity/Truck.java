package org.example.entity;

public class Truck extends Vehicle{
  public Truck(int id, String plateNumber, String color) {
    super(id, plateNumber, color);
  }

  @Override
  public boolean canFitIn(ParkingSpot parkingSpot) {
    return parkingSpot.doesTruckFit(this);
  }
}
