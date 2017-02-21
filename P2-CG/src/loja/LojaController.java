package loja;

import java.util.ArrayList;
import java.util.HashSet;

import jogo.Jogabilidade;
import jogo.Jogo;
import jogo.Tipo;
import usuario.Usuario;
import usuario.Veterano;

public class LojaController {

	private static final String NL = "\n";
	
	private ArrayList<Usuario> usuarios = new ArrayList<>();
	
	/**
	 * adiciona um usuario na lista de usuarios
	 * 
	 * @param user . usuario recebido como parametro
	 */
	public void adicionaUsuario(Usuario user) {
		usuarios.add(user);
	}
	
	/**
	 * retorna usuario procurando no arrayList pelo id
	 * 
	 * @param . id identificador unico do usuario recebido como parametro
	 * @return . retorna nulo caso o usuario n�o exista ou retorna o usuario encontrado
	 */
	public Usuario pesquisaUsuario(String id) {
		for (Usuario usuario : usuarios) {
			if (id.equals(usuario.getId()))
				return usuario;					
		}
		return null;
	}
	
	/**
	 * adiciona dinheiro para um usuario
	 * 
	 * @param id
	 * @param quantia . quantia � ser acrescentada
	 * @throws Exception . caso o usuario n�o exista lan�a exce��o
	 */
	public void adicionaDinheiro(String id, double quantia) throws Exception {
		if (pesquisaUsuario(id) == null)
			throw new Exception("O usuário não existe.");
		Usuario user = pesquisaUsuario(id);
		user.addDinheiro(quantia);
	}
		
	/**
	 * vende um jogo criado para um usuario, chamando o m�todo de compraJogo(...) do Usu�rio
	 * 
	 * @param id . identificador �nico do usu�rio
	 * @param nomeJogo . par�metro para ser passado para o construtor do Jogo
	 * @param preco  . par�metro para ser passado para o construtor do Jogo
	 * @param jogabilidade . par�metro para ser passado para o construtor do Jogo
	 * @param tipo . par�metro para ser passado para o construtor do Jogo
	 * @throws Exception . lan�a exce��o caso o usu�rio n�o exista
	 */
	public void vendeJogo(String id, String nomeJogo, double preco, HashSet<Jogabilidade> jogabilidade, Tipo tipo) throws Exception {
		if (pesquisaUsuario(id) == null)
			throw new Exception("O usuário não existe.");
		Usuario user = pesquisaUsuario(id);
		Jogo jogo = new Jogo(nomeJogo, preco, jogabilidade, tipo);
		user.compraJogo(jogo);
	}
	
	/**
	 * faz o upgrade do usu�rio de Noob para Veterano caso ele j� tenha no m�nimo 1000 de x2p
	 * 
	 * @param id
	 * @throws Exception . caso o usu�rio n�o exista, ou j� � veterano, ou n�o tem x2p suficiente (1000) lan�a exce��o
	 */
	public void upgrade(String id) throws Exception {
		if (pesquisaUsuario(id) == null)
			throw new Exception("O usuário não existe.");
		Usuario user = pesquisaUsuario(id);
		if (user.getCategoria() instanceof Veterano)
			throw new Exception("O usuário já é Veterano.");
		if (user.getX2p() < 1000)
			throw new Exception("O usuário não tem x2p suficiente.");
		user.setCategoria();
	}

	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	@Override
	public String toString() {
		String stringCompleta = "=== Central P2-CG ===" + NL + NL;
		
		for (Usuario usuario : usuarios) {
			stringCompleta += usuario.toString();
		}
		return stringCompleta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((usuarios == null) ? 0 : usuarios.hashCode());
		return result;
	}

	/**
	 * duas lojas s�o iguais se tiverem a mesma lista de usu�rios
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LojaController other = (LojaController) obj;
		if (usuarios == null) {
			if (other.usuarios != null)
				return false;
		} else if (!usuarios.equals(other.usuarios))
			return false;
		return true;
	}
	
}