package jogo;

import java.util.Set;

import exceptions.ValorException;
import exceptions.StringException;

public class Luta extends Jogo{
	
	public Luta (String nome, double preco, Set<Jogabilidade> jogabilidades) throws StringException, ValorException {
		super(nome, preco, jogabilidades);
	}
	
	@Override
	public int registraJogada(int score, boolean venceu) {
		setVezesJogadas(getVezesJogadas()+ 1);
		if(score > this.getMaiorScore()){
			setMaiorScore(score);
		}
		if(venceu){
			setVezesConcluidas(getvezesConcluidas() + 1);
			
		}
		return score/1000;
	}
	
	public String toString() {
		String resultado = getNome() + " - Luta:" + FIM_DE_LINHA;
		resultado += super.toString();
		return resultado;
	}
}
