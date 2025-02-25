package org.example.entity;

public class Person {
  private String name;
  int id;
  private String licenceNumber;

  public Person(int id, String name, String licenceNumber) {
    this.name = name;
    this.id = id;
    this.licenceNumber = licenceNumber;
  }

  public String getName() {
    return name;
  }

  public int getId() {
    return id;
  }

  public String getLicenceNumber() {
    return licenceNumber;
  }

  @Override
  public String toString() {
    return "Driver{" +
            "name='" + name + '\'' +
            ", licienceNumber='" + licenceNumber + '\'' +
            '}';
  }
}
