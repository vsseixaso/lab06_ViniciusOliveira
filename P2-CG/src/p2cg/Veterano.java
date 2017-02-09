package p2cg;

public class Veterano extends Usuario {

	public Veterano(String nome, String id) throws Exception {
		super(nome, id);
		x2p = 1000;
	}
	
	@Override
	protected void compra(Jogo jogo, double desconto) throws Exception {
		super.compra(jogo, desconto);
		x2p += (15 * jogo.getPreco());
	}
	
	public void compra(Jogo jogo) throws Exception {
		compra(jogo, 0.2);
	}

}
