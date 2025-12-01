package com.example.api_veiculos1.repository;

import com.example.api_veiculos1.model.Modelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositório para operações de acesso a dados da entidade Modelo.
 * <p>
 * Esta interface estende {@link JpaRepository} fornecendo métodos CRUD padrão
 * para a entidade {@link Modelo}.
 * </p>
 * 
 * @author IFSC - Mão na Massa 1
 * @version 1.0
 * @since 2025-12-01
 */
@Repository
public interface ModeloRepository extends JpaRepository<Modelo, Integer> {
}
