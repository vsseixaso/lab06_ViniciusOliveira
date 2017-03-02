package usuario;

import jogo.Jogabilidade;
import jogo.Jogo;

public class Veterano implements Categoria {

	private static final double DESCONTO = 0.2;

	/**
	 * retorna o DESCONTO para usu�rios Veterano
	 */
	public double getDesconto() {
		return DESCONTO;
	}	
	
	/**
	 * calcula o x2p que o usu�rio Veterano ganha na compra de um jogo e retorna esse valor
	 */
	public int x2pCompra(Jogo jogo) {
		int x2p;
		x2p = (int) (15 * jogo.getPreco());
		return x2p;
	}
	
	@Override
	public String toString() {
		return "Veterano";
	}

	@Override
	public int punir(Jogo jogo, int scoreObtido, boolean zerou) {
		int x2p = 0;
		for (Jogabilidade jogabilidade : jogo.getJogabilidades()) {
			if (jogabilidade.equals("Offline")) {
				x2p -= 20;
			} else if (jogabilidade.equals("Competitivo")) {
				x2p -= 20;
			}
		}
		return x2p;
	}

	@Override
	public int recompensar(Jogo jogo, int scoreObtido, boolean zerou) {
		int x2p = 0;
		for (Jogabilidade jogabilidade : jogo.getJogabilidades()) {
			if (jogabilidade.equals("Online")) {
				x2p += 10;
			} else if (jogabilidade.equals("Cooperativo")) {
				x2p += 20;
			}
		}
		return x2p;
	}

}
