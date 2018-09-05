package car.store.service.impl;

import car.store.model.HibernateMotorcycleModel;
import car.store.service.HibernateMotorcycleModelService;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

public class HibernateMotorcycleModelServiceImpl implements HibernateMotorcycleModelService {

    @PersistenceContext(unitName = "postgres")
    public EntityManager em;

    @Override
    @Transactional
    public HibernateMotorcycleModel add(HibernateMotorcycleModel motorcycle) {
       return em.merge(motorcycle);
    }

    @Override
    @Transactional
    public void delete(int id) {
        em.remove(get(id));
    }

    @Override
    @Transactional
    public HibernateMotorcycleModel get(int id) {
        return em.find(HibernateMotorcycleModel.class,id);
    }

    @Override
    @Transactional
    public void update(HibernateMotorcycleModel motorcycle) {
        em.merge(motorcycle);
    }

    @Override
    @Transactional
    public List<HibernateMotorcycleModel> getAll() {
        TypedQuery<HibernateMotorcycleModel> namedQuery = em.createNamedQuery("HibernateMotorcycleModel.getAll", HibernateMotorcycleModel.class);
        return namedQuery.getResultList();
    }
}
