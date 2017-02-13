package p2cg;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

public class UsuarioTest {

	private Usuario user;
	
	@Before
	public void criaUsuario() throws Exception {
		user = new Usuario("Vinícius Oliveira", "v.oliveira");
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
	
	@Test
	public void testCompraJogo() throws Exception {
		// criando jogo
		HashSet<Jogabilidade> jogabilidade = new HashSet<>();
		jogabilidade.add(Jogabilidade.Offline);
		Jogo jogo = new Jogo("Super Mario", 18000, jogabilidade, Tipo.PLATAFORMA);
		
		user.compraJogo(jogo);
	}

}
