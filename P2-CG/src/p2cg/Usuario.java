package p2cg;
import java.util.ArrayList;

import exceptions.JogoException;
import exceptions.ParametroVazioException;
import exceptions.ValorException;
import exceptions.ValorNegativoException;

public class Usuario {

	private String nome;
	private String id;
	private ArrayList<Jogo> jogos;
	private double dinheiro;
	protected int x2p;
	
	public Usuario(String nome, String id) throws Exception {
		if (nome == null || nome.trim().equals(""))
			throw new ParametroVazioException("Nome do usuário não pode ser nulo ou vazio.");
		if (id == null || id.trim().equals(""))
			throw new ParametroVazioException("ID do usuário não pode ser nulo ou vazio.");
		if (dinheiro < 0)
			throw new ValorNegativoException("Dinheiro do usuário não pode ser menor que zero.");
		this.nome = nome;
		this.id = id;
		dinheiro = 0;
		jogos = new ArrayList<Jogo>();
	}
	
	protected void compra(Jogo jogo, double desconto) throws Exception {
		double preco = jogo.getPreco() - (jogo.getPreco() * desconto);
		if (procura(jogo.getNome()) != null)
			throw new JogoException("O usuário já tem esse jogo.");
		desconto = jogo.getPreco()*0.1;
		if (preco > dinheiro)
			throw new ValorException("Dinheiro insuficiente para comprar esse jogo.");
		jogos.add(jogo);
		dinheiro -= preco;
	}
	
	public Jogo procura(String nome) {
		Jogo jogo = null;
		for (int i = 0; i < jogos.size(); i++) {
			if (nome.equals(jogos.get(i).getNome()))
				jogo = jogos.get(i);
		}
		return jogo;
	}
	
	public int registraJogada(String nomeDoJogo, int score, boolean zerou) {
		Jogo jogo = procura(nomeDoJogo);
		int x2p = jogo.registraJogada(score, zerou);
		return x2p;
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

	public void setDinheiro(double dinheiro) {
		this.dinheiro = dinheiro;
	}

	public ArrayList<Jogo> getJogos() {
		return jogos;
	}

	@Override
	public String toString() {
		return "Usuario [nome=" + nome + ", id=" + id + ", jogos=" + jogos
				+ ", dinheiro=" + dinheiro + "]";
	}
	
}
