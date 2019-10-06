package mock;

import br.com.emotional.entidade.Usuario;
import br.com.emotional.persistencia.UsuarioDAO;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;
import java.util.List;
import java.util.ArrayList;

public class mockUsuarioDAO {
	UsuarioDAO teste = Mockito.mock(UsuarioDAO.class);
	
	public void mockBuscaPorCodigo() throws Exception {
		Usuario usuario = new Usuario();
		
		doThrow(new Exception()).when(teste).open();
		when(teste.buscaPorCodigo(anyObject())).thenReturn(usuario);
	}
	
	public void mockGetIdPorEmail() throws Exception{
		doThrow(new Exception()).when(teste).open();
		when(teste.getIdPorEmail(anyString())).thenReturn(1);
	}
	
	public void mockGetListaBuscaUsuario() throws Exception{
		List<Usuario> lista = new ArrayList<Usuario>();
		
		
		doThrow(new Exception()).when(teste).open();
		when(teste.getListaBuscaUsuario(anyString())).thenReturn(lista);
	}
	
	public void mockEstaAtivoporId() throws Exception{
		doThrow(new Exception()).when(teste).open();
		when(teste.estaAtivoporId(anyInt())).thenReturn(true);
	}
	
	

}
