package br.com.dankicommerce.controller;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.validation.Valid;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.interceptor.IncludeParameters;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.com.dankicommerce.dao.usuarioDAO;
import br.com.dankicommerce.model.Usuario;

@Controller
@Path("cadastrar")
public class CadastrarController {

	@Inject
	EntityManager em;
	@Inject
	Result result;
	@Inject 
	usuarioDAO usuarioDao;
	@Inject
	Validator validator;
	
	
	@Get("")
	public void cadastrar() {
	}
	
	@IncludeParameters
	@Post("salvaUsuario")
	public void salvaUsuario(@Valid Usuario usuario, String confirmaSenha) {
		boolean asSenhasSaoIguais = usuario.getSenha().equals(confirmaSenha);
		validator.ensure(asSenhasSaoIguais, new SimpleMessage("erro", "A confirmação de senha está errada"));
		validator.onErrorRedirectTo(this).cadastrar();
		// se tiver erro redireciona para o cadastro
		
		usuarioDao.insert(usuario);
		result.redirectTo(ProdutosController.class).produtos();
	}
}
