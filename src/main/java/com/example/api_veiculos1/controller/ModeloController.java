package com.example.api_veiculos1.controller;

import com.example.api_veiculos1.model.Modelo;
import com.example.api_veiculos1.repository.ModeloRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para gerenciamento de modelos de veículos.
 * <p>
 * Esta classe expõe endpoints RESTful para operações CRUD (Create, Read, Update, Delete)
 * relacionadas a modelos. Todos os endpoints retornam respostas no formato JSON.
 * </p>
 * 
 * @author IFSC - Mão na Massa 1
 * @version 1.0
 * @since 2025-12-01
 */
@RestController
@RequestMapping("/modelos")
public class ModeloController {
    
    @Autowired
    private ModeloRepository modeloRepository;
    
    /**
     * Cria um novo modelo no sistema.
     * 
     * @param modelo objeto contendo os dados do modelo a ser criado
     * @return ResponseEntity contendo o modelo criado e status HTTP 201 (CREATED)
     */
    @PostMapping
    public ResponseEntity<Modelo> criar(@Valid @RequestBody Modelo modelo) {
        Modelo novoModelo = modeloRepository.save(modelo);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoModelo);
    }
    
    /**
     * Lista todos os modelos cadastrados no sistema.
     * 
     * @return ResponseEntity contendo a lista de modelos e status HTTP 200 (OK)
     */
    @GetMapping
    public ResponseEntity<List<Modelo>> listarTodos() {
        List<Modelo> modelos = modeloRepository.findAll();
        return ResponseEntity.ok(modelos);
    }
    
    /**
     * Busca um modelo específico pelo identificador.
     * 
     * @param id o identificador do modelo
     * @return ResponseEntity contendo o modelo encontrado e status HTTP 200 (OK),
     *         ou status HTTP 404 (NOT_FOUND) se o modelo não existir
     */
    @GetMapping("/{id}")
    public ResponseEntity<Modelo> buscarPorId(@PathVariable Integer id) {
        return modeloRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    /**
     * Atualiza os dados de um modelo existente.
     * 
     * @param id o identificador do modelo a ser atualizado
     * @param modelo objeto contendo os novos dados do modelo
     * @return ResponseEntity contendo o modelo atualizado e status HTTP 200 (OK),
     *         ou status HTTP 404 (NOT_FOUND) se o modelo não existir
     */
    @PutMapping("/{id}")
    public ResponseEntity<Modelo> atualizar(@PathVariable Integer id, @Valid @RequestBody Modelo modelo) {
        return modeloRepository.findById(id)
                .map(modeloExistente -> {
                    modeloExistente.setDescricao(modelo.getDescricao());
                    modeloExistente.setMarca(modelo.getMarca());
                    Modelo modeloAtualizado = modeloRepository.save(modeloExistente);
                    return ResponseEntity.ok(modeloAtualizado);
                })
                .orElse(ResponseEntity.notFound().build());
    }
    
    /**
     * Remove um modelo do sistema.
     * 
     * @param id o identificador do modelo a ser removido
     * @return ResponseEntity vazio com status HTTP 204 (NO_CONTENT) se o modelo foi removido,
     *         ou status HTTP 404 (NOT_FOUND) se o modelo não existir
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        return modeloRepository.findById(id)
                .map(modelo -> {
                    modeloRepository.delete(modelo);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
