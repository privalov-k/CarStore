package car.store.service.impl;

import car.store.dao.CarModelDao;
import car.store.model.CarModel;
import car.store.service.CarModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CarModelServiceImpl implements CarModelService {

    @Autowired
    CarModelDao carModelDao;



    @Override
    public void insert(CarModel car) {
        carModelDao.insert(car);
    }

    @Override
    public void insertBatch(List<CarModel> cars) {
        carModelDao.insertBatch(cars);
    }

    @Override
    public void loadAllCars() {
        List<CarModel> listOfCars = carModelDao.loadAllCars();
        for(CarModel carModel : listOfCars) System.out.println(carModel.toString());
    }

    @Override
    public void getCarById(long car_id) {
        CarModel carModel = carModelDao.findCarById(car_id);
        System.out.println(carModel);
    }

    @Override
    public void getCarBrandById(long car_id) {
        String brand = carModelDao.findBrandById(car_id);
        System.out.println("Car brand = " + brand);
    }

    @Override
    public void getTotalNumberOfCars() {
        int totalNumber = carModelDao.getTotalNumberOfCars();
        System.out.println("Total Number of Cars is: " + totalNumber);
    }
}
