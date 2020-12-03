package com.javierfernandez.springboot.demo.models.dao;



import com.javierfernandez.springboot.demo.models.entity.Cliente;

import java.util.List;

public interface ICLienteDao {

    public List<Cliente> findAll();

    public void save(Cliente cliente);

}
