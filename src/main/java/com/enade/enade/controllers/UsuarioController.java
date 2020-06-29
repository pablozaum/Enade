package com.enade.enade.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.enade.enade.models.TbTipoUsuario;
import com.enade.enade.models.TbUsuario;
import com.enade.enade.repository.TbTipoUsuarioRepository;
import com.enade.enade.repository.TbUsuarioRepository;

@Controller
public class UsuarioController {

	@Autowired
	private TbUsuarioRepository user;
	
	@Autowired
	private TbTipoUsuarioRepository userTipo;
	
	@RequestMapping(value="/cadastrarUsuario", method=RequestMethod.GET)
	public String form(){
		return "view/formUsuario";
	}
	
	@RequestMapping(value="/cadastrarUsuario", method=RequestMethod.POST)
	public String form(TbUsuario usuario, BindingResult result, RedirectAttributes attributes){
		
		if(result.hasErrors()){
			attributes.addFlashAttribute("mensagem", "Verifique os campos!");
			return "redirect:/cadastrarUsuario";
		}
		TbTipoUsuario tb = new TbTipoUsuario();
		tb.setIdTipoUsuario(2);
		tb.setNomeTipoUsuario("Aluno");
		usuario.setTbTipoUsuarioidTipoUsuario(tb);
		user.save(usuario);
		attributes.addFlashAttribute("mensagem", "Usuario cadastrado com sucesso!");
		return "redirect:/cadastrarUsuario";
	}
	
}	

