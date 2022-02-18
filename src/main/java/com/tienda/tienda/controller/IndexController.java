package com.tienda.tienda.controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
import com.tienda.tienda.dao.ClienteDao;
import com.tienda.tienda.domain.Cliente;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
@Slf4j
public class IndexController {
    
    
    @Autowired
    private ClienteDao clienteDao;
    
    @RequestMapping("/")
    public String inicio(Model model) {
        log.info("Ahora se usa arquitectura MVC");
        
        var mensaje = "Mensaje desde el controlador";
        model.addAttribute("TextoSaludo", mensaje);
        
        Cliente cliente = new Cliente("Javier", "Murillo Víquez", "jemuvic@hotmail.com", "8506-5939");
        model.addAttribute(cliente);
        
        Cliente cliente2 = new Cliente("Monica", "Montero Soto", "monmon@hotmail.com", "8867-7359");
        var clientes = Arrays.asList(cliente, cliente2);
        model.addAttribute("clientes",clientes);
        
        clienteDao.save(cliente2);
        
        var clientesDB = clienteDao.findAll();       
        model.addAttribute("clientesDB",clientesDB);
        return "index";
    }

}