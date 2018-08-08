package car.store.hellocontroller;

import car.store.model.CarModel;
import car.store.service.impl.CarModelServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HelloController {

    @Autowired
    private CarModelServiceImpl carModelService;

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
        System.out.println(carModel);
        return carModel;
    }

    @GetMapping("/car")
    public List<CarModel> loadAllCars(){
        List<CarModel> cars = carModelService.loadAllCars();
        for(CarModel carModel : cars) System.out.println(carModel.toString());
        return cars;
    }

}
