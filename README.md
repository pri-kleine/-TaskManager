# AdaTask

Aplicativo de Gerenciamento de Tarefas via Console

## Descrição Geral

AdaTask é um aplicativo de console para gerenciamento de tarefas implementado em Java. Ele permite a criação, listagem,
atualização e exclusão de tarefas, com diferentes tipos, como tarefas gerais, pessoais, de estudos e de trabalho.

## Estrutura do Projeto

* **_Camada de Domain (Domínio)_**:
    - Contém as classes BaseTask, PersonalTask, WorkTask, StudyTask.
    - Tipos de Tarefas:
        - BaseTask: Classe base para todas as tarefas, contendo informações comuns.
        - PersonalTask, StudyTask, WorkTask: Tipos específicos de tarefas com atributos adicionais.

* **_Camada de Repository (Repositório)_**:
    - TaskRepository: Mantém a persistência das tarefas em uma lista.
    - RepositoryInterface: Define a interface para operações de criação, leitura, atualização e exclusão.

* **_Camada de Service (Serviço)_**:
    - TaskService: Gerencia a lógica de negócios e interage com o repositório.

* **_Camada de Controller (Controlador)_**:
    - TaskController: Controla as interações do usuário e direciona as solicitações para a camada Service para executar.

## Principais funcionalidades

* `Visualização de Tarefas`: Listar todas as tarefas cadastradas.
* `Consulta de uma Tarefa`: Visualize os detalhes de uma tarefa específica.
* `Edição de Tarefas`: Atualizar detalhes de tarefas existentes.
* `Remoção de Tarefas`: Deletar tarefas existentes.
* `Criação de Tarefas`: Adicione novas tarefas com diferentes categorias.

## Considerações Adicionais

* O projeto foi elaborado com objetivo de seguir os princípios SOLID para um design limpo e extensível.
* Conceitos de herança e generics foram aplicados nas estruturas de dados e nas operações de manipulação de
  tarefas.
* O projeto foi solicitado como avaliação final do Módulo de POOII do curso de Java da ADA/B3 - Devas
