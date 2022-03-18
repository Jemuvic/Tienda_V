
package com.tienda.tienda.service;

import com.tienda.tienda.dao.CategoriaDao;
import com.tienda.tienda.domain.Categoria;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaDao categoriaDao;
    
    @Override
    @Transactional (readOnly = true)
    public List<Categoria> getCategorias(boolean activos) {
        var lista = (List<Categoria>) categoriaDao.findAll();
        
        if (activos){
            lista.removeIf(e -> !e.isActivo());
            
        }
        
        return lista;
        
    }

    @Override
    @Transactional //manejo de transacciones de escritura y lectura
    public void save(Categoria categoria) {
       categoriaDao.save(categoria);
        
    }

    @Override
    @Transactional
    public void delete(Categoria categoria) {
        categoriaDao.delete(categoria);
    }

    @Override
    @Transactional (readOnly = true)
    public Categoria getCategoria(Categoria categoria) {
        return categoriaDao.findById(categoria.getIdCategoria()).orElse(null);
    }
    
}
