package jogo;

import java.util.HashSet;

import jogo.Jogabilidade;
import jogo.Jogo;
import jogo.Tipo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class JogoTest {

	Jogo jogo1;
	HashSet<Jogabilidade> jogabilidade1;
	
	@Before
	public void criaJogo() throws Exception {
		jogabilidade1 = new HashSet<>();
		jogabilidade1.add(Jogabilidade.Offline);
		jogo1 = new Jogo("Super Mario", 18000, jogabilidade1, Tipo.PLATAFORMA);
	}
	
	@Test
	public void testConstrutorWithException() throws Exception {
		try {
			jogo1 = new Jogo(null, 18000, jogabilidade1, Tipo.PLATAFORMA);
			Assert.fail("Lancamento de Exception com Nome nulo");

		} catch (Exception e) {
			Assert.assertEquals("Nome não pode ser nulo ou vazio.", e.getMessage());
		}
		
		try {
			Jogo jogo2 = new Jogo("", 18000, jogabilidade1, Tipo.PLATAFORMA);
			Assert.fail("Lancamento de Exception com Nome vazio");

		} catch (Exception e) {
			Assert.assertEquals("Nome não pode ser nulo ou vazio.", e.getMessage());
		}
		
		try {
			Jogo jogo3 = new Jogo("Super Mario", -1, jogabilidade1, Tipo.PLATAFORMA);
			Assert.fail("Lancamento de Exception com Preço negativo");

		} catch (Exception e) {
			Assert.assertEquals("Preço não pode ser menor que zero.", e.getMessage());
		}
	}

	@Test
	public void testRegistraJogada1() throws Exception {
		jogo1.registraJogada(20000, false);
		Assert.assertEquals(20000, jogo1.getBestScore());
		Assert.assertEquals(0, jogo1.getVezesZeradas());
		Assert.assertEquals(1, jogo1.getVezesJogadas());
		
		jogo1.registraJogada(22000, true);
		Assert.assertEquals(22000, jogo1.getBestScore());
		Assert.assertEquals(1, jogo1.getVezesZeradas());
		Assert.assertEquals(2, jogo1.getVezesJogadas());
		
		jogo1.registraJogada(21000, false);
		Assert.assertEquals(22000, jogo1.getBestScore());
		Assert.assertEquals(1, jogo1.getVezesZeradas());
		Assert.assertEquals(3, jogo1.getVezesJogadas());
		
		Assert.assertEquals(20, jogo1.registraJogada(15000, true));
	}
	
	@Test
	public void testRegistraJogada2() throws Exception {
		// criando novo jogo
		HashSet<Jogabilidade> jogabilidade2 = new HashSet<>();
		jogabilidade2.add(Jogabilidade.Cooperativo);
		jogabilidade2.add(Jogabilidade.Online);
		Jogo jogo2 = new Jogo("World of Warcraft", 20000, jogabilidade2, Tipo.RPG);

		Assert.assertEquals(10, jogo2.registraJogada(10000, false));
		Assert.assertEquals(10, jogo2.registraJogada(10000, true));
	}
	
	@Test
	public void testRegistraJogada3() throws Exception {
		// criando novo jogo		
		HashSet<Jogabilidade> jogabilidade3 = new HashSet<>();
		jogabilidade3.add(Jogabilidade.Competitivo);
		jogabilidade3.add(Jogabilidade.Offline);
		jogabilidade3.add(Jogabilidade.Multiplayer);
		Jogo jogo3 = new Jogo("Street Fight 2", 15000, jogabilidade3, Tipo.LUTA);
		
		jogo3.registraJogada(800, false);
		Assert.assertEquals(800, jogo3.getBestScore());
		Assert.assertEquals(0, jogo3.getVezesZeradas());
		Assert.assertEquals(1, jogo3.getVezesJogadas());
		
		Assert.assertEquals(0, jogo3.registraJogada(900, true));
		Assert.assertEquals(3, jogo3.registraJogada(3200, true));
		Assert.assertEquals(0, jogo3.registraJogada(3200, true));
		Assert.assertEquals(100, jogo3.registraJogada(100000, true));
		Assert.assertEquals(0, jogo3.registraJogada(100001, true));
	}
	
	@Test
	public void testEqualsJogo() throws Exception {	
		HashSet<Jogabilidade> jogabilidade = new HashSet<>();
		Jogo jogo2 = new Jogo("Street Fight 2", 15000, jogabilidade, Tipo.LUTA);
		Assert.assertFalse(jogo1.equals(jogo2));

		Jogo jogo3 = new Jogo("Super Mario", 15000, jogabilidade, Tipo.RPG);
		Assert.assertFalse(jogo1.equals(jogo3));

		Jogo jogo4 = new Jogo("Super Mario World", 15000, jogabilidade, Tipo.PLATAFORMA);
		Assert.assertFalse(jogo1.equals(jogo4));

		Jogo jogo5 = new Jogo("Super Mario", 15000, jogabilidade, Tipo.PLATAFORMA);
		Assert.assertTrue(jogo1.equals(jogo5));
		
		Jogo jogo6 = new Jogo("Super Mario", 18000, jogabilidade, Tipo.PLATAFORMA);
		Assert.assertTrue(jogo1.equals(jogo6));
	}
	
	@Test
	public void testToString() {
		String esperado = "+ Super Mario - PLATAFORMA:\n"
				+ "==> Jogou 0 vez(es)\n"
				+ "==> Zerou 0 vez(es)\n"
				+ "==> Maior score: 0\n\n";
		Assert.assertEquals(esperado, jogo1.toString());
	}
	
}
