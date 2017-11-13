package com.example.informator.repository;

import com.example.informator.model.Equipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

import static org.apache.coyote.http11.Constants.a;

@Repository
public class EquipmentRepository {
    @PersistenceContext
    private EntityManager entityManager;


    @Transactional
    public Equipment save(Equipment e) {

        entityManager.persist(e);

        return (e);

    }
    @Transactional
    public Equipment findOne(long id) {
        Equipment e = entityManager.find(Equipment.class, id);
        return e;
    }

    public Equipment findByName(String name) {
        TypedQuery<Equipment> query = entityManager.createQuery("select u from Equipment u where u.name = :name", Equipment.class);
        query.setParameter("name", name);
        List<Equipment> userList = query.getResultList();
        if (userList.isEmpty())
            return null;
        return userList.get(0);
    }


    public List<Equipment> findAll() {
        TypedQuery<Equipment> query = entityManager.createQuery("select e from Equipment e", Equipment.class);
        return query.getResultList();
    }

    @Transactional
    public Equipment deleteOne(Long id) {

        Equipment e = findOne(id);
        entityManager.remove(e);
        return e;
    }

}
