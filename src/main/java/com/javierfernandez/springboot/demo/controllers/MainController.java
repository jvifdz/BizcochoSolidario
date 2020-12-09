package com.javierfernandez.springboot.demo.controllers;


import com.javierfernandez.springboot.demo.models.dao.IBizcochoDao;
import com.javierfernandez.springboot.demo.models.entity.Bizcocho;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Map;

@Controller
public class MainController {

    @Autowired
    @Qualifier("bizcochoDaoJPA")
    private IBizcochoDao bizcochoDao;

    @RequestMapping(value = "/listarbizcocho",method = RequestMethod.GET)
    public String listarBizcocho(Model model){
        model.addAttribute("titulo","Listado de bizcochos");
        model.addAttribute("bizcochos",bizcochoDao.findAll());
        return "listarbizcocho";
    }

    @RequestMapping(value = "/formbizcocho")
    public String crearBizcocho(Map <String, Object> model){
        Bizcocho bizcocho = new Bizcocho();
        model.put("bizcocho", bizcocho);

        model.put("titulo", "Insertar Bizcocho");
        return "formbizcocho";
    }

    @RequestMapping(value = "/formbizcocho", method = RequestMethod.POST)
    public String guardarBizcocho (@Valid Bizcocho bizcocho, BindingResult result, Model model){

        //si tiene errores volvemos a la vista formulario
        //y volvemos a pasar el titulo
        //no pasamos cliente por que lo pasa automaticamente pero debe llamarese ela clase Cliente
        //no importa la mayus
        //igual que como lo pasas a la vista arriba en el put ("cliente")
        //sino se indica en el @ModelAtribute
        if (result.hasErrors()){
            model.addAttribute("titulo","Insertar Bizcocho");

            return "formbizcocho";
        }

        bizcochoDao.save(bizcocho);
        return "redirect:listarbizcocho";
    }

}
