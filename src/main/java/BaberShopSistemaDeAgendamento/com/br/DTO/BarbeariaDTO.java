package BaberShopSistemaDeAgendamento.com.br.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Classe DTO (Data Transfer Object) para Barbearia.
 * Utilizada para transferir dados entre as camadas do sistema.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BarbeariaDTO {

    /**
     * Identificador único da Barbearia.
     */
    private Long id;

    /**
     * Nome da Barbearia.
     */
    private String nome;

    /**
     * Endereço da Barbearia.
     */
    private String endereco;

    /**
     * Telefone de contato da Barbearia.
     */
    private String telefone;
}