package org.example.entity;

public class SmallParkingSpot extends ParkingSpot{
  public SmallParkingSpot(int id, Location location) {
    super(id, true, location);
  }

  @Override
  public boolean doesCarFit(Car car) {
    return true;
  }

  @Override
  public boolean doesTruckFit(Truck truck) {
    return false;
  }
}
