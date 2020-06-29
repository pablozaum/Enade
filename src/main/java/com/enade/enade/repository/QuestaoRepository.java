package com.enade.enade.repository;

import org.springframework.data.repository.CrudRepository;

import com.enade.enade.models.TbQuestao;

public interface QuestaoRepository extends CrudRepository<TbQuestao, String>{
	TbQuestao findByIdQuestao(long idQuestao);
}
