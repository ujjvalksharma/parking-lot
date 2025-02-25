package org.example.repository;

import org.example.entity.Vehicle;

import java.util.HashMap;
import java.util.Map;

public class VechileRepository implements IBaseRepository<Vehicle> {

  private static VechileRepository baseRepository = new VechileRepository();
  Map<Integer, Vehicle> db = new HashMap<>();
  public static VechileRepository  getInstance() {
    return baseRepository;
  }

  @Override
  public Vehicle save(Vehicle vehicle) {
    return db.put(vehicle.getId(), vehicle);
  }

  @Override
  public Vehicle findById(int id) {
    return db.get(id);
  }

  @Override
  public Vehicle deleteById(int id) {
    return db.remove(id);
  }
}
