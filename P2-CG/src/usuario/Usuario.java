package usuario;

import java.util.ArrayList;

import jogo.Jogo;
import exceptions.JogoException;
import exceptions.StringException;
import exceptions.ValorException;

public class Usuario {

	private static final String NL = System.lineSeparator();
	
	private String nome;
	private String id;
	private ArrayList<Jogo> jogos;
	private double dinheiro;
	private Categoria categoria;
	private int x2p;
	
	/**
	 * cria o usu�rio e seta sua categoria como Noob e o dinheiro como 0
	 * 
	 * @param nome . nome do usuario
	 * @param id . id do usuario
	 * @throws Exception . lan�a exce��o para nome e id nulo/vazio
	 */
	public Usuario(String nome, String id) throws Exception {
		if (nome == null || nome.trim().equals(""))
			throw new StringException("Nome do usuário não pode ser nulo ou vazio.");
		if (id == null || id.trim().equals(""))
			throw new StringException("ID do usuário não pode ser nulo ou vazio.");
		this.nome = nome;
		this.id = id;
		categoria = new Noob();
		x2p = 0;
		dinheiro = 0;
		jogos = new ArrayList<Jogo>();
	}
	
	/**
	 * opera��o de compra de jogo, adiciona na lista do usuario, diminui do seu dinheiro o preco do jogo menos o desconto
	 * e adiciona x2p no seu perfil
	 * 
	 * @param jogo . recebe o jogo j� criado
	 * @throws Exception . lan�a exce��o caso o usu�rio ja tenha o jogo ou caso n�o tenha dinheiro suficiente
	 */
	public void compraJogo(Jogo jogo) throws Exception {
		double preco = jogo.getPreco() - (jogo.getPreco() * categoria.getDesconto());
		if (procuraJogo(jogo.getNome()) != null)
			throw new JogoException("O usuário já tem esse jogo.");
		if (preco > dinheiro)
			throw new ValorException("Dinheiro insuficiente para comprar esse jogo.");
		jogos.add(jogo);
		dinheiro -= preco;
		x2p += categoria.x2pCompra(jogo);
	}

	/**
	 * procura um jogo na lista de jogos do usu�rio
	 * 
	 * @param nome . nome do jogo que quer encontrar
	 * @return . retorna o jogo ou nulo (caso n�o exista na lista)
	 */
	public Jogo procuraJogo(String nome) {
		Jogo jogo = null;
		for (int i = 0; i < jogos.size(); i++) {
			if (nome.equals(jogos.get(i).getNome()))
				jogo = jogos.get(i);
		}
		return jogo;
	}
	
	public void recompensar(String nomeJogo, int scoreObtido, boolean zerou) {
		Jogo jogo = procuraJogo(nomeJogo);
		x2p += (jogo.registraJogada(scoreObtido, zerou));
		x2p += categoria.recompensar(jogo, scoreObtido, zerou);		
	}
	
	public void punir(String nomeJogo, int scoreObtido, boolean zerou) {
		Jogo jogo = procuraJogo(nomeJogo);
		x2p += (jogo.registraJogada(scoreObtido, zerou));
		x2p += categoria.punir(jogo, scoreObtido, zerou);
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

	public void upgrade() {
		this.categoria = new Veterano();
	}
	
	public void downgrade() {
		this.categoria = new Noob();
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
				+ categoria.toString() + NL	+ "Lista de Jogos:" + NL;		
		
		for (Jogo jogo : jogos) {
			stringCompleta += jogo.toString();
		}
		stringCompleta += "Total de preço dos jogos: R$ " + precoTotal() + NL + NL
				+ "--------------------------------------------" + NL + NL;
		
		return stringCompleta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/**
	 * define a igualdade de usuarios pelo id
	 */
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
