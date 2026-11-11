# Comparação entre o Jornada360 original e o projeto acadêmico

## Contexto

O [Jornada360 original](https://github.com/Priscillacahino/Jornada360), de autoria de Priscilla Cahino, é uma aplicação web voltada ao acompanhamento da jornada do cliente. Conforme a documentação de apresentação do original, utiliza HTML, CSS, JavaScript e armazenamento local no navegador.

Este repositório é um exercício acadêmico independente em Java, com foco restrito à geração de relatórios e à demonstração de Template Method e SOLID. Não substitui nem modifica o produto original.

| Aspecto | Jornada360 original | Projeto acadêmico |
|---|---|---|
| Objetivo | Acompanhar a jornada do cliente em aplicação web | Demonstrar geração estruturada de relatórios |
| Tecnologia | HTML, CSS e JavaScript | Java 17+ |
| Persistência | Armazenamento local no navegador, conforme documentação do original | Dados fictícios em memória |
| Interface | Aplicação web | Console |
| Escopo | Recursos de acompanhamento e gestão da jornada | Relatórios de jornadas ativas, concluídas e interrompidas |
| Ênfase técnica | Fluxos e funcionalidades de CX/CS | Template Method e SOLID |

## O que foi preservado conceitualmente

- O domínio de acompanhamento da jornada do cliente.
- A ideia de observar estados e etapas ao longo da jornada.
- A utilidade de indicadores para apoiar a análise.

## O que foi adaptado

- O escopo foi reduzido à geração de três relatórios.
- Os dados são fictícios e ficam em memória.
- A interface web foi substituída por uma aplicação de console.
- A implementação foi feita em Java para evidenciar abstração, herança e responsabilidades.

## Melhorias arquiteturais demonstradas neste recorte

- A sequência comum de geração foi centralizada no Template Method.
- As regras específicas de seleção e apresentação foram isoladas nas subclasses.
- Os relatórios dependem de uma interface de repositório.
- Cálculo, formatação, domínio e acesso aos dados possuem responsabilidades distintas.

Esses pontos demonstram decisões arquiteturais no exercício acadêmico; não representam uma avaliação global de qualidade nem uma afirmação de que esta implementação é superior ao sistema original.

## Aprendizados da comparação

A comparação evidencia que um mesmo domínio pode ser explorado com objetivos técnicos diferentes. O projeto original atende a um escopo de produto mais amplo; o projeto acadêmico isola um problema menor para estudar um padrão de projeto. A escolha de arquitetura deve considerar o problema, o contexto e os requisitos, e não apenas a quantidade de funcionalidades.
