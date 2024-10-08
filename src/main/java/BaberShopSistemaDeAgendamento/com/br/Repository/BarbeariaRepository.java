package BaberShopSistemaDeAgendamento.com.br.Repository;

import BaberShopSistemaDeAgendamento.com.br.Model.BarbeariaModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repositório JPA para acessar dados da Barbearia.
 */
public interface BarbeariaRepository extends JpaRepository<BarbeariaModel, Long> {

    /**
     * Busca Barbearias pelo nome.
     *
     * @param nome Nome parcial da Barbearia.
     * @return Lista de Barbearias que contêm o nome fornecido.
     */
    List<BarbeariaModel> findByNomeContaining(String nome);

    /**
     * Busca Barbearias pelo endereço.
     *
     * @param endereco Endereço parcial da Barbearia.
     * @return Lista de Barbearias que contêm o endereço fornecido.
     */
    List<BarbeariaModel> findByEnderecoContaining(String endereco);

    /**
     * Busca Barbearias pelo telefone.
     *
     * @param telefone Telefone parcial da Barbearia.
     * @return Lista de Barbearias que contêm o telefone fornecido.
     */
    List<BarbeariaModel> findByTelefoneContaining(String telefone);
}