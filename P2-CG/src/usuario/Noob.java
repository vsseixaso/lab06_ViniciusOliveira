package usuario;

import java.util.HashSet;

import jogo.Jogabilidade;
import jogo.Jogo;

public class Noob implements Categoria {
	
	private static final double DESCONTO = 0.1;

	/**
	 * retorna o DESCONTO para usu�rios Noob
	 */
	public double getDesconto() {
		return DESCONTO;
	}	
	
	/**
	 * calcula o x2p que o usu�rio Noob ganha na compra de um jogo e retorna
	 */
	public int x2pCompra(Jogo jogo) {
		int x2p;
		x2p = (int) (10 * jogo.getPreco());
		return x2p;
	}

	@Override
	public String toString() {
		return "Noob";
	}

	@Override
	public int punir(Jogo jogo, int scoreObtido, boolean zerou) {
		int x2p = 0;
		for (Jogabilidade jogabilidade : jogo.getJogabilidades()) {
			if (jogabilidade.equals("Online")) {
				x2p -= 10;
			} else if (jogabilidade.equals("Competitivo")) {
				x2p -= 20;
			} else if (jogabilidade.equals("Cooperatibo")) {
				x2p -= 50;
			}
		}
		return x2p;
	}

	@Override
	public int recompensar(Jogo jogo, int scoreObtido, boolean zerou) {
		int x2p = 0;
		for (Jogabilidade jogabilidade : jogo.getJogabilidades()) {
			if (jogabilidade.equals("Offline")) {
				x2p += 30;
			} else if (jogabilidade.equals("Multiplayer")) {
				x2p += 10;
			}
		}
		return x2p;
	}
	
}
