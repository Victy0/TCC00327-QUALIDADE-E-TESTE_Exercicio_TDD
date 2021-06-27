package boleto;

import java.util.Date;

public class Boleto {

	private String codigo;
	
	private Date data;
	
	private Double valor;
	
	public Boleto(String codigo, Double valor, Date data) {
		this.codigo = codigo;
		this.valor = valor;
		this.data= data;
	}

	public String getCodigo() {
		return codigo;
	}

	public Date getData() {
		return data;
	}

	public Double getValor() {
		return valor;
	}
	
}
