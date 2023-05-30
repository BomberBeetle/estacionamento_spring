package com.javalet.estacionamento.model;

import java.sql.Timestamp;

import com.javalet.estacionamento.model.*;
import com.javalet.estacionamento.model.enums.TipoEventoVeiculo;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class EventoVeiculo {
		
	private Timestamp datahora;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer id;

	@ManyToOne
	private Estacionamento estacionamento;
	
	@ManyToOne
	private Veiculo veiculo;
	
	@Enumerated(EnumType.STRING)
	TipoEventoVeiculo tipo_evento;
}
