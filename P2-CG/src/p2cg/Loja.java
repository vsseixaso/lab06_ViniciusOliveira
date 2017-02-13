package p2cg;

import java.util.ArrayList;

import javax.xml.crypto.dsig.spec.ExcC14NParameterSpec;

public class Loja {

	private static final String NL = "\n";
	
	private ArrayList<Usuario> usuarios;
	
	public void adicionaUsuario(Usuario user) {
		usuarios.add(user);
	}
	
	public Usuario pesquisaUsuario(String id) {
		for (Usuario usuario : usuarios) {
			if (id.equals(usuario.getId()))
				return usuario;					
		}
		return null;
	}
	
	public void adicionaDinheiro(String id, double quantia) throws Exception {
		if (pesquisaUsuario(id) == null)
			throw new Exception("O usuário não existe.");
		Usuario user = pesquisaUsuario(id);
		user.addDinheiro(quantia);
	}
		
	public void vendeJogo(String id, Jogo jogo) throws Exception {
		if (pesquisaUsuario(id) == null)
			throw new Exception("O usuário não existe.");
		Usuario user = pesquisaUsuario(id);
		user.compraJogo(jogo);
	}
	
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