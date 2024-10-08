package BaberShopSistemaDeAgendamento.com.br.Service.Imp;

import BaberShopSistemaDeAgendamento.com.br.DTO.BarbeariaDTO;
import BaberShopSistemaDeAgendamento.com.br.DTO.EnderecoBarbeariaDTO;
import BaberShopSistemaDeAgendamento.com.br.Model.Barbearia;
import BaberShopSistemaDeAgendamento.com.br.Model.EnderecoBarbearia;
import BaberShopSistemaDeAgendamento.com.br.Repository.BarbeariaRepository;
import BaberShopSistemaDeAgendamento.com.br.Repository.EnderecoBarbeariaRepository;
import BaberShopSistemaDeAgendamento.com.br.Service.BarbeariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementação do serviço de Barbearia.
 * Contém a lógica de negócios para operações CRUD relacionadas à Barbearia.
 */
@Service
public class BarbeariaServiceImp implements BarbeariaService {

    @Autowired
    private BarbeariaRepository barbeariaRepository;

    @Autowired
    private EnderecoBarbeariaRepository enderecoBarbeariaRepository;

    /**
     * Salva uma nova Barbearia e seu endereço associado no banco de dados.
     *
     * @param barbeariaDTO DTO contendo os dados da barbearia e seu endereço.
     * @return BarbeariaDTO atualizado após a persistência no banco de dados.
     */
    @Override
    @Transactional
    public BarbeariaDTO save(BarbeariaDTO barbeariaDTO) {
        // Converte o DTO para uma entidade Barbearia
        Barbearia barbearia = new Barbearia();
        barbearia.setNome(barbeariaDTO.getNome());
        barbearia.setTelefone(barbeariaDTO.getTelefone());

        // Converte e salva o endereço, se houver
        EnderecoBarbeariaDTO enderecoDTO = barbeariaDTO.getEndereco();
        if (enderecoDTO != null) {
            EnderecoBarbearia endereco;

            // Verifica se o endereço já existe para evitar entidade desanexada
            if (enderecoDTO.getId() != null) {
                endereco = enderecoBarbeariaRepository.findById(enderecoDTO.getId())
                        .orElseThrow(() -> new RuntimeException("Endereço não encontrado"));
                endereco.setRua(enderecoDTO.getRua());
                endereco.setBairro(enderecoDTO.getBairro());
                endereco.setCidade(enderecoDTO.getCidade());
                endereco.setEstado(enderecoDTO.getEstado());
                endereco.setCep(enderecoDTO.getCep());
            } else {
                endereco = new EnderecoBarbearia();
                endereco.setRua(enderecoDTO.getRua());
                endereco.setBairro(enderecoDTO.getBairro());
                endereco.setCidade(enderecoDTO.getCidade());
                endereco.setEstado(enderecoDTO.getEstado());
                endereco.setCep(enderecoDTO.getCep());
            }

            // Associa o endereço à barbearia
            endereco.setBarbearia(barbearia);
            barbearia.setEndereco(endereco);
        }

        // Salva a Barbearia
        Barbearia savedBarbearia = barbeariaRepository.save(barbearia);
        barbeariaDTO.setId(savedBarbearia.getId());

        return toDTO(savedBarbearia);
    }

    /**
     * Busca todas as barbearias que correspondem ao filtro fornecido.
     *
     * @param filtro DTO contendo os critérios de filtro para a busca.
     * @return Lista de BarbeariaDTO que correspondem ao filtro.
     */
    @Override
    @Transactional(readOnly = true)
    public List<BarbeariaDTO> findAll(BarbeariaDTO filtro) {
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Barbearia barbeariaFiltro = fromDTO(filtro);
        Example<Barbearia> example = Example.of(barbeariaFiltro, matcher);

        List<Barbearia> barbeariasList = barbeariaRepository.findAll(example);
        return barbeariasList.stream().map(this::toDTO).collect(Collectors.toList());
    }

    /**
     * Busca uma Barbearia específica pelo seu ID.
     *
     * @param id ID da barbearia a ser buscada.
     * @return BarbeariaDTO representando a barbearia encontrada.
     */
    @Override
    @Transactional(readOnly = true)
    public BarbeariaDTO findById(Long id) {
        Barbearia barbearia = barbeariaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Barbearia não encontrada"));
        return toDTO(barbearia);
    }

    /**
     * Deleta uma Barbearia específica pelo seu ID.
     *
     * @param id ID da barbearia a ser deletada.
     */
    @Override
    @Transactional
    public void delete(Long id) {
        barbeariaRepository.deleteById(id);
    }

    /**
     * Converte uma entidade Barbearia para um DTO BarbeariaDTO.
     *
     * @param barbearia Entidade Barbearia a ser convertida.
     * @return BarbeariaDTO representando a entidade convertida.
     */
    private BarbeariaDTO toDTO(Barbearia barbearia) {
        BarbeariaDTO barbeariaDTO = new BarbeariaDTO();
        barbeariaDTO.setId(barbearia.getId());
        barbeariaDTO.setNome(barbearia.getNome());
        barbeariaDTO.setTelefone(barbearia.getTelefone());

        if (barbearia.getEndereco() != null) {
            EnderecoBarbearia endereco = barbearia.getEndereco();
            EnderecoBarbeariaDTO enderecoDTO = new EnderecoBarbeariaDTO();
            enderecoDTO.setId(endereco.getId());
            enderecoDTO.setRua(endereco.getRua());
            enderecoDTO.setBairro(endereco.getBairro());
            enderecoDTO.setCidade(endereco.getCidade());
            enderecoDTO.setEstado(endereco.getEstado());
            enderecoDTO.setCep(endereco.getCep());
            enderecoDTO.setBarbeariaId(endereco.getBarbearia().getId());
            barbeariaDTO.setEndereco(enderecoDTO);
        }

        return barbeariaDTO;
    }

    /**
     * Converte um DTO BarbeariaDTO para uma entidade Barbearia.
     *
     * @param barbeariaDTO DTO a ser convertido.
     * @return Entidade Barbearia representando o DTO convertido.
     */
    private Barbearia fromDTO(BarbeariaDTO barbeariaDTO) {
        Barbearia barbearia = new Barbearia();
        barbearia.setId(barbeariaDTO.getId());
        barbearia.setNome(barbeariaDTO.getNome());
        barbearia.setTelefone(barbeariaDTO.getTelefone());
        return barbearia;
    }
}