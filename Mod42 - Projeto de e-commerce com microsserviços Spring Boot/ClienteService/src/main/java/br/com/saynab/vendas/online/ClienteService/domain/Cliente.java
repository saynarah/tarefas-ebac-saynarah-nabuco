package br.com.saynab.vendas.online.ClienteService.domain;

import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.*;

@Document(collection="cliente")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name="Cliente",description="Cliente")
public class Cliente {
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public Long getTel() {
		return tel;
	}

	public void setTel(Long tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Id
	@Schema(description="Identificador único")
	private String id;
	
	@NotNull
	@Size(min= 1,max= 50)
	@Schema(description="Nome",minLength = 1,maxLength =50, nullable = false)
	private String nome;
	
	@NotNull
	@Indexed(unique=true,background=true)
	@Schema(description = "CPF",nullable = false)
	private Long cpf;
	
	@NotNull
	@Schema(description="Telefone", nullable = false)
	private Long tel;
	
	@NotNull
	@Size(min=1, max=50)
	@Indexed(unique=true,background=true)
	@Schema(description="Email", minLength=1, maxLength=50, nullable=false)
	@Pattern(regexp = ".+@.+\\..+", message = "Email inválido")
	private String email;
	
	@NotNull
	@Size(min=1,max=50)
	@Schema(description="Endereço",minLength=1,maxLength=50, nullable=false)
	private String end;
	
	@NotNull
	@Schema(description="Numero residencial",nullable=false)
	private Integer numero;
	
	@NotNull
	@Size(min=1,max=50)
	@Schema(description="Cidade",minLength=1,maxLength=50,nullable=false)
	private String cidade;
	
	@NotNull
	@Size(min=1, max=50)
	@Schema(description="Estado",minLength=1, maxLength=50, nullable=false)
	private String estado;
	
	

}
