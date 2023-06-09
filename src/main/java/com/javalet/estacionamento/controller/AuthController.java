package com.javalet.estacionamento.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.javalet.estacionamento.model.Usuario;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class AuthController{

	@Autowired
	UsuarioController usuarioController;

	@GetMapping("/login")
	public ModelAndView login(){
		ModelAndView model = new ModelAndView();
		model.setViewName("login");
		model.addObject("user", new Usuario());
		return model;
	}

	@PostMapping("/post_login")
	public ModelAndView postLogin(@ModelAttribute Usuario user_creds, HttpServletResponse response){
		ModelAndView model = new ModelAndView();
		Optional<Usuario> user = usuarioController.login(user_creds.getEmail(), user_creds.getSenha());
		
		if(user.isEmpty()){
			System.out.println("spifdoisjafj");
			model.addObject("usr_notfound", true);
			model.setViewName("login");
		}
		else{
			Cookie usrid = new Cookie("usuario_id", user.get().getId_usuario().toString());
			usrid.setPath("/");

			response.addCookie(usrid);
			model.setViewName("redirect:/");
		}

		return model;
	}

	@GetMapping("/cadastro_cliente")
	public ModelAndView cadastroCliente(){
		ModelAndView model = new ModelAndView();
		model.setViewName("cadastro");

		return model;
	}

	@PostMapping("/post_cadastro_cliente")
	public ModelAndView postCadastroCliente(){
		ModelAndView model = new ModelAndView();

		return model;
	}
}
