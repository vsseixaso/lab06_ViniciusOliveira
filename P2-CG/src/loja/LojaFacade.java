package loja;

import java.util.ArrayList;
import java.util.HashSet;

import exceptions.StringException;
import exceptions.ValorException;
import jogo.Jogabilidade;
import jogo.Jogo;
import usuario.Usuario;

public class LojaFacade {

	private LojaController lojaController;
	
	public void adicionaUsuario(Usuario user) {
		lojaController.adicionaUsuario(user);
	}
	
	public Usuario criaUsuario(String nome, String id, String categoria) throws Exception {
		return lojaController.criaUsuario(nome, id, categoria);
	}
	
	public Jogo criaJogo(String nome, double preco, HashSet<Jogabilidade> jogabilidade, String tipo) 
			throws StringException, ValorException {
		return lojaController.criaJogo(nome, preco, jogabilidade, tipo);
	}
	
	public Usuario pesquisaUsuario(String id) {
		return lojaController.pesquisaUsuario(id);
	}
	
	public void adicionaDinheiro(String id, double quantia) throws Exception {
		lojaController.adicionaDinheiro(id, quantia);
	}
	
	public void vendeJogo(String id, String nomeJogo, double preco, HashSet<Jogabilidade> jogabilidade, String tipo) 
			throws Exception {
		lojaController.vendeJogo(id, nomeJogo, preco, jogabilidade, tipo);
	}
	
	public void upgrade(String id) throws Exception {
		lojaController.upgrade(id);
	}
	
	public void downgrade(String id) throws Exception {
		lojaController.downgrade(id);
	}
	
	public ArrayList<Usuario> getUsuarios() {
		return lojaController.getUsuarios();
	}
	
}
