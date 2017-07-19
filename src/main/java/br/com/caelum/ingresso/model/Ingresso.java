package br.com.caelum.ingresso.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.com.caelum.ingresso.model.descontos.Desconto;

	@Entity
	public class Ingresso {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@ManyToOne
	private Sessao sessao;
	
	@ManyToOne
	private Lugar lugar;
	
	private BigDecimal preco;
	
	 /**
     * @deprecated hibernate only
     */
    public Ingresso() {

    }
	
	@Enumerated(EnumType.STRING)
	private TipoDeIngresso tipoDeIngresso;
	public Ingresso (Sessao sessao, TipoDeIngresso tipoDeDesconto, Lugar lugar){
		this.sessao = sessao;
		this.tipoDeIngresso = tipoDeDesconto;
		this.preco = tipoDeIngresso.aplicaDesconto(sessao.getPreco());
		this.lugar = lugar;
		
	}

	public Sessao getSessao(){
		return sessao;
	}
	public BigDecimal getPreco(){
		return preco;
	}
	public Lugar getLugar() {
		return lugar;
	}
}
