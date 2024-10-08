package BaberShopSistemaDeAgendamento.com.br.DTO;

import BaberShopSistemaDeAgendamento.com.br.Model.Barbearia;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Classe DTO (Data Transfer Object) para EnderecoBarbearia.
 * Utilizada para transferir dados entre as camadas do sistema.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoBarbeariaDTO {

    private Long id;
    private String rua;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;
    private Long barbeariaId; // Corrigido para Long
}