package com.javatechie.spring.batch.repository;

import com.javatechie.spring.batch.entity.Invitado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvitadoRepository  extends JpaRepository<Invitado,Integer> {
}
