package processador;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import boleto.Boleto;
import fatura.Fatura;

public class ProcessadorTest {
	
	private Processador processador;
	
	@Test
	public void inicializa() {
		processador = new Processador();
		Assertions.assertNotNull(processador);
	}
	
	@DisplayName("Testa se recebeu boleto e fatura e gerou pagamento")
	@Test
	public void testGeraPagamento() {
		processador = new Processador();
		
		Fatura fatura = new Fatura();
		fatura.setValorTotal(50.0);
		fatura.setNomeCliente("Cliente");
		
		Boleto boleto = new Boleto();
		boleto.setValor(50.0);
		
		Pagamento pagamento = processador.processa(boleto, fatura);
		Assertions.assertNotNull(pagamento);
		 
	}
	

}
