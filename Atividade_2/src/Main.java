import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        //Desenvolva um programa que simule as funcionalidades de "desfazer" e "refazer" de um editor de texto simples. O
        //programa deve manter um histórico das operações realizadas pelo usuário e permitir que ele reverta ou reaplique
        //essas operações usando pilhas.

        EditorDeTexto editor = new EditorDeTexto();
        while(true) {
            int s = Integer.parseInt(JOptionPane.showInputDialog("****** Editor de Texto Java ****** \nEscolha uma opção: \n1 - Inserir \n2 - Remover \n3 - Desfazer \n4 - Refazer \n 5 - Sair"));

            switch (s) {
                case 1:
                    editor.inserir(JOptionPane.showInputDialog("Digite um texto inicial: "));
                    JOptionPane.showMessageDialog(null, editor.texto.toString());
                    break;
                case 2:
                    int caracteres = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de caracteres que deseja remover: "));
                    editor.remover(caracteres);
                    JOptionPane.showMessageDialog(null, editor.texto.toString());
                    break;
                case 3:
                    editor.desfazer();
                    JOptionPane.showMessageDialog(null, editor.texto.toString());
                    break;
                case 4:
                    editor.refazer();
                    JOptionPane.showMessageDialog(null, editor.texto.toString());
                    break;

                case 5:
                    int confirm = JOptionPane.showConfirmDialog(null, "Deseja encerrar o programa?");
                    if (confirm == JOptionPane.YES_OPTION) {
                        return;
                    }
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida.");
                    break;
            }
        }
    }
}
