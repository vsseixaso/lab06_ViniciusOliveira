package p2cg;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class LojaTest {

	Loja loja;
	Usuario user;
	
	@Before
	public void inicializa() throws Exception {
		loja = new Loja();
		user = new Usuario("Vinícius Oliveira", "v.oliveira");
	}
	
	@Test
	public void testAdicionaUser() {
		Assert.assertFalse(loja.getUsuarios().contains(user));
		loja.adicionaUsuario(user);
		Assert.assertTrue(loja.getUsuarios().contains(user));
	}
	
	@Test
	public void testPesquisaUser() throws Exception {
		Assert.assertNull(loja.pesquisaUsuario("v.oliveira"));
		Usuario user2 = new Usuario("Gabriel Souza", "g.souza");
		loja.adicionaUsuario(user);
		loja.adicionaUsuario(user2);
		Assert.assertEquals(user, loja.pesquisaUsuario("v.oliveira"));		
	}
	
	@Test(expected=Exception.class)
	public void testAddDinheiroUserNulo() throws Exception {
		loja.adicionaDinheiro("v.oliveira", 20000);
	}
	
	@Test
	public void testAddDinheiro() throws Exception {
		loja.adicionaUsuario(user);
		loja.adicionaDinheiro("v.oliveira", 20000);
		Assert.assertEquals(20000, user.getDinheiro(), 0.01);
	}
	
	@Test(expected=Exception.class)
	public void testVendeJogoUserNulo() throws Exception {
		HashSet<Jogabilidade> jogabilidade = new HashSet<>();
		loja.vendeJogo("v.oliveira", "Super Mario", 10000, jogabilidade, Tipo.PLATAFORMA);
	}
	
	@Test
	public void testVendeJogo() throws Exception {
		loja.adicionaUsuario(user);
		user.addDinheiro(20000);
		Assert.assertEquals(0, user.getJogos().size());
		
		HashSet<Jogabilidade> jogabilidade = new HashSet<>();
		loja.vendeJogo("v.oliveira", "Super Mario", 10000, jogabilidade, Tipo.PLATAFORMA);
		
		Assert.assertEquals(1, user.getJogos().size());
	}
	
	@Test(expected=Exception.class)
	public void testUpgradeUserNulo() throws Exception {
		loja.upgrade("v.oliveira");
	}
	
	@Test(expected=Exception.class)
	public void testUpgradeX2pInsuficiente() throws Exception {
		loja.adicionaUsuario(user);
		loja.upgrade("v.oliveira");
	}
	
	@Test(expected=Exception.class)
	public void testUpgradeVeterano() throws Exception {
		loja.adicionaUsuario(user);
		user.setX2p(3000);
		loja.upgrade("v.oliveira");
		loja.upgrade("v.oliveira");
	}
	
	@Test
	public void testUpgrade() throws Exception {
		loja.adicionaUsuario(user);
		user.setX2p(3000);
		loja.upgrade("v.oliveira");
	}
	
	@Test
	public void testToString() throws Exception {
		// cria usuario
		Usuario user2 = new Usuario("Gabriel Souza", "g.souza");
		
		// cria jogos
		HashSet<Jogabilidade> jogabilidade = new HashSet<>();
		jogabilidade.add(Jogabilidade.Online);
		Jogo jogo1 = new Jogo("WoW", 30000, jogabilidade, Tipo.RPG);
		HashSet<Jogabilidade> jogabilidade2 = new HashSet<>();
		jogabilidade2.add(Jogabilidade.Offline);
		Jogo jogo2 = new Jogo("Super Mario", 10000, jogabilidade2, Tipo.PLATAFORMA);
					
		loja.adicionaUsuario(user);
		loja.adicionaUsuario(user2);
		user.getJogos().add(jogo1);
		user.getJogos().add(jogo2);
		user2.getJogos().add(jogo1);
		
		System.out.println(loja.toString());
	}
	
}
