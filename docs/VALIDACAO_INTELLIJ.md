# Validação final no IntelliJ IDEA — Jornada360 Template Method

## Pré-requisitos
- IntelliJ IDEA Community ou Ultimate
- JDK 17 ou superior
- Projeto acadêmico [Jornada360-TemplateMethod](https://github.com/Priscillacahino/Jornada360-TemplateMethod)

## Importação
1. Baixe o ZIP da branch `main` ou clone o repositório.
2. Extraia o ZIP e abra o IntelliJ IDEA.
3. Clique em **Open** e escolha a pasta raiz que contém `src`, `.project` e `.classpath`.
4. Se solicitado, confie no projeto apenas após verificar sua origem.
5. Em **File > Project Structure > Project**, selecione um SDK Java 17 ou superior.
6. Em **Project Structure > Modules**, confirme que `src` está marcada como **Sources Root**. Se não estiver, clique com o botão direito na pasta `src` e escolha **Mark Directory as > Sources Root**.
7. Aguarde a indexação e confirme que os arquivos Java não apresentam erros de compilação.

## Executar a aplicação
1. Abra `src/br/com/jornada360/app/Aplicacao.java`.
2. Clique no ícone de execução ao lado do método `main` e escolha **Run 'Aplicacao.main()'**.
3. No console, informe o período inicial `2026-10-01` e final `2026-10-31`.
4. Escolha as opções de relatórios: **1 (ativas)**, **2 (concluídas)** e **3 (interrompidas)**; encerre com **0**.
5. Confira os resultados esperados para os dados fictícios: **3 ativas**, **2 concluídas** com tempo médio **9 dias**, e **2 interrompidas**, pelos motivos **Documentação não enviada** e **Desistência do cliente**.

## Executar testes
1. Abra `src/br/com/jornada360/testes/TestesRelatorios.java`.
2. Execute o método `main` como aplicação Java.
3. Confirme a mensagem de sucesso no console. Caso haja exceção ou falha de asserção, registre a saída integral e não declare a validação local concluída.

## Evidências para entrega
- Captura da estrutura do projeto importado e do SDK configurado.
- Captura do console de cada um dos três relatórios.
- Captura do console de testes com resultado de sucesso.
- Registro da versão do Java e do commit validado (`git rev-parse HEAD`).

## Limitações e escopo
Este projeto acadêmico é uma aplicação Java de console com dados fictícios em memória. Não inclui interface gráfica, banco de dados ou integração com o Jornada360 web original. O IntelliJ é uma alternativa de execução; não é necessária migração de código. O sucesso de testes no GitHub Actions não substitui a validação na máquina de apresentação.
