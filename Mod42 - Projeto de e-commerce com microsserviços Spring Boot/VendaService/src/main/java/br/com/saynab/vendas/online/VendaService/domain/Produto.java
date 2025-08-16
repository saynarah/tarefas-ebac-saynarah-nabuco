package br.com.saynab.vendas.online.VendaService.domain;

import java.math.BigDecimal;

import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Produto {
	
	@Id
	private String id;
	
	@NotNull
	@Size(min=2,max=10)
	@Indexed(unique=true, background=true)
	private String codigo;
	
	@NotNull
	@Size(min=1, max=50)
	private String nome;
	
	@NotNull
	@Size(min=1,max=50)
	private String descricao;
	
	
	private BigDecimal valor;
	


}
