package br.com.estudo.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.estudo.domain.dtos.DashboardResponse;
import br.com.estudo.domain.dtos.ProdutoRequest;
import br.com.estudo.domain.dtos.ProdutoResponse;
import br.com.estudo.domain.interfaces.ProdutoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/produto/v1/")
public class ProdutoController {
	
	@Autowired ProdutoService produtoService;
	
	
	@GetMapping("/buscar/{id}")
	public ProdutoResponse buscarProdutoPorId(@PathVariable UUID id) {
		
		return produtoService.buscarProdutoPorId(id);
	}
	@GetMapping("/listar")
	public List<ProdutoResponse> buscarTodosProdutos() {
		return produtoService.listarProdutos();
	}
	@GetMapping("/dashboard")
	public List<DashboardResponse> dashboard() {
	    return produtoService.gerarDashboard();
	}
	@PostMapping("/cadastrar")
	public ProdutoResponse cadastrarProduto(@RequestBody @Valid ProdutoRequest produtoRequest) {
		
		return produtoService.salvar(produtoRequest);
	}
	
	
	@PutMapping("/atualizar/{id}")
	public ProdutoResponse atualizarProduto(@PathVariable UUID id, @RequestBody @Valid ProdutoRequest produtoRequest) {
		return produtoService.atualizarProduto(id, produtoRequest);
	}
	@DeleteMapping("/deletar{id}")
	public ProdutoResponse deletarProduto(@PathVariable UUID id) {
		
		return produtoService.deletarProduto(id);
	}
}
