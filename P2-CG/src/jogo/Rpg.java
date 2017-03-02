package jogo;

import java.util.HashSet;

import exceptions.ValorException;
import exceptions.StringException;

public class Rpg extends Jogo{
	
	public final static int TAXA_XP2 = 10;
	
	public Rpg (String nome, double preco, HashSet<Jogabilidade> jogabilidades) throws StringException, ValorException {
		super(nome, preco, jogabilidades);
	}

	@Override
	public int registraJogada(int score, boolean venceu) {
		setVezesJogadas(getVezesJogadas()+ 1);
		if (score > this.getMaiorScore()) {
			setMaiorScore(score);
		}
		if (venceu) {
			setVezesConcluidas(getvezesConcluidas() + 1);
		}
		return TAXA_XP2;
	}
	
	public String toString() {
		String resultado = getNome() + " - RPG:" + FIM_DE_LINHA;
		resultado += super.toString();
		return resultado;
	}

}
