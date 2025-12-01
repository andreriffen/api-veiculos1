package com.example.api_veiculos1.controller;

import com.example.api_veiculos1.model.Cor;
import com.example.api_veiculos1.repository.CorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para gerenciamento de cores de veículos.
 * <p>
 * Esta classe expõe endpoints RESTful para operações CRUD (Create, Read, Update, Delete)
 * relacionadas a cores. Todos os endpoints retornam respostas no formato JSON.
 * </p>
 * 
 * @author IFSC - Mão na Massa 1
 * @version 1.0
 * @since 2025-12-01
 */
@RestController
@RequestMapping("/cores")
public class CorController {
    
    @Autowired
    private CorRepository corRepository;
    
    /**
     * Cria uma nova cor no sistema.
     * 
     * @param cor objeto contendo os dados da cor a ser criada
     * @return ResponseEntity contendo a cor criada e status HTTP 201 (CREATED)
     */
    @PostMapping
    public ResponseEntity<Cor> criar(@Valid @RequestBody Cor cor) {
        Cor novaCor = corRepository.save(cor);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaCor);
    }
    
    /**
     * Lista todas as cores cadastradas no sistema.
     * 
     * @return ResponseEntity contendo a lista de cores e status HTTP 200 (OK)
     */
    @GetMapping
    public ResponseEntity<List<Cor>> listarTodas() {
        List<Cor> cores = corRepository.findAll();
        return ResponseEntity.ok(cores);
    }
    
    /**
     * Busca uma cor específica pelo identificador.
     * 
     * @param id o identificador da cor
     * @return ResponseEntity contendo a cor encontrada e status HTTP 200 (OK),
     *         ou status HTTP 404 (NOT_FOUND) se a cor não existir
     */
    @GetMapping("/{id}")
    public ResponseEntity<Cor> buscarPorId(@PathVariable Integer id) {
        return corRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    /**
     * Atualiza os dados de uma cor existente.
     * 
     * @param id o identificador da cor a ser atualizada
     * @param cor objeto contendo os novos dados da cor
     * @return ResponseEntity contendo a cor atualizada e status HTTP 200 (OK),
     *         ou status HTTP 404 (NOT_FOUND) se a cor não existir
     */
    @PutMapping("/{id}")
    public ResponseEntity<Cor> atualizar(@PathVariable Integer id, @Valid @RequestBody Cor cor) {
        return corRepository.findById(id)
                .map(corExistente -> {
                    corExistente.setNome(cor.getNome());
                    Cor corAtualizada = corRepository.save(corExistente);
                    return ResponseEntity.ok(corAtualizada);
                })
                .orElse(ResponseEntity.notFound().build());
    }
    
    /**
     * Remove uma cor do sistema.
     * 
     * @param id o identificador da cor a ser removida
     * @return ResponseEntity vazio com status HTTP 204 (NO_CONTENT) se a cor foi removida,
     *         ou status HTTP 404 (NOT_FOUND) se a cor não existir
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        return corRepository.findById(id)
                .map(cor -> {
                    corRepository.delete(cor);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
