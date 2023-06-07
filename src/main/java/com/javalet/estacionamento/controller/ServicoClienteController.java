 package com.javalet.estacionamento.controller;

import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.javalet.estacionamento.model.Estacionamento;
import com.javalet.estacionamento.model.Usuario;
import com.javalet.estacionamento.model.Veiculo;
import com.javalet.estacionamento.model.Servico;

@Controller
public class ServicoClienteController{
	
	@Autowired
	ServicoController servicoController;

	@Autowired
	UsuarioController usuarioController;

	@Autowired
	EstacionamentoController estacionamentoController;

	@Autowired
	VeiculoController veiculoController;

	@PostMapping("/servico_post")
	public ModelAndView servico_post(@CookieValue Integer usuario_id, @ModelAttribute Servico servico,@RequestParam("tempo") Integer tempo){
	ModelAndView model = new ModelAndView();

	Estacionamento est = estacionamentoController.findById(servico.getEstacionamento().getId()).orElseThrow();

	double money;

	switch(servico.getTipo_servico()){
		case HORARIA:
			money = tempo*est.getTaxa_horaria();
			servico.setFim(ChronoUnit.HOURS.addTo(servico.getInicio(), Integer.toUnsignedLong(tempo)));	
			break;
		case DIARIA:
			money = tempo*est.getTaxa_diaria();
			servico.setFim(ChronoUnit.DAYS.addTo(servico.getInicio(), Integer.toUnsignedLong(tempo)));				
			break;
		case SEMANAL:
			money = tempo*est.getTaxa_semanal();
			servico.setFim(ChronoUnit.WEEKS.addTo(servico.getInicio(), Integer.toUnsignedLong(tempo)));		
			break;
		case MENSAL:
			money = tempo*est.getTaxa_mensal();
			servico.setFim(ChronoUnit.MONTHS.addTo(servico.getInicio(), Integer.toUnsignedLong(tempo)));		
			break;
		default:
			money = 0;
	}
	
	model.setViewName("pagto_servico");
	model.addObject("servico", servico);
	model.addObject("money", money);
	return model;
	}

	@GetMapping("/registrar_servico")
	public ModelAndView registrarServico(@CookieValue Integer usuario_id){
		ModelAndView model = new ModelAndView();
		Optional<Usuario> user_maybe = usuarioController.findById(usuario_id);

		if(user_maybe.isEmpty()){
			model.setViewName("redirect:/");
			return model;
		}

		Usuario user = user_maybe.get();

		List<Veiculo> veics_user = veiculoController.findByUser(user);
		Iterable<Estacionamento> estacionamentos = estacionamentoController.findAll();

		model.addObject("estacionamentos", estacionamentos);
		if(!veics_user.isEmpty())model.addObject("veiculos", veics_user);

		model.addObject("servico", new Servico());

		model.setViewName("registrar_servico");
		return model;

	}

	@GetMapping("/registrar_veiculo")
	public ModelAndView registrarVeiculo(@CookieValue Integer usuario_id){
		ModelAndView model = new ModelAndView();
		model.addObject("veiculo", new Veiculo());
		model.addObject("entry_event", false);
		model.addObject("tempo", 1);
		model.setViewName("create_veiculo");
		return model;
	}

	@PostMapping("/servico_pagamento_efetuado")
	public ModelAndView servico_pgto_efetuado(@ModelAttribute Servico servico){
		Servico savedServico = servicoController.save(servico);
		
		ModelAndView mev = new ModelAndView("servico_success" ,"servico", savedServico);

		return mev;
	}
}
