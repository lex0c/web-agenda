package br.com.leo.agenda.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.leo.agenda.entity.Contato;

public class ContatoDAOTest {

	@Test
	@Ignore
	public void testSalvar(){
		Contato c = new Contato();
		c.setNome("Léo");
		c.setTelefone(991729408);
		c.setEmail("test@gmail.com");
		c.setSenhaWifi("af34w");
		new ContadoDAO().save(c);
	}
	
	@Test
	@Ignore
	public void testDelete(){
		new ContadoDAO().delete(1);
	}
	
	@Test
	@Ignore
	public void testUpdate(){
		Contato c = new Contato();
		c.setId(2);
		c.setNome("Léo");
		c.setTelefone(991729408);
		c.setEmail("test2@gmail.com");
		c.setSenhaWifi("af34w//");
		new ContadoDAO().update(c);
	}
	
	@Test
	@Ignore
	public void testList(){
		List<Contato> contatos = new ContadoDAO().listAll();
		for(Contato c:contatos){
			System.out.println(c.getNome());
		}
	}
	
	@Test
	@Ignore
	public void testFindById(){
		Contato c = new ContadoDAO().findById(2);
		System.out.println(c.getNome());
	}
	
	
	
}