package org.example.entity;

import java.util.Optional;

public abstract class ParkingSpot {
  private int id;
  private boolean isAvailable;

  private Location location;

  public int getId() {
    return id;
  }

  public ParkingSpot(int id, boolean isAvailable, Location location) {
    this.id = id;
    this.isAvailable = isAvailable;
    this.location = location;
  }

  public boolean isAvailable() {
    return isAvailable;
  }

  public Location getLocation() {
    return location;
  }

  public void setAvailable(boolean available) {
    isAvailable = available;
  }

  public abstract boolean doesCarFit(Car car);
  public abstract boolean doesTruckFit(Truck truck);

  @Override
  public String toString() {
    return "ParkingSpot{" +
            "id=" + id +
            ", isAvailable=" + isAvailable +
            '}';
  }
}
