//João Pedro do Couto

import java.util.List;

public class CompiladorCalcVar {
    public static void main(String[] args) {
        String codigo = """
             int x = "texto";\s
             x = x + 1;
""";



        // Léxico
        AnalisadorLexico lexico = new AnalisadorLexico(codigo);
        List<Token> tokens = lexico.analisar();
        System.out.println("Tokens:");
        tokens.forEach(System.out::println);

        // Sintático
        AnalisadorSintatico sintatico = new AnalisadorSintatico(tokens);
        List<NoAST> ast = sintatico.analisar();
        System.out.println("\nAST:");
        ast.forEach(System.out::println);

        // Semântico
        AnalisadorSemantico semantico = new AnalisadorSemantico();
        System.out.println("\nAnálise Semântica:");
        semantico.analisar(ast);
    }
}