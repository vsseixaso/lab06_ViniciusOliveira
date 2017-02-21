package usuario;

import jogo.Jogo;

public class Veterano extends Categoria {

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

}
