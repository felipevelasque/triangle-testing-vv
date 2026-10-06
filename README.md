# Is this a triangle?

Projeto desenvolvido para a disciplina de **Verificação e Validação** da PUCRS.

O objetivo é aplicar técnicas de teste de software ao kata **Is this a triangle?**, disponível no CodeWars.

## Problema

A função recebe três valores inteiros `a`, `b` e `c`, representando os comprimentos dos lados de um possível triângulo.

O retorno deve ser:

- `true` quando os três lados formarem um triângulo válido com área maior que zero;
- `false` caso contrário.

Para formar um triângulo válido, devem ser satisfeitas as seguintes condições:

```text
a + b > c
a + c > b
b + c > a
```

## Tecnologias

- Java 17
- Maven
- JUnit 5

## Técnicas de teste

Foram aplicadas duas técnicas de teste caixa-preta:

- Particionamento de Equivalência
- Análise de Valores Limite

Os casos de teste e a relação entre cada teste e sua respectiva técnica estão documentados no arquivo [`tests.md`](./tests.md).

## Estrutura do projeto

```text
triangle-testing-vv/
├── pom.xml
├── README.md
├── tests.md
├── src/
│   └── main/
│       └── java/
│           └── Triangle.java
└── tests/
    └── TriangleTest.java
```

## Implementação

A classe `Triangle` contém o método:

```java
public static boolean isTriangle(int a, int b, int c)
```

O método verifica se os três valores recebidos satisfazem as desigualdades necessárias para formar um triângulo válido.

## Executando os testes

É necessário possuir Java 17 e Maven instalados.

Na raiz do projeto, execute:

```bash
mvn test
```

Resultado atual:

```text
Tests run: 12, Failures: 0, Errors: 0, Skipped: 0
BUILD SUCCESS
```

Foram implementados:

- 6 testes de Particionamento de Equivalência;
- 6 testes de Análise de Valores Limite.

## Referencial teórico

As técnicas utilizadas foram fundamentadas nos seguintes trabalhos:

- REID, Stuart