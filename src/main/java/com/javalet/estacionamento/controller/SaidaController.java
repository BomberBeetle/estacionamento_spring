package com.javalet.estacionamento.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.javalet.estacionamento.model.Estacionamento;
import com.javalet.estacionamento.model.EventoVeiculo;
import com.javalet.estacionamento.model.Veiculo;
import com.javalet.estacionamento.model.enums.TipoEventoVeiculo;
import com.javalet.estacionamento.model.enums.TipoUsuario;

@Controller
public class SaidaController{

	@Autowired
	UsuarioController usuarioController;

	@Autowired
	EstacionamentoController estacionamentoController;

	@Autowired
	VeiculoController veiculoController;

	@Autowired
	EventoVeiculoController eventoVeiculoController;
	
	@GetMapping("/saida")
	public ModelAndView saida(@CookieValue Integer usuario_id , @CookieValue Integer estacionamento_id){

		ModelAndView model = new ModelAndView();
		if(usuarioController.findById(usuario_id).orElseThrow().getTipo() == TipoUsuario.PORTEIRO){
			
		      Optional<Estacionamento> est = estacionamentoController.findById(estacionamento_id);
			if(est.isPresent()){
				model.addObject("estacionamento", est.get());
				model.setViewName("saida_veiculo");
				return model;
			}
			else{
				model.setViewName("redirect:/index");
				return model;
			}
		}
		model.setViewName("redirect:/index");
		return model;
	}

	@PostMapping("/saida_placa")
	public ModelAndView saida_placa(@CookieValue Integer estacionamento_id, @CookieValue Integer usuario_id, @RequestParam(value = "placa") String placa){
		ModelAndView model = new ModelAndView();
		Optional<Veiculo> vei_maybe = veiculoController.findByPlaca(placa);
		if(vei_maybe.isPresent()){
			Estacionamento est = estacionamentoController.findById(estacionamento_id).orElseThrow();
			Veiculo v = vei_maybe.get();
			EventoVeiculo ev = new EventoVeiculo();
			ev.setVeiculo(v);
			ev.setTipo_evento(TipoEventoVeiculo.SAIDA);
			ev.setEstacionamento(est);
			eventoVeiculoController.create(ev);
			model.setViewName("saida_success");
			return model;
		}
		else
		{
			Estacionamento est = estacionamentoController.findById(estacionamento_id).orElseThrow();
			model.addObject("estacionamento", est);
			model.setViewName("saida_veiculo");
			model.addObject("veiculo_not_found", "true");
			return model;

		}
	
	}
}
