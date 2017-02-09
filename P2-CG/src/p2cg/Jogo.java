package p2cg;
import java.util.HashSet;

import exceptions.ParametroVazioException;
import exceptions.ValorNegativoException;


public class Jogo {

	private String nome;
	private double preco;
	private int bestScore;
	private int vezesJogadas;
	private int vezesZeradas;
	private HashSet<Jogabilidade> jogabilidade;
	private Tipo tipo;
	
	/**
	 * Construtor do jogo.
	 */
	public Jogo(String nome, double preco, HashSet<Jogabilidade> jogabilidade, Tipo tipo) throws Exception {
		if (nome == null || nome.trim().equals(""))
			throw new ParametroVazioException("Nome não pode ser nulo ou vazio.");
		if (preco < 0)
			throw new ValorNegativoException("Preço não pode ser menor que zero.");
		this.nome = nome;
		this.preco = preco;
		this.jogabilidade = jogabilidade;
		this.tipo = tipo;
		bestScore = 0;
		vezesJogadas = 0;
		vezesZeradas = 0;
	}
	
	public int registraJogada(int score, boolean zerou) {
		int x2p = 0;
		int pontosLuta;
		if (score > bestScore)
			if (tipo.equals(tipo.LUTA)) {
				if (score <= 100000)
					bestScore = score;
					
			} else bestScore = score;	
			
		if (zerou == true)
			vezesZeradas++;
		
		if (tipo.equals(tipo.RPG))
			x2p += 10;			
			
		return x2p;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getNome() {
		return nome;
	}

	public int getBestScore() {
		return bestScore;
	}

	public int getVezesJogadas() {
		return vezesJogadas;
	}

	public int getVezesZeradas() {
		return vezesZeradas;
	}

	public HashSet<Jogabilidade> getJogabilidade() {
		return jogabilidade;
	}

	@Override
	public String toString() {
		return "Jogo [nome=" + nome + ", preco=" + preco + ", bestScore="
				+ bestScore + ", vezesJogadas=" + vezesJogadas
				+ ", vezesZeradas=" + vezesZeradas + ", jogabilidade="
				+ jogabilidade + "]";
	}
	
}
