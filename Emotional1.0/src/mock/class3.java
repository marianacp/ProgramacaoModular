package mock;

import org.junit.experimental.theories.suppliers.TestedOn;
import org.mockito.Mock;
import org.mockito.Mockito;


import static org.mockito.Mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class class3 {
	
	
	public int multiplicaPor10(int valor) {
		System.out.println("mult 10");
		return valor*10;
	}
	
	public int dividePor5(int valor) {
		System.out.println("div 5");
		return valor-1;
	}
	public int soma3(int valor) {
		System.out.println("soma 3");
		return valor+3;
	}
	
	public void imprime (int valor) {
		System.out.println("imprime");
		System.out.println(valor);
	}
}


