package com.javierfernandez.springboot.demo.models.dao;

import com.javierfernandez.springboot.demo.models.entity.Bizcocho;

import java.util.List;

public interface IBizcochoDao {

    public List<Bizcocho> findAll();
    public void save(Bizcocho bizcocho);
    public Bizcocho findOne(Long id);
}
