package p2cg;
import java.util.ArrayList;

import exceptions.JogoException;
import exceptions.ParametroVazioException;
import exceptions.ValorException;
import exceptions.ValorNegativoException;

public class Usuario {

	private static final String NL = "\n";
	
	private String nome;
	private String id;
	private ArrayList<Jogo> jogos;
	private double dinheiro;
	private Categoria categoria;
	private int x2p;
	
	public Usuario(String nome, String id) throws Exception {
		if (nome == null || nome.trim().equals(""))
			throw new ParametroVazioException("Nome do usuário não pode ser nulo ou vazio.");
		if (id == null || id.trim().equals(""))
			throw new ParametroVazioException("ID do usuário não pode ser nulo ou vazio.");
		this.nome = nome;
		this.id = id;
		categoria = new Noob();
		x2p = 0;
		dinheiro = 0;
		jogos = new ArrayList<Jogo>();
	}
	
	protected void compraJogo(Jogo jogo) throws Exception {
		double preco = jogo.getPreco() - (jogo.getPreco() * categoria.getDesconto());
		if (procuraJogo(jogo.getNome()) != null)
			throw new JogoException("O usuário já tem esse jogo.");
		if (preco > dinheiro)
			throw new ValorException("Dinheiro insuficiente para comprar esse jogo.");
		jogos.add(jogo);
		dinheiro -= preco;
		x2p += categoria.x2pCompra(jogo);
	}

	public Jogo procuraJogo(String nome) {
		Jogo jogo = null;
		for (int i = 0; i < jogos.size(); i++) {
			if (nome.equals(jogos.get(i).getNome()))
				jogo = jogos.get(i);
		}
		return jogo;
	}
	
	public void registraJogada(String nomeDoJogo, int score, boolean zerou) throws Exception {
		Jogo jogo = procuraJogo(nomeDoJogo);
		x2p += (jogo.registraJogada(score, zerou));
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getDinheiro() {
		return dinheiro;
	}

	public void addDinheiro(double dinheiro) {
		this.dinheiro += dinheiro;
	}

	public ArrayList<Jogo> getJogos() {
		return jogos;
	}
	
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria() {
		this.categoria = new Veterano();
	}

	public int getX2p() {
		return x2p;
	}

	public void setX2p(int x2p) {
		this.x2p = x2p;
	}

	public double precoTotal() {
		double precoTotal = 0;
		for (Jogo jogo : jogos) {
			precoTotal += jogo.getPreco();
		}
		return precoTotal;
	}

	@Override
	public String toString() {
		String stringCompleta = id + NL + nome + " - Jogador "
				+ getClass() + NL	+ "Lista de Jogos:" + NL;		
		
		for (Jogo jogo : jogos) {
			stringCompleta += jogo.toString();
		}
		stringCompleta += "Total de pre�o dos jogos: R$ " + precoTotal() + NL + NL
				+ "--------------------------------------------";
		
		return stringCompleta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
