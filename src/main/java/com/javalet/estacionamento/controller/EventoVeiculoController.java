package com.javalet.estacionamento.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.javalet.estacionamento.model.EventoVeiculo;
import com.javalet.estacionamento.model.enums.TipoEventoVeiculo;
import com.javalet.estacionamento.model.repositories.EventoVeiculoRepository;

@Controller
public class EventoVeiculoController{
		
	@Autowired
	private EventoVeiculoRepository eventosRepository;
	
	@Autowired
	private VeiculoController veiculoController;

	@GetMapping
	public List<EventoVeiculo> getEstacionamentoEventos(@PathVariable Integer estacionamentoID){
		return eventosRepository.findByEstacionamento_Id(estacionamentoID);
	
	}

	public Optional<EventoVeiculo> getLatestEvent(Integer veiculo_id){
		return eventosRepository.findFirstByVeiculo_IdOrderByDatahoraDesc(veiculo_id);
	}
	
	public EventoVeiculo create(@RequestBody EventoVeiculo evento){
		EventoVeiculo savedEvento = eventosRepository.save(evento);
		if(savedEvento.getTipoEvento() == TipoEventoVeiculo.ENTRADA) veiculoController.updateEstacionamento(savedEvento.getVeiculo(), savedEvento.getEstacionamento());	
		else if(savedEvento.getTipoEvento() == TipoEventoVeiculo.SAIDA){
			veiculoController.updateEstacionamento(savedEvento.getVeiculo(), null);		
		}
		return savedEvento;
	}


}
