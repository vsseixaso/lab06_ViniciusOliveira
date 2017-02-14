package p2cg;

public class Veterano extends Categoria {

	private static final double DESCONTO = 0.2;

	public double getDesconto() {
		return DESCONTO;
	}
	
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
