package fatura;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import pagamento.Pagamento;

public class Fatura {
	
	private Date data;
	
	private Double valorTotal;
	
	private String nomeCliente;
	
	private List<Pagamento> pagamentos = new ArrayList<Pagamento>();
	
	public Fatura(String nome, Double valor, Date data) {
		this.nomeCliente = nome;
		this.valorTotal = valor;
		this.data = data;
	}

	public Date getData() {
		return data;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}
	
	public void addPagamento(Pagamento pagamento) {
		this.pagamentos.add(pagamento);
	}
	
	public List<Pagamento> getPagamentos(){
		return this.pagamentos;
	}

}
