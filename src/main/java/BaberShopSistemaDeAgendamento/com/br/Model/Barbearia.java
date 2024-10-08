package BaberShopSistemaDeAgendamento.com.br.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Classe de modelo JPA que representa uma Barbearia no sistema.
 *
 * Esta classe é usada para mapear a entidade Barbearia com a tabela correspondente no banco de dados.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "barbearia")
public class Barbearia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String telefone;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    private EnderecoBarbearia endereco;
}