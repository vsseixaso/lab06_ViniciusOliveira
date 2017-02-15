package p2cg;
import java.util.HashSet;

import exceptions.ParametroVazioException;
import exceptions.ValorNegativoException;


public class Jogo {

	private static final String NL = "\n";
	
	private String nome;
	private double preco;
	private int bestScore;
	private int vezesJogadas;
	private int vezesZeradas;
	private HashSet<Jogabilidade> jogabilidade;
	private Tipo tipo;
	
	/** 
	 * Construtor que recebe os par√¢metros que definem o jogo e lan√ßa exce√ß√£o para o par√¢metro
	 * 'nome' (caso esteja nulo ou vazio) e para o par√¢metro 'preco' (caso seja menor que zero).
	 * 
	 * @param nome . do jogo
	 * @param preco . do jogo
	 * @param jogabilidade . pode ter mais de uma jogabilidade, definidas com Enum em "Jogabilidade"
	 * @param tipo . apenas um È possÌvel, definido com Enum em "Tipo"
	 * @throws Exception . lanÁa exceÁıes para nome nulo/vazio e preco < 0
	 */
	public Jogo(String nome, double preco, HashSet<Jogabilidade> jogabilidade, Tipo tipo) throws Exception {
		if (nome == null || nome.trim().equals(""))
			throw new Exception("Nome n√£o pode ser nulo ou vazio.");
		if (preco < 0)
			throw new Exception("Pre√ßo n√£o pode ser menor que zero.");
		this.nome = nome;
		this.preco = preco;
		this.jogabilidade = jogabilidade;
		this.tipo = tipo;
		bestScore = 0;
		vezesJogadas = 0;
		vezesZeradas = 0;
	}
	
	/**
	 * registra a atual jogada feita pelo usuario no jogo this e retorna o x2p adquirido
	 * 
	 * @param score . pontuaÁ„o na jogada atual
	 * @param zerou . booleano, true zerou o jogo, false n„o zerou
	 * @return . retorna o x2p adquirido com a jogada atual
	 * @throws Exception . lanÁa exceÁ„o caso o jogo n„o foi criado ainda
	 */
	public int registraJogada(int score, boolean zerou) throws Exception {
		if (this == null)
			throw new Exception("O jogo n√£o foi inicializado.");
		
		int x2p = 0;
		vezesJogadas++;
		if (score > bestScore)
			if (tipo.equals(Tipo.LUTA)) {
				
				if (score <= 100000) {
					bestScore = score;
					double x2pLutaDouble = score/1000;
					int x2pLuta = (int) x2pLutaDouble;
					x2p += x2pLuta;
				}
			} else bestScore = score;	
			
		if (zerou)
			vezesZeradas++;
			if (tipo.equals(Tipo.PLATAFORMA))
				x2p += 20;
		
		if (tipo.equals(Tipo.RPG))
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

	public Tipo getTipo() {
		return tipo;
	}

	@Override
	public String toString() {
		return "+ " + nome + " - " + tipo + ":" + NL
				+ "==> Jogou " + vezesJogadas + " vez(es)" + NL
				+ "==> Zerou " + vezesZeradas + " vez(es)" + NL
				+ "==> Maior score: " + bestScore + NL + NL;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		return result;
	}

	/**
	 * define a igualdade de jogos pelo nome e tipo
	 */
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
		if (tipo != other.tipo)
			return false;
		return true;
	}
	
}
