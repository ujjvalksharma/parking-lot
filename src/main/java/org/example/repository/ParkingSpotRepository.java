package org.example.repository;

import org.example.entity.Entrance;
import org.example.entity.ParkingSpot;

import java.util.HashMap;
import java.util.Map;

public class ParkingSpotRepository implements IBaseRepository<ParkingSpot> {

  private static ParkingSpotRepository baseRepository = new ParkingSpotRepository();
  Map<Integer, ParkingSpot> db = new HashMap<>();
  public static ParkingSpotRepository  getInstance() {
    return baseRepository;
  }

  @Override
  public ParkingSpot save(ParkingSpot parkingSpot) {
    return db.put(parkingSpot.getId(), parkingSpot);
  }

  @Override
  public ParkingSpot findById(int id) {
    return db.get(id);
  }

  @Override
  public ParkingSpot deleteById(int id) {
    return db.remove(id);
  }
}
