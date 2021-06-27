package boleto;

import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import fatura.Fatura;


@DisplayName("Classe para teste do boleto")
public class BoletoTest {
	
	private Boleto boleto;
	
	@DisplayName("Testa a get/set da DATA")
	@Test
	public void testGetSetData() {
		Date data = new Date();
		boleto = new Boleto("XXXXXXXXXX", 50.0, new Date());	
		
		Assertions.assertEquals("XXXXXXXXXX", boleto.getCodigo());
		Assertions.assertEquals(50.0, boleto.getValor());
		Assertions.assertEquals(data, boleto.getData());		
	}

}
