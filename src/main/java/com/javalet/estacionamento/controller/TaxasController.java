package com.javalet.estacionamento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.javalet.estacionamento.model.Estacionamento;
import com.javalet.estacionamento.model.Usuario;
import com.javalet.estacionamento.model.enums.TipoUsuario;

@Controller
public class TaxasController{

	@Autowired
	UsuarioController usuarioController;

	@Autowired
	EstacionamentoController estacionamentoController;
	
	@GetMapping("/gerenciar_taxas")
	public ModelAndView gerenciar_taxas(@CookieValue Integer usuario_id, Estacionamento e, ModelAndView model){
		Usuario user = usuarioController.findById(usuario_id).orElseThrow();
		if(user.getTipo() == TipoUsuario.DIRETOR){

			Iterable<Estacionamento> estacionamentos = estacionamentoController.getAll();
			model.addObject("estacionamentos", estacionamentos);
			model.addObject("estacionamento", e);
			model.setViewName("gerenciar_taxas");
			return model;
		}
		else{
			System.out.println("gerenciar_taxas rejeitado id " + usuario_id + "tipo " + user.getTipo());
			model.setViewName("redirect:/");
			return model;
		}

	}

	@PostMapping("/update_estacionamento")
	public ModelAndView update_estacionamento(@CookieValue Integer usuario_id, @ModelAttribute Estacionamento estacionamento){
		Estacionamento estUpdated = estacionamentoController.updateTaxas(estacionamento);
		ModelAndView model = new ModelAndView();
		model.addObject("updateSuccess", true);
		return gerenciar_taxas(usuario_id, estUpdated, model);
	}
}
