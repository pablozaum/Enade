package com.enade.enade.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.enade.enade.models.Evento;
import com.enade.enade.models.TbProva;
import com.enade.enade.models.TbTipoUsuario;
import com.enade.enade.models.TbUsuario;
import com.enade.enade.repository.TbProvaRepository;



@Controller
public class TbProvaController {

	@Autowired
	private TbProvaRepository pr;
	
	@RequestMapping(value="/cadastrarProva", method=RequestMethod.GET)
	public String form(){
		return "view/formProva";
	}
	
	@RequestMapping(value="/cadastrarProva", method=RequestMethod.POST)
	public String form(TbProva prova, BindingResult result, RedirectAttributes attributes){
		
		if(result.hasErrors()){
			attributes.addFlashAttribute("mensagem", "Verifique os campos!");
			return "redirect:/cadastrarProva";
		}
		
		pr.save(prova);
		attributes.addFlashAttribute("mensagem", "Evento cadastrado com sucesso!");
		return "redirect:/cadastrarProva";
	}
	
	@RequestMapping("/graficos")
	public ModelAndView graficos(){
		ModelAndView mv = new ModelAndView("graficos");
		int myNum1 = 25;
		int myNum2 = 75;
		mv.addObject("eventos1", myNum1);
		mv.addObject("eventos2", myNum2);

		return mv;
	}
	@RequestMapping("/tabelas")
	public ModelAndView tabelas(){
		ModelAndView mv = new ModelAndView("tabelas");
		int myNum1 = 40;
		int myNum2 = 60;
		mv.addObject("eventos1", myNum1);
		mv.addObject("eventos2", myNum2);

		return mv;
	}
}
