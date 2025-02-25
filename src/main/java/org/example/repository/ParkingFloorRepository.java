package org.example.repository;

import org.example.entity.Exit;
import org.example.entity.ParkingFloor;

import java.util.HashMap;
import java.util.Map;

public class ParkingFloorRepository implements IBaseRepository<ParkingFloor> {

  private static ParkingFloorRepository baseRepository = new ParkingFloorRepository();
  Map<Integer, ParkingFloor> db = new HashMap<>();
  public static ParkingFloorRepository  getInstance() {
    return baseRepository;
  }

  @Override
  public ParkingFloor save(ParkingFloor parkingFloor) {
    return db.put(parkingFloor.getId(), parkingFloor);
  }

  @Override
  public ParkingFloor findById(int id) {
    return db.get(id);
  }

  @Override
  public ParkingFloor deleteById(int id) {
    return db.remove(id);
  }
}
