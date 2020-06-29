package com.enade.enade.repository;


import org.springframework.data.repository.CrudRepository;

import com.enade.enade.models.Convidado;
import com.enade.enade.models.Evento;

public interface ConvidadoRepository extends CrudRepository<Convidado, String>{
	Iterable<Convidado> findByEvento(Evento evento);
	Convidado findByRg(String rg);
}

