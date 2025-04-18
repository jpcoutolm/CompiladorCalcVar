//João Pedro do Couto

import java.util.*;

public class AnalisadorSintatico {
    private final List<Token> tokens;
    private int pos = 0;

    public AnalisadorSintatico(List<Token> tokens) {
        this.tokens = tokens;
    }

    private Token atual() {
        return tokens.get(pos);
    }

    private Token consumir() {
        return tokens.get(pos++);
    }

    public List<NoAST> analisar() {
        List<NoAST> nos = new ArrayList<>();
        while (atual().tipo != Token.Tipo.EOF) {
            if (atual().tipo == Token.Tipo.INT) {
                consumir(); // int
                String nome = consumir().valor; // ident
                consumir(); // =
                NoAST valor = parseExpressao();
                consumir(); // ;
                nos.add(new NoDeclaracao(nome, valor));
            } else {
                String nome = consumir().valor; // ident
                consumir(); // =
                NoAST expr = parseExpressao();
                consumir(); // ;
                nos.add(new NoAtribuicao(nome, expr));
            }
        }
        return nos;
    }

    private NoAST parseExpressao() {
        NoAST esquerdo = parseTermo();
        while (atual().tipo == Token.Tipo.MAIS || atual().tipo == Token.Tipo.MENOS) {
            String op = consumir().valor;
            NoAST direito = parseTermo();
            esquerdo = new NoOperacao(op, esquerdo, direito);
        }
        return esquerdo;
    }

    private NoAST parseTermo() {
        Token token = consumir();
        if (token.tipo == Token.Tipo.NUMERO) {
            return new NoNumero(Integer.parseInt(token.valor));
        } else {
            return new NoVariavel(token.valor);
        }
    }
}