package com.javierfernandez.springboot.demo.models.services;

import com.javierfernandez.springboot.demo.models.entity.Bizcocho;

import java.util.List;

public interface IBizcochoService {


    public List<Bizcocho> findAll();
    public void save(Bizcocho bizcocho);
    public Bizcocho findOne(Long id);
    public void delete(Long id);



}
