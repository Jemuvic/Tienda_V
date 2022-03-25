
package com.tienda.tienda.dao;

import com.tienda.tienda.domain.Cliente;
/*import java.util.List;*/
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


public interface ClienteDao extends JpaRepository<Cliente, Long> {
    /*public List<Cliente> findByCorreo(String correo);*/
}
