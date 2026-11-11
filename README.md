# Jornada360 — Relatórios de Acompanhamento da Jornada do Cliente

Projeto acadêmico independente desenvolvido em Java 17+ para demonstrar o padrão comportamental **Template Method** e sua relação com os princípios **SOLID**, no contexto de relatórios de acompanhamento da jornada do cliente.

## Objetivo

Implementar três relatórios de console — jornadas ativas, concluídas e interrompidas — reutilizando um fluxo comum de geração e permitindo variações específicas por meio de subclasses.

## Tecnologias e execução

- Java 17 ou superior
- Eclipse IDE
- Aplicação de console
- Dados fictícios mantidos em memória
- Sem banco de dados, API ou dependência de internet

## Padrão de projeto

A classe abstrata `RelatorioJornada` define o algoritmo de geração do relatório em um método final. As subclasses especializam os pontos variáveis sem alterar a sequência principal.

## Princípios SOLID

- **SRP:** domínio, persistência em memória, cálculo, formatação e relatórios possuem responsabilidades separadas.
- **OCP:** novos tipos de relatório podem ser adicionados por extensão da abstração.
- **LSP:** as implementações concretas respeitam o contrato de `RelatorioJornada`.
- **ISP:** o contrato do repositório é pequeno e específico.
- **DIP:** os relatórios dependem da interface `RepositorioJornadas`, não da implementação em memória.

## Relação com o Jornada360 original

Este exercício acadêmico parte do mesmo domínio conceitual, mas possui escopo, código e documentação próprios. Ele não altera nem substitui o projeto original, de autoria de Priscilla Cahino: [Priscilla Cahino/Jornada360](https://github.com/Priscillacahino/Jornada360).

O projeto original é uma aplicação web de acompanhamento da jornada do cliente. Este repositório é um recorte didático em Java, voltado exclusivamente à geração de relatórios e à demonstração de Template Method e SOLID. A comparação é contextual, não uma afirmação de superioridade global.

## Participantes

- Priscilla Cahino
- Paulo Henrique
- Gabriel Lucas

**Nota de autoria:** o Jornada360 original permanece de autoria e propriedade intelectual de Priscilla Cahino. Paulo Henrique e Gabriel Lucas participam do desenvolvimento deste projeto acadêmico independente.

## Situação

Projeto acadêmico em desenvolvimento. As instruções de importação, execução e validação serão documentadas junto aos códigos-fonte.
