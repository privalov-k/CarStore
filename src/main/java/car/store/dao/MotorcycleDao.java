package car.store.dao;

import car.store.model.Motorcycle;

public interface MotorcycleDao {

    public void add(Motorcycle motorcycle);

    public void delete(int id);

    public Motorcycle get(int id);

    public void update(Motorcycle motorcycle);
}
