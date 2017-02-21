package usuario;

import static org.junit.Assert.*;

import java.util.HashSet;

import jogo.Jogabilidade;
import jogo.Jogo;
import jogo.Tipo;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import usuario.Noob;

public class NoobTest {

	Noob noob;
	
	Jogo jogo1;
	HashSet<Jogabilidade> jogabilidade1;
	
	@Before
	public void criaJogo() throws Exception {
		noob = new Noob();
		jogabilidade1 = new HashSet<>();
		jogabilidade1.add(Jogabilidade.Offline);
		jogo1 = new Jogo("Super Mario", 18000, jogabilidade1, Tipo.PLATAFORMA);
	}
	
	@Test
	public void testX2pCompra() {
		Assert.assertEquals(180000, noob.x2pCompra(jogo1));
	}
	
	@Test
	public void getDesconto() {
		Assert.assertEquals(0.1, noob.getDesconto());
	}

}
