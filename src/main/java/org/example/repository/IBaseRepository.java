package org.example.repository;

public interface IBaseRepository<T> {

  public T save(T t);
  T findById(int id);

  T deleteById(int id);

}
