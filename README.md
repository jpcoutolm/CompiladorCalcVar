# 🧮 CalcVar Compiler

**CalcVar** é um compilador simples desenvolvido em Java que realiza a análise léxica, sintática e semântica de uma linguagem fictícia chamada `CalcVar`. Essa linguagem suporta declarações e atribuições de variáveis do tipo `int` com expressões aritméticas básicas.

## 📁 Estrutura do Projeto

```
.
├── AnalisadorLexico.java
├── AnalisadorSintatico.java
├── AnalisadorSemantico.java
├── CompiladorCalcVar.java
├── NoAST.java
├── Token.java
└── CalcVarCompiler.iml
```

## 🚀 Como executar

### Pré-requisitos

- Java 8 ou superior instalado
- Compilador Java (`javac`) disponível no terminal

### Compilação

```bash
javac *.java
```

### Execução

```bash
java CompiladorCalcVar
```

> O código de exemplo a ser compilado está dentro da `main()` de `CompiladorCalcVar.java`.

## 📌 Funcionalidades

### ✅ Analisador Léxico (`AnalisadorLexico.java`)
Transforma a string de entrada em uma lista de **tokens** (palavras-chave, identificadores, números, símbolos).

### ✅ Analisador Sintático (`AnalisadorSintatico.java`)
Gera uma **AST (Árvore de Sintaxe Abstrata)** com base na estrutura da linguagem `CalcVar`.

### ✅ Analisador Semântico (`AnalisadorSemantico.java`)
Verifica:
- Se variáveis foram declaradas antes de serem usadas.
- Se os valores atribuídos a variáveis inteiras são válidos (números ou expressões válidas).

### ✅ AST Nodes (`NoAST.java`)
Define a estrutura dos nós da árvore sintática:
- Declaração
- Atribuição
- Número
- Variável
- Operações

### ✅ Token (`Token.java`)
Define os tipos de tokens utilizados na linguagem.

## 🧪 Exemplo de código analisado

```calcvar
int x = "texto";
x = x + 1;
```

### Saída esperada:
```
Tokens:
[INT: int]
[IDENT: x]
[IGUAL: =]
[IDENT: texto]
[PONTO_VIRGULA: ;]
[IDENT: x]
[IGUAL: =]
[IDENT: x]
[MAIS: +]
[NUMERO: 1]
[PONTO_VIRGULA: ;]
[EOF: ]

AST:
Declaracao: int x = texto
Atribuicao: x = (x + 1)

Análise Semântica:
Erro: valor inválido para declaração de x
```

## 👨‍💻 Autor

**João Pedro do Couto**
