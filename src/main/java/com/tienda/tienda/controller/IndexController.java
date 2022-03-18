package com.tienda.tienda.controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */

import com.tienda.tienda.domain.Cliente;
import com.tienda.tienda.service.ArticuloService;
import com.tienda.tienda.service.ClienteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class IndexController {
    
    
    @Autowired
    private ArticuloService articuloService;
    
    @GetMapping("/") //el profe lo puso como getmapping
    public String inicio(Model model) {
        log.info("Ahora se usa arquitectura MVC");
        
        var articulos = articuloService.getArticulos(true);
        model.addAttribute("articulos", articulos);
          
        return "index";
    }

}