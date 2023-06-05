package com.javalet.estacionamento.model.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.javalet.estacionamento.model.Servico;
import com.javalet.estacionamento.model.Veiculo;

public interface ServicoRepository extends CrudRepository<Servico, Integer>{
	public Iterable<Servico> findAllByVeiculo(Veiculo vei);
	
	@Query("from Servico where veiculo = :veiculo and inicio <= current_timestamp() and fim >= current_timestamp()") 	
	public Iterable<Servico> findActiveServicesByVeiculo(@Param("veiculo") Veiculo veiculo);
}
