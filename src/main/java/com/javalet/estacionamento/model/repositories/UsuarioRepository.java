package com.javalet.estacionamento.model.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.javalet.estacionamento.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer>{
	public Optional<Usuario> findByEmailAndSenha(String email, String senha);	
}
