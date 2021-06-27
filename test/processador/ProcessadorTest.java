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
		
		processador.processa(boleto, fatura);
		
		Assertions.assertEquals(1, fatura.getPagamentos().size());
		
		Assertions.assertEquals(50.0, boleto.getValor());
		Assertions.assertEquals(50.0, fatura.getValorTotal());
		Assertions.assertEquals(50.0, fatura.getPagamentos().get(0).getValorPago());
		 
	}
	
	@DisplayName("Testa se pagamento gerado é do tipo 'BOLETO'")
	@Test
	public void testTipoPagamentoGerado() {
		
		Fatura fatura = new Fatura("Cliente", 50.0, new Date());
		
		Boleto boleto = new Boleto("XXXXXXXXXX", 50.0, new Date());
		
		processador.processa(boleto, fatura);
		
		Assertions.assertEquals(1, fatura.getPagamentos().size());
		
		Assertions.assertEquals("BOLETO", fatura.getPagamentos().get(0).getTipoPagamento());
		
	}
	
	@DisplayName("Testa se valor do boleto é maior que da fatura e gera pagamento")
	@Test
	public void testBoletoMaiorFatura() {
		
		Fatura fatura = new Fatura("Cliente", 50.0, new Date());
		
		Boleto boleto = new Boleto("XXXXXXXXXX", 80.0, new Date());
		
		processador.processa(boleto, fatura);
		
		Assertions.assertEquals(1, fatura.getPagamentos().size());
		 
	}
	
	@DisplayName("Testa se pagamento está vinculado a fatura e fatura está paga")
	@Test
	public void testPagamentoAssociadoFatura() {
		
		Fatura fatura = new Fatura("Cliente", 50.0, new Date());
		
		Boleto boleto = new Boleto("XXXXXXXXXX", 50.0, new Date());
		
		processador.processa(boleto, fatura);
		
		Assertions.assertEquals(1, fatura.getPagamentos().size());
		
		Assertions.assertEquals(true, fatura.getPaga());
		 
	}
	
	@DisplayName("Testa se pagamento de valor baixo está vinculado a fatura e fatura não está paga")
	@Test
	public void testPagamentoAssociadoFaturaBoletoInferior() {
		
		Fatura fatura = new Fatura("Cliente", 50.0, new Date());
		
		Boleto boleto = new Boleto("XXXXXXXXXX", 40.0, new Date());
		
		processador.processa(boleto, fatura);
		
		Assertions.assertEquals(1, fatura.getPagamentos().size());
		
		Assertions.assertEquals(false, fatura.getPaga());
		 
	}
	

}
