package BaberShopSistemaDeAgendamento.com.br.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "endereco_barbearia")
public class EnderecoBarbearia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "A rua não pode ser vazia.")
    private String rua;

    @NotEmpty(message = "O bairro não pode ser vazio.")
    private String bairro;

    private String cidade;
    private String estado;
    private String cep;

    @OneToOne(mappedBy = "endereco", cascade = CascadeType.ALL)
    private Barbearia barbearia;
}