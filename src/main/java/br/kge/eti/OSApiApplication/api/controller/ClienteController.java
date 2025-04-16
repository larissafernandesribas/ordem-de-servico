    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.kge.eti.OSApiApplication.api.controller;
import br.kge.eti.OSApiApplication.domain.model.Cliente;
import br.kge.eti.OSApiApplication.domain.repository.ClienteRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sesideva
 */

@RestController
public class ClienteController {
    
    @Autowired
    private ClienteRepository clienteRepository;
            
    @GetMapping("/clientes")
    public List<Cliente> listas(){
    return clienteRepository.findAll(); 
    }
}

