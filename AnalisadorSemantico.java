//João Pedro do Couto

import java.util.*;

public class AnalisadorSemantico {
    private final Map<String, String> tabelaSimbolos = new HashMap<>();
    private boolean houveErro;

    public void analisar(List<NoAST> nos) {
        houveErro = false;

        for (NoAST no : nos) {
            if (no instanceof NoDeclaracao declaracao) {
                boolean valorValido = declaracao.valor instanceof NoNumero || declaracao.valor instanceof NoOperacao;

                if (declaracao.valor instanceof NoVariavel var) {
                    if (!tabelaSimbolos.containsKey(var.nome)) {
                        System.out.println("Erro: variável '" + var.nome + "' não declarada.");
                        houveErro = true;
                    } else {
                        valorValido = true;
                    }
                }

                if (!valorValido) {
                    System.out.println("Erro: valor inválido para declaração de " + declaracao.nome);
                    houveErro = true;
                }

                tabelaSimbolos.put(declaracao.nome, "int");
            } else if (no instanceof NoAtribuicao atribuicao) {
                if (!tabelaSimbolos.containsKey(atribuicao.nome)) {
                    System.out.println("Erro: variável '" + atribuicao.nome + "' não declarada.");
                    houveErro = true;
                }
                verificarExpressao(atribuicao.expressao);
            }
        }

        if (!houveErro) {
            System.out.println("Sem erros");
        }
    }

    private void verificarExpressao(NoAST expr) {
        if (expr instanceof NoNumero) return;

        if (expr instanceof NoVariavel var) {
            if (!tabelaSimbolos.containsKey(var.nome)) {
                System.out.println("Erro: variável '" + var.nome + "' não declarada.");
                houveErro = true;
            }
        } else if (expr instanceof NoOperacao op) {
            verificarExpressao(op.esquerdo);
            verificarExpressao(op.direito);
        }
    }
}