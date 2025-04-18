//João Pedro do Couto

import java.util.ArrayList;
import java.util.List;

public class AnalisadorLexico {
    private final String entrada;
    private int pos = 0;

    public AnalisadorLexico(String entrada) {
        this.entrada = entrada;
    }

    public List<Token> analisar() {
        List<Token> tokens = new ArrayList<>();

        while (pos < entrada.length()) {
            char atual = entrada.charAt(pos);

            if (Character.isWhitespace(atual)) {
                pos++;
            } else if (entrada.startsWith("int", pos) && (pos + 3 == entrada.length() || !Character.isLetterOrDigit(entrada.charAt(pos + 3)))) {
                tokens.add(new Token(Token.Tipo.INT, "int"));
                pos += 3;
            } else if (Character.isLetter(atual)) {
                StringBuilder sb = new StringBuilder();
                while (pos < entrada.length() && (Character.isLetterOrDigit(entrada.charAt(pos)))) {
                    sb.append(entrada.charAt(pos++));
                }
                tokens.add(new Token(Token.Tipo.IDENT, sb.toString()));
            } else if (Character.isDigit(atual)) {
                StringBuilder sb = new StringBuilder();
                while (pos < entrada.length() && Character.isDigit(entrada.charAt(pos))) {
                    sb.append(entrada.charAt(pos++));
                }
                tokens.add(new Token(Token.Tipo.NUMERO, sb.toString()));
            } else if (atual == '+') {
                tokens.add(new Token(Token.Tipo.MAIS, "+"));
                pos++;
            } else if (atual == '-') {
                tokens.add(new Token(Token.Tipo.MENOS, "-"));
                pos++;
            } else if (atual == '=') {
                tokens.add(new Token(Token.Tipo.IGUAL, "="));
                pos++;
            } else if (atual == ';') {
                tokens.add(new Token(Token.Tipo.PONTO_VIRGULA, ";"));
                pos++;
            } else if (atual == '"') {
                // Ignora strings entre aspas para permitir erro semântico posteriormente
                pos++;
                StringBuilder sb = new StringBuilder();
                while (pos < entrada.length() && entrada.charAt(pos) != '"') {
                    sb.append(entrada.charAt(pos++));
                }
                pos++; // pular a segunda aspa
                tokens.add(new Token(Token.Tipo.IDENT, sb.toString()));
            } else {
                throw new RuntimeException("Caractere inválido: " + atual);
            }
        }

        tokens.add(new Token(Token.Tipo.EOF, ""));
        return tokens;
    }
}