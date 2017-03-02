package jogo;

import java.util.HashSet;
import java.util.Set;

import exceptions.ValorException;
import exceptions.StringException;

public abstract class Jogo {
	public static final String FIM_DE_LINHA = System.lineSeparator();

	private String nome;
	private double preco;
	private int vezesJogadas;
	private int vezesConcluidas;
	private int maiorScore;
	private Set<Jogabilidade> jogabilidades;

	public Jogo(String nome, double preco, HashSet<Jogabilidade> jogabilidades)
			throws StringException, ValorException {

		if (nome == null || nome.trim().isEmpty()) {
			throw new StringException("Nome nao pode ser nulo ou vazio.");
		}
		if (preco < 0) {
			throw new ValorException("Preco nao pode ser negativo");
		}

		this.nome = nome;
		this.preco = preco;
		this.vezesConcluidas = 0;
		this.vezesJogadas = 0;
		this.maiorScore = 0;
		this.jogabilidades = jogabilidades;
	}

	public abstract int registraJogada(int score, boolean venceu);

	public double getPreco() {
		return this.preco;
	}

	public String getNome() {
		return this.nome;
	}

	public int getMaiorScore() {
		return this.maiorScore;
	}

	public void setMaiorScore(int novoScore) {
		this.maiorScore = novoScore;
	}

	public int getvezesConcluidas() {
		return this.vezesConcluidas;
	}

	public void setVezesConcluidas(int novaQuantidade) {
		this.vezesConcluidas = novaQuantidade;
	}

	public int getVezesJogadas() {
		return this.vezesJogadas;
	}

	public void setVezesJogadas(int novaQuantidade) {
		this.vezesJogadas = novaQuantidade;
	}

	public Set<Jogabilidade> getJogabilidades() {
		return jogabilidades;
	}

	public void setJogabilidades(Set<Jogabilidade> jogabilidades) {
		this.jogabilidades = jogabilidades;
	}

	@Override
	public String toString() {
		String resultado = "==> Jogou " + getVezesJogadas() + " vez(es)" + FIM_DE_LINHA;
		resultado += "==> Zerou " + getvezesConcluidas() + " vez(es)" + FIM_DE_LINHA;
		resultado += "==> Maior Score: " + getMaiorScore() + FIM_DE_LINHA;
		return resultado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		long temp;
		temp = Double.doubleToLongBits(preco);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Jogo other = (Jogo) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (Double.doubleToLongBits(preco) != Double
				.doubleToLongBits(other.preco))
			return false;
		return true;
	}

}
