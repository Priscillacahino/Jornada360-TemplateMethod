# Jornada360 — Relatórios de Acompanhamento da Jornada do Cliente

Projeto acadêmico independente desenvolvido em **Java 17+** para demonstrar o padrão comportamental **Template Method** e sua relação com os princípios **SOLID**, no contexto de relatórios de acompanhamento da jornada do cliente.

## Objetivo

Implementar três relatórios de console — jornadas ativas, concluídas e interrompidas — reutilizando um fluxo comum de geração e permitindo variações específicas por meio de subclasses.

## Tecnologias e escopo

- Java 17 ou superior (records e switch expressions).
- Eclipse IDE.
- Aplicação de console.
- Dados fictícios mantidos em memória.
- Sem banco de dados, API ou dependência de internet.

## Estrutura do projeto

- `src/br/com/jornada360/app`: aplicação de console.
- `src/br/com/jornada360/model`: entidades, enums e objetos de valor.
- `src/br/com/jornada360/repository`: contrato e repositório em memória.
- `src/br/com/jornada360/report`: Template Method e relatórios concretos.
- `src/br/com/jornada360/service`: cálculo e formatação.
- `src/br/com/jornada360/testes`: testes executáveis sem bibliotecas externas.
- `docs`: comparação, diagrama textual e roteiro de apresentação.

## Padrão Template Method

A classe abstrata `RelatorioJornada` define o algoritmo em `gerar(Periodo)`, método `final`. A sequência é:

1. Validar o período (garantido pelo construtor de `Periodo`).
2. Consultar os dados no repositório.
3. Selecionar os registros conforme o tipo de relatório.
4. Calcular indicadores.
5. Montar detalhes.
6. Criar o documento do relatório.
7. Formatar a saída.

As subclasses `RelatorioJornadasAtivas`, `RelatorioJornadasConcluidas` e `RelatorioJornadasInterrompidas` implementam os critérios específicos de seleção e, quando necessário, especializam indicadores e detalhes.

## Princípios SOLID

- **SRP:** domínio, repositório, cálculo, formatação e relatórios possuem responsabilidades separadas.
- **OCP:** novos tipos de relatório podem ser adicionados por extensão da abstração.
- **LSP:** as implementações concretas respeitam o contrato de `RelatorioJornada`.
- **ISP:** o contrato do repositório é pequeno e específico.
- **DIP:** os relatórios dependem da interface `RepositorioJornadas`, não da implementação em memória.

## Como executar no Eclipse

1. Instale e configure um JDK 17 ou superior.
2. Clone ou baixe este repositório.
3. No Eclipse, escolha **File > Import > Existing Projects into Workspace**.
4. Selecione a pasta do projeto. Os arquivos `.project` e `.classpath` já estão incluídos.
5. Abra `br.com.jornada360.app.Aplicacao` e execute **Run As > Java Application**.
6. Informe as datas no formato `AAAA-MM-DD`, por exemplo `2026-10-01` e `2026-10-31`.
7. Escolha o relatório desejado no menu.

### Executar os testes

Execute `br.com.jornada360.testes.TestesRelatorios` como **Java Application**. Se tudo estiver correto, será exibida a mensagem de sucesso. Os testes usam apenas recursos nativos do Java, sem JUnit.

## Padrões alternativos considerados

- **Strategy:** permitiria trocar algoritmos de seleção/cálculo por composição; seria adequado se a variação de comportamento fosse o foco principal.
- **Factory Method:** poderia encapsular a criação dos relatórios escolhidos no menu.
- **Builder:** poderia ajudar na construção de documentos mais complexos, caso sua estrutura crescesse.
- **Observer:** seria pertinente se outros componentes precisassem reagir a eventos de mudança de estado das jornadas.

O Template Method foi escolhido porque o problema didático apresenta uma sequência de geração compartilhada, com etapas específicas variando por tipo de relatório.

## Relação com o Jornada360 original

Este exercício parte do mesmo domínio conceitual, mas possui escopo, código e documentação próprios. Ele não altera nem substitui o projeto original, de autoria de Priscilla Cahino: [Jornada360 original](https://github.com/Priscillacahino/Jornada360).

O projeto original é uma aplicação web de acompanhamento da jornada do cliente. Este repositório é um recorte didático em Java, voltado exclusivamente à geração de relatórios e à demonstração de Template Method e SOLID. A comparação é contextual, não uma afirmação de superioridade global.

Consulte [docs/COMPARACAO.md](docs/COMPARACAO.md) para a análise comparativa.

## Participantes

- Priscilla Cahino
- Paulo Henrique
- Gabriel Lucas

**Nota de autoria:** o Jornada360 original permanece de autoria e propriedade intelectual de Priscilla Cahino. Paulo Henrique e Gabriel Lucas participam do desenvolvimento deste projeto acadêmico independente.

## Documentação adicional

- [Comparação com o projeto original](docs/COMPARACAO.md)
- [Diagrama de classes e fluxo](docs/DIAGRAMA_CLASSES.md)
- [Exemplo prático do Template Method](docs/EXEMPLO_TEMPLATE_METHOD.md)
- [Perguntas e respostas para a apresentação](docs/PERGUNTAS_APRESENTACAO.md)
- [Roteiro de apresentação e perguntas](docs/ROTEIRO_APRESENTACAO.md)

## Escopo, limitações e validação

Os dados são fictícios e mantidos em memória; são reiniciados ao encerrar o programa. O projeto não realiza operações reais com clientes e não integra banco de dados ou serviços externos. O código e a estrutura foram publicados; a execução final no Eclipse ainda precisa ser validada no ambiente local com JDK 17+.
