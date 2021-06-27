package processador;

import boleto.Boleto;
import fatura.Fatura;
import pagamento.Pagamento;

public class Processador {
	
	public Pagamento processa(Boleto boleto, Fatura fatura) {
		
		if(boleto != null && fatura != null) 
		{
			if(boleto.getValor() >= fatura.getValorTotal()) 
			{
				Pagamento pagamento = new Pagamento(boleto.getValor(), "BOLETO");
				fatura.addPagamento(pagamento);
				return pagamento;
			}
		}
		
		return null;
	}

}
