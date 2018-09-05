package car.store.controller;

import car.store.model.Motorcycle;
import car.store.service.MotorcycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MotorcycleController {

    @Autowired
    private MotorcycleService service;

    @GetMapping("/addMoto")
    public void addTestMoto() {
        Motorcycle moto = new Motorcycle();
        moto.setYear(2222);
        moto.setBrand("Yamaha");
        service.add(moto);
    }
}
