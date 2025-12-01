package com.example.api_veiculos1.controller;

import com.example.api_veiculos1.model.Marca;
import com.example.api_veiculos1.repository.MarcaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para gerenciamento de marcas de veículos.
 * <p>
 * Esta classe expõe endpoints RESTful para operações CRUD (Create, Read, Update, Delete)
 * relacionadas a marcas. Todos os endpoints retornam respostas no formato JSON.
 * </p>
 * 
 * @author IFSC - Mão na Massa 1
 * @version 1.0
 * @since 2025-12-01
 */
@RestController
@RequestMapping("/marcas")
public class MarcaController {
    
    @Autowired
    private MarcaRepository marcaRepository;
    
    /**
     * Cria uma nova marca no sistema.
     * 
     * @param marca objeto contendo os dados da marca a ser criada
     * @return ResponseEntity contendo a marca criada e status HTTP 201 (CREATED)
     */
    @PostMapping
    public ResponseEntity<Marca> criar(@Valid @RequestBody Marca marca) {
        Marca novaMarca = marcaRepository.save(marca);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaMarca);
    }
    
    /**
     * Lista todas as marcas cadastradas no sistema.
     * 
     * @return ResponseEntity contendo a lista de marcas e status HTTP 200 (OK)
     */
    @GetMapping
    public ResponseEntity<List<Marca>> listarTodas() {
        List<Marca> marcas = marcaRepository.findAll();
        return ResponseEntity.ok(marcas);
    }
    
    /**
     * Busca uma marca específica pelo identificador.
     * 
     * @param id o identificador da marca
     * @return ResponseEntity contendo a marca encontrada e status HTTP 200 (OK),
     *         ou status HTTP 404 (NOT_FOUND) se a marca não existir
     */
    @GetMapping("/{id}")
    public ResponseEntity<Marca> buscarPorId(@PathVariable Integer id) {
        return marcaRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    /**
     * Atualiza os dados de uma marca existente.
     * 
     * @param id o identificador da marca a ser atualizada
     * @param marca objeto contendo os novos dados da marca
     * @return ResponseEntity contendo a marca atualizada e status HTTP 200 (OK),
     *         ou status HTTP 404 (NOT_FOUND) se a marca não existir
     */
    @PutMapping("/{id}")
    public ResponseEntity<Marca> atualizar(@PathVariable Integer id, @Valid @RequestBody Marca marca) {
        return marcaRepository.findById(id)
                .map(marcaExistente -> {
                    marcaExistente.setNome(marca.getNome());
                    Marca marcaAtualizada = marcaRepository.save(marcaExistente);
                    return ResponseEntity.ok(marcaAtualizada);
                })
                .orElse(ResponseEntity.notFound().build());
    }
    
    /**
     * Remove uma marca do sistema.
     * 
     * @param id o identificador da marca a ser removida
     * @return ResponseEntity vazio com status HTTP 204 (NO_CONTENT) se a marca foi removida,
     *         ou status HTTP 404 (NOT_FOUND) se a marca não existir
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        return marcaRepository.findById(id)
                .map(marca -> {
                    marcaRepository.delete(marca);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
