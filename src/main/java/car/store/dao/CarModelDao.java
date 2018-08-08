package car.store.dao;

import car.store.model.CarModel;

import java.util.List;

public interface CarModelDao {

    void insert(CarModel car);

    void insertBatch(List<CarModel> cars);

    List<CarModel> loadAllCars();

    CarModel findCarById(long car_id);

    String findBrandById(long car_id);

    int getTotalNumberOfCars();

    void deleteCarById(long car_id);
}
