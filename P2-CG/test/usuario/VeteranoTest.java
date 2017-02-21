package usuario;

import static org.junit.Assert.*;

import java.util.HashSet;

import jogo.Jogabilidade;
import jogo.Jogo;
import jogo.Tipo;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import usuario.Veterano;

public class VeteranoTest {

	Veterano veterano;
	
	Jogo jogo1;
	HashSet<Jogabilidade> jogabilidade1;
	
	@Before
	public void criaJogo() throws Exception {
		veterano = new Veterano();
		jogabilidade1 = new HashSet<>();
		jogabilidade1.add(Jogabilidade.Offline);
		jogo1 = new Jogo("Super Mario", 18000, jogabilidade1, Tipo.PLATAFORMA);
	}
	
	@Test
	public void testX2pCompra() {
		Assert.assertEquals(270000, veterano.x2pCompra(jogo1));
	}
	
	@Test
	public void getDesconto() {
		Assert.assertEquals(0.2, veterano.getDesconto());
	}
	
}
