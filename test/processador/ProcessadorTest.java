package processador;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import boleto.Boleto;
import fatura.Fatura;

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
		List<Boleto> boletos = new ArrayList<Boleto>();
		boletos.add(boleto);
		
		processador.processa(boletos, fatura);
		
		Assertions.assertEquals(1, fatura.getPagamentos().size());
		
		Assertions.assertEquals(50.0, boleto.getValor());
		Assertions.assertEquals(50.0, fatura.getValorTotal());
		Assertions.assertEquals(50.0, fatura.getPagamentos().get(0).getValorPago());
		 
	}
	
	@DisplayName("Testa se pagamento gerado � do tipo 'BOLETO'")
	@Test
	public void testTipoPagamentoGerado() {
		
		Fatura fatura = new Fatura("Cliente", 50.0, new Date());
		
		Boleto boleto = new Boleto("XXXXXXXXXX", 50.0, new Date());
		List<Boleto> boletos = new ArrayList<Boleto>();
		boletos.add(boleto);
		
		processador.processa(boletos, fatura);
		
		Assertions.assertEquals(1, fatura.getPagamentos().size());
		
		Assertions.assertEquals("BOLETO", fatura.getPagamentos().get(0).getTipoPagamento());
		
	}
	
	@DisplayName("Testa se valor do boleto � maior que da fatura e gera pagamento")
	@Test
	public void testBoletoMaiorFatura() {
		
		Fatura fatura = new Fatura("Cliente", 50.0, new Date());
		
		Boleto boleto = new Boleto("XXXXXXXXXX", 80.0, new Date());
		List<Boleto> boletos = new ArrayList<Boleto>();
		boletos.add(boleto);
		
		processador.processa(boletos, fatura);
		
		Assertions.assertEquals(1, fatura.getPagamentos().size());
		 
	}
	
	@DisplayName("Testa se pagamento est� vinculado a fatura e fatura est� paga")
	@Test
	public void testPagamentoAssociadoFatura() {
		
		Fatura fatura = new Fatura("Cliente", 50.0, new Date());
		
		Boleto boleto = new Boleto("XXXXXXXXXX", 50.0, new Date());
		List<Boleto> boletos = new ArrayList<Boleto>();
		boletos.add(boleto);
		
		processador.processa(boletos, fatura);
		
		Assertions.assertEquals(1, fatura.getPagamentos().size());
		
		Assertions.assertEquals(true, fatura.getPaga());
		 
	}
	
	@DisplayName("Testa se pagamento de valor baixo est� vinculado a fatura e fatura n�o est� paga")
	@Test
	public void testPagamentoAssociadoFaturaBoletoInferior() {
		
		Fatura fatura = new Fatura("Cliente", 50.0, new Date());
		
		Boleto boleto = new Boleto("XXXXXXXXXX", 40.0, new Date());
		List<Boleto> boletos = new ArrayList<Boleto>();
		boletos.add(boleto);
		
		processador.processa(boletos, fatura);
		
		Assertions.assertEquals(1, fatura.getPagamentos().size());
		
		Assertions.assertEquals(false, fatura.getPaga());
		 
	}
	
	@DisplayName("Testa se processa multiplos boletos e fatura est� paga")
	@Test
	public void testMultiplosBoletos() {
		
		Fatura fatura = new Fatura("Cliente", 50.0, new Date());
		
		Boleto boleto1 = new Boleto("XXXXXXXXXX", 40.0, new Date());
		Boleto boleto2 = new Boleto("YYYYYYYYYY", 50.0, new Date());
		
		List<Boleto> boletos = new ArrayList<Boleto>();
		boletos.add(boleto1);
		boletos.add(boleto2);
		
		processador.processa(boletos, fatura);
		
		Assertions.assertEquals(2, fatura.getPagamentos().size());
		
		Assertions.assertEquals(true, fatura.getPaga());
		 
	}
	

}
