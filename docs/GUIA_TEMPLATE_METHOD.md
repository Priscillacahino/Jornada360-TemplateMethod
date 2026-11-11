# Guia didático — Template Method no Jornada360

## 1. Objetivo deste guia

Este material explica o contexto do Jornada360, o problema escolhido para o exercício acadêmico e como o padrão Template Method foi aplicado no projeto Java. A intenção é permitir que alguém que não conhece o sistema original consiga entender o exemplo, localizar o padrão no código e saber como utilizá-lo.

## 2. Contexto: o que é o Jornada360?

O Jornada360 é uma proposta de sistema para acompanhar a jornada de clientes. O domínio envolve observar em que etapa cada cliente está, acompanhar pendências e identificar jornadas em andamento, concluídas ou interrompidas.

O projeto original é uma aplicação web de acompanhamento da jornada do cliente. Este exercício acadêmico utiliza esse contexto de negócio, mas possui código, tecnologia e escopo próprios. O original não foi alterado nem substituído.

## 3. O que é Template Method?

Template Method é um padrão comportamental que define o esqueleto de um algoritmo em uma classe-base. A classe-base controla a sequência das etapas, enquanto as subclasses implementam ou especializam os pontos que variam.

Em termos simples:

- A classe-base define **a ordem do processo**.
- As subclasses definem **como executar algumas etapas específicas**.
- O fluxo principal fica centralizado e não precisa ser repetido em cada implementação.

O padrão é útil quando diferentes operações seguem uma sequência semelhante, mas possuem algumas regras ou etapas particulares.

## 4. Qual problema estamos resolvendo?

O projeto precisa gerar três tipos de relatório:

1. Jornadas ativas.
2. Jornadas concluídas.
3. Jornadas interrompidas.

Todos precisam consultar os dados, selecionar registros, calcular indicadores, montar detalhes e formatar a saída. O que muda são os critérios de seleção e algumas informações apresentadas.

### Sem Template Method

Cada classe de relatório poderia implementar toda a sequência por conta própria:

```text
Relatório de ativas:
consultar → selecionar → calcular → detalhar → formatar

Relatório de concluídas:
consultar → selecionar → calcular → detalhar → formatar

Relatório de interrompidas:
consultar → selecionar → calcular → detalhar → formatar
```

A sequência seria repetida. Uma alteração no processo comum poderia exigir mudanças em várias classes.

### Com Template Method

A classe abstrata `RelatorioJornada` concentra o fluxo comum. Cada subclasse implementa somente as particularidades necessárias.

O ganho é reduzir repetição e manter uma sequência consistente.

## 5. Como o padrão foi aplicado no Jornada360-TemplateMethod?

A classe abstrata `RelatorioJornada` contém o método:

```java
public final String gerar(Periodo periodo)
```

Esse é o **Template Method**. Ele controla a sequência de geração:

1. Verifica se o período foi informado.
2. Consulta os registros no repositório.
3. Seleciona as jornadas conforme o tipo de relatório.
4. Calcula os indicadores.
5. Monta os detalhes.
6. Cria um `DocumentoRelatorio`.
7. Usa o `FormatadorRelatorio` para produzir o texto final.

A assinatura retorna `String`, porque o resultado entregue pelo formatador é o texto pronto para exibição no console.

### Fluxo resumido

```text
Aplicação
   ↓
gerar(Periodo) — Template Method
   ↓
Consultar repositório
   ↓
Selecionar jornadas (regra da subclasse)
   ↓
Calcular indicadores
   ↓
Montar detalhes
   ↓
Criar documento e formatar
   ↓
Exibir relatório no console
```

## 6. Quais métodos são fixos e quais podem variar?

| Elemento | Implementação | Papel |
|---|---|---|
| Template Method | `gerar(Periodo)` | Controla a sequência completa. É `final`. |
| Método abstrato | `titulo()` | Obriga cada relatório a informar seu título. |
| Método abstrato | `selecionar(...)` | Obriga cada relatório a definir quais jornadas entram. |
| Método com implementação padrão | `calcularIndicadores(...)` | Usa o cálculo padrão por etapa; pode ser sobrescrito. |
| Método com implementação padrão | `montarDetalhes(...)` | Monta detalhes básicos; pode ser sobrescrito. |

Nem todas as etapas precisam ser reimplementadas em todas as subclasses. A classe-base oferece comportamentos padrão e cada relatório altera somente o que precisa.

## 7. O que cada relatório faz?

### RelatorioJornadasAtivas

- Define o título “Jornadas ativas”.
- Seleciona jornadas com status `ATIVA`.
- Considera a data de início dentro do período informado.
- Utiliza o cálculo e os detalhes padrão da classe-base.

### RelatorioJornadasConcluidas

- Define o título “Jornadas concluídas”.
- Seleciona jornadas com status `CONCLUIDA`.
- Considera a data de conclusão dentro do período informado.
- Sobrescreve o cálculo para apresentar o tempo médio de conclusão.
- Sobrescreve os detalhes para mostrar início, conclusão e resultado.

### RelatorioJornadasInterrompidas

- Define o título “Jornadas interrompidas”.
- Seleciona jornadas com status `INTERROMPIDA`.
- Considera a data de início dentro do período informado.
- Sobrescreve os detalhes para mostrar a etapa atual e o motivo da interrupção.

## 8. Por que o método gerar() é final?

A palavra-chave `final` impede que uma subclasse sobrescreva o método `gerar()`.

Isso protege a sequência principal. Se cada subclasse pudesse substituir esse método, poderia mudar a ordem das etapas ou deixar alguma delas de fora.

As subclasses continuam podendo personalizar os métodos protegidos previstos para variação, mas não substituem o algoritmo completo.

## 9. Como utilizar um relatório?

A aplicação instancia uma das subclasses e chama o mesmo método `gerar()`:

```java
Periodo periodo = new Periodo(dataInicial, dataFinal);

RelatorioJornada relatorio =
    new RelatorioJornadasAtivas(
        repositorio,
        calculadora,
        formatador
    );

String resultado = relatorio.gerar(periodo);
System.out.println(resultado);
```

Para gerar outro tipo, basta instanciar `RelatorioJornadasConcluidas` ou `RelatorioJornadasInterrompidas`. A chamada ao método continua sendo `gerar(periodo)`.

## 10. Como criar um novo relatório?

Imagine que seja necessário criar um relatório de jornadas pendentes. O caminho seria:

1. Criar uma classe chamada, por exemplo, `RelatorioJornadasPendentes`.
2. Fazer a classe estender `RelatorioJornada`.
3. Implementar `titulo()`.
4. Implementar `selecionar(...)` com a regra de negócio das jornadas pendentes.
5. Sobrescrever `calcularIndicadores(...)` ou `montarDetalhes(...)` somente se precisar de um comportamento diferente.
6. Disponibilizar a nova classe na aplicação/menu para que possa ser escolhida.

A nova classe reaproveita o método `gerar()`. Não é necessário copiar a sequência inteira de processamento.

## 11. Template Method ou Strategy?

Os dois são padrões comportamentais, mas organizam a variação de maneiras diferentes.

| Template Method | Strategy |
|---|---|
| Baseia-se principalmente em herança. | Baseia-se em composição. |
| A classe-base define a sequência do algoritmo. | O contexto utiliza uma estratégia que encapsula um algoritmo. |
| Subclasses especializam etapas previstas. | Estratégias diferentes podem ser substituídas. |
| O fluxo principal permanece definido pela classe-base. | O algoritmo utilizado pode ser trocado conforme a necessidade. |

**Por que escolhemos Template Method?**

Porque o objetivo deste exercício é demonstrar que os três relatórios seguem uma sequência comum de geração, mas possuem critérios e detalhes específicos. Queremos manter a ordem do processo em um único lugar e permitir variações controladas.

**Quando Strategy seria mais apropriado?**

Se o requisito principal fosse trocar livremente, por composição, entre algoritmos independentes — por exemplo, diferentes estratégias de cálculo ou seleção escolhidas em tempo de execução — Strategy poderia ser mais adequado.

## 12. Relação com SOLID

- **SRP — Responsabilidade Única:** domínio, relatórios, repositório, cálculo e formatação têm responsabilidades separadas.
- **OCP — Aberto/Fechado:** um novo tipo de relatório pode ser acrescentado estendendo `RelatorioJornada`, sem reescrever o fluxo comum. A nova opção ainda precisa ser disponibilizada na aplicação.
- **LSP — Substituição de Liskov:** as subclasses concretas respeitam o contrato da classe-base e podem ser utilizadas como `RelatorioJornada`.
- **ISP — Segregação de Interfaces:** `RepositorioJornadas` apresenta um contrato pequeno e específico, com a operação necessária para listar os registros.
- **DIP — Inversão de Dependência:** a classe-base depende da interface `RepositorioJornadas`, não diretamente da implementação `RepositorioJornadasMemoria`.

## 13. Outros padrões considerados

- **Strategy:** seria uma alternativa para encapsular algoritmos intercambiáveis; não foi escolhido porque o foco é a sequência fixa do processo.
- **Factory Method:** poderia organizar a criação dos relatórios, por exemplo, a partir de uma opção do menu.
- **Builder:** poderia ajudar se a construção dos documentos se tornasse mais complexa.
- **Observer:** poderia ser útil se outros componentes precisassem reagir a eventos de mudança de estado das jornadas.

Esses padrões resolvem problemas diferentes. Não são substitutos automáticos do Template Method.

## 14. Dados, testes e escopo

O projeto utiliza sete registros fictícios em memória:

- 3 jornadas ativas;
- 2 jornadas concluídas;
- 2 jornadas interrompidas.

Os testes verificam os totais dos relatórios, o tempo médio de conclusão de 9 dias e a presença dos motivos de interrupção cadastrados.

A aplicação é Java 17+, executada pelo console, sem banco de dados, API ou serviços externos. Os dados são reiniciados quando a aplicação é encerrada.

A compilação e os testes foram validados pelo GitHub Actions. A execução local no Eclipse precisa ser confirmada no ambiente dos participantes antes da apresentação.

## 15. Vantagens e limitações

### Vantagens

- Evita repetir a sequência de geração.
- Mantém a ordem das etapas em um único lugar.
- Facilita a manutenção do processo comum.
- Permite acrescentar novos relatórios por extensão.
- Deixa explícitos os pontos em que o comportamento pode variar.

### Limitações

- A herança cria dependência em relação à classe-base.
- Alterações no template podem afetar todas as subclasses.
- Não é a melhor escolha quando os processos têm sequências completamente diferentes.
- O exemplo acadêmico não possui persistência real nem integração externa; isso é uma limitação de escopo do projeto, não uma exigência do padrão.

## 16. Conclusão

O Template Method foi escolhido porque os relatórios compartilham uma sequência de processamento, mas precisam de regras específicas em algumas etapas.

No projeto, `RelatorioJornada.gerar(Periodo)` define e protege o fluxo comum. As subclasses determinam quais jornadas selecionar e personalizam indicadores ou detalhes quando necessário.

O principal aprendizado é que podemos reaproveitar a estrutura de um algoritmo sem obrigar todas as implementações a produzir exatamente o mesmo conteúdo.

## 17. Respostas rápidas para a apresentação

**O que é Template Method?**  
É um padrão que define a sequência de um algoritmo na classe-base e deixa algumas etapas para as subclasses.

**Onde está no projeto?**  
No método final `gerar(Periodo)`, da classe `RelatorioJornada`.

**Por que foi escolhido?**  
Porque os relatórios compartilham um fluxo de geração, mas variam nos critérios e nas informações.

**Qual a diferença para Strategy?**  
Template Method usa herança para manter uma sequência fixa com etapas variáveis. Strategy usa composição para permitir a troca de algoritmos encapsulados.

**Por que gerar() é final?**  
Para impedir que subclasses alterem a sequência principal.

**Como adicionar um relatório?**  
Criar uma subclasse, implementar título e seleção, sobrescrever os pontos necessários e disponibilizá-la na aplicação.

**O projeto usa dados reais?**  
Não. Usa registros fictícios em memória.

**O projeto substitui o Jornada360 original?**  
Não. É um exercício acadêmico independente, com foco em relatórios e padrões de projeto.
