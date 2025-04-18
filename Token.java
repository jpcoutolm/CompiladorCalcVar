public class Token {
    public enum Tipo {
        INT, IDENT, IGUAL, MAIS, MENOS, NUMERO, PONTO_VIRGULA, EOF
    }

    public final Tipo tipo;
    public final String valor;

    public Token(Tipo tipo, String valor) {
        this.tipo = tipo;
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "[" + tipo + ": " + valor + "]";
    }
}