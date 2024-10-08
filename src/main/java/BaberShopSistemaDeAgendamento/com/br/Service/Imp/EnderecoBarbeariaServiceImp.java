package BaberShopSistemaDeAgendamento.com.br.Service.Imp;

import BaberShopSistemaDeAgendamento.com.br.DTO.EnderecoBarbeariaDTO;
import BaberShopSistemaDeAgendamento.com.br.Model.Barbearia;
import BaberShopSistemaDeAgendamento.com.br.Model.EnderecoBarbearia;
import BaberShopSistemaDeAgendamento.com.br.Repository.EnderecoBarbeariaRepository;
import BaberShopSistemaDeAgendamento.com.br.Service.EnderecoBarbeariaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementação do serviço de EnderecoBarbearia.
 * Contém a lógica de negócios para operações CRUD relacionadas a EnderecoBarbearia.
 */
@Service
@RequiredArgsConstructor
public class EnderecoBarbeariaServiceImp implements EnderecoBarbeariaService {

    private final EnderecoBarbeariaRepository enderecoBarbeariaRepository;

    /**
     * Recupera todos os EnderecoBarbearia.
     *
     * @return Lista de EnderecoBarbeariaDTO representando todos os endereços de barbearias.
     */
    @Override
    @Transactional
    public List<EnderecoBarbeariaDTO> getAllEnderecoBarbearia() {
        // Recupera todos os endereços do repositório
        List<EnderecoBarbearia> enderecos = enderecoBarbeariaRepository.findAll();
        // Converte a lista de entidades para uma lista de DTOs
        return enderecos.stream()
                .map(endereco -> new EnderecoBarbeariaDTO(
                        endereco.getId(),
                        endereco.getRua(),
                        endereco.getBairro(),
                        endereco.getCidade(),
                        endereco.getEstado(),
                        endereco.getCep(),
                        endereco.getBarbearia().getId() // Pega o ID da barbearia
                )).collect(Collectors.toList());
    }

    /**
     * Recupera um EnderecoBarbearia específico pelo seu ID.
     *
     * @param id ID do EnderecoBarbearia a ser recuperado.
     * @return EnderecoBarbeariaDTO representando o EnderecoBarbearia encontrado.
     */
    @Override
    @Transactional
    public EnderecoBarbeariaDTO findById(Long id) {
        // Busca o endereço no repositório pelo ID e lança uma exceção se não for encontrado
        EnderecoBarbearia endereco = enderecoBarbeariaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Endereço não encontrado"));
        // Converte a entidade encontrada para um DTO
        return new EnderecoBarbeariaDTO(
                endereco.getId(),
                endereco.getRua(),
                endereco.getBairro(),
                endereco.getCidade(),
                endereco.getEstado(),
                endereco.getCep(),
                endereco.getBarbearia().getId() // Pega o ID da barbearia
        );
    }

    /**
     * Salva um novo EnderecoBarbearia ou atualiza um existente.
     *
     * @param enderecoDTO DTO contendo os dados do EnderecoBarbearia a ser salvo.
     * @return EnderecoBarbeariaDTO atualizado após a persistência no banco de dados.
     */
    @Override
    @Transactional
    public EnderecoBarbeariaDTO save(EnderecoBarbeariaDTO enderecoDTO) {
        // Converte o DTO para uma entidade EnderecoBarbearia
        EnderecoBarbearia endereco = new EnderecoBarbearia();
        endereco.setRua(enderecoDTO.getRua());
        endereco.setBairro(enderecoDTO.getBairro());
        endereco.setCidade(enderecoDTO.getCidade());
        endereco.setEstado(enderecoDTO.getEstado());
        endereco.setCep(enderecoDTO.getCep());

        // Associar o ID da barbearia, se fornecido
        if (enderecoDTO.getBarbeariaId() != null) {
            // Busca a barbearia no repositório ou inicializa uma nova
            Barbearia barbearia = enderecoBarbeariaRepository.findBarbeariaById(enderecoDTO.getBarbeariaId())
                    .orElseGet(() -> {
                        Barbearia newBarbearia = new Barbearia();
                        newBarbearia.setId(enderecoDTO.getBarbeariaId());
                        return newBarbearia;
                    });
            endereco.setBarbearia(barbearia);
        }

        // Salva a entidade no repositório
        EnderecoBarbearia savedEndereco = enderecoBarbeariaRepository.save(endereco);

        Long barbeariaId = null;
        if (savedEndereco.getBarbearia() != null) {
            barbeariaId = savedEndereco.getBarbearia().getId();
        }

        // Converte a entidade salva para um DTO e o retorna
        return new EnderecoBarbeariaDTO(
                savedEndereco.getId(),
                savedEndereco.getRua(),
                savedEndereco.getBairro(),
                savedEndereco.getCidade(),
                savedEndereco.getEstado(),
                savedEndereco.getCep(),
                barbeariaId
        );
    }

    /**
     * Deleta um EnderecoBarbearia específico pelo seu ID.
     *
     * @param id ID do EnderecoBarbearia a ser deletado.
     */
    @Override
    @Transactional
    public void delete(Long id) {
        // Deleta o endereço no repositório pelo ID
        enderecoBarbeariaRepository.deleteById(id);
    }
}