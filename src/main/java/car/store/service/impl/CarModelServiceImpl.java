package car.store.service.impl;

import car.store.dao.CarModelDao;
import car.store.model.Car;
import car.store.service.CarModelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CarModelServiceImpl implements CarModelService {

    @Autowired
    CarModelDao carModelDao;

    @Override
    public void insert(Car car) {
        carModelDao.insert(car);
    }

    @Override
    public void insertBatch(List<Car> cars) {
        carModelDao.insertBatch(cars);
    }

    @Override
    public List<Car> loadAllCars() {
        List<Car> listOfCars = carModelDao.loadAllCars();
        for(Car car : listOfCars) System.out.println(car.toString());
        return listOfCars;
    }

    @Override
    public Car getCarById(long car_id) {
        Car car = carModelDao.findCarById(car_id);
        System.out.println(car);
        return car;
    }

    @Override
    public void getCarBrandById(long car_id) {
        String brand = carModelDao.findBrandById(car_id);
        log.debug("Car brand = " + brand);
    }

    @Override
    public void getTotalNumberOfCars() {
        int totalNumber = carModelDao.getTotalNumberOfCars();
        log.debug("Total Number of Cars is: " + totalNumber);
    }
}
