package p2cg;

public class Noob extends Usuario {
	
	public Noob(String nome, String id) throws Exception {
		super(nome, id);
		x2p = 0;
	}
	
	@Override
	protected void compra(Jogo jogo, double desconto) throws Exception {
		super.compra(jogo, desconto);
		x2p += (10 * jogo.getPreco());
	}
	
	public void compra(Jogo jogo) throws Exception {
		compra(jogo, 0.1);
	}

}
