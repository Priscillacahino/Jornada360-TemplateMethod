# Diagrama de classes e fluxo

## Responsabilidades e relações

```mermaid
classDiagram
    class RelatorioJornada {
      <<abstract>>
      -RepositorioJornadas repositorio
      -CalculadoraIndicadores calculadora
      -FormatadorRelatorio formatador
      +gerar(Periodo) String final
      #titulo() String*
      #selecionar(List~Jornada~, Periodo) List~Jornada~*
      #calcularIndicadores(List~Jornada~) Map
      #montarDetalhes(List~Jornada~) List~String~
    }
    class RelatorioJornadasAtivas
    class RelatorioJornadasConcluidas
    class RelatorioJornadasInterrompidas
    class RepositorioJornadas {
      <<interface>>
      +listarTodas() List~Jornada~
    }
    class RepositorioJornadasMemoria
    class CalculadoraIndicadores
    class FormatadorRelatorio
    class Jornada
    class Periodo
    class DocumentoRelatorio
    RelatorioJornada <|-- RelatorioJornadasAtivas
    RelatorioJornada <|-- RelatorioJornadasConcluidas
    RelatorioJornada <|-- RelatorioJornadasInterrompidas
    RelatorioJornada --> RepositorioJornadas
    RepositorioJornadas <|.. RepositorioJornadasMemoria
    RelatorioJornada --> CalculadoraIndicadores
    RelatorioJornada --> FormatadorRelatorio
    RelatorioJornada --> DocumentoRelatorio
    DocumentoRelatorio --> Periodo
    RepositorioJornadasMemoria --> Jornada
```

## Sequência do Template Method

```mermaid
flowchart TD
    A[Aplicação escolhe o relatório] --> B[Chama gerar Periodo]
    B --> C[Valida o período]
    C --> D[Consulta RepositorioJornadas]
    D --> E[Subclasse seleciona jornadas]
    E --> F[Calcula indicadores]
    F --> G[Monta detalhes]
    G --> H[Cria DocumentoRelatorio]
    H --> I[FormatadorRelatorio formata]
    I --> J[Texto exibido no console]
```

## Como explicar o diagrama

- A classe abstrata `RelatorioJornada` contém o método Template Method `gerar(Periodo)`, que é final e retorna uma `String` formatada.
- As três subclasses herdam o fluxo e definem título e seleção. O relatório de concluídas também especializa o cálculo de indicadores e os detalhes.
- `RepositorioJornadas` é uma interface; `RepositorioJornadasMemoria` fornece os dados fictícios.
- `CalculadoraIndicadores` e `FormatadorRelatorio` são colaboradores recebidos pela classe-base.
- `Jornada`, `Periodo` e `DocumentoRelatorio` representam dados de entrada, recorte temporal e saída estruturada.

## Atenção à distinção entre algoritmo e resultado

O Template Method não significa que todos os relatórios produzem o mesmo conteúdo. Significa que a sequência de geração é definida em um único lugar. As subclasses preenchem os pontos de variação previstos pela classe-base.
