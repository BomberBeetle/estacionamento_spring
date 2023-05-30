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
	@GeneratedValue(strategy=GenerationType.AUTO)
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
}
