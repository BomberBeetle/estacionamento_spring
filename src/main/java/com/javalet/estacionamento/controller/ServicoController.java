package com.javalet.estacionamento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.javalet.estacionamento.model.Servico;
import com.javalet.estacionamento.model.Veiculo;
import com.javalet.estacionamento.model.repositories.ServicoRepository;

@Controller
public class ServicoController{
	
	@Autowired
	ServicoRepository servicoRepository;

	public Iterable<Servico> findActiveServicesByVeiculo(Veiculo vei){
		return servicoRepository.findActiveServicesByVeiculo(vei);
	}
}
