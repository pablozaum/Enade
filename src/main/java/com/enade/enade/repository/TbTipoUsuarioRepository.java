package com.enade.enade.repository;


import org.springframework.data.repository.CrudRepository;

import com.enade.enade.models.TbTipoUsuario;

public interface TbTipoUsuarioRepository extends CrudRepository<TbTipoUsuario, String>{
	TbTipoUsuario findByIdTipoUsuario(long idTipoUsuario);
}