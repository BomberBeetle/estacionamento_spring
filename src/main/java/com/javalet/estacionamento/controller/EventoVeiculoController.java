package com.javalet.estacionamento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

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
	
	@GetMapping("/entrada")
	public String registrarEntrada(@CookieValue Integer estacionamento_id, @CookieValue Integer usuario_id, Model model){
		if(usuarioController.findById(usuario_id).orElseThrow().getTipo() == TipoUsuario.PORTEIRO){
			if(estacionamentoController.findById(estacionamento_id).isPresent()) return "entrada_veiculo";
			else return "redirect:/index";
		};
		return "redirect:/index";
	}
}
