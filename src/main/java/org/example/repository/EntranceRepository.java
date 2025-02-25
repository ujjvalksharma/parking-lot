package org.example.repository;

import org.example.entity.Entrance;
import org.example.entity.Person;

import java.util.HashMap;
import java.util.Map;

public class EntranceRepository implements IBaseRepository<Entrance> {

  private static EntranceRepository baseRepository = new EntranceRepository();
  Map<Integer, Entrance> db = new HashMap<>();
  public static EntranceRepository  getInstance() {
    return baseRepository;
  }

  @Override
  public Entrance save(Entrance entrance) {
    return db.put(entrance.getId(), entrance);
  }

  @Override
  public Entrance findById(int id) {
    return db.get(id);
  }

  @Override
  public Entrance deleteById(int id) {
    return db.remove(id);
  }
}
