package mock;
import br.com.emotional.persistencia.MusicaDAO;
//import br.com.emotional.persistencia.PlaylistDAO;
import br.com.emotional.entidade.Musica;

import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.List;
import java.util.ArrayList;

//import org.mockito.junit.MockitoJUnitRunner;
import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mockito;
//import static org.mockito.Mockito.*;

import junit.framework.*;
import org.jacoco.*;

public class mockMusicaDAO {
	
	@Test
	public void teste() throws Exception {
		boolean expected = true;
		String input1 = "busca";
		MusicaDAO teste = Mockito.mock(MusicaDAO.class);		
		Musica musica1 = new Musica();
		
		musica1.setId_musica(5);		
		musica1.setId_artista(7);
		musica1.setId_emocao(2);
		musica1.setArquivo_musica("musicalização");
		musica1.setId_estilo_musical(3);
		
		System.out.println(musica1.getArquivo_musica());
		
		List<Musica> musicas = new ArrayList<Musica>();
		List<Musica> musicas2 = new ArrayList<Musica>();
		
		Musica musica2 = new Musica();
		Musica musica3 = new Musica();
		Musica musica4 = new Musica();
		
		musicas.add(musica1);
		musicas.add(musica2);
		musicas.add(musica3);
		musicas.add(musica4);
		
		imprime(musicas);
		System.out.println("/n 1 /n");
		doThrow(new Exception()).when(teste).open();
		when(teste.denunciarMusica(anyInt())).thenReturn(true);
		when(teste.getListaMusicasAprovadas("busca")).thenReturn(musicas);
		musicas2 = doReturn(musicas).when(teste).getListaMusicasAprovadas("busca");
		imprime(teste.getListaMusicasAprovadas("busca"));
		assertEquals("busca", teste.getListaMusicasAprovadas(input1));
		System.out.println("uuuuuuuuuuu");
		imprime(musicas);
	}
	
	public void imprime (List<Musica> lista) {
		for (int i =0; i< lista.size(); i++) {
			System.out.println(lista.get(i).getArquivo_musica());
		}
	}
	/*
	@Test
	public void testaSpy() {
		System.out.println("c/ spy");
		MusicaDAO teste = Mockito.mock(MusicaDAO.class);		
		Musica musica = new Musica();
		musica.setId_musica(5);
		doReturn(2).when(suntzu).dividePor5(10);
		suntzu.imprime(suntzu.soma3((suntzu.dividePor5(suntzu.multiplicaPor10(1)))));
	}
	
	
	
	
	
	
	
	--------
	
	
	

	*/

}