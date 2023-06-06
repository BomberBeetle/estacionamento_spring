package com.javalet.estacionamento.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.JsonPath;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.javalet.estacionamento.model.Estacionamento;
import com.javalet.estacionamento.model.repositories.EstacionamentoRepository;

@RestController
@RequestMapping("/estacionamento")
public class EstacionamentoController{
	
	@Autowired
	EstacionamentoRepository repository;

	@GetMapping("/getAll")
	public Iterable<Estacionamento> getAll(){
		return repository.findAll();
	}
	
	public Optional<Estacionamento> findById(@PathVariable Integer id){
		return repository.findById(id);
	}
	
	@GetMapping("/{id}")
	public Estacionamento findByIdJSON(@PathVariable Integer id){
		return repository.findById(id).orElseThrow();	
	}

	public Estacionamento save(Estacionamento e){
		return repository.save(e);
	}

	public Estacionamento updateTaxas(Estacionamento e){
		Estacionamento est = findById(e.getId()).orElseThrow();
		est.setTaxa_base(e.getTaxa_base());
		est.setTaxa_diaria(e.getTaxa_diaria());
		est.setTaxa_horaria(e.getTaxa_horaria());
		est.setTaxa_semanal(e.getTaxa_semanal());
		est.setTaxa_mensal(e.getTaxa_mensal());
		return save(est);
	}

	public Iterable<Estacionamento> findAll(){
		return repository.findAll();
	}
}
