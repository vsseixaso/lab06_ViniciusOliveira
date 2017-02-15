package p2cg;

import static org.junit.Assert.*;

import java.util.HashSet;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import exceptions.ValorException;

public class UsuarioTest {

	Usuario user;
	Jogo jogo;
	
	@Before
	public void criaUsuarioJogo() throws Exception {
		user = new Usuario("Vinícius Oliveira", "v.oliveira");
		
		HashSet<Jogabilidade> jogabilidade = new HashSet<>();
		jogabilidade.add(Jogabilidade.Offline);
		jogo = new Jogo("Super Mario", 20000, jogabilidade, Tipo.PLATAFORMA);
	}
	
	@Test(expected=Exception.class)
	public void testUsuarioNomeNull() throws Exception {
		user = new Usuario(null, "v.oliveira");
	}
	
	@Test(expected=Exception.class)
	public void testUsuarioNomeVazio() throws Exception {
		user = new Usuario("", "v.oliveira");
	}
	
	@Test(expected=Exception.class)
	public void testUsuarioIdNull() throws Exception {
		user = new Usuario("Vinícius Oliveira", null);
	}
	
	@Test(expected=Exception.class)
	public void testUsuarioIdVazio() throws Exception {
		user = new Usuario("Vinícius Oliveira", "");
	}	
	
	@Test(expected=ValorException.class)
	public void testCompraJogoSemDinheiro() throws Exception {
		user.compraJogo(jogo);
	}
	
	@Test
	public void testCompraJogo() throws Exception {				
		Assert.assertEquals(0, user.getDinheiro(), 0.01);
		Assert.assertEquals(0, user.getJogos().size());
		user.addDinheiro(60000);
		user.compraJogo(jogo);
		Assert.assertEquals(42000, user.getDinheiro(), 0.01);
		Assert.assertEquals(1, user.getJogos().size());
	}
	
	@Test
	public void testProcuraJogo() throws Exception {
		Assert.assertNull(user.procuraJogo("Super Mario"));
		
		user.getJogos().add(jogo);
		Assert.assertEquals(jogo, user.procuraJogo("Super Mario"));
	}
	
	@Test
	public void testRegistraJogada() throws Exception {
		user.addDinheiro(30000);
		user.compraJogo(jogo);
		
		Assert.assertEquals(200000, user.getX2p());
		user.registraJogada("Super Mario", 12000, true);
		Assert.assertEquals(200020, user.getX2p());
	}
	
	@Test
	public void testPrecoTotal() throws Exception {
		// cria jogo
		HashSet<Jogabilidade> jogabilidade = new HashSet<>();
		jogabilidade.add(Jogabilidade.Online);
		Jogo jogo1 = new Jogo("WoW", 30000, jogabilidade, Tipo.RPG);
	
		user.addDinheiro(60000);
		user.compraJogo(jogo);
		user.compraJogo(jogo1);
		
		Assert.assertEquals(50000, user.precoTotal(), 0.01);
	}
	
	@Test
	public void testToString() throws Exception {
		// cria jogo
		HashSet<Jogabilidade> jogabilidade = new HashSet<>();
		jogabilidade.add(Jogabilidade.Online);
		Jogo jogo1 = new Jogo("WoW", 30000, jogabilidade, Tipo.RPG);
		
		user.getJogos().add(jogo);
		user.getJogos().add(jogo1);
		
		String esperado = "v.oliveira\n"
				+ "Vinícius Oliveira - Jogador Noob\n"
				+ "Lista de Jogos:\n"
				+ "+ Super Mario - PLATAFORMA:\n"
				+ "==> Jogou 0 vez(es)\n"
				+ "==> Zerou 0 vez(es)\n"
				+ "==> Maior score: 0\n"
				+ "\n"
				+ "+ WoW - RPG:\n"
				+ "==> Jogou 0 vez(es)\n"
				+ "==> Zerou 0 vez(es)\n"
				+ "==> Maior score: 0\n"
				+ "\n"
				+ "Total de preço dos jogos: R$ 50000.0\n"
				+ "\n"
				+ "--------------------------------------------\n\n";
		
		Assert.assertEquals(esperado, user.toString());
	}
	
}
