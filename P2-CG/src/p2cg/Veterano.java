package p2cg;

public class Veterano extends Usuario {

	private static final double DESCONTO = 0.2;
	
	public Veterano(String nome, String id) throws Exception {
		super(nome, id);
		x2p = 1000;
	}

	public double getDesconto() {
		return DESCONTO;
	}

}
