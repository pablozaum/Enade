package com.enade.enade.repository;

import org.springframework.data.repository.CrudRepository;

import com.enade.enade.models.Evento;

public interface EventoRepository extends CrudRepository<Evento, String>{
	Evento findByCodigo(long codigo);
}
