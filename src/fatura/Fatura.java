package fatura;

import java.util.Date;

public class Fatura {
	
	private Date data;
	
	private Double valorTotal;
	
	private String nomeCliente;
	
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

}
