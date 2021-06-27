package processador;

import java.util.List;

import boleto.Boleto;
import fatura.Fatura;
import pagamento.Pagamento;

public class Processador {
	
	public void processa(List<Boleto> boletos, Fatura fatura) {
		
		Double sumValorBoletos = boletos.stream().mapToDouble(Boleto::getValor).sum();
		
		for(Boleto boleto : boletos)
		{
		
			if(boleto != null && fatura != null) 
			{
				Pagamento pagamento = new Pagamento(boleto.getValor(), "BOLETO");
				fatura.addPagamento(pagamento);
			}
		}
		
		if(sumValorBoletos >= fatura.getValorTotal()) 
		{
			fatura.setPaga(true);
		}
		
	}

}
