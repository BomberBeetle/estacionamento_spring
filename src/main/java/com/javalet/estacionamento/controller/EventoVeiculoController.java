package com.javalet.estacionamento.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.javalet.estacionamento.model.Estacionamento;
import com.javalet.estacionamento.model.EventoVeiculo;
import com.javalet.estacionamento.model.Usuario;
import com.javalet.estacionamento.model.Veiculo;
import com.javalet.estacionamento.model.enums.TipoEventoVeiculo;
import com.javalet.estacionamento.model.enums.TipoUsuario;
import com.javalet.estacionamento.model.repositories.EventoVeiculoRepository;

@Controller
@RequestMapping(path="/veiculo_evento")
public class EventoVeiculoController{
		
	@Autowired
	private EventoVeiculoRepository eventosRepository;
	
	@Autowired
	private VeiculoController veiculoController;

	@Autowired
	private UsuarioController usuarioController;

	@Autowired
	private EstacionamentoController estacionamentoController;

	@GetMapping
	public List<EventoVeiculo> getEstacionamentoEventos(@PathVariable Integer estacionamentoID){
		return eventosRepository.findByEstacionamento_Id(estacionamentoID);

	}

@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public EventoVeiculo create(@RequestBody EventoVeiculo evento){
		EventoVeiculo savedEvento = eventosRepository.save(evento);
		if(savedEvento.getTipoEvento() == TipoEventoVeiculo.ENTRADA) veiculoController.updateEstacionamento(savedEvento.getVeiculo(), savedEvento.getEstacionamento());	
		else if(savedEvento.getTipoEvento() == TipoEventoVeiculo.SAIDA){
			veiculoController.updateEstacionamento(savedEvento.getVeiculo(), null);		
		}
		return savedEvento;
	}


}
