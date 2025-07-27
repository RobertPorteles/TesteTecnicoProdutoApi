package br.com.estudo.domain.mappers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.estudo.domain.dtos.ProdutoRequest;
import br.com.estudo.domain.dtos.ProdutoResponse;
import br.com.estudo.domain.entities.Produto;
import br.com.estudo.repositories.ProdutoRepository;

@Component
public class ProdutoMapper {
	@Autowired ProdutoRepository produtoRepository;
	
	public Produto toEntity(ProdutoRequest produtoRequest) {
		Produto produto = new Produto();
		produto.setNome(produtoRequest.getNome());
		produto.setTipo(produtoRequest.getTipo());
		produto.setPreco(produtoRequest.getPreco());
		return produto;
	}
	public ProdutoResponse toResponse(Produto produto) {
		ProdutoResponse produtoResponse = new ProdutoResponse();
		produtoResponse.setId(produto.getId());
		produtoResponse.setNome(produto.getNome());
		produtoResponse.setTipo(produto.getTipo());
		produtoResponse.setPreco(produto.getPreco());
		return produtoResponse;
	}
	public void updateEntityFromRequest(ProdutoRequest produtoRequest, Produto produto) {
		
		produto.setNome(produtoRequest.getNome());
		produto.setTipo(produtoRequest.getTipo());
		produto.setPreco(produtoRequest.getPreco());
		
	}
	public Produto achaPorId(UUID id) {
		Produto produto = produtoRepository.findById(id)
		.orElseThrow(() -> new RuntimeException("Produto não encontrado"));
		
		return produto;
	}
}
