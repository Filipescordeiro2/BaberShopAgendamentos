package BaberShopSistemaDeAgendamento.com.br.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Classe de modelo JPA que representa uma Barbearia no sistema.
 *
 * Esta classe é usada para mapear a entidade Barbearia com a tabela correspondente no banco de dados.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BarbeariaModel {

    /**
     * Campo que representa o identificador único da Barbearia.
     * É a chave primária na tabela do banco de dados.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Campo que representa o nome da Barbearia.
     */
    private String nome;

    /**
     * Campo que representa o endereço da Barbearia.
     */
    private String endereco;

    /**
     * Campo que representa o telefone de contato da Barbearia.
     */
    private String telefone;

    // Outros campos e métodos podem ser adicionados conforme necessário
}