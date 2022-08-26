package com.luv2code.springboot.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springboot.cruddemo.entity.Invitado;
import com.luv2code.springboot.cruddemo.service.InvitadoService;

@RestController
@RequestMapping("/api")
public class InvitadoRestController {

	private InvitadoService invitadoService;
	
	@Autowired
	public InvitadoRestController(InvitadoService theInvitadoService) {
		invitadoService = theInvitadoService;
	}
	
	// expose "/invitados" and return list of invitados
	@GetMapping("/invitados")
	public List<Invitado> findAll() {
		return invitadoService.findAll();
	}

	// add mapping for GET /invitados/{invitadoId}
	
	@GetMapping("/invitados/{invitadoId}")
	public Invitado getInvitado(@PathVariable int invitadoId) {
		
		Invitado theInvitado = invitadoService.findById(invitadoId);
		
		if (theInvitado == null) {
			throw new RuntimeException("Invitado id not found - " + invitadoId);
		}
		
		return theInvitado;
	}
	
	// add mapping for POST /invitados - add new invitado
	
	@PostMapping("/invitados")
	public Invitado addInvitado(@RequestBody Invitado theInvitado) {
		
		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update
		
		theInvitado.setId(0);
		
		invitadoService.save(theInvitado);
		
		return theInvitado;
	}
	
	// add mapping for PUT /invitados - update existing invitado
	
	@PutMapping("/invitados")
	public Invitado updateInvitado(@RequestBody Invitado theInvitado) {
		
		invitadoService.save(theInvitado);
		
		return theInvitado;
	}
	
	// add mapping for DELETE /invitados/{invitadoId} - delete invitado
	
	@DeleteMapping("/invitados/{invitadoId}")
	public String deleteInvitado(@PathVariable int invitadoId) {
		
		Invitado tempInvitado = invitadoService.findById(invitadoId);
		
		// throw exception if null
		
		if (tempInvitado == null) {
			throw new RuntimeException("Invitado id not found - " + invitadoId);
		}
		
		invitadoService.deleteById(invitadoId);
		
		return "Deleted invitado id - " + invitadoId;
	}
	
}










