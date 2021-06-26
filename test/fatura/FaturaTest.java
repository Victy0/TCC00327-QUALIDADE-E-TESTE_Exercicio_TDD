package fatura;

import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Classe para teste da fatura")
public class FaturaTest {
	
	private Fatura fatura;
	
	@BeforeEach
	public void inicializa() {
		fatura = new Fatura();
	}
	
	@DisplayName("Testa a get/set da DATA")
	@Test
	public void testGetSetData() {
		Date data = new Date();
		fatura.setData(data);		
		Assertions.assertEquals(data, fatura.getData());		
	}
	
	@DisplayName("Testa a get/set da VALOR TOTAL")
	@Test
	public void testGetSetValorTotal() {
		fatura.setValorTotal(50.0);
		Assertions.assertEquals(50.0, fatura.getValorTotal());		
	}
	
	@DisplayName("Testa a get/set da NOME CLIENTE")
	@Test
	public void testGetSetNomeCliente() {
		fatura.setNomeCliente("Fulano");	
		Assertions.assertEquals("Fulano", fatura.getNomeCliente());		
	}
}
