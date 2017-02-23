package usuario;

public class UsuarioFactory {
	
	public Usuario criaUsuario(String nome, String id, String categoria) throws Exception {
		return new Usuario(nome, id);
	}
	
}
