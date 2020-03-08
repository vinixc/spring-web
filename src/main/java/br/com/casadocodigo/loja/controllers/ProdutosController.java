package br.com.casadocodigo.loja.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.casadocodigo.loja.daos.ProdutoDAO;
import br.com.casadocodigo.loja.enums.TipoPreco;
import br.com.casadocodigo.loja.models.Produto;

@Controller
@RequestMapping("/produtos")
public class ProdutosController {
	
	@Autowired
	private ProdutoDAO produtoDAO;
	
	@RequestMapping("/form")
	public ModelAndView form() {
		ModelAndView view = new ModelAndView("produtos/form");
		view.addObject("tipos", TipoPreco.values());
		
		return view;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String gravar(Produto produto) {
		System.out.println(produto);
		produtoDAO.gravar(produto);
		return "produtos/ok";
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listar() {
		ModelAndView view = new ModelAndView("produtos/lista");
		List<Produto> produtos = produtoDAO.listar();
		view.addObject("produtos", produtos);
		return view;
	}

}
