package br.com.estudo.domain.dtos;



import br.com.estudo.domain.entities.Tipo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
@Data
public class ProdutoRequest {
	
	@NotBlank(message = "O nome do produto é obrigatório.")
    private String nome;

    @NotNull(message = "O tipo do produto é obrigatório.")
    private Tipo tipo;

    @NotNull(message = "O preço do produto é obrigatório.")
    @Positive(message = "O preço deve ser maior que zero.")
    private Double preco;
}
