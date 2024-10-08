package BaberShopSistemaDeAgendamento.com.br.Controller;

import BaberShopSistemaDeAgendamento.com.br.DTO.BarbeariaDTO;
import BaberShopSistemaDeAgendamento.com.br.Service.BarbeariaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controladora para gerenciar Barbearias.
 */
@RestController
@RequestMapping("/api/barbearias")
@RequiredArgsConstructor
public class BarbeariaController {

    private final BarbeariaService barbeariaService;

    /**
     * Cria uma nova Barbearia.
     *
     * @param barbeariaDTO DTO contendo os dados da barbárie.
     * @return BarbeariaDTO atualizado após a persistência no banco de dados.
     */
    @PostMapping
    public ResponseEntity<BarbeariaDTO> createBarbearia(@Validated @RequestBody BarbeariaDTO barbeariaDTO) {
        BarbeariaDTO savedBarbearia = barbeariaService.save(barbeariaDTO);
        return ResponseEntity.ok(savedBarbearia);
    }

    /**
     * Recupera todas as Barbearias.
     *
     * @param filtro DTO contendo os critérios de filtro para a busca.
     * @return Lista de BarbeariaDTO que correspondem ao filtro.
     */
    @GetMapping
    public ResponseEntity<List<BarbeariaDTO>> getAllBarbearias(@Validated BarbeariaDTO filtro) {
        List<BarbeariaDTO> barbearias = barbeariaService.findAll(filtro);
        return ResponseEntity.ok(barbearias);
    }

    /**
     * Recupera uma Barbearia pelo seu ID.
     *
     * @param id ID da barbárie a ser recuperada.
     * @return BarbeariaDTO representando a barbárie encontrada.
     */
    @GetMapping("/{id}")
    public ResponseEntity<BarbeariaDTO> getBarbeariaById(@PathVariable Long id) {
        BarbeariaDTO barbearia = barbeariaService.findById(id);
        return ResponseEntity.ok(barbearia);
    }

    /**
     * Deleta uma Barbearia pelo seu ID.
     *
     * @param id ID da barbárie a ser deletada.
     * @return Resposta sem conteúdo.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBarbearia(@PathVariable Long id) {
        barbeariaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}