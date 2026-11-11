# Roteiro de apresentação

## 1. Problema escolhido

Uma operação que acompanha jornadas de clientes precisa consultar situações diferentes: jornadas em andamento, finalizadas e interrompidas. Embora os relatórios tenham conteúdos diferentes, todos seguem etapas semelhantes de geração.

## 2. Solução

A classe abstrata RelatorioJornada concentra a sequência comum no método final gerar(Periodo). Cada subclasse define o título e os critérios de seleção; quando necessário, especializa indicadores e detalhes.

## 3. Onde está o Template Method?

O método gerar é o Template Method. Ele controla a ordem das etapas e impede que subclasses alterem a sequência principal. Os métodos protegidos representam os pontos de variação.

## 4. Relação com SOLID

- SRP: cada classe tem uma responsabilidade delimitada.
- OCP: é possível criar outro relatório estendendo a abstração.
- LSP: qualquer relatório concreto pode ser utilizado como RelatorioJornada.
- ISP: RepositorioJornadas expõe somente a operação necessária.
- DIP: a abstração do relatório recebe a interface, não uma classe concreta de armazenamento.

## 5. Limitações assumidas

Os registros são fictícios, armazenados em memória e reiniciados ao encerrar a aplicação. Não há integração com sistemas externos nem banco de dados, pois isso não é necessário para demonstrar o padrão solicitado.

## 6. Comparação

O Jornada360 original é uma aplicação web de escopo mais amplo. Este exercício não o substitui: usa o mesmo contexto de negócio para estudar, em um programa Java independente, a organização de um algoritmo de relatórios.

## Perguntas que podem surgir

**Por que Template Method?** Porque os relatórios compartilham uma sequência de processamento, mas variam nos critérios de seleção e nos detalhes apresentados.

**Por que não Strategy?** Strategy também seria possível para encapsular algoritmos intercambiáveis. Neste caso, o objetivo didático é demonstrar uma sequência fixa definida por uma classe-base, característica central de Template Method.

**Por que o método gerar é final?** Para preservar a ordem do algoritmo e evitar que subclasses substituam o fluxo completo.

**Como adicionar um novo relatório?** Criar uma subclasse de RelatorioJornada, implementar título e seleção e sobrescrever os pontos de variação necessários.

**Por que não há banco de dados?** O foco é o padrão de projeto. Um repositório em memória permite demonstrar a dependência de abstração sem introduzir infraestrutura fora do escopo.

**O projeto acadêmico substitui o Jornada360 original?** Não. É um exercício independente, com finalidade, tecnologia e escopo diferentes.
