package car.store.service.impl;

import car.store.model.dao.CarModelDao;
import car.store.model.CarModel;
import car.store.service.CarModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Service
public class CarModelServiceImpl implements CarModelService {

    @Autowired
    CarModelDao carModelDao;

    private final static Logger log = LoggerFactory.getLogger(CarModelServiceImpl.class);



    @Override
    public void insert(CarModel car) {
        carModelDao.insert(car);
    }

    @Override
    public void insertBatch(List<CarModel> cars) {
        carModelDao.insertBatch(cars);
    }

    @Override
    public List<CarModel> loadAllCars() {
        List<CarModel> listOfCars = carModelDao.loadAllCars();
        for(CarModel carModel : listOfCars) System.out.println(carModel.toString());
        return listOfCars;
    }

    @Override
    public CarModel getCarById(long car_id) {
        CarModel carModel = carModelDao.findCarById(car_id);
        System.out.println(carModel);
        return carModel;
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
