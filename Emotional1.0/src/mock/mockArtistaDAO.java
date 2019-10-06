package mock;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;
import br.com.emotional.persistencia.ArtistaDAO;

public class mockArtistaDAO {

	ArtistaDAO teste = Mockito.mock(ArtistaDAO.class);
	

	@Test
	public void mockGetIdArtista() throws Exception {		
		doThrow(new Exception()).when(teste).open();
		when(teste.getIdArtistabyUsu(anyInt())).thenReturn(1);
	}

}
