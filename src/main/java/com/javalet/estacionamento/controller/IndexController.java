package com.javalet.estacionamento.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.javalet.estacionamento.model.Usuario;

@Controller
public class IndexController{

	@Autowired
	UsuarioController usuarioController;

	@GetMapping("/")
	public ModelAndView index(@CookieValue(required = false) Integer usuario_id){
		ModelAndView model = new ModelAndView();

		

		if(usuario_id != null){
			Optional<Usuario> user = usuarioController.findById(usuario_id);
			System.out.println(user.get().getId_usuario());
			if(user.isPresent()){
				model.addObject("usuario", user.get());
			}
			else{
				model.addObject("usuario", new Usuario());
			}
		}
		else{
			model.addObject("usuario", new Usuario());
		}
		model.setViewName("index");

		return model;
	}
}
