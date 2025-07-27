package br.com.estudo.domain.entities;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "produto")
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	@Column(name = "nome",nullable = false, length = 20, unique = true)
	private String nome;
	@Enumerated(EnumType.STRING)
	private Tipo tipo;
	@Column(name = "preco", nullable = false)
	private Double preco;
	
}
