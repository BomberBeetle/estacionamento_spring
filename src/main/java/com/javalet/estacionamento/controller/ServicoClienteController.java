 package com.javalet.estacionamento.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.javalet.estacionamento.model.Estacionamento;
import com.javalet.estacionamento.model.Usuario;
import com.javalet.estacionamento.model.Veiculo;

@Controller
public class ServicoClienteController{
	
	@Autowired
	UsuarioController usuarioController;

	@Autowired
	EstacionamentoController estacionamentoController;

	@Autowired
	VeiculoController veiculoController;

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

		model.setViewName("registrar_servico");
		return model;

	}

	@GetMapping("/registrar_veiculo")
	public ModelAndView registrarVeiculo(@CookieValue Integer usuario_id){
		ModelAndView model = new ModelAndView();
		model.addObject("veiculo", new Veiculo());
		model.addObject("entry_event", false);
		model.setViewName("create_veiculo");
		return model;
	}
}
