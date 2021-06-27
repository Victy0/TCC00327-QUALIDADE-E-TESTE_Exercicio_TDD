package pagamento;

public class Pagamento {
	
	private Double valorPago;
	
	private String tipoPagamento;
	
	public Pagamento(Double valorPago, String tipo) {
		this.valorPago = valorPago;
		this.tipoPagamento = tipo;
	}

	public Double getValorPago() {
		return valorPago;
	}

	public String getTipoPagamento() {
		return tipoPagamento;
	}

}
