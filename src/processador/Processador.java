package processador;

import boleto.Boleto;
import fatura.Fatura;
import pagamento.Pagamento;

public class Processador {
	
	public void processa(Boleto boleto, Fatura fatura) {
		
		if(boleto != null && fatura != null) 
		{
			Pagamento pagamento = new Pagamento(boleto.getValor(), "BOLETO");
			fatura.addPagamento(pagamento);
			
			if(boleto.getValor() >= fatura.getValorTotal()) 
			{
				fatura.setPaga(true);
			}
		}
		
	}

}
