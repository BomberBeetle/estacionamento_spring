package com.javalet.estacionamento.model;

import java.sql.Timestamp;

import com.javalet.estacionamento.model.*;
import com.javalet.estacionamento.model.enums.TipoServico;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Servico {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	Integer id;

	@ManyToOne
	Estacionamento estacionamento;
     
	@ManyToOne
	Usuario cliente;
     
    	@Enumerated(EnumType.STRING)
    	TipoServico tipo_servico;
    
	Timestamp inicio;
	
	Timestamp fim;
}
