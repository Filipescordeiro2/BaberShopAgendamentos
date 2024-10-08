package BaberShopSistemaDeAgendamento.com.br.Controller;

import BaberShopSistemaDeAgendamento.com.br.DTO.BarbeariaDTO;
import BaberShopSistemaDeAgendamento.com.br.Service.BarbeariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para gerenciar Barbearias.
 * Processa as requisições HTTP e delega a lógica de negócios ao serviço de Barbearia.
 */
@RestController
@RequestMapping("/api/barbearias")
public class BarbeariaController {

    @Autowired
    private BarbeariaService barbeariaService;

    /**
     * Cria uma nova Barbearia.
     *
     * @param barbeariaDTO Objeto DTO que contém os dados da Barbearia a ser criada.
     * @return Retorna o objeto BarbeariaDTO criado dentro de um ResponseEntity.
     */
    @PostMapping
    public ResponseEntity<BarbeariaDTO> createBarbearia(@RequestBody BarbeariaDTO barbeariaDTO) {
        BarbeariaDTO newBarbearia = barbeariaService.save(barbeariaDTO);
        return ResponseEntity.ok(newBarbearia);
    }

    /**
     * Retorna uma lista de todas as Barbearias.
     *
     * @return Lista de objetos BarbeariaDTO.
     */
    @GetMapping
    public List<BarbeariaDTO> getAllBarbearias() {
        return barbeariaService.findAll();
    }

    /**
     * Retorna os dados de uma Barbearia específica, baseado no ID fornecido.
     *
     * @param id ID da Barbearia a ser recuperada.
     * @return Retorna o objeto BarbeariaDTO correspondente ao ID fornecido dentro de um ResponseEntity.
     */
    @GetMapping("/{id}")
    public ResponseEntity<BarbeariaDTO> getBarbeariaById(@PathVariable Long id) {
        BarbeariaDTO barbeariaDTO = barbeariaService.findById(id);
        return ResponseEntity.ok(barbeariaDTO);
    }

    /**
     * Busca Barbearias com base em diferentes parâmetros.
     *
     * @param nome Nome parcial da Barbearia.
     * @param endereco Endereço parcial da Barbearia.
     * @param telefone Telefone parcial da Barbearia.
     * @return Lista de objetos BarbeariaDTO que correspondem aos parâmetros fornecidos.
     */
    @GetMapping("/search")
    public List<BarbeariaDTO> searchBarbearias(
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) String endereco,
            @RequestParam(required = false) String telefone) {

        if (nome != null) {
            return barbeariaService.findByNome(nome);
        } else if (endereco != null) {
            return barbeariaService.findByEndereco(endereco);
        } else if (telefone != null) {
            return barbeariaService.findByTelefone(telefone);
        } else {
            return barbeariaService.findAll();
        }
    }

    /**
     * Deleta uma Barbearia específica, baseado no ID fornecido.
     *
     * @param id ID da Barbearia a ser deletada.
     * @return Retorna um ResponseEntity com status `noContent`.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBarbearia(@PathVariable Long id) {
        barbeariaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}