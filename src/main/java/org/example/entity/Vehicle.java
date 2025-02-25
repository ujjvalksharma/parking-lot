package org.example.entity;

public abstract class Vehicle {
  String plateNumber;
  int id;
  String color;

  public Vehicle(int id, String plateNumber, String color) {
    this.id = id;
    this.plateNumber = plateNumber;
    this.color = color;
  }

  public String getPlateNumber() {
    return plateNumber;
  }

  public String getColor() {
    return color;
  }

  public int getId() {
    return id;
  }

  public abstract boolean canFitIn(ParkingSpot parkingSpot);

  @Override
  public String toString() {
    return "Vehicle{" +
            "plateNumber='" + plateNumber + '\'' +
            ", id=" + id +
            ", color='" + color + '\'' +
            '}';
  }
}
