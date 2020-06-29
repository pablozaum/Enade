package com.enade.enade.repository;



import org.springframework.data.repository.CrudRepository;


import com.enade.enade.models.TbUsuario;

public interface TbUsuarioRepository extends CrudRepository<TbUsuario, String>{
	TbUsuario findByIdUsuario(long idUsuario);
}