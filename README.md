# Refatoração SOLID - Sistema das Olimpíadas

## Objetivo
Refatorar o sistema legado aplicando os princípios SOLID, sem alterar a lógica de negócio original.

---

## Principais mudanças realizadas

- Separação de responsabilidades da classe principal
- Introdução de abstrações para reduzir acoplamento
- Extração de regras específicas para classes dedicadas
- Melhoria na organização e legibilidade do código

---

## Aplicação dos princípios SOLID

### S - Single Responsibility Principle (SRP)

A classe `App` possuía múltiplas responsabilidades, incluindo controle de fluxo, entrada de dados e impressão de tabuleiro.

Foi criada a classe `TabuleiroPrinter`, responsável exclusivamente por interpretar e imprimir o tabuleiro a partir da string FEN.

---

### O - Open/Closed Principle (OCP)

O cálculo de nota estava diretamente implementado na classe `App`.

Foi criada a interface `CalculadoraNota`, permitindo a extensão do comportamento sem modificar a classe principal.

Foram criadas implementações como:
- `CalculadoraNotaPadrao`
- `CalculadoraNotaPorAcertos`

Dessa forma, novas estratégias de cálculo podem ser adicionadas sem alterar o código existente.

---

### L - Liskov Substitution Principle (LSP)

As implementações `CalculadoraNotaPadrao` e `CalculadoraNotaPorAcertos` respeitam o contrato definido pela interface `CalculadoraNota`.

A classe `App` utiliza a abstração, permitindo substituir qualquer implementação de cálculo de nota sem alterar o funcionamento do sistema.

---

### I - Interface Segregation Principle (ISP)

Foram criadas interfaces específicas e enxutas, como:
- `TabuleiroService`
- `CalculadoraNota`
- `ParticipanteSelector`
- `ProvaSelector`

Isso evita que classes dependam de métodos que não utilizam.

---

### D - Dependency Inversion Principle (DIP)

A classe `App` passou a depender de abstrações, e não de implementações concretas.

Exemplos:
- `TabuleiroPrinter` é utilizado através da interface `TabuleiroService`
- `CalculadoraNotaPadrao` / `CalculadoraNotaPorAcertos` são utilizadas através da interface `CalculadoraNota`

---

## Restrições atendidas

- Nenhuma funcionalidade foi removida
- A lógica de negócio original foi mantida
- Nenhum framework externo foi utilizado