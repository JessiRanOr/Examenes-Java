package com.javatechie.spring.batch.config;

import com.javatechie.spring.batch.entity.Invitado;
import org.springframework.batch.item.ItemProcessor;

public class InvitadoProcessor implements ItemProcessor<Invitado,Invitado> {

    @Override
    public Invitado process(Invitado invitado) throws Exception {
        if(invitado.getPais().equals("China")) {
            return invitado;
        }
        return null;
        
    }
}
