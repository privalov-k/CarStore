package car.store.core;

import car.store.model.CarModel;
import car.store.service.CarModelService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SpringBootApplication
@ComponentScan(basePackages = "car.store")
public class CarStoreApplication implements CommandLineRunner {
    @Autowired
    CarModelService carModelService;

    public static void main(String[] args) {
        SpringApplication.run(CarStoreApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        ///////////////////////////////hibernate
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.close();
        sessionFactory.close();


       /* //////////////////////////////springboot
        Random random = new Random();

        //Car 1
        CarModel car_1 = new CarModel(random.nextLong(),"Audi",3);
        //Car 2
        CarModel car_2 = new CarModel(random.nextLong(),"Volvo", 7);
        //Car 3
        CarModel car_3 = new CarModel(random.nextLong(), "BMW", 20);

        //Insert car's to DB
        List<CarModel> carList = new ArrayList<CarModel>();
        carList.add(car_1);
        carList.add(car_2);
        carList.add(car_3);
        carModelService.insertBatch(carList);

        //Load all car's and display
        carModelService.loadAllCars();

        //Get car by id
        carModelService.getCarById(Long.valueOf(car_1.getCarId()));

        //Get car brand by id
        carModelService.getCarBrandById(Long.valueOf(car_2.getCarId()));

        //Get total car's in DB
        carModelService.getTotalNumberOfCars();*/

    }
}
