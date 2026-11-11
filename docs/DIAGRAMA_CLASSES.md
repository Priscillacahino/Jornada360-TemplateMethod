# Diagrama de classes

O diagrama abaixo representa as principais relações da implementação:

- RepositorioJornadas é a interface de acesso aos dados.
- RepositorioJornadasMemoria implementa essa interface.
- RelatorioJornada é a classe abstrata que define o Template Method.
- As três subclasses implementam os relatórios concretos.
- CalculadoraIndicadores e FormatadorRelatorio são colaboradores injetados na classe-base.
- Jornada, Periodo e DocumentoRelatorio representam os dados do domínio e da saída.

## Fluxo do Template Method

1. A aplicação seleciona um tipo concreto de relatório.
2. A aplicação chama gerar(Periodo).
3. O período é validado na criação do objeto Periodo.
4. O repositório fornece a lista de jornadas.
5. A subclasse seleciona os registros pertinentes ao período.
6. A classe-base calcula os indicadores, com possibilidade de especialização.
7. A classe-base monta os detalhes, também com possibilidade de especialização.
8. O documento é criado e enviado ao formatador.
9. A aplicação exibe o texto no console.

## Esboço UML textual

RelatorioJornada (abstrata)
  ├── RelatorioJornadasAtivas
  ├── RelatorioJornadasConcluidas
  └── RelatorioJornadasInterrompidas

RelatorioJornada --> RepositorioJornadas (interface)
RelatorioJornada --> CalculadoraIndicadores
RelatorioJornada --> FormatadorRelatorio
RepositorioJornadasMemoria ..|> RepositorioJornadas
RepositorioJornadasMemoria --> Jornada
RelatorioJornada --> DocumentoRelatorio
DocumentoRelatorio --> Periodo
Jornada --> StatusJornada
Jornada --> EtapaJornada

O método gerar(Periodo) é final e mantém o fluxo comum. Os métodos titulo() e selecionar(...) são pontos abstratos de variação. calcularIndicadores(...) e montarDetalhes(...) podem ser especializados pelas subclasses.
