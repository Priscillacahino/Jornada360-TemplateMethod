# Exemplo prático: Template Method no contexto do Jornada360

## 1. Cenário

Imagine uma operação que acompanha a jornada de clientes e precisa produzir três visões: jornadas ativas, concluídas e interrompidas. Os registros abaixo são fictícios e servem apenas para explicar o padrão.

| Cliente | Status | Etapa / informação |
|---|---|---|
| Cliente Alfa | ATIVA | Documentação pendente |
| Cliente Beta | CONCLUIDA | Processo finalizado em 8 dias |
| Cliente Gama | INTERROMPIDA | Documentação não enviada |

Cada relatório precisa consultar a mesma fonte, selecionar registros dentro do período, calcular indicadores, montar detalhes e formatar a saída. O critério de seleção e alguns detalhes variam.

## 2. Como seria sem Template Method?

Sem uma classe que centralizasse o algoritmo, cada relatório poderia repetir o fluxo:

```text
Relatório de ativas:
consultar -> filtrar ativas -> calcular -> detalhar -> formatar

Relatório de concluídas:
consultar -> filtrar concluídas -> calcular -> detalhar -> formatar

Relatório de interrompidas:
consultar -> filtrar interrompidas -> calcular -> detalhar -> formatar
```

A repetição aumenta o custo de manutenção. Uma mudança na ordem do processamento, por exemplo, teria de ser replicada em mais de uma classe.

## 3. Como fica com Template Method?

No projeto, a classe abstrata `RelatorioJornada` define o método `gerar(Periodo)`, que é `final`. Ele mantém a sequência:

1. validar se o período foi informado;
2. consultar o repositório;
3. selecionar as jornadas;
4. calcular indicadores;
5. montar detalhes;
6. criar o documento;
7. formatar a saída.

Trecho fiel à implementação do repositório:

```java
public final String gerar(Periodo periodo) {
    Objects.requireNonNull(periodo, "O período é obrigatório.");

    List<Jornada> base = repositorio.listarTodas();
    List<Jornada> selecionadas = selecionar(base, periodo);
    Map<String, Long> indicadores = calcularIndicadores(selecionadas);
    List<String> detalhes = montarDetalhes(selecionadas);

    return formatador.formatar(
        new DocumentoRelatorio(
            titulo(), periodo, selecionadas.size(),
            indicadores, detalhes
        )
    );
}
```

A assinatura retorna `String`, pois o formatador entrega o relatório pronto para exibição no console. O método não retorna `DocumentoRelatorio`.

## 4. Onde cada relatório especializa o algoritmo?

A subclasse de jornadas interrompidas implementa seu critério de seleção e personaliza os detalhes:

```java
protected List<Jornada> selecionar(
        List<Jornada> jornadas, Periodo periodo) {
    return jornadas.stream()
        .filter(j -> j.status() == StatusJornada.INTERROMPIDA
            && periodo.contem(j.dataInicio()))
        .toList();
}

protected List<String> montarDetalhes(List<Jornada> jornadas) {
    return jornadas.stream()
        .map(j -> j.id() + " | " + j.cliente()
            + " | Etapa: " + j.etapaAtual()
            + " | Motivo: " + j.motivoInterrupcao())
        .toList();
}
```

O fluxo principal continua na classe-base. A subclasse informa quais registros entram e quais informações específicas devem aparecer.

## 5. Resultado esperado no exemplo

- Relatório de ativas: inclui jornadas com status ATIVA cuja data de início esteja dentro do período.
- Relatório de concluídas: inclui jornadas com status CONCLUIDA cuja data de conclusão esteja dentro do período. Nesse relatório, o cálculo especializado apresenta o tempo médio de conclusão.
- Relatório de interrompidas: inclui jornadas com status INTERROMPIDA cuja data de início esteja dentro do período e mostra o motivo da interrupção.

No conjunto fictício implementado no repositório, os testes verificam 3 jornadas ativas, 2 concluídas e 2 interrompidas. Também verificam a média de 9 dias para as jornadas concluídas e a presença dos motivos de interrupção cadastrados.

## 6. O que este exemplo demonstra?

- **Template Method:** `gerar(Periodo)` fixa a ordem do algoritmo.
- **Herança e polimorfismo:** cada subclasse fornece comportamentos específicos.
- **OCP:** um novo relatório pode ser acrescentado por extensão da abstração, sem reescrever o fluxo comum.
- **DIP:** a classe-base recebe a interface `RepositorioJornadas`, não depende diretamente do repositório em memória.

## 7. Resposta curta para a apresentação

Escolhemos Template Method porque os relatórios compartilham uma sequência de geração, mas possuem critérios e detalhes próprios. A classe abstrata controla o processo comum e as subclasses implementam as variações. Isso evita duplicar o algoritmo e mantém a ordem das etapas consistente.
