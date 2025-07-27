package br.com.estudo.domain.dtos;

import java.util.UUID;

import br.com.estudo.domain.entities.Tipo;
import lombok.Data;

@Data
public class ProdutoResponse {
	private UUID id;
	private String nome;
	private Tipo tipo;
	private Double preco;
}
