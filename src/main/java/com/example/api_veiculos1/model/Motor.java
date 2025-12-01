package com.example.api_veiculos1.model;

import com.example.api_veiculos1.model.enums.ETipoCombustivel;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Classe embarcável que representa as características de um motor.
 * <p>
 * Esta classe é incorporada na entidade Veículo e armazena
 * informações sobre potência e tipo de combustível do motor.
 * </p>
 * 
 * @author IFSC - Mão na Massa 1
 * @version 1.0
 * @since 2025-12-01
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Motor {
    
    private int potencia;
    
    @Enumerated(EnumType.STRING)
    private ETipoCombustivel tipoCombustivel;
}
