package com.example.api_veiculos1.controller;

import com.example.api_veiculos1.model.Veiculo;
import com.example.api_veiculos1.repository.VeiculoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para gerenciamento de veículos.
 * <p>
 * Esta classe expõe endpoints RESTful para operações CRUD (Create, Read, Update, Delete)
 * relacionadas a veículos. Todos os endpoints retornam respostas no formato JSON.
 * </p>
 * 
 * @author IFSC - Mão na Massa 1
 * @version 1.0
 * @since 2025-12-01
 */
@RestController
@RequestMapping("/veiculos")
public class VeiculoController {
    
    @Autowired
    private VeiculoRepository veiculoRepository;
    
    /**
     * Cria um novo veículo no sistema.
     * 
     * @param veiculo objeto contendo os dados do veículo a ser criado
     * @return ResponseEntity contendo o veículo criado e status HTTP 201 (CREATED)
     */
    @PostMapping
    public ResponseEntity<Veiculo> criar(@Valid @RequestBody Veiculo veiculo) {
        Veiculo novoVeiculo = veiculoRepository.save(veiculo);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoVeiculo);
    }
    
    /**
     * Lista todos os veículos cadastrados no sistema.
     * 
     * @return ResponseEntity contendo a lista de veículos e status HTTP 200 (OK)
     */
    @GetMapping
    public ResponseEntity<List<Veiculo>> listarTodos() {
        List<Veiculo> veiculos = veiculoRepository.findAll();
        return ResponseEntity.ok(veiculos);
    }
    
    /**
     * Busca um veículo específico pelo identificador.
     * 
     * @param id o identificador do veículo
     * @return ResponseEntity contendo o veículo encontrado e status HTTP 200 (OK),
     *         ou status HTTP 404 (NOT_FOUND) se o veículo não existir
     */
    @GetMapping("/{id}")
    public ResponseEntity<Veiculo> buscarPorId(@PathVariable Integer id) {
        return veiculoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    /**
     * Atualiza os dados de um veículo existente.
     * 
     * @param id o identificador do veículo a ser atualizado
     * @param veiculo objeto contendo os novos dados do veículo
     * @return ResponseEntity contendo o veículo atualizado e status HTTP 200 (OK),
     *         ou status HTTP 404 (NOT_FOUND) se o veículo não existir
     */
    @PutMapping("/{id}")
    public ResponseEntity<Veiculo> atualizar(@PathVariable Integer id, @Valid @RequestBody Veiculo veiculo) {
        return veiculoRepository.findById(id)
                .map(veiculoExistente -> {
                    veiculoExistente.setPlaca(veiculo.getPlaca());
                    veiculoExistente.setObservacoes(veiculo.getObservacoes());
                    veiculoExistente.setMotor(veiculo.getMotor());
                    veiculoExistente.setCor(veiculo.getCor());
                    veiculoExistente.setModelo(veiculo.getModelo());
                    veiculoExistente.setProprietario(veiculo.getProprietario());
                    Veiculo veiculoAtualizado = veiculoRepository.save(veiculoExistente);
                    return ResponseEntity.ok(veiculoAtualizado);
                })
                .orElse(ResponseEntity.notFound().build());
    }
    
    /**
     * Remove um veículo do sistema.
     * 
     * @param id o identificador do veículo a ser removido
     * @return ResponseEntity vazio com status HTTP 204 (NO_CONTENT) se o veículo foi removido,
     *         ou status HTTP 404 (NOT_FOUND) se o veículo não existir
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        return veiculoRepository.findById(id)
                .map(veiculo -> {
                    veiculoRepository.delete(veiculo);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
