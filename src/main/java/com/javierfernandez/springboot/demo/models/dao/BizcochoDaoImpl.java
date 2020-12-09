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
    @Transactional(readOnly = true)
    public Bizcocho findOne(Long id) {
        return em.find(Bizcocho.class, id);
    }

    //Hace de guardar y de editar
    @Override
    @Transactional
    public void save(Bizcocho bizcocho) {
        if (bizcocho.getId()!= null && bizcocho.getId()>0){
            em.merge(bizcocho);
        }else {
        em.persist(bizcocho);
        }


    }



    @Override
    @Transactional
    public void delete(Long id) {
        Bizcocho bizcocho= findOne(id);
        em.remove(bizcocho);
    }
}
