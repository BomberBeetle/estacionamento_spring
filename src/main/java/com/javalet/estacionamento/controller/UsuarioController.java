package com.javalet.estacionamento.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javalet.estacionamento.model.Usuario;
import com.javalet.estacionamento.model.repositories.UsuarioRepository;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class UsuarioController{

	@Autowired
	UsuarioRepository usuarioRepository;

	public Optional<Usuario> findById(Integer id){
		return usuarioRepository.findById(id);
	}
	
	@GetMapping("/login")
	public ResponseEntity<?> login(@RequestBody String password, @RequestBody String login, HttpServletResponse response){
		
		Cookie userid = new Cookie("usuario_id", "1");
		Cookie estacionamentoid = new Cookie("estacionamento_id", "1");
		
		response.addCookie(userid);
		response.addCookie(estacionamentoid);

		return new ResponseEntity<>("owo whats this? *notices your usuario_id cookie*", HttpStatus.OK);
	}

	@GetMapping("/owogin")
	public ResponseEntity<?> login(HttpServletResponse response){
		
		Cookie userid = new Cookie("usuario_id", "1");
		Cookie estacionamentoid = new Cookie("estacionamento_id", "1");
		
		response.addCookie(userid);
		response.addCookie(estacionamentoid);

		return new ResponseEntity<>("owo whats this? *notices your usuario_id cookie*", HttpStatus.OK);
	}
}
