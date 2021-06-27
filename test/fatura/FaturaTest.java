package fatura;

import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Classe para teste da fatura")
public class FaturaTest {
	
	private Fatura fatura;
	
	@DisplayName("Testa a get/set da DATA")
	@Test
	public void testGetSetData() {
		Date data = new Date();
		fatura = new Fatura("Cliente", 50.0, data);	
		
		Assertions.assertEquals("Cliente", fatura.getNomeCliente());
		Assertions.assertEquals(50.0, fatura.getValorTotal());
		Assertions.assertEquals(data, fatura.getData());
	}
	
}
