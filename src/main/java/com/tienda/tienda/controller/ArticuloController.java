package com.tienda.tienda.controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */

import com.tienda.tienda.domain.Articulo;
import com.tienda.tienda.service.ArticuloService;
import com.tienda.tienda.service.CategoriaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class ArticuloController {
    
    
    @Autowired
    private ArticuloService articuloService;
    
    @Autowired
    private CategoriaService categoriaService;
    
    @GetMapping("/articulo/listado") //el profe lo puso como getmapping
    public String inicio(Model model) {
        var articulos = articuloService.getArticulos(false);
        model.addAttribute("articulos",articulos);
        
        
        return "/articulo/listado";
    }

 @GetMapping("/articulo/nuevo")
 public String nuevoArticulo(Articulo articulo, Model model) {
  var categorias = categoriaService.getCategorias(true);
    model.addAttribute("categorias", categorias);
    
  return "/articulo/modifica";
   
 }
 @PostMapping("/articulo/guardar")
 public String guardarArticulo(Articulo articulo){
     articuloService.save(articulo);
     return "redirect:/articulo/listado";
 }
 
    @GetMapping("/articulo/modificar/{idArticulo}")
    public String modificarArticulo(Articulo articulo, Model model) {
       var respuesta = articuloService.getArticulo(articulo);
       var categorias = categoriaService.getCategorias(true);
       model.addAttribute("articulo", respuesta);
       model.addAttribute("categorias", categorias);
       
       return "/articulo/modifica";
            }
    
    @GetMapping("/articulo/eliminar/{idArticulo}")
     public String eliminarArticulo(Articulo articulo) {
    articuloService.delete(articulo);
    return "redirect:/articulo/listado";
}
}