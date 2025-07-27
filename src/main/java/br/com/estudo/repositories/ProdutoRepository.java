package br.com.estudo.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.estudo.domain.entities.Produto;
import br.com.estudo.domain.entities.Tipo;
@Repository
public interface ProdutoRepository extends JpaRepository<Produto, UUID> {
	
	    // Contagem por tipo
	    long countByTipo(Tipo tipo);

	    // Preço médio por tipo (Spring Data não gera automaticamente — usaremos uma query abaixo)
	    @Query("SELECT AVG(p.preco) FROM Produto p WHERE p.tipo = :tipo")
	    Double calcularPrecoMedioPorTipo(@Param("tipo") Tipo tipo);
	}

