package car.store.dao;

import car.store.model.Car;

import java.util.List;

public interface CarModelDao {

    void insert(Car car);

    void insertBatch(List<Car> cars);

    List<Car> loadAllCars();

    Car findCarById(long id);

    String findBrandById(long id);

    int getTotalNumberOfCars();
}
