package com.enade.enade.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.enade.enade.models.TbQuestao;
import com.enade.enade.models.TbTipoQuestao;
import com.enade.enade.repository.QuestaoRepository;

@Controller
public class QuestaoController {

	@Autowired
	private QuestaoRepository qr;
	
	
	@RequestMapping(value="/cadastrarQuestao", method=RequestMethod.GET)
	public String form(){
		return "formQuestao";
	}
	
	@RequestMapping(value="/cadastrarQuestao", method=RequestMethod.POST)
	public String form(TbQuestao questao, BindingResult result, RedirectAttributes attributes){
		if(result.hasErrors()){
			attributes.addFlashAttribute("mensagem", "Verifique os campos!");
			return "redirect:/cadastrarQuestao";
		}
		TbTipoQuestao q = new TbTipoQuestao();
		q.setIdTipoQuestao(1);
		q.setNomeTipoQuestaocol("objetiva");
		questao.setTbTipoQuestaoidTipoQuestao(q);
		questao.setIdQuestao(50);
		qr.save(questao);
		attributes.addFlashAttribute("mensagem", "Questão cadastrado com sucesso!");
		return "redirect:/cadastrarQuestao";
	}
	
//	@RequestMapping("/questoes")
//	public ModelAndView listaQuestoes(){
//		ModelAndView mv = new ModelAndView("listaquestoes");
//		Iterable<Tbquestao> questoes = qr.findAll();
//		mv.addObject("questoes", questoes);
//		return mv;
//	}
//	
//	@RequestMapping(value="/{idQuestao}", method=RequestMethod.GET)
//	public ModelAndView detalheQuestao(@PathVariable("idQuestao") Integer idQuestao){
//		Tbquestao questao = qr.findById(idQuestao);
//		ModelAndView mv = new ModelAndView("questao/detalhesQuestao");
//		mv.addObject("questao", questao);
//		
//		return mv;
//	}
//	
//	@RequestMapping("/deletarQuestao")
//	public String deletarQuestao(Integer idQuestao){
//		Tbquestao questao = qr.findById(idQuestao);
//		qr.delete(questao);
//		return "redirect:/questoes";
//	}
	
	
	
	
}	
