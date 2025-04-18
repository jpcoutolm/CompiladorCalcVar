public abstract class NoAST {}

class NoDeclaracao extends NoAST {
    public final String nome;
    public final NoAST valor;

    public NoDeclaracao(String nome, NoAST valor) {
        this.nome = nome;
        this.valor = valor;
    }

    public String toString() {
        return "Declaracao: int " + nome + " = " + valor;
    }
}

class NoAtribuicao extends NoAST {
    public final String nome;
    public final NoAST expressao;

    public NoAtribuicao(String nome, NoAST expressao) {
        this.nome = nome;
        this.expressao = expressao;
    }

    public String toString() {
        return "Atribuicao: " + nome + " = " + expressao;
    }
}

class NoNumero extends NoAST {
    public final int valor;

    public NoNumero(int valor) {
        this.valor = valor;
    }

    public String toString() {
        return Integer.toString(valor);
    }
}

class NoVariavel extends NoAST {
    public final String nome;

    public NoVariavel(String nome) {
        this.nome = nome;
    }

    public String toString() {
        return nome;
    }
}

class NoOperacao extends NoAST {
    public final String operador;
    public final NoAST esquerdo, direito;

    public NoOperacao(String operador, NoAST esquerdo, NoAST direito) {
        this.operador = operador;
        this.esquerdo = esquerdo;
        this.direito = direito;
    }

    public String toString() {
        return "(" + esquerdo + " " + operador + " " + direito + ")";
    }
}