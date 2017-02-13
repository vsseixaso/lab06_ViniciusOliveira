package p2cg;

public class Noob extends Categoria {
	
	private static final double DESCONTO = 0.1;

	public double getDesconto() {
		return DESCONTO;
	}	
	
	public int x2pCompra(Jogo jogo) {
		int x2p;
		x2p = (int) (10 * jogo.getPreco());
		return x2p;
	}
	
}
