package com.javierfernandez.springboot.demo.models.dao;

import com.javierfernandez.springboot.demo.models.entity.Bizcocho;
import org.springframework.data.repository.CrudRepository;


//no se anota por que hereda de un componente ya spring
public interface IBizcochoDao  extends CrudRepository <Bizcocho, Long>{


}
