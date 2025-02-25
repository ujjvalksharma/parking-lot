package org.example.entity;

import java.util.List;
public class ParkingLot {
  List<ParkingFloor> parkingFloorList;
  List<Entrance> entrances;
  List<Exit> exits;
  int id;

  public ParkingLot(List<ParkingFloor> parkingFloorList, List<Entrance> entrances, List<Exit> exits, int id) {
    this.parkingFloorList = parkingFloorList;
    this.entrances = entrances;
    this.exits = exits;
    this.id = id;
  }

  public List<ParkingFloor> getParkingFloorList() {
    return parkingFloorList;
  }

  public List<Entrance> getEntrances() {
    return entrances;
  }

  public List<Exit> getExits() {
    return exits;
  }

  public int getId() {
    return id;
  }

  @Override
  public String toString() {
    return "ParkingLot{" +
            "parkingFloorList=" + parkingFloorList +
            ", entrances=" + entrances +
            ", exits=" + exits +
            ", id=" + id +
            '}';
  }
}
