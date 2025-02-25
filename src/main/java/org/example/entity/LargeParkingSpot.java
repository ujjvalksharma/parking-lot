package org.example.entity;

public class LargeParkingSpot extends ParkingSpot {
  public LargeParkingSpot(int id, Location location) {
    super(id, true, location);
  }

  @Override
  public boolean doesCarFit(Car car) {
    return false;
  }

  @Override
  public boolean doesTruckFit(Truck truck) {
    return true;
  }
}
