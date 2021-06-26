package boleto;

import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


@DisplayName("Classe para teste do boleto")
public class BoletoTest {
	
	private Boleto boleto;
	
	@BeforeEach
	public void inicializa() {
		boleto = new Boleto();
	}
	
	@DisplayName("Testa a get/set da DATA")
	@Test
	public void testGetSetData() {
		Date data = new Date();
		boleto.setData(data);		
		Assertions.assertEquals(data, boleto.getData());		
	}
	
	@DisplayName("Testa a get/set da VALOR")
	@Test
	public void testGetSetValorTotal() {
		boleto.setValor(50.0);
		Assertions.assertEquals(50.0, boleto.getValor());		
	}
	
	@DisplayName("Testa a get/set da NOME CLIENTE")
	@Test
	public void testGetSetNomeCliente() {
		boleto.setCodigo("0000000000000000000000015");
		Assertions.assertEquals("0000000000000000000000015", boleto.getCodigo());		
	}

}
