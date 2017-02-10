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
	
}
