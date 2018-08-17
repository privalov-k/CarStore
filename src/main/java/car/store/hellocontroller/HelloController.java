package car.store.hellocontroller;

import car.store.model.CarModel;

import car.store.service.CarModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class HelloController {

    @Autowired
    private CarModelService carModelService;

    private final static Logger log = LoggerFactory.getLogger(HelloController.class);

    @RequestMapping("/hello")
    public String sayHello(){
        return "Hello World!";

    }

    @PostMapping("/car")
    public void insert(CarModel car){
        carModelService.insert(car);
    }

    @GetMapping("/car/{id}")
    public CarModel getCarById(@PathVariable("id")long car_id) {
        CarModel carModel = carModelService.getCarById(car_id);
        log.debug(carModel.toString());
        return carModel;
    }

    @GetMapping("/car")
    public List<CarModel> loadAllCars(){
        List<CarModel> cars = carModelService.loadAllCars();
        for(CarModel carModel : cars)
            log.debug(carModel.toString());
        return cars;
    }

}
