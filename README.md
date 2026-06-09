# POO_projParc
Projeto Parcial POO IFBA

Instituto Federal de Educação, Ciência e Tecnologia da Bahia Campus Camaçari

Disciplina: INF301 - Programação Orientada a Objeto

Prof: Dr. Fábio Marques

Discente: Felipe Eugênio Trindade Gaspar

## Resumo

Este projeto trata-se de um gerenciador de projetos, sua função é administrar detalhes dos projetos como seus componentes, a função que cada componente exerce em cada projeto, os avisos dos componentes para o projeto e as atividades de cada projeto e seu estado. anexado a ele está o arquivo 'ScriptDB.sql' que orienta a criação do banco de dados o qual irá armazenar todas as informações que serão operadas nesta aplicação.

## Mapa de Atributos:

Legenda:

    - Classe:
        - Atributo (tipo, dado esperado)

- Projeto:
    - Titulo (String, *nome do projeto*)
    - Tipo (Tipos[enum], *tipo de projeto, definido em: [PIBIC, PIBIC_af, PIVIC, PIVIC_af, PIBIC_EM, PIBIC_EM_af, PIVIC_EM_af]*)
    - Componentes (ArrayList(Componente), *pessoas que compõem o projeto definidas na classe 'Componente'*)
    - Avisos (ArrayList(Aviso), *avisos emitidos pelo sistema ou por componentes do projeto, este atributo está definido na classe 'Aviso'*)
    - Atividades (ArrayList(Atividade), *atividades que definem o projeto, este atributo está definido na classe 'Atividade'*)
 
- Componente:
    - Lattes ID (int, *código lattes do membro do projeto, este atributo também comporta o ID -255 reservado para as funções do sistema*)
    - Nome (String, *nome do componente do projeto*)
    - Função (String, *papel do componente em um projeto*)
    - Entrada (LocalDate, *data de entrada do componente no projeto*)
    - Saída (LocalDate, *data de desligamento do componente no projeto, este dado será sempre nulo a menos que o atributo 'Estado' seja 'desligado'*)
    - Estado (CompEstado[enum], *situação do componente em relação ao projeto, definido em: [ativo, desligado, suspenso]*)

- Atividade:
    - Atividade (String, *descrição da atividade a ser realizada no projeto*)
    - Situação (Situacao[enum], *estado em que a atividade se encontra, definido em: [pendente, em_andamento, em_atraso, concluida]*)
    - Início (LocalDate, *data de inicio previsto para a atividade*)
    - Fim (LocalDate, *data de fim previsto para a atividade*)
 
- Aviso:
    - Código do Aviso (int, *código do aviso emitido, o valor deste atributo é gerado automaticamente pelo banco de dados*)
    - Remetente (int, *Id Lattes do componente que emitiu o aviso, ou o código -255 para avisos emitidos pelo sistema*)
    - Publicação (LocalDateTime, *data, hora da emissão do aviso de acordo com o fuso horário do sistema*)
    - Aviso (String, *Conteúdo do aviso, informação divulgada para os componentes por um componente*)
