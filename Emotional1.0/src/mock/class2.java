package mock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;

import java.lang.reflect.Constructor;

import org.mockito.junit.MockitoJUnitRunner;

public class class2 {
	
	@Test
	public void testaMetodoAlvoComMock() {
		System.out.println("c/ mock");
		class3 suntzu = Mockito.mock(class3.class);
		System.out.println("mock2");
		when(suntzu.dividePor5(anyInt())).thenReturn(2);
		System.out.println("mock3");
		suntzu.imprime(suntzu.dividePor5(suntzu.multiplicaPor10(1)));
		System.out.println("mock4");
		verify(suntzu);
		System.out.println("mock5");
	}
	
	@Test	
	public void testaMetodoAlvoSemMock() {
		System.out.println("s/ mock");
		class3 suntzu = new class3();
		suntzu.imprime(suntzu.soma3(suntzu.dividePor5(suntzu.multiplicaPor10(1))));
	}
	
	@Test
	public void testaSpy() {
		System.out.println("c/ spy");
		class3 suntzu = spy(class3.class);
		doReturn(2).when(suntzu).dividePor5(10);
		suntzu.imprime(suntzu.soma3((suntzu.dividePor5(suntzu.multiplicaPor10(1)))));
	}
	
}
