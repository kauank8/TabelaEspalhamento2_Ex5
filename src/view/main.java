package view;

import javax.swing.JOptionPane;

import controller.TabelaController;

public class main {

	public static void main(String[] args) {
		int opc=0;
		TabelaController tb = new TabelaController();
		do {
			opc=Integer.parseInt(JOptionPane.showInputDialog("1-Inserir conta\n2-Consultar conta\n3-Excluir conta\n9-Finalizar"));
			switch(opc) {
			case 1: tb.run(opc);
					break;
			case 2: tb.run(opc);
			break;
			case 3: tb.run(opc);
			break;
			case 9: JOptionPane.showMessageDialog(null, "Sistema Finalizado");
			break;
			default : JOptionPane.showMessageDialog(null, "Opção Invalida");
			}
		}while(opc!=9);
	}

}
