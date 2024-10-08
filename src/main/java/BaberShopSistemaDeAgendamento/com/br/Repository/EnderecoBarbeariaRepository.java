package BaberShopSistemaDeAgendamento.com.br.Repository;

import BaberShopSistemaDeAgendamento.com.br.Model.Barbearia;
import BaberShopSistemaDeAgendamento.com.br.Model.EnderecoBarbearia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repositório para a entidade EnderecoBarbearia.
 * Fornece operações CRUD padrão usando Spring Data JPA.
 */
@Repository
public interface EnderecoBarbeariaRepository extends JpaRepository<EnderecoBarbearia, Long> {

    Optional<Barbearia> findBarbeariaById(Long id);

}