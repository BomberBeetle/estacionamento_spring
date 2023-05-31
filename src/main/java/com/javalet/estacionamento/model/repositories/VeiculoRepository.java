package com.javalet.estacionamento.model.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.javalet.estacionamento.model.Veiculo;

public interface VeiculoRepository extends CrudRepository<Veiculo, Integer>{
 public Optional<Veiculo> findByPlaca(String placa);
}
