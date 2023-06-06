package com.javalet.estacionamento.model.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.javalet.estacionamento.model.Veiculo;

public interface VeiculoRepository extends CrudRepository<Veiculo, Integer>{
	public Optional<Veiculo> findByPlaca(String placa);

	public List<Veiculo> findByCliente_Id(Integer cliente_id);
}
