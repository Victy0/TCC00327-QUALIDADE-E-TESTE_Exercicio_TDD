package processador;

import boleto.Boleto;
import fatura.Fatura;
import pagamento.Pagamento;

public class Processador {
	
	public Pagamento processa(Boleto boleto, Fatura fatura) {
		
		if(boleto != null && fatura != null) 
		{
			if(boleto.getValor() > fatura.getValorTotal()) 
			{
				return new Pagamento(boleto.getValor(), "BOLETO");
			}
			if(boleto.getValor().equals(fatura.getValorTotal())) 
			{
				return new Pagamento(boleto.getValor(), "BOLETO");
			}
		}
		
		return null;
	}

}
