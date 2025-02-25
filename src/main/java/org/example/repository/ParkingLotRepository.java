package org.example.repository;

import org.example.entity.ParkingLot;
import org.example.entity.Ticket;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class ParkingLotRepository implements IBaseRepository<ParkingLot> {

  private static ParkingLotRepository baseRepository = new ParkingLotRepository();
  Map<Integer, ParkingLot> db = new HashMap<>();
  public static ParkingLotRepository  getInstance() {
    return baseRepository;
  }

  @Override
  public ParkingLot save(ParkingLot parkingLot) {
    return db.put(parkingLot.getId(), parkingLot);
  }

  @Override
  public ParkingLot findById(int id) {
    return db.get(id);
  }

  @Override
  public ParkingLot deleteById(int id) {
    return db.remove(id);
  }

  public Optional<ParkingLot> findByEntranceId(int id) {

    return db
            .values()
            .stream()
            .filter(plot ->
                    plot
                            .getEntrances()
                            .stream()
                            .map(entrance -> entrance.getId())
                            .collect(Collectors.toList()).contains(id))
            .findAny();
  }
}
