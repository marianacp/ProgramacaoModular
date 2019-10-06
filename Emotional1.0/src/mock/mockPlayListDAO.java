package mock;

import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;
import br.com.emotional.persistencia.PlaylistDAO;


public class mockPlayListDAO {
	PlaylistDAO teste = Mockito.mock(PlaylistDAO.class);
	
	public void mockInserirPlaylist() throws Exception{
		doThrow(new Exception()).when(teste).open();
		when(teste.inserirPlaylist(anyString(), anyInt())).thenReturn(true);
	}
	
	public void mockBuscaPlaylistDiariaporUs() throws Exception{
		doThrow(new Exception()).when(teste).open();
		when(teste.buscaPlaylistDiariaporUs(anyInt())).thenReturn(1);
	}
	
	public void mockGerarPlaylist() throws Exception{
		doThrow(new Exception()).when(teste).open();
		when(teste.getIdArtistabyUsu(anyInt())).thenReturn(1);
	}
}
