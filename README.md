# Teste_Pratico-Iniflex

# Sistema de Gerenciamento de Funcionários

Este projeto é um sistema de gerenciamento de funcionários desenvolvido em Java, seguindo os princípios de orientação a objetos. Ele permite realizar operações como listagem, filtragem, agrupamento e cálculos específicos sobre os dados dos funcionários de uma empresa.

## Tecnologias Utilizadas
- **Java 17+**: Versão LTS do Java para garantir compatibilidade e estabilidade.
- **Java Time API**: Manipulação de datas (LocalDate) para cálculos de idade e formatação.
- **BigDecimal**: Para representação precisa de valores monetários e operações aritméticas.
- **Streams API**: Processamento de coleções com operações como filtragem, ordenação e agrupamento.
- **Lambda Expressions**: Simplificação de operações em coleções.

## Funcionalidades Implementadas
1. **Cadastro de Funcionários**: Inserção de funcionários com nome, data de nascimento, salário e função.
2. **Remoção de Funcionário**: Exclusão do funcionário "João" da lista.
3. **Impressão Formatada**:
   - Datas no formato `dd/mm/aaaa`.
   - Salários formatados com separadores de milhar (ponto) e decimal (vírgula).
4. **Reajuste Salarial**: Aumento de 10% para todos os funcionários.
5. **Agrupamento por Função**: Funcionários organizados em um `Map` por função.
6. **Filtros Específicos**:
   - Funcionários que fazem aniversário em outubro e dezembro.
   - Identificação do funcionário mais velho.
7. **Ordenação Alfabética**: Listagem de funcionários em ordem alfabética.
8. **Cálculos**:
   - Soma total dos salários.
   - Conversão de salários para quantidades de salários mínimos (R$ 1.212,00).

## Como Executar o Projeto

### Pré-requisitos
- JDK 17+ instalado.
- Ambiente de desenvolvimento (IDE) ou terminal.

### Passos para Execução
1. Clone o repositório:
   ```bash
   git clone 
    ```
2. Compile o projeto:
   ```bash
   cd Teste_Pratico-Iniflex
   javac -d bin/ src/main/java/meu/projeto/*.java
   ```
3. Execute o projeto:
   ```bash
   java -cp bin/ main/meu/projeto.Principal
   ```

## Exemplos de Saídas

1. – Funcionários:
Nome: Maria, Data Nascimento: 18/10/2000, Salário: 2.009,44, Função: Operador
...

2. – Funcionários por função:
Função: Gerente
  Nome: Laura, Data Nascimento: 08/07/1994, Salário: 3.017,45
...

3. – Funcionário mais velho: Nome: Caio, Idade: 62

4. – Total dos salários: 45.842,39


### Observações Adicionais:
1. **Formatação de Valores**:  
   - Utilização de `DecimalFormatSymbols` para customizar separadores numéricos.  
   - `DateTimeFormatter` para datas no padrão brasileiro.

2. **Tratamento de Datas**:  
   - Cálculo de idade usando `Period.between()`.  
   - Filtro de meses de aniversário com `getMonthValue()`.

3. **Eficiência**:  
   - Uso de `Streams` para operações em coleções (menos código, mais legibilidade).  
   - `BigDecimal` evita erros de arredondamento em cálculos financeiros.

4. **Extensibilidade**:  
   - O código está estruturado para facilitar a adição de novas funcionalidades.  
   - Métodos bem definidos permitem modificações pontuais sem impactar outras partes.
