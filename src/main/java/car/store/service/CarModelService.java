package car.store.service;

import car.store.model.Car;

import java.util.List;

public interface CarModelService {

    void insert(Car car);

    void insertBatch(List<Car> cars);

    List<Car> loadAllCars();

    Car getCarById(long car_id);

    void getCarBrandById(long car_id);

    void getTotalNumberOfCars();
}
