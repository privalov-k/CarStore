package car.store.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "car.store")
@EntityScan(basePackages = "car.store.model")
public class CarStoreApplication {
    public static void main(String[] args) {
        SpringApplication.run(CarStoreApplication.class, args);
    }
}
