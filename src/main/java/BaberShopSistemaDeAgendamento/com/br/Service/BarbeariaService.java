package BaberShopSistemaDeAgendamento.com.br.Service;

import BaberShopSistemaDeAgendamento.com.br.DTO.BarbeariaDTO;

import java.util.List;

/**
 * Interface de serviço para operações CRUD relacionadas à Barbearia.
 * Define os métodos que devem ser implementados para manipulação dos dados da Barbearia.
 */
public interface BarbeariaService {
    BarbeariaDTO save(BarbeariaDTO barbeariaDTO);
    List<BarbeariaDTO> findAll();
    BarbeariaDTO findById(Long id);
    void delete(Long id);

    // Novos métodos de busca
    List<BarbeariaDTO> findByNome(String nome);
    List<BarbeariaDTO> findByEndereco(String endereco);
    List<BarbeariaDTO> findByTelefone(String telefone);
}