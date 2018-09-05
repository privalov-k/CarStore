package car.store.service;

import car.store.model.CarModel;

import java.util.List;

public interface CarModelService {

    void insert(CarModel car);

    void insertBatch(List<CarModel> cars);

    List<CarModel> loadAllCars();

    CarModel getCarById(long car_id);

    void getCarBrandById(long car_id);

    void getTotalNumberOfCars();
}
