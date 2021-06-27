package processador;

import boleto.Boleto;
import fatura.Fatura;
import pagamento.Pagamento;

public class Processador {
	
	public Pagamento processa(Boleto boleto, Fatura fatura) {
		if(boleto != null && fatura != null) {
			return new Pagamento();
		}
		
		return null;
	}

}
