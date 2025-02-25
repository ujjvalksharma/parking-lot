package org.example.repository;

import org.example.entity.Person;

import java.util.HashMap;
import java.util.Map;

public class PersonRepository implements IBaseRepository<Person> {

  private static PersonRepository baseRepository = new PersonRepository();
  Map<Integer, Person> db = new HashMap<>();
  public static PersonRepository  getInstance() {
    return baseRepository;
  }

  @Override
  public Person save(Person person) {
    return db.put(person.getId(), person);
  }

  @Override
  public Person findById(int id) {
    return db.get(id);
  }

  @Override
  public Person deleteById(int id) {
    return db.remove(id);
  }
}
