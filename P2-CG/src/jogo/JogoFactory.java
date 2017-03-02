package jogo;

import java.util.HashSet;

import exceptions.StringException;
import exceptions.ValorException;

public class JogoFactory {

	public Jogo criaJogo(String nome, double preco, String tipo, HashSet<Jogabilidade> jogabilidade) throws StringException, ValorException {
		if (tipo.equals("RPG")) {
			Jogo jogo = criaJogoRPG(nome, preco, jogabilidade);
			return jogo;
		} else if (tipo.equals("Plataforma")) {
			Jogo jogo = criaJogoPlataforma(nome, preco, jogabilidade);
			return jogo;
		} else if (tipo.equals("Luta")) {
			Jogo jogo = criaJogoLuta(nome, preco, jogabilidade);
			return jogo;
		}		
		return null;
	}
	
	private Jogo criaJogoRPG(String nome, double preco,	HashSet<Jogabilidade> jogabilidade) throws StringException, ValorException {
		Jogo jogo;
		jogo = new Rpg(nome, preco, jogabilidade);
		return jogo;
	}
	
	private Jogo criaJogoLuta(String nome, double preco, HashSet<Jogabilidade> jogabilidade) throws ValorException, StringException {
		Jogo jogo;
		jogo = new Plataforma(nome, preco, jogabilidade);
		return jogo;		
	}
	
	private Jogo criaJogoPlataforma(String nome, double preco, HashSet<Jogabilidade> jogabilidade) throws StringException, ValorException {
		Jogo jogo;
		jogo = new Luta(nome, preco, jogabilidade);
		return jogo;		
	}
	
}
