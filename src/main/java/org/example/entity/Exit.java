package org.example.entity;

public class Exit {
  private int id;

  private Location location;

  public Exit(int id, Location location) {
    this.id = id;
    this.location = location;
  }

  public int getId() {
    return id;
  }

  public Location getLocation() {
    return location;
  }

  @Override
  public String toString() {
    return "Exit{" +
            "id=" + id +
            '}';
  }
}
