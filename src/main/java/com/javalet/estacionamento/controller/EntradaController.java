package com.javalet.estacionamento.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.javalet.estacionamento.model.Estacionamento;
import com.javalet.estacionamento.model.EventoVeiculo;
import com.javalet.estacionamento.model.Usuario;
import com.javalet.estacionamento.model.Veiculo;
import com.javalet.estacionamento.model.enums.TipoEventoVeiculo;
import com.javalet.estacionamento.model.enums.TipoUsuario;

import jakarta.validation.Valid;

@Controller
public class EntradaController{

		@Autowired
		VeiculoController veiculoController;

		@Autowired
		UsuarioController usuarioController;

		@Autowired
		EstacionamentoController estacionamentoController;

		@Autowired
		EventoVeiculoController eventoVeiculoController;


		@PostMapping("/post_create_veiculo")
	public String postCreateVeiculo(@CookieValue(required = false) Integer estacionamento_id, @CookieValue Integer usuario_id, @ModelAttribute("veiculo") @Valid Veiculo veiculo, @RequestParam(value = "entry_event") String entryEvent, BindingResult result, Model model){
		Usuario user = usuarioController.findById(usuario_id).orElseThrow();
		if(result.hasErrors()){
			return "create_veiculo";
		}
		else{

			if(entryEvent.equals("true") && user.getTipo() == TipoUsuario.PORTEIRO){
				Veiculo new_vei = veiculoController.create(veiculo);		
				Estacionamento est = estacionamentoController.findById(estacionamento_id).orElseThrow();
				EventoVeiculo ev = new EventoVeiculo();
				ev.setVeiculo(new_vei);
				ev.setEstacionamento(est);
				ev.setTipo_evento(TipoEventoVeiculo.ENTRADA);
				eventoVeiculoController.create(ev);
				return "entrada_success";
			}
			else if(user.getTipo() == TipoUsuario.CLIENTE){
				veiculo.setCliente(user);
				veiculoController.create(veiculo);
				return "redirect:/registrar_servico";

			}
			return "redirect:/";
		}
	}
	
	@GetMapping("/entrada")
	public String registrarEntrada(@CookieValue Integer estacionamento_id, @CookieValue Integer usuario_id, Model model){
		if(usuarioController.findById(usuario_id).orElseThrow().getTipo() == TipoUsuario.PORTEIRO){
			
		      Optional<Estacionamento> est = estacionamentoController.findById(estacionamento_id);
			if(est.isPresent()){
				model.addAttribute("estacionamento", est.get());
				return "entrada_veiculo";
			}
			else return "redirect:/";
		};
		return "redirect:/";
	}
	@PostMapping("/entrada_placa")
	public String entradaPlaca(@CookieValue Integer estacionamento_id, @CookieValue Integer usuario_id, @RequestParam(value = "placa") String placa, Model model){
		Optional<Veiculo> vei_maybe = veiculoController.findByPlaca(placa);
		if(vei_maybe.isPresent()){
			Estacionamento est = estacionamentoController.findById(estacionamento_id).orElseThrow();
			Veiculo v = vei_maybe.get();
			EventoVeiculo ev = new EventoVeiculo();
			ev.setVeiculo(v);
			ev.setTipo_evento(TipoEventoVeiculo.ENTRADA);
			ev.setEstacionamento(est);
			eventoVeiculoController.create(ev);
			return "entrada_success";
		}
		else
		{
			model.addAttribute("context", "estacionamento_veiculo");
			model.addAttribute("estacionamento_id", estacionamento_id);
			model.addAttribute("placa_autofill", placa);
			model.addAttribute("entry_event", "true");
			Veiculo vei_autofilled = new Veiculo();
			vei_autofilled.setPlaca(placa);
			model.addAttribute("veiculo", vei_autofilled);
			return "create_veiculo";

		}
	}

}
