package usuario;

import jogo.Jogo;

public class Noob extends Categoria {
	
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
	
}
