package BaberShopSistemaDeAgendamento.com.br.Service.Imp;

import BaberShopSistemaDeAgendamento.com.br.DTO.BarbeariaDTO;
import BaberShopSistemaDeAgendamento.com.br.Model.BarbeariaModel;
import BaberShopSistemaDeAgendamento.com.br.Repository.BarbeariaRepository;
import BaberShopSistemaDeAgendamento.com.br.Service.BarbeariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public BarbeariaDTO save(BarbeariaDTO barbeariaDTO) {
        BarbeariaModel barbearia = new BarbeariaModel();
        barbearia.setNome(barbeariaDTO.getNome());
        barbearia.setEndereco(barbeariaDTO.getEndereco());
        barbearia.setTelefone(barbeariaDTO.getTelefone());

        barbearia = barbeariaRepository.save(barbearia);
        return new BarbeariaDTO(barbearia.getId(), barbearia.getNome(), barbearia.getEndereco(), barbearia.getTelefone());
    }

    @Override
    public List<BarbeariaDTO> findAll() {
        return barbeariaRepository.findAll().stream()
                .map(barbearia -> new BarbeariaDTO(barbearia.getId(), barbearia.getNome(), barbearia.getEndereco(), barbearia.getTelefone()))
                .collect(Collectors.toList());
    }

    @Override
    public BarbeariaDTO findById(Long id) {
        BarbeariaModel barbearia = barbeariaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Barbearia não encontrada"));
        return new BarbeariaDTO(barbearia.getId(), barbearia.getNome(), barbearia.getEndereco(), barbearia.getTelefone());
    }

    @Override
    public void delete(Long id) {
        barbeariaRepository.deleteById(id);
    }

    /**
     * Busca Barbearias pelo nome.
     *
     * @param nome Nome da Barbearia.
     * @return Lista de objetos BarbeariaDTO que correspondem ao nome fornecido.
     */
    @Override
    public List<BarbeariaDTO> findByNome(String nome) {
        return barbeariaRepository.findByNomeContaining(nome).stream()
                .map(barbearia -> new BarbeariaDTO(barbearia.getId(), barbearia.getNome(), barbearia.getEndereco(), barbearia.getTelefone()))
                .collect(Collectors.toList());
    }

    /**
     * Busca Barbearias pelo endereço.
     *
     * @param endereco Endereço da Barbearia.
     * @return Lista de objetos BarbeariaDTO que correspondem ao endereço fornecido.
     */
    @Override
    public List<BarbeariaDTO> findByEndereco(String endereco) {
        return barbeariaRepository.findByEnderecoContaining(endereco).stream()
                .map(barbearia -> new BarbeariaDTO(barbearia.getId(), barbearia.getNome(), barbearia.getEndereco(), barbearia.getTelefone()))
                .collect(Collectors.toList());
    }

    /**
     * Busca Barbearias pelo telefone.
     *
     * @param telefone Telefone da Barbearia.
     * @return Lista de objetos BarbeariaDTO que correspondem ao telefone fornecido.
     */
    @Override
    public List<BarbeariaDTO> findByTelefone(String telefone) {
        return barbeariaRepository.findByTelefoneContaining(telefone).stream()
                .map(barbearia -> new BarbeariaDTO(barbearia.getId(), barbearia.getNome(), barbearia.getEndereco(), barbearia.getTelefone()))
                .collect(Collectors.toList());
    }
}