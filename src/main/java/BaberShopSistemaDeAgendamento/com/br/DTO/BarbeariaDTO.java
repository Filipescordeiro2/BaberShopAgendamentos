package BaberShopSistemaDeAgendamento.com.br.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Classe DTO (Data Transfer Object) para Barbearia.
 * Utilizada para transferir dados entre as camadas do sistema.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BarbeariaDTO {
    private Long id;
    private String nome;
    private String telefone;
    private EnderecoBarbeariaDTO endereco; // Singular
}