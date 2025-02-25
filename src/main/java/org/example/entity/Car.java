package org.example.entity;

public class Car extends Vehicle{
  public Car(int id, String plateNumber, String color) {
    super(id, plateNumber, color);
  }

  @Override
  public boolean canFitIn(ParkingSpot parkingSpot) {
    return parkingSpot.doesCarFit(this);
  }
}
