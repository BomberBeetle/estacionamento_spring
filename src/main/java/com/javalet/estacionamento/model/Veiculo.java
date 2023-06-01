package com.javalet.estacionamento.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.javalet.estacionamento.model.enums.TipoVeiculo;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class Veiculo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	private Usuario cliente;

	@ManyToOne
	private Estacionamento estacionamento;

	private String cor;
	
	private String modelo;
	
	private String placa;
	
	@Enumerated(EnumType.STRING)
	private TipoVeiculo tipo;

	public void setEstacionamento(Estacionamento e){
		this.estacionamento = e;
	}

	public Integer getId(){
		return this.id;
	}

	public String getPlaca(){
		return this.placa;
	}

	public String getCor() {
	return cor;
	}

	public String getModelo() {
	return modelo;
	}
	
	public Usuario getCliente() {
	return cliente;
	}

	public TipoVeiculo getTipo() {
	return tipo;
	}

	public Estacionamento getEstacionamento() {
	return estacionamento;
	}

	public void setId(Integer id) {
	this.id = id;
	}

	public void setCor(String cor) {
	this.cor = cor;
	}

	public void setPlaca(String placa) {
	this.placa = placa;
	}

	public void setModelo(String modelo) {
	this.modelo = modelo;
	}
	
	public void setTipo(TipoVeiculo tipo) {
	this.tipo = tipo;
	}

	public void setCliente(Usuario cliente) {
	this.cliente = cliente;
	}
	
	
}
