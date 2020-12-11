package com.javierfernandez.springboot.demo.models.services;

import com.javierfernandez.springboot.demo.models.dao.IBizcochoDao;
import com.javierfernandez.springboot.demo.models.entity.Bizcocho;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BizcochoServideImpl implements IBizcochoService{

    @Autowired
    private IBizcochoDao bizcochoDao;


    @Override
    @Transactional(readOnly = true)
    public List<Bizcocho> findAll() {
        return (List<Bizcocho>) bizcochoDao.findAll();
    }

    @Override
    @Transactional
    public void save(Bizcocho bizcocho) {
        bizcochoDao.save(bizcocho);

    }

    @Override
    @Transactional(readOnly = true)
    public Bizcocho findOne(Long id) {
        return bizcochoDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        bizcochoDao.deleteById(id);

    }
}
