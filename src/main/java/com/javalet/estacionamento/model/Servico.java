package com.javalet.estacionamento.model;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import com.javalet.estacionamento.model.*;
import com.javalet.estacionamento.model.enums.TipoServico;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class Servico {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	Integer id;

	@NotNull
	@ManyToOne
	Estacionamento estacionamento;
     
	@NotNull
	@ManyToOne
	Veiculo veiculo;
     
    	@Enumerated(EnumType.STRING)
    	TipoServico tipo_servico;
  	
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	@NotNull
	LocalDateTime inicio;

	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	@NotNull
	LocalDateTime fim;

	public Integer getId() {
	return id;
	}

	public void setId(Integer id) {
	this.id = id;
	}

	public Estacionamento getEstacionamento() {
	return estacionamento;
	}

	public void setEstacionamento(Estacionamento estacionamento) {
	this.estacionamento = estacionamento;
	}

	public LocalDateTime getInicio() {
	return inicio;
	}
	
	public void setInicio(LocalDateTime inicio) {
	this.inicio = inicio;
	}

	public LocalDateTime getFim() {
	return fim;
	}

	public void setFim(LocalDateTime fim) {
	this.fim = fim;
	}

	public Veiculo getVeiculo() {
	return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
	this.veiculo = veiculo;
	}

	public TipoServico getTipo_servico() {
	return tipo_servico;
	}

	public void setTipo_servico(TipoServico tipo_servico) {
	this.tipo_servico = tipo_servico;
	}
}
