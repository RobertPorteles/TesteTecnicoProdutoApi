package br.com.estudo.domain.interfaces;

import java.util.List;
import java.util.UUID;

import br.com.estudo.domain.dtos.DashboardResponse;
import br.com.estudo.domain.dtos.ProdutoRequest;
import br.com.estudo.domain.dtos.ProdutoResponse;

public interface ProdutoService {
	ProdutoResponse salvar(ProdutoRequest produtoRequest);
	
	List<ProdutoResponse> listarProdutos();
	
	ProdutoResponse buscarProdutoPorId(UUID id);
	
	ProdutoResponse atualizarProduto(UUID id, ProdutoRequest produto);
	
	ProdutoResponse deletarProduto(UUID id);

	List<DashboardResponse> gerarDashboard();

	
	
}
