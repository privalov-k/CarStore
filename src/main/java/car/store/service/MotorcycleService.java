package car.store.service;

import car.store.model.Motorcycle;

public interface MotorcycleService {

    void add(Motorcycle motorcycle);

    void delete(int id);

    Motorcycle get(int id);

    void update(Motorcycle motorcycle);
}
