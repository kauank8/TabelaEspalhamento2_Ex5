package model;

public class Conta {
	private int numeroConta;
	private String nome;
	private double saldo;
	
	//get e set
	public int getNumeroConta() {
		return numeroConta;
	}
	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	@Override
	public String toString() {
		return "Conta [numeroConta=" + numeroConta + ", nome=" + nome + ", saldo=" + saldo + "]";
	}
	

	
}
