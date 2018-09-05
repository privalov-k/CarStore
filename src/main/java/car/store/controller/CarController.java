package car.store.controller;

import car.store.model.Car;
import car.store.service.CarModelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class CarController {

    @Autowired
    private CarModelService carModelService;

    @PostMapping("/car")
    public void insert(Car car){
        carModelService.insert(car);
    }

    @GetMapping("/car/{id}")
    public Car getCarById(@PathVariable("id")long car_id) {
        Car car = carModelService.getCarById(car_id);
        log.debug(car.toString());
        return car;
    }

    @GetMapping("/car")
    public List<Car> loadAllCars(){
        List<Car> cars = carModelService.loadAllCars();
        for(Car car : cars)
            log.debug(car.toString());
        return cars;
    }
}
