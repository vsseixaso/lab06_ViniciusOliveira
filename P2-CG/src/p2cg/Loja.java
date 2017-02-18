package p2cg;

import java.util.ArrayList;
import java.util.HashSet;

import javax.xml.crypto.dsig.spec.ExcC14NParameterSpec;

public class Loja {

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
	 * @return . retorna nulo caso o usuario não exista ou retorna o usuario encontrado
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
	 * @param quantia . quantia à ser acrescentada
	 * @throws Exception . caso o usuario não exista lança exceção
	 */
	public void adicionaDinheiro(String id, double quantia) throws Exception {
		if (pesquisaUsuario(id) == null)
			throw new Exception("O usuÃ¡rio nÃ£o existe.");
		Usuario user = pesquisaUsuario(id);
		user.addDinheiro(quantia);
	}
		
	/**
	 * vende um jogo criado para um usuario, chamando o método de compraJogo(...) do Usuário
	 * 
	 * @param id . identificador único do usuário
	 * @param nomeJogo . parâmetro para ser passado para o construtor do Jogo
	 * @param preco  . parâmetro para ser passado para o construtor do Jogo
	 * @param jogabilidade . parâmetro para ser passado para o construtor do Jogo
	 * @param tipo . parâmetro para ser passado para o construtor do Jogo
	 * @throws Exception . lança exceção caso o usuário não exista
	 */
	public void vendeJogo(String id, String nomeJogo, double preco, HashSet<Jogabilidade> jogabilidade, Tipo tipo) throws Exception {
		if (pesquisaUsuario(id) == null)
			throw new Exception("O usuÃ¡rio nÃ£o existe.");
		Usuario user = pesquisaUsuario(id);
		Jogo jogo = new Jogo(nomeJogo, preco, jogabilidade, tipo);
		user.compraJogo(jogo);
	}
	
	/**
	 * faz o upgrade do usuário de Noob para Veterano caso ele já tenha no mínimo 1000 de x2p
	 * 
	 * @param id
	 * @throws Exception . caso o usuário não exista, ou já é veterano, ou não tem x2p suficiente (1000) lança exceção
	 */
	public void upgrade(String id) throws Exception {
		if (pesquisaUsuario(id) == null)
			throw new Exception("O usuÃ¡rio nÃ£o existe.");
		Usuario user = pesquisaUsuario(id);
		if (user.getCategoria() instanceof Veterano)
			throw new Exception("O usuÃ¡rio jÃ¡ Ã© Veterano.");
		if (user.getX2p() < 1000)
			throw new Exception("O usuÃ¡rio nÃ£o tem x2p suficiente.");
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
	 * duas lojas são iguais se tiverem a mesma lista de usuários
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Loja other = (Loja) obj;
		if (usuarios == null) {
			if (other.usuarios != null)
				return false;
		} else if (!usuarios.equals(other.usuarios))
			return false;
		return true;
	}
	
}