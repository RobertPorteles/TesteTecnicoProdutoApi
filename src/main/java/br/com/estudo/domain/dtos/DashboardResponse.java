package br.com.estudo.domain.dtos;

import br.com.estudo.domain.entities.Tipo;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DashboardResponse {
	private Tipo tipo;
    private Long quantidade;
    private Double precoMedio;
}
