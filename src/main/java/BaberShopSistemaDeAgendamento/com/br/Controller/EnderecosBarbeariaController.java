package BaberShopSistemaDeAgendamento.com.br.Controller;

import BaberShopSistemaDeAgendamento.com.br.DTO.EnderecoBarbeariaDTO;
import BaberShopSistemaDeAgendamento.com.br.Service.EnderecoBarbeariaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controladora para gerenciar Endereços de Barbearias.
 */
@RestController
@RequestMapping("/api/enderecos")
@RequiredArgsConstructor
public class EnderecosBarbeariaController {

    private final EnderecoBarbeariaService enderecoBarbeariaService;

    /**
     * Cria ou atualiza um EnderecoBarbearia.
     *
     * @param enderecoDTO DTO contendo os dados do EnderecoBarbearia a ser salvo.
     * @return EnderecoBarbeariaDTO atualizado após a persistência no banco de dados.
     */
    @PostMapping
    public ResponseEntity<EnderecoBarbeariaDTO> createOrUpdateEndereco(@Validated @RequestBody EnderecoBarbeariaDTO enderecoDTO) {
        EnderecoBarbeariaDTO savedEndereco = enderecoBarbeariaService.save(enderecoDTO);
        return ResponseEntity.ok(savedEndereco);
    }

    /**
     * Recupera todos os EnderecoBarbearia.
     *
     * @return Lista de EnderecoBarbeariaDTO representando todos os endereços de barbearias.
     */
    @GetMapping
    public ResponseEntity<List<EnderecoBarbeariaDTO>> getAllEnderecos() {
        List<EnderecoBarbeariaDTO> enderecos = enderecoBarbeariaService.getAllEnderecoBarbearia();
        return ResponseEntity.ok(enderecos);
    }

    /**
     * Recupera um EnderecoBarbearia pelo seu ID.
     *
     * @param id ID do EnderecoBarbearia a ser recuperado.
     * @return EnderecoBarbeariaDTO representando o EnderecoBarbearia encontrado.
     */
    @GetMapping("/{id}")
    public ResponseEntity<EnderecoBarbeariaDTO> getEnderecoById(@PathVariable Long id) {
        EnderecoBarbeariaDTO endereco = enderecoBarbeariaService.findById(id);
        return ResponseEntity.ok(endereco);
    }

    /**
     * Deleta um EnderecoBarbearia pelo seu ID.
     *
     * @param id ID do EnderecoBarbearia a ser deletado.
     * @return Resposta sem conteúdo.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEndereco(@PathVariable Long id) {
        enderecoBarbeariaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}