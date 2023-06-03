package com.javalet.estacionamento.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Estacionamento {
	
	String nome;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer id;

	Integer capacidade;
	
	float taxa_base;
	
	float taxa_horaria;
	
	float taxa_diaria;
	
	float taxa_semanal;
	
	float taxa_mensal;

	@OneToMany
	List<Veiculo> veiculos;

	@OneToMany
	List<EventoVeiculo> eventos;

	@OneToMany
	List<Servico> servicos;

	public Integer getId() {
	return id;
	}

	public void setId(Integer id) {
	this.id = id;
	}
public String getNome() {
return nome;
}

public void setNome(String nome) {
this.nome = nome;
}

public float getTaxa_base() {
return taxa_base;
}

public void setTaxa_base(float taxa_base) {
this.taxa_base = taxa_base;
}

public float getTaxa_diaria() {
return taxa_diaria;
}

public void setTaxa_diaria(float taxa_diaria) {
this.taxa_diaria = taxa_diaria;
}

public float getTaxa_mensal() {
return taxa_mensal;
}

public void setTaxa_mensal(float taxa_mensal) {
this.taxa_mensal = taxa_mensal;
}

public float getTaxa_horaria() {
return taxa_horaria;
}

public void setTaxa_horaria(float taxa_horaria) {
this.taxa_horaria = taxa_horaria;
}

public float getTaxa_semanal() {
return taxa_semanal;
}

public void setTaxa_semanal(float taxa_semanal) {
this.taxa_semanal = taxa_semanal;
}

public List<Servico> getServicos() {
return servicos;
}

public void setServicos(List<Servico> servicos) {
this.servicos = servicos;
}

public void setVeiculos(List<Veiculo> veiculos) {
this.veiculos = veiculos;
}

public List<Veiculo> getVeiculos() {
return veiculos;
}

public void setEventos(List<EventoVeiculo> eventos) {
this.eventos = eventos;
}

public List<EventoVeiculo> getEventos() {
return eventos;
}

public Integer getCapacidade() {
return capacidade;
}

public void setCapacidade(Integer capacidade) {
this.capacidade = capacidade;
}


}
