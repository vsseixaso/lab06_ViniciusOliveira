package p2cg;

public class Noob extends Usuario {
	
	private static final double DESCONTO = 0.1;
	
	public Noob(String nome, String id) throws Exception {
		super(nome, id);
		x2p = 0;
	}

	public double getDesconto() {
		return DESCONTO;
	}	
	
	public void x2pCompra(Jogo jogo) {
		x2p += (10 * jogo.getPreco());
	}
	
}
