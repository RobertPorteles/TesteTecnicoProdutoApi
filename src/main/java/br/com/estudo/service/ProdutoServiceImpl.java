package br.com.estudo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.estudo.domain.dtos.DashboardResponse;
import br.com.estudo.domain.dtos.ProdutoRequest;
import br.com.estudo.domain.dtos.ProdutoResponse;
import br.com.estudo.domain.entities.Produto;
import br.com.estudo.domain.entities.Tipo;
import br.com.estudo.domain.interfaces.ProdutoService;
import br.com.estudo.domain.mappers.ProdutoMapper;
import br.com.estudo.repositories.ProdutoRepository;


@Service
public class ProdutoServiceImpl implements ProdutoService {
	
	@Autowired ProdutoRepository produtoRepository;
	@Autowired ProdutoMapper mapper;
	
	public Produto buscarOuFalhar(UUID id) {
	    return produtoRepository.findById(id)
	        .orElseThrow(() -> new RuntimeException("Produto com ID " + id + " não encontrado"));
	}


	@Override
	public ProdutoResponse salvar(ProdutoRequest produtoRequest) {
		
		Produto produto = produtoRepository.save(mapper.toEntity(produtoRequest));
		
		return mapper.toResponse(produto);
		
		
	}

	@Override
	public List<ProdutoResponse> listarProdutos() {
		// TODO Auto-generated method stub
		return produtoRepository.findAll()
				.stream()
				.map(mapper::toResponse)
				.collect(Collectors.toList());
	}

	@Override
	public ProdutoResponse atualizarProduto(UUID id, ProdutoRequest request) {
		
		Produto produto = buscarOuFalhar(id);
		
		 mapper.updateEntityFromRequest(request, produto);
		 
		 Produto produtoAtualizado = produtoRepository.save(produto);
		 return mapper.toResponse(produtoAtualizado);
	}

	@Override
	public ProdutoResponse deletarProduto(UUID id) {
		Produto produto = buscarOuFalhar(id);
		
		produtoRepository.delete(produto);
		
		return mapper.toResponse(produto);
	}

	@Override
	public ProdutoResponse buscarProdutoPorId(UUID id) {
		Produto produto = buscarOuFalhar(id);
		
		return mapper.toResponse(produto);
		
	}

	@Override
	public List<DashboardResponse> gerarDashboard() {
	    List<DashboardResponse> resultado = new ArrayList<>();

	    for (Tipo tipo : Tipo.values()) {
	        long quantidade = produtoRepository.countByTipo(tipo);
	        Double precoMedio = produtoRepository.calcularPrecoMedioPorTipo(tipo);

	        resultado.add(new DashboardResponse(
	            tipo,
	            quantidade,
	            precoMedio != null ? precoMedio : 0.0
	        ));
	    }

	    return resultado;
	}




}
