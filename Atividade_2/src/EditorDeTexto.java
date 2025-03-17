import javax.swing.*;
import java.util.Stack;

public class EditorDeTexto {
    StringBuilder texto;
    private Stack<String> operacoes;
    private Stack<String> refazerOperacoes;

    public EditorDeTexto() {
        this.texto = new StringBuilder();
        this.operacoes = new Stack<>();
        this.refazerOperacoes = new Stack<>();
    }

    // Comando INSERIR
    public void inserir(String textoInserido) {
        operacoes.push("REMOVER " + textoInserido.length());
        texto.append(textoInserido);
        refazerOperacoes.clear();
    }


    public void remover(int n) {
        if (n > texto.length()) {
            n = texto.length();
        }
        String removido = texto.substring(texto.length() - n);
        operacoes.push("INSERIR " + removido);
        texto.delete(texto.length() - n, texto.length());
        refazerOperacoes.clear();
    }


    public void desfazer() {
        if (!operacoes.isEmpty()) {
            String ultimaOperacao = operacoes.pop();
            if (ultimaOperacao.startsWith("INSERIR")) {
                String textoInserido = ultimaOperacao.substring(8);
                remover(textoInserido.length());
                refazerOperacoes.push(ultimaOperacao);
            } else if (ultimaOperacao.startsWith("REMOVER")) {
                int n = Integer.parseInt(ultimaOperacao.substring(8));
                String textoRemovido = texto.substring(texto.length() - n);
                inserir(textoRemovido);
                refazerOperacoes.push(ultimaOperacao);
            }
        }
    }


    public void refazer() {
        if (!refazerOperacoes.isEmpty()) {
            String ultimaOperacao = refazerOperacoes.pop();
            if (ultimaOperacao.startsWith("INSERIR")) {
                String textoInserido = ultimaOperacao.substring(8);
                inserir(textoInserido);
                operacoes.push(ultimaOperacao);
            } else if (ultimaOperacao.startsWith("REMOVER")) {
                int n = Integer.parseInt(ultimaOperacao.substring(8));
                remover(n);
                operacoes.push(ultimaOperacao);
            }
        }
    }


}
