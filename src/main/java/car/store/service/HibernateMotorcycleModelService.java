package car.store.service;

import car.store.model.HibernateMotorcycleModel;

import java.util.List;

public interface HibernateMotorcycleModelService {

    public HibernateMotorcycleModel add(HibernateMotorcycleModel motorcycle);

    public void delete(int id);

    public HibernateMotorcycleModel get(int id);

    public void update(HibernateMotorcycleModel motorcycle);

    public List<HibernateMotorcycleModel> getAll();

}
