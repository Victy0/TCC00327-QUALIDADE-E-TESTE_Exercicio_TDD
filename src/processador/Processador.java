package processador;

import boleto.Boleto;
import fatura.Fatura;
import pagamento.Pagamento;

public class Processador {
	
	public Pagamento processa(Boleto boleto, Fatura fatura) {
		if(boleto != null && fatura != null) 
		{
			if(boleto.getValor().equals(fatura.getValorTotal())) 
			{
				Pagamento pagamento = new Pagamento();
				pagamento.setValorPago(fatura.getValorTotal());
				return pagamento;
			}
		}
		
		return null;
	}

}
