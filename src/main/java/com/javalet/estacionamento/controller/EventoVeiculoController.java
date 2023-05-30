package com.javalet.estacionamento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.javalet.estacionamento.model.EventoVeiculo;
import com.javalet.estacionamento.model.repositories.EventoVeiculoRepository;

@Controller
@RequestMapping(path="/veiculo_evento")
public class EventoVeiculoController{
		
	@Autowired
	private EventoVeiculoRepository eventosRepository;

	@GetMapping
	public List<EventoVeiculo> getEstacionamentoEventos(@PathVariable Integer estacionamentoID){
		return eventosRepository.findByEstacionamento_Id(estacionamentoID);

	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public EventoVeiculo create(@RequestBody EventoVeiculo evento){
		EventoVeiculo savedEvento = eventosRepository.save(evento);
		return savedEvento;
	}
}
