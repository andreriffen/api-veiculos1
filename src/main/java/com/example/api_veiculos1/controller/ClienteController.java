package com.example.api_veiculos1.controller;

import com.example.api_veiculos1.model.Cliente;
import com.example.api_veiculos1.repository.ClienteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para gerenciamento de clientes.
 * <p>
 * Esta classe expõe endpoints RESTful para operações CRUD (Create, Read, Update, Delete)
 * relacionadas a clientes. Todos os endpoints retornam respostas no formato JSON.
 * </p>
 * 
 * @author IFSC - Mão na Massa 1
 * @version 1.0
 * @since 2025-12-01
 */
@RestController
@RequestMapping("/clientes")
public class ClienteController {
    
    @Autowired
    private ClienteRepository clienteRepository;
    
    /**
     * Cria um novo cliente no sistema.
     * 
     * @param cliente objeto contendo os dados do cliente a ser criado
     * @return ResponseEntity contendo o cliente criado e status HTTP 201 (CREATED)
     */
    @PostMapping
    public ResponseEntity<Cliente> criar(@Valid @RequestBody Cliente cliente) {
        Cliente novoCliente = clienteRepository.save(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoCliente);
    }
    
    /**
     * Lista todos os clientes cadastrados no sistema.
     * 
     * @return ResponseEntity contendo a lista de clientes e status HTTP 200 (OK)
     */
    @GetMapping
    public ResponseEntity<List<Cliente>> listarTodos() {
        List<Cliente> clientes = clienteRepository.findAll();
        return ResponseEntity.ok(clientes);
    }
    
    /**
     * Busca um cliente específico pelo identificador.
     * 
     * @param id o identificador do cliente
     * @return ResponseEntity contendo o cliente encontrado e status HTTP 200 (OK),
     *         ou status HTTP 404 (NOT_FOUND) se o cliente não existir
     */
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable Integer id) {
        return clienteRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    /**
     * Atualiza os dados de um cliente existente.
     * 
     * @param id o identificador do cliente a ser atualizado
     * @param cliente objeto contendo os novos dados do cliente
     * @return ResponseEntity contendo o cliente atualizado e status HTTP 200 (OK),
     *         ou status HTTP 404 (NOT_FOUND) se o cliente não existir
     */
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizar(@PathVariable Integer id, @Valid @RequestBody Cliente cliente) {
        return clienteRepository.findById(id)
                .map(clienteExistente -> {
                    clienteExistente.setNome(cliente.getNome());
                    clienteExistente.setCelular(cliente.getCelular());
                    clienteExistente.setEmail(cliente.getEmail());
                    clienteExistente.setDataCadastro(cliente.getDataCadastro());
                    Cliente clienteAtualizado = clienteRepository.save(clienteExistente);
                    return ResponseEntity.ok(clienteAtualizado);
                })
                .orElse(ResponseEntity.notFound().build());
    }
    
    /**
     * Remove um cliente do sistema.
     * 
     * @param id o identificador do cliente a ser removido
     * @return ResponseEntity vazio com status HTTP 204 (NO_CONTENT) se o cliente foi removido,
     *         ou status HTTP 404 (NOT_FOUND) se o cliente não existir
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        return clienteRepository.findById(id)
                .map(cliente -> {
                    clienteRepository.delete(cliente);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
