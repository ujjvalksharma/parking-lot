package org.example.repository;

import org.example.entity.Entrance;
import org.example.entity.Exit;

import java.util.HashMap;
import java.util.Map;

public class ExitRepository implements IBaseRepository<Exit> {

  private static ExitRepository baseRepository = new ExitRepository();
  Map<Integer, Exit> db = new HashMap<>();
  public static ExitRepository  getInstance() {
    return baseRepository;
  }

  @Override
  public Exit save(Exit exit) {
    return db.put(exit.getId(), exit);
  }

  @Override
  public Exit findById(int id) {
    return db.get(id);
  }

  @Override
  public Exit deleteById(int id) {
    return db.remove(id);
  }
}
