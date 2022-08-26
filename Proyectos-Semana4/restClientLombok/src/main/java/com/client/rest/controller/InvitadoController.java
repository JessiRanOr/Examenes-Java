package com.client.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.client.rest.model.Invitado;
import com.client.rest.service.InvitadoService;

@Controller
@RequestMapping("/invitado")
public class InvitadoController {

	// need to inject our invitado service
	@Autowired
	private InvitadoService invitadoService;
	
	@GetMapping("/list")
	public String listInvitados(Model theModel) {
		
		// get invitados from the service
		List<Invitado> theInvitados = invitadoService.getInvitados();
				
		// add the invitados to the model
		theModel.addAttribute("invitados", theInvitados);
		
		return "list-invitados";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Invitado theInvitado = new Invitado();
		
		theModel.addAttribute("invitado", theInvitado);
		
		return "invitado-form";
	}
	
	@PostMapping("/saveInvitado")
	public String saveInvitado(@ModelAttribute("invitado") Invitado theInvitado) {
		
		// save the invitado using our service
		invitadoService.saveInvitado(theInvitado);	
		
		return "redirect:/invitado/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("invitadoId") int theId,
									Model theModel) {
		
		// get the invitado from our service
		Invitado theInvitado = invitadoService.getInvitado(theId);	
		
		// set invitado as a model attribute to pre-populate the form
		theModel.addAttribute("invitado", theInvitado);
		
		// send over to our form		
		return "invitado-form";
	}
	
	@GetMapping("/delete")
	public String deleteInvitado(@RequestParam("invitadoId") int theId) {
		
		// delete the invitado
		invitadoService.deleteInvitado(theId);
		
		return "redirect:/invitado/list";
	}
}










