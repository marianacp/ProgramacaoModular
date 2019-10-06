package mock;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;
import br.com.emotional.persistencia.EmocaoDAO;
import br.com.emotional.entidade.Emocao;

public class mockEmocaoDAO {
	EmocaoDAO teste = Mockito.mock(EmocaoDAO.class);
	
	public void mockGetIdEmocaoByNome() throws Exception {		
		doThrow(new Exception()).when(teste).open();
		when(teste.getIdEmocaoByNome(anyObject())).thenReturn(1);
	}
	

}
