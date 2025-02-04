package main.meu.projeto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Principal {
    public static void main(String[] args) {
        // 3.1 – Inserir funcionários
        List<Funcionario> funcionarios = new ArrayList<>(Arrays.asList(
            new Funcionario("Maria", LocalDate.of(2000, Month.OCTOBER, 18), new BigDecimal("2009.44"), "Operador"),
            new Funcionario("João", LocalDate.of(1990, Month.MAY, 12), new BigDecimal("2284.38"), "Operador"),
            new Funcionario("Caio", LocalDate.of(1961, Month.MAY, 2), new BigDecimal("9836.14"), "Coordenador"),
            new Funcionario("Miguel", LocalDate.of(1988, Month.OCTOBER, 14), new BigDecimal("19119.88"), "Diretor"),
            new Funcionario("Alice", LocalDate.of(1995, Month.JANUARY, 5), new BigDecimal("2234.68"), "Recepcionista"),
            new Funcionario("Heitor", LocalDate.of(1999, Month.NOVEMBER, 19), new BigDecimal("1582.72"), "Operador"),
            new Funcionario("Arthur", LocalDate.of(1993, Month.MARCH, 31), new BigDecimal("4071.84"), "Contador"),
            new Funcionario("Laura", LocalDate.of(1994, Month.JULY, 8), new BigDecimal("3017.45"), "Gerente"),
            new Funcionario("Heloísa", LocalDate.of(2003, Month.MAY, 24), new BigDecimal("1606.85"), "Eletricista"),
            new Funcionario("Helena", LocalDate.of(1996, Month.SEPTEMBER, 2), new BigDecimal("2799.93"), "Gerente")
        ));

        // 3.2 – Remover João
        funcionarios.removeIf(f -> f.getNome().equals("João"));

        // 3.3 – Imprimir funcionários com formatação
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setDecimalSeparator(',');
        symbols.setGroupingSeparator('.');
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00", symbols);

        System.out.println("3.3 – Funcionários:");
        for (Funcionario f : funcionarios) {
            String dataStr = f.getDataNascimento().format(dateFormatter);
            String salarioStr = decimalFormat.format(f.getSalario());
            System.out.printf("Nome: %s, Data Nascimento: %s, Salário: %s, Função: %s%n",
                    f.getNome(), dataStr, salarioStr, f.getFuncao());
        }

        // 3.4 – Aumento de 10%
        funcionarios.forEach(f -> {
            BigDecimal novoSalario = f.getSalario().multiply(new BigDecimal("1.10"));
            f.setSalario(novoSalario);
        });

        // 3.5 – Agrupar por função
        Map<String, List<Funcionario>> funcionariosPorFuncao = funcionarios.stream()
                .collect(Collectors.groupingBy(Funcionario::getFuncao));

        // 3.6 – Imprimir agrupado por função
        System.out.println("\n3.6 – Funcionários por função:");
        funcionariosPorFuncao.forEach((funcao, lista) -> {
            System.out.println("Função: " + funcao);
            lista.forEach(f -> {
                String dataStr = f.getDataNascimento().format(dateFormatter);
                String salarioStr = decimalFormat.format(f.getSalario());
                System.out.printf("  Nome: %s, Data Nascimento: %s, Salário: %s%n",
                        f.getNome(), dataStr, salarioStr);
            });
        });

        // 3.8 – Aniversariantes do mês 10 e 12
        System.out.println("\n3.8 – Aniversariantes em outubro e dezembro:");
        funcionarios.stream()
                .filter(f -> {
                    int mes = f.getDataNascimento().getMonthValue();
                    return mes == 10 || mes == 12;
                })
                .forEach(f -> System.out.printf("Nome: %s, Data Nascimento: %s%n",
                        f.getNome(), f.getDataNascimento().format(dateFormatter)));

        // 3.9 – Funcionário mais velho
        Funcionario maisVelho = funcionarios.stream()
                .min(Comparator.comparing(Pessoa::getDataNascimento))
                .orElseThrow();
        int idade = Period.between(maisVelho.getDataNascimento(), LocalDate.now()).getYears();
        System.out.printf("\n3.9 – Funcionário mais velho: Nome: %s, Idade: %d%n",
                maisVelho.getNome(), idade);

        // 3.10 – Ordem alfabética
        System.out.println("\n3.10 – Funcionários em ordem alfabética:");
        funcionarios.stream()
                .sorted(Comparator.comparing(Pessoa::getNome))
                .forEach(f -> System.out.println(f.getNome()));

        // 3.11 – Total dos salários
        BigDecimal totalSalarios = funcionarios.stream()
                .map(Funcionario::getSalario)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.printf("\n3.11 – Total dos salários: %s%n", decimalFormat.format(totalSalarios));

        // 3.12 – Salários em SM
        BigDecimal salarioMinimo = new BigDecimal("1212.00");
        System.out.println("\n3.12 – Salários em salários mínimos:");
        funcionarios.forEach(f -> {
            BigDecimal quantidade = f.getSalario().divide(salarioMinimo, 2, RoundingMode.HALF_UP);
            System.out.printf("%s: %s%n", f.getNome(), decimalFormat.format(quantidade));
        });
    }
}