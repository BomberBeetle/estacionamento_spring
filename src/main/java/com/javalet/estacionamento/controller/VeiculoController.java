package com.javalet.estacionamento.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.javalet.estacionamento.model.Estacionamento;
import com.javalet.estacionamento.model.Veiculo;
import com.javalet.estacionamento.model.repositories.VeiculoRepository;

@Controller
public class VeiculoController{

	@Autowired
	VeiculoRepository veiculoRepository;

	public Optional<Veiculo> findById(Integer id){
		Optional<Veiculo> vei = veiculoRepository.findById(id);
		return vei;
	}

	public Optional<Veiculo> findByPlaca(String placa){
		return veiculoRepository.findByPlaca(placa);
	}

	public Veiculo create(Veiculo vei){
		return veiculoRepository.save(vei);
	}

	public void updateEstacionamento(Veiculo vei, Estacionamento e){
		vei.setEstacionamento(e);
		veiculoRepository.save(vei);
	}
}

