# Casos de Teste — Is this a triangle?

## Sistema sob Teste

O sistema recebe três valores inteiros `a`, `b` e `c`, representando os comprimentos dos lados de um possível triângulo.

O retorno esperado é:

- `true` quando os três lados formam um triângulo válido com área maior que zero;
- `false` caso contrário.

Para formar um triângulo válido, devem ser satisfeitas as seguintes condições:

```text
a + b > c
a + c > b
b + c > a
```

## Técnicas utilizadas

Foram utilizadas duas técnicas de teste caixa-preta:

- Particionamento de Equivalência;
- Análise de Valores Limite.

---

## Particionamento de Equivalência

O domínio de entrada foi dividido em classes com comportamentos semelhantes. A partir dessas classes, foram escolhidos valores representativos para os testes.

| ID | Entrada | Classe de equivalência | Resultado esperado |
|---|---|---|---|
| EP01 | `(3,3,3)` | Triângulo válido | `true` |
| EP02 | `(4,5,6)` | Triângulo válido | `true` |
| EP03 | `(6,2,3)` | Um lado maior que a soma dos outros | `false` |
| EP04 | `(2,6,3)` | Um lado maior que a soma dos outros | `false` |
| EP05 | `(0,2,2)` | Presença de lado igual a zero | `false` |
| EP06 | `(-1,2,2)` | Presença de lado negativo | `false` |

> Observação: o caso `(2,3,5)` também representa a classe em que um lado é igual à soma dos outros, mas foi contabilizado entre os testes de Análise de Valores Limite por corresponder exatamente à fronteira superior `c = 5`.

---

## Análise de Valores Limite

Para aplicar a técnica, foram fixados os valores:

```text
a = 2
b = 3
```

Para que `c` forme um triângulo válido, deve ser satisfeita a condição:

```text
|a - b| < c < a + b
```

Substituindo os valores:

```text
|2 - 3| < c < 2 + 3
```

Logo:

```text
1 < c < 5
```

Portanto, as fronteiras são:

- `c = 1`, fronteira inferior;
- `c = 5`, fronteira superior.

Foram escolhidos valores imediatamente abaixo, exatamente sobre e imediatamente acima dessas fronteiras.

| ID | Entrada | Situação | Resultado esperado |
|---|---|---|---|
| BVA01 | `(2,3,0)` | Abaixo da fronteira inferior | `false` |
| BVA02 | `(2,3,1)` | Sobre a fronteira inferior | `false` |
| BVA03 | `(2,3,2)` | Acima da fronteira inferior | `true` |
| BVA04 | `(2,3,4)` | Abaixo da fronteira superior | `true` |
| BVA05 | `(2,3,5)` | Sobre a fronteira superior | `false` |
| BVA06 | `(2,3,6)` | Acima da fronteira superior | `false` |

Os casos `(2,3,1)` e `(2,3,5)` representam exatamente os pontos em que uma das desigualdades deixa de ser estrita e o triângulo passa a ser inválido.

Um exemplo claro da mudança de comportamento é:

```text
(2,3,4) -> true
(2,3,5) -> false
```

Uma alteração de apenas uma unidade em `c` muda o resultado esperado.

---

## Rastreabilidade

| Técnica | Casos de teste |
|---|---|
| Particionamento de Equivalência | EP01, EP02, EP03, EP04, EP05, EP06 |
| Análise de Valores Limite | BVA01, BVA02, BVA03, BVA04, BVA05, BVA06 |

---

## Resultado da execução

Os 12 casos foram implementados como testes automatizados utilizando JUnit 5 e executados com Maven.

Resultado:

```text
Tests run: 12, Failures: 0, Errors: 0, Skipped: 0
BUILD SUCCESS
```

Foram executados:

- 6 testes de Particionamento de Equivalência;
- 6 testes de Análise de Valores Limite.

Todos os testes foram concluídos com sucesso.