package com.client.rest.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.client.rest.model.Invitado;

@Service
public class InvitadoServiceRestClientImpl implements InvitadoService {

	private RestTemplate restTemplate;

	private String crmRestUrl;
		
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Autowired
	public InvitadoServiceRestClientImpl(RestTemplate theRestTemplate, 
										@Value("${crm.rest.url}") String theUrl) {
		
		restTemplate = theRestTemplate;
		crmRestUrl = theUrl;
				
		logger.info("Loaded property:  crm.rest.url=" + crmRestUrl);
	}
	
	@Override
	public List<Invitado> getInvitados() {
		
		logger.info("***OBTENER LISTA DE INVITADOS DESDE EL SERVICE REST INVITADO");
		logger.info("in getInvitados(): Calling REST API " + crmRestUrl);

		// make REST call
		ResponseEntity<List<Invitado>> responseEntity = 
											restTemplate.exchange(crmRestUrl, HttpMethod.GET, null, 
													 new ParameterizedTypeReference<List<Invitado>>() {});

		// get the list of invitados from response
		List<Invitado> invitados = responseEntity.getBody();

		logger.info("in getInvitados(): invitados" + invitados);
		
		return invitados;
	}

	@Override
	public Invitado getInvitado(int theId) {
		logger.info("***OBTENER UN INVITADO DESDE EL SERVICE REST INVITADO");

		logger.info("in getInvitado(): Calling REST API " + crmRestUrl);

		// make REST call
		Invitado theInvitado = 
				restTemplate.getForObject(crmRestUrl + "/" + theId, 
						Invitado.class);

		logger.info("in saveInvitado(): theInvitado=" + theInvitado);
		
		return theInvitado;
	}

	@Override
	public void saveInvitado(Invitado theInvitado) {

		logger.info("in saveInvitado(): Calling REST API " + crmRestUrl);
		
		int invitadoId = theInvitado.getId();

		// make REST call
		if (invitadoId == 0) {
			// add invitado
			logger.info("***SALVAR UN INVITADO DESDE EL SERVICE REST INVITADO");

			restTemplate.postForEntity(crmRestUrl, theInvitado, String.class);			
		
		} else {
			// update invitado
			logger.info("***ACTUALIZAR UN INVITADO DESDE EL SERVICE REST INVITADO");

			restTemplate.put(crmRestUrl, theInvitado);
		}

		logger.info("in saveInvitado(): success");	
	}

	@Override
	public void deleteInvitado(int theId) {
		logger.info("***BORRAR UN INVITADO DESDE EL SERVICE REST INVITADO");

		logger.info("in deleteInvitado(): Calling REST API " + crmRestUrl);

		// make REST call
		restTemplate.delete(crmRestUrl + "/" + theId);

		logger.info("in deleteInvitado(): deleted invitado theId=" + theId);
	}

}
