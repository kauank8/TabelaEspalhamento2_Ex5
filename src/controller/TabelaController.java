package controller;

import javax.swing.JOptionPane;

import br.com.KauanPaulino.ListaObject.Lista_Object;
import model.Conta;

public class TabelaController {
	Lista_Object[] vtlista = new Lista_Object[4];

	public TabelaController() {
		for (int i = 0; i < 4; i++) {
			vtlista[i] = new Lista_Object();
		}
	}
	//run
	public void run(int n) {
		switch (n) {
		case 1:
			inserir();
			break;
		case 2:
			consultar();
			break;
		case 3:
			excluir();
			break;
		default:
			break;
		}
	}

	private void inserir() {
		Conta c = new Conta();
		c.setNome(JOptionPane.showInputDialog("Digite o nome do cliente"));
		int tamanho = 0;
		do {
			c.setNumeroConta(Integer.parseInt(JOptionPane.showInputDialog("Digite o numero da conta, até 4 digitos")));
			String contaaux = Integer.toString(c.getNumeroConta());
			String[] vtconta = contaaux.split("");
			tamanho = vtconta.length;
		} while (tamanho > 4 || tamanho < 0);
		c.setSaldo(Double.parseDouble(JOptionPane.showInputDialog("Digite o saldo da conta")));
		GeraTabela(c);
	}

	private void GeraTabela(Conta c) {
		int n = c.getNumeroConta();
		int hash = Hashcode(n);
		if (vtlista[hash].isEmpty()) {
			vtlista[hash].addFirst(c);
		} else {
			try {
				vtlista[hash].addLast(c);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private int Hashcode(int n) {
		String contaaux = Integer.toString(n);
		String[] vtconta = contaaux.split("");
		int tamanho = vtconta.length;
		return tamanho - 1;
	}

	private void consultar() {
		int nConta = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero da conta"));
		int hash = Hashcode(nConta);
		Boolean status = false;

		if (hash == 1 || hash == 2 || hash == 0 || hash == 3) {
			int tamanho = vtlista[hash].size();
			for (int i = 0; i < tamanho; i++) {
				Conta c = new Conta();
				try {
					c = (Conta) vtlista[hash].get(i);
					if (c.getNumeroConta() == nConta) {
						System.out.println(c);
						status = true;
						break;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
			if (!status) {
				JOptionPane.showMessageDialog(null, "Conta não encontrada ou não existe");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Numero de digitos invalido");
		}
	}

	private void excluir() {
		int nConta = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero da conta que deseja excluir"));
		int hash = Hashcode(nConta);
		Boolean status = false;

		if (hash == 1 || hash == 2 || hash == 0 || hash == 3) {
			int tamanho = vtlista[hash].size();
			for (int i = 0; i < tamanho; i++) {
				Conta c = new Conta();
				try {
					c = (Conta) vtlista[hash].get(i);
					if (c.getNumeroConta() == nConta) {
						vtlista[hash].remove(i);
						System.out.println("A conta:" + nConta + " Foi excluida");
						status = true;
						break;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
			if (!status) {
				JOptionPane.showMessageDialog(null, "Conta não encontrada ou não existe");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Numero de digitos invalido");
		}
	}

}
