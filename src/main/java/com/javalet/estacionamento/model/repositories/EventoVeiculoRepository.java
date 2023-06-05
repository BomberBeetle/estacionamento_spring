package com.javalet.estacionamento.model.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.javalet.estacionamento.model.EventoVeiculo;

public interface EventoVeiculoRepository extends CrudRepository<EventoVeiculo, Integer>{
	List<EventoVeiculo> findByEstacionamento_Id(Integer estacionamento_id);

	Optional<EventoVeiculo> findFirstByVeiculo_IdOrderByDatahoraDesc(Integer veiculo_id);
}
