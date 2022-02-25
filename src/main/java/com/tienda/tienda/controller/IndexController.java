package com.tienda.tienda.controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */

import com.tienda.tienda.domain.Cliente;
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
    private ClienteService clienteService;
    
    @RequestMapping("/") //el profe lo puso como getmapping
    public String inicio(Model model) {
        log.info("Ahora se usa arquitectura MVC");
        
        var mensaje = "Mensaje desde el controlador";
        model.addAttribute("TextoSaludo", mensaje);
        
        Cliente cliente = new Cliente("Javier", "Murillo Víquez", "jemuvic@hotmail.com", "8506-5939");
        model.addAttribute(cliente);
        
        Cliente cliente2 = new Cliente("Monica", "Montero Soto", "monmon@hotmail.com", "8867-7359");
        var clientes = Arrays.asList(cliente, cliente2);
        model.addAttribute("clientes",clientes);
     
        var clientesDB = clienteService.getClientes();
        model.addAttribute("clientesDB",clientesDB);
        
        return "index";
    }

 @GetMapping("/nuevoCliente")
 public String nuevoCliente(Cliente cliente) {
   return "modificarCliente";
   
 }
 @PostMapping("/guardarcliente")
 public String guardarCliente(Cliente cliente){
     clienteService.save(cliente);
     return "redirect:/";
 }
    @GetMapping("/modificarCliente/{idcliente}")
    public String modificarCliente(Cliente cliente, Model model) {
       var respuesta = clienteService.getCliente(cliente);
       model.addAttribute("cliente", respuesta);
       return "modificarCliente";
            }
    
    @GetMapping("/eliminarCliente/{idcliente}")
     public String eliminarCliente(Cliente cliente) {
    clienteService.delete(cliente);
    return "redirect:/";
}
}