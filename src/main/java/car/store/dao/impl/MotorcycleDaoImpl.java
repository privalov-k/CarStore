package car.store.dao.impl;

import car.store.dao.MotorcycleDao;
import car.store.model.Motorcycle;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Component
@Transactional
public class MotorcycleDaoImpl implements MotorcycleDao {

    @PersistenceContext
    EntityManager em;

    @Override
    public void add(Motorcycle motorcycle) {
        em.persist(motorcycle);
    }

    @Override
    public void delete(int id) {
        em.remove(get(id));
    }

    @Override
    public Motorcycle get(int id) {
        return em.find(Motorcycle.class,id);
    }

    @Override
    public void update(Motorcycle motorcycle) {
        em.merge(motorcycle);
    }
}
