/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alphacomercio;

import java.io.IOException;
import javax.swing.JOptionPane;


/**
 *
 * @author cleyslane
 */
public class AlphaComercio {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        int opc = 0;
        JOptionPane.showMessageDialog(null, "Carregando dados!");
        Objetos obj = new Objetos();
        obj.lerDados();

        while (opc != 3) {

            opc = Integer.parseInt(JOptionPane.showInputDialog("----Menu----"
                    + "\n1- Realizar busca por logradouros do bairro"
                    + "\n2- Realizar busca por CEP"
                    + "\n3- Sair do programa!"));

            switch (opc) {
                case 1:
                    
                    obj.buscarLogBairro();
                    
                    break;
                
                case 2:
                    String cep = JOptionPane.showInputDialog("Informe o CEP:");
                    obj.buscarCEP(cep);
                    break;
                    
                default:
                    JOptionPane.showMessageDialog(null, "Saindo do Sistema!");
                    System.exit(0);

            }

        }

    }

}
