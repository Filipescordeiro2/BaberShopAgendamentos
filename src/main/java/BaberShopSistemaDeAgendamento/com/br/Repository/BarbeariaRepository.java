package BaberShopSistemaDeAgendamento.com.br.Repository;

import BaberShopSistemaDeAgendamento.com.br.Model.Barbearia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repositório JPA para acessar dados da Barbearia.
 */
public interface BarbeariaRepository extends JpaRepository<Barbearia, Long> {

    /**
     * Busca Barbearias pelo nome.
     *
     * @param nome Nome parcial da Barbearia.
     * @return Lista de Barbearias que contêm o nome fornecido.
     */
    List<Barbearia> findByNomeContaining(String nome);

    /**
     * Busca Barbearias pela rua do endereço.
     *
     * @param rua Rua parcial do endereço da Barbearia.
     * @return Lista de Barbearias que contêm a rua fornecida.
     */
    List<Barbearia> findByEnderecoRuaContaining(String rua);

    /**
     * Busca Barbearias pelo telefone.
     *
     * @param telefone Telefone parcial da Barbearia.
     * @return Lista de Barbearias que contêm o telefone fornecido.
     */
    List<Barbearia> findByTelefoneContaining(String telefone);
}