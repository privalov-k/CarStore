package car.store.controller;

import car.store.model.Motorcycle;
import car.store.model.Person;
import car.store.service.MotorcycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MotorcycleController {

    @Autowired
    private MotorcycleService service;

    @GetMapping("/motorcycle/add")
    public void addTestMoto() {
        Motorcycle moto = new Motorcycle();
        moto.setYear(2222);
        moto.setBrand("Yamaha");
        service.add(moto);
    }

    @GetMapping("/motorcycle/delete/{motoId}")
    public void deleteMoto(@PathVariable("motoId") int id){
        service.delete(id);
    }

    @GetMapping("/motorcycle/get/{motoId}")
    public Motorcycle getMoto(@PathVariable("motoId") int id){
        return service.get(id);
    }

    @GetMapping("/motorcycle/update")
    public void updateMoto(Motorcycle motorcycle){
    service.update(motorcycle);
    }
}
