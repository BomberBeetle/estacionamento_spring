package com.javalet.estacionamento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.javalet.estacionamento.model.Estacionamento;
import com.javalet.estacionamento.model.repositories.EstacionamentoRepository;

@Controller
@RequestMapping("/estacionamento")
public class EstacionamentoController{
	
	@Autowired
	EstacionamentoRepository repository;

	@GetMapping("/getAll")
	public Iterable<Estacionamento> getAll(){
		return repository.findAll();
	}

	@GetMapping("/testEst")
	public ModelAndView testEst() {
		ModelAndView model = new ModelAndView();
		model.addObject("veics", getAll());
		model.setViewName("estacionamento_test");
		return model;
	}
}
