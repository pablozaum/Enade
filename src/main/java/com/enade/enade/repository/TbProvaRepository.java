package com.enade.enade.repository;

import org.springframework.data.repository.CrudRepository;

import com.enade.enade.models.TbProva;

public interface TbProvaRepository extends CrudRepository<TbProva, String> {
	TbProva findByIdProva(long idProva);

}
