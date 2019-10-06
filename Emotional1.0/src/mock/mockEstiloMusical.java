package mock;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;
import br.com.emotional.persistencia.EstiloMusicalDAO;

public class mockEstiloMusical {
	EstiloMusicalDAO teste = Mockito.mock(EstiloMusicalDAO.class);
	
	public void mockGetIdEstiloByNome() throws Exception {
		doThrow(new Exception()).when(teste).open();
		when(teste.getIdEstiloByNome(anyObject())).thenReturn(1);
	}
}
