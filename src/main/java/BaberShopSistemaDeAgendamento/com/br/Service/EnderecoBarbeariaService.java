package BaberShopSistemaDeAgendamento.com.br.Service;

import BaberShopSistemaDeAgendamento.com.br.DTO.EnderecoBarbeariaDTO;

import java.util.List;

/**
 * Interface do serviço para EnderecoBarbearia.
 * Define operações CRUD relacionadas a EnderecoBarbearia.
 */
public interface EnderecoBarbeariaService {

    /**
     * Recupera todos os EnderecoBarbearia.
     *
     * @return Lista de EnderecoBarbeariaDTO representando todos os endereços de barbearias.
     */
    List<EnderecoBarbeariaDTO> getAllEnderecoBarbearia();

    /**
     * Recupera um EnderecoBarbearia específico pelo seu ID.
     *
     * @param id ID do EnderecoBarbearia a ser recuperado.
     * @return EnderecoBarbeariaDTO representando o EnderecoBarbearia encontrado.
     */
    EnderecoBarbeariaDTO findById(Long id);

    /**
     * Salva um novo EnderecoBarbearia ou atualiza um existente.
     *
     * @param enderecoDTO DTO contendo os dados do EnderecoBarbearia a ser salvo.
     * @return EnderecoBarbeariaDTO atualizado após a persistência no banco de dados.
     */
    EnderecoBarbeariaDTO save(EnderecoBarbeariaDTO enderecoDTO);

    /**
     * Deleta um EnderecoBarbearia específico pelo seu ID.
     *
     * @param id ID do EnderecoBarbearia a ser deletado.
     */
    void delete(Long id);
}