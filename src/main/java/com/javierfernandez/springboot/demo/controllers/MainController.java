package com.javierfernandez.springboot.demo.controllers;



import com.javierfernandez.springboot.demo.models.entity.Bizcocho;
import com.javierfernandez.springboot.demo.models.services.IBizcochoService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

@Controller
@SessionAttributes("cliente")
public class MainController {

    @Autowired
    private IBizcochoService bizcochoService;




    @RequestMapping(value = {"/listarbizcocho","/",""},method = RequestMethod.GET)
    public String listarBizcocho(Model model){
        model.addAttribute("titulo","Listado de bizcochos");
        model.addAttribute("bizcochos",bizcochoService.findAll());
        return "listarbizcocho";
    }

    @RequestMapping(value = "/formbizcocho")
    public String crearBizcocho(Map <String, Object> model){
        Bizcocho bizcocho = new Bizcocho();
        model.put("bizcocho", bizcocho);

        model.put("titulo", "Insertar Bizcocho");
        return "formbizcocho";
    }


    @RequestMapping(value = "/formbizcocho/{id}")
    public String editar(@PathVariable(value ="id") Long id, Map<String,Object> model){
        Bizcocho bizcocho = null;
        if (id>0){
            bizcocho= bizcochoService.findOne(id);
        }else {
            return"redirect:/listarbizcocho";
        }
        model.put("bizcocho",bizcocho);
        model.put("titulo","Editar bizcocho");
        return "formbizcocho";
    }


    @RequestMapping(value = "/formbizcocho", method = RequestMethod.POST)
    public String guardarBizcocho (@Valid Bizcocho bizcocho, BindingResult result, Model model, @RequestParam("file")MultipartFile foto, SessionStatus status){

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
        if (!foto.isEmpty()){
            Path directorioRecursos = Paths.get("src//main//resources//static/uploads");
            String rootPath = directorioRecursos.toFile().getAbsolutePath();
            try {
                byte[] bytes = foto.getBytes();

                Path rutaCompleta = Paths.get(rootPath+"//"+foto.getOriginalFilename());
                Files.write(rutaCompleta,bytes);

                bizcocho.setFoto(foto.getOriginalFilename());
            }catch (IOException e){
                e.printStackTrace();
            }
        }

        bizcochoService.save(bizcocho);
        status.setComplete();
        return "redirect:listarbizcocho";
    }

    @RequestMapping(value="/eliminar/{id}")
    public String eliminar(@PathVariable(value ="id") Long id){

        if (id>0){
            bizcochoService.delete(id);
        }

        return"redirect:/listarbizcocho";
    }

}
