package car.store.service.impl;

import car.store.model.HibernateMotorcycleModel;
import car.store.service.HibernateMotorcycleModelService;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class HibernateMotorcycleModelServiceImpl implements HibernateMotorcycleModelService {

    public EntityManager em = Persistence.createEntityManagerFactory("postgres@localhost").createEntityManager();

    @Override
    public HibernateMotorcycleModel add(HibernateMotorcycleModel motorcycle) {
        em.getTransaction().begin();
        HibernateMotorcycleModel motorcycleModel = em.merge(motorcycle);
        em.getTransaction().commit();
        return motorcycleModel;
    }

    @Override
    public void delete(int id) {
        em.getTransaction().begin();
        em.remove(get(id));
        em.getTransaction().commit();

    }

    @Override
    public HibernateMotorcycleModel get(int id) {
        return em.find(HibernateMotorcycleModel.class,id);
    }

    @Override
    public void update(HibernateMotorcycleModel motorcycle) {
        em.getTransaction().begin();
        em.merge(motorcycle);
        em.getTransaction().commit();
    }

    @Override
    public List<HibernateMotorcycleModel> getAll() {
        TypedQuery<HibernateMotorcycleModel> namedQuery = em.createNamedQuery("HibernateMotorcycleModel.getAll", HibernateMotorcycleModel.class);
        return namedQuery.getResultList();
    }
}
