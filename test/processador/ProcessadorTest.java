package processador;

import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import boleto.Boleto;
import fatura.Fatura;
import pagamento.Pagamento;

public class ProcessadorTest {
	
	private Processador processador;
	
	@BeforeEach
	public void inicializa() {
		processador = new Processador();
	}
	
	@DisplayName("Testa se recebeu boleto e fatura e gerou pagamento validando valores")
	@Test
	public void testGeraPagamento() {
		
		Fatura fatura = new Fatura("Cliente", 50.0, new Date());
		
		Boleto boleto = new Boleto("XXXXXXXXXX", 50.0, new Date());
		
		Pagamento pagamento = processador.processa(boleto, fatura);
		Assertions.assertNotNull(pagamento);
		
		Assertions.assertEquals(50.0, boleto.getValor());
		Assertions.assertEquals(50.0, fatura.getValorTotal());
		Assertions.assertEquals(50.0, pagamento.getValorPago());
		 
	}
	
	@DisplayName("Testa se pagamento gerado é do tipo 'BOLETO'")
	@Test
	public void testTipoPagamentoGerado() {
		
		Fatura fatura = new Fatura("Cliente", 50.0, new Date());
		
		Boleto boleto = new Boleto("XXXXXXXXXX", 50.0, new Date());
		
		Pagamento pagamento = processador.processa(boleto, fatura);
		Assertions.assertNotNull(pagamento);
		
		Assertions.assertEquals("BOLETO", pagamento.getTipoPagamento());
		 
	}
	

}
