package model.entities;

import model.exceptions.DomainExceptions;

public class Conta {

	private Integer numero;
	private String nome;
	private Double saldo;
	private Double limiteSaldo;

	public Conta() {

	}

	public Conta(Integer numero, String nome, Double saldo, Double limiteSaldo) {
		this.numero = numero;
		this.nome = nome;
		this.saldo = saldo;
		this.limiteSaldo = limiteSaldo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getLimiteSaldo() {
		return limiteSaldo;
	}

	public void setLimiteSaldo(Double limiteSaldo) {
		this.limiteSaldo = limiteSaldo;
	}

	public Integer getNumero() {
		return numero;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void deposito(Double valor) {
		saldo += valor;
	}

	public void saque(Double valor) throws DomainExceptions {
		if (valor > saldo) {
			throw new DomainExceptions("Valor maior que saldo da conta!");
		}

		if (valor > limiteSaldo) {
			throw new DomainExceptions("Valor maior que limite cadastrado para saque!");
		}

		this.saldo -= valor;
	}
	
	@Override
	public String toString() {
		return "Número: " + numero
				+ "\nNome: " + nome
				+ "\nNovo saldo: " + saldo;
	}

}
