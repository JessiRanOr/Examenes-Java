package com.client.rest.service;

import java.util.List;
import com.client.rest.model.Invitado;

public interface InvitadoService {

	public List<Invitado> getInvitados();

	public void saveInvitado(Invitado theInvitado);

	public Invitado getInvitado(int theId);

	public void deleteInvitado(int theId);
	
}
