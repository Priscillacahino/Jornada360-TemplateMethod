# Perguntas e respostas técnicas — Jornada360 Template Method

Documento resumido para consulta do professor. Projeto Java 17 independente, com dados fictícios em memória.

## 1. Qual é a finalidade?
Gerar relatórios de jornadas ativas, concluídas e interrompidas com um processo comum e regras específicas.

## 2. Onde está o Template Method?
Em `src/br/com/jornada360/report/RelatorioJornada.java`, no método `public final String gerar(Periodo periodo)`. Ele consulta os dados, seleciona jornadas, calcula indicadores, monta detalhes e formata o documento. O modificador `final` protege a sequência.

## 3. O que as subclasses alteram?
`RelatorioJornadasAtivas`, `RelatorioJornadasConcluidas` e `RelatorioJornadasInterrompidas` implementam `titulo()` e `selecionar(...)`. O relatório de concluídas também sobrescreve `calcularIndicadores(...)` para apresentar o tempo médio; relatórios podem especializar `montarDetalhes(...)`.

## 4. Como SOLID aparece no código?
- **SRP:** `CalculadoraIndicadores` calcula; `FormatadorRelatorio` formata; o repositório fornece dados.
- **OCP:** novos relatórios estendem `RelatorioJornada` sem reescrever `gerar(...)`; o menu pode exigir atualização.
- **LSP:** subclasses são utilizadas pelo contrato comum `RelatorioJornada`.
- **ISP:** `RepositorioJornadas` expõe apenas `listarTodas()`.
- **DIP:** `RelatorioJornada` recebe a interface `RepositorioJornadas`, não a implementação `RepositorioJornadasMemoria`.

São exemplos de aplicação dos princípios, não garantia de uma arquitetura perfeita.

## 5. Qual exemplo concreto de DIP?
O construtor de `RelatorioJornada` recebe `RepositorioJornadas r`. Outra implementação dessa interface poderia substituir o armazenamento em memória sem modificar a classe-base.

## 6. Por que Template Method e não Strategy?
Template Method preserva uma sequência fixa com etapas variáveis por herança. Strategy favorece a troca de algoritmos encapsulados por composição.

## 7. Como adicionar outro relatório?
Criar uma subclasse, implementar `titulo()` e `selecionar(...)`, personalizar etapas quando necessário e disponibilizar a opção na aplicação.

## 8. O que os testes verificam?
`src/br/com/jornada360/testes/TestesRelatorios.java` verifica totais, média de conclusão e motivos de interrupção. Para outubro de 2026, os dados fictícios resultam em **3 ativas, 2 concluídas (média de 9 dias) e 2 interrompidas**. O CI do GitHub foi aprovado e a execução local no Eclipse foi realizada com sucesso, com capturas de tela anexadas ao e-mail.

## 9. Quais dois exemplos cotidianos ilustram Template Method?
- **Preparação de refeições:** separar ingredientes, preparar, cozinhar e servir são etapas gerais; o preparo específico muda conforme a receita. É uma analogia de fluxo fixo com etapas especializadas, não uma implementação de software.
- **Atendimento bancário:** identificar o cliente, verificar documentação, analisar a solicitação e comunicar o resultado seguem um roteiro comum; a análise muda conforme o produto. Em código, as variações poderiam ser subclasses de um fluxo-base.

## 10. Quais princípios SOLID são mais diretamente relacionados?
**OCP** (aberto/fechado) é central: subclasses acrescentam relatórios sem alterar `gerar(...)`. **SRP** aparece na separação entre cálculo, formatação e acesso a dados. **LSP** é relevante porque os relatórios concretos devem respeitar o contrato da classe-base. **DIP** é exemplificado pela dependência da interface `RepositorioJornadas`; **ISP** pelo contrato enxuto dessa interface. A relação com SOLID depende do desenho adotado, não é automática pelo uso do padrão.

## 11. Que outros padrões poderiam ser usados?
**Strategy** é a alternativa mais próxima: diferentes regras de seleção e cálculo poderiam ser injetadas por composição, permitindo trocar comportamentos em tempo de execução. **Factory Method** poderia organizar a criação dos objetos de relatório, mas não resolve sozinho a sequência de etapas. **Builder** auxilia a montar documentos complexos; **Observer** lida com notificações de mudanças. Estes dois últimos atendem a problemas diferentes, não substituem diretamente o Template Method.

## 12. Substitui o Jornada360 original?
Não. O original é uma aplicação web de acompanhamento da jornada do cliente, de autoria de Priscilla Cahino. Este é um exercício acadêmico Java independente.

**Repositório:** https://github.com/Priscillacahino/Jornada360-TemplateMethod
