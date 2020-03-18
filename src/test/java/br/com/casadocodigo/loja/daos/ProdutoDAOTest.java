package br.com.casadocodigo.loja.daos;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import br.com.casadocodigo.loja.builders.ProdutoBuilder;
import br.com.casadocodigo.loja.conf.JPAConfiguration;
import br.com.casadocodigo.loja.enums.TipoPreco;
import br.com.casadocodigo.loja.models.Produto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {JPAConfiguration.class, ProdutoDAO.class})
public class ProdutoDAOTest {
	
	@Autowired
	private ProdutoDAO produtoDAO;
	
	@Test
	@Transactional
	public void deveSomarTodosPrecosPorTipoLivro() {
		
		List<Produto> livrosImpressos = ProdutoBuilder.newProduto(TipoPreco.IMPRESSO, BigDecimal.TEN).more(3).buildAll();
		
		List<Produto> livrosEbooks = ProdutoBuilder.newProduto(TipoPreco.EBOOK, BigDecimal.TEN).more(3).buildAll();
		
		livrosImpressos.stream().forEach(produtoDAO::gravar);
		livrosEbooks.stream().forEach(produtoDAO::gravar);
		
		
		BigDecimal valor = produtoDAO.somaPrecosPorTipo(TipoPreco.EBOOK);
		Assert.assertEquals(new BigDecimal(40).setScale(2), valor);
	}

}
