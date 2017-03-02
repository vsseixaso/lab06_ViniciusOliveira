package usuario;

import jogo.Jogo;

public interface Categoria {
	
	public int x2pCompra(Jogo jogo);

	public double getDesconto();

	public int punir(Jogo jogo, int scoreObtido, boolean zerou);

	public int recompensar(Jogo jogo, int scoreObtido, boolean zerou);
	
}
