package car.store.service.impl;

import car.store.dao.MotorcycleDao;
import car.store.model.Motorcycle;
import car.store.service.MotorcycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MotorcycleServiceImpl implements MotorcycleService {

    @Autowired
    private MotorcycleDao dao;

    @Override
    public void add(Motorcycle motorcycle) {
       dao.add(motorcycle);
    }

    @Override
    public void delete(int id) {
        dao.delete(id);
    }

    @Override
    public Motorcycle get(int id) {
        return dao.get(id);
    }

    @Override
    public void update(Motorcycle motorcycle) {
        dao.update(motorcycle);
    }
}
