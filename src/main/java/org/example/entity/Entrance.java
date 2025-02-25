package org.example.entity;

public class Entrance {
  private int id;
  Location location;


  public Entrance(int id, Location location) {
    this.id = id;
    this.location = location;
  }

  public Location getLocation() {
    return location;
  }

  public int getId() {
    return id;
  }

  @Override
  public String toString() {
    return "Entrance{" +
            "id=" + id +
            '}';
  }
}
