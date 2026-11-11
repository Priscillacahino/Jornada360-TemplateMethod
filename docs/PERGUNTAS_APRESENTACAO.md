# Guia de perguntas e respostas para a apresentação

As respostas abaixo foram escritas para serem faladas em voz alta. Elas complementam o roteiro principal e devem ser ajustadas às perguntas exatas do professor, caso haja um enunciado específico.

## 1. O que é Template Method?

É um padrão comportamental que define o esqueleto de um algoritmo em uma classe-base e permite que subclasses implementem ou especializem determinadas etapas, sem alterar a sequência principal.

## 2. Onde está o Template Method no projeto?

Na classe `RelatorioJornada`, no método `gerar(Periodo)`. Ele consulta os dados, chama a seleção especializada, calcula indicadores, monta detalhes e formata o documento.

## 3. Por que esse padrão foi escolhido?

Porque os três relatórios compartilham um processo de geração, mas variam nos critérios de seleção e em parte das informações exibidas. O padrão centraliza o fluxo e evita duplicação.

## 4. Qual é um exemplo prático?

Os relatórios de jornadas ativas, concluídas e interrompidas consultam a mesma base. Cada um seleciona um status diferente. O relatório de concluídas também calcula o tempo médio e apresenta datas e resultado; o de interrompidas mostra o motivo da interrupção.

## 5. Por que o método gerar é final?

Para impedir que uma subclasse substitua o algoritmo completo e altere a ordem das etapas. As variações devem acontecer nos métodos previstos para isso.

## 6. O que são os métodos abstratos?

São métodos declarados na classe abstrata sem implementação completa. As subclasses concretas precisam fornecer o comportamento, como o título e o critério de seleção.

## 7. O que significa sobrescrever um método?

Significa fornecer, na subclasse, uma implementação específica para um método herdado. No projeto, isso acontece, por exemplo, com `selecionar(...)` e, no relatório de concluídas, com `calcularIndicadores(...)`.

## 8. Qual a diferença entre Template Method e Strategy?

Template Method usa herança para definir uma sequência fixa com etapas variáveis. Strategy usa composição para trocar um algoritmo ou comportamento encapsulado. Neste exercício, a sequência comum é o foco, por isso Template Method é mais adequado ao objetivo didático.

## 9. Como o projeto demonstra OCP?

É possível acrescentar um novo tipo de relatório criando outra subclasse e implementando seus pontos de variação, preservando o fluxo comum já existente. A inclusão ainda pode exigir registro do novo relatório na aplicação/menu, mas não exige duplicar o algoritmo de geração.

## 10. Como o projeto demonstra DIP?

A classe-base depende da interface `RepositorioJornadas`. Ela não precisa conhecer a implementação concreta que guarda os dados em memória.

## 11. Por que existe um repositório em memória?

Porque o objetivo é demonstrar o padrão sem introduzir banco de dados, configuração ou serviços externos. A interface permite substituir a implementação futuramente, se isso fizer parte de outro escopo.

## 12. Por que os dados são fictícios?

Para que a aplicação seja demonstrável e testável sem utilizar informações reais de clientes. Os registros são recriados quando a aplicação é iniciada.

## 13. O projeto acadêmico substitui o Jornada360 original?

Não. É um exercício independente em Java, com foco em relatórios e padrões de projeto. O Jornada360 original permanece separado e é de autoria de Priscilla Cahino.

## 14. Como adicionar um novo relatório?

Criar uma subclasse de `RelatorioJornada`, implementar `titulo()` e `selecionar(...)`, e especializar cálculo ou detalhes somente se necessário. Depois, disponibilizar essa classe na aplicação.

## 15. Quais são as limitações?

A aplicação usa console, dados fictícios em memória e não possui persistência nem integração externa. Essas limitações são intencionais para manter o exercício concentrado no Template Method.

## 16. O que os testes verificam?

Verificam os totais dos três tipos de relatório, a média de tempo de conclusão e a presença dos motivos de interrupção. O teste é executável sem JUnit.

## 17. O que poderia ser melhorado em uma evolução futura?

Poderia haver persistência real, interface gráfica ou integração com outras fontes de dados. Essas melhorias exigiriam novos requisitos e não são necessárias para demonstrar o padrão neste exercício.

## 18. Qual é a principal conclusão do trabalho?

O padrão permite reaproveitar um algoritmo comum e manter as particularidades em subclasses. O ganho didático está em compreender como organizar a variação sem repetir todo o processo.
