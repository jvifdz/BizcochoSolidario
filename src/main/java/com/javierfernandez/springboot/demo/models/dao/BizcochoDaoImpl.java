package com.javierfernandez.springboot.demo.models.dao;

import com.javierfernandez.springboot.demo.models.entity.Bizcocho;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository("bizcochoDaoJPA")
public class BizcochoDaoImpl implements IBizcochoDao{
    @PersistenceContext
    private EntityManager em;
    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    @Override
    public List<Bizcocho> findAll() {
        return em.createQuery("from Bizcocho").getResultList();
    }

    @Override
    public void save(Bizcocho bizcocho) {
        em.persist(bizcocho);

    }
}
