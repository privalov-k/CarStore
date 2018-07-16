package car.store.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication
@ComponentScan(basePackages = "car.store")
public class CarStoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarStoreApplication.class, args);
    }
}
