
Neste exemplo, temos um sistema de gestão de tarefas onde as tarefas são criadas e atualizadas pelos utilizadores. Cada tarefa é atribuída a um utilizador específico. Quando uma tarefa é atualizada, o Mediator coordena a comunicação entre a tarefa e os utilizadores, garantindo que a atualização seja refletida corretamente em todas as listas de tarefas.

## README

### Problema

O problema consiste em implementar um sistema de gestão de tarefas onde as atualizações nas tarefas devem ser refletidas nas listas de tarefas dos utilizadores envolvidos.

### Solução

A solução proposta utiliza o padrão Mediator para centralizar a comunicação e o controlo entre os componentes do sistema (tarefas e utilizadores). O Mediator atua como intermediário entre os componentes, coordenando as interações e garantindo que as atualizações nas tarefas sejam propagadas corretamente.

O sistema é composto pelas seguintes classes:

- Mediator: Define a interface para a comunicação entre os componentes.
- GestorTarefas: Implementa o Mediator e coordena as interações entre as tarefas e os utilizadores. Mantém uma lista de tarefas e uma lista de utilizadores registados. Quando uma tarefa é atualizada, o Gestor de Tarefas, notifica todos os utilizadores registafos através do método atualizarTarefa.
- Tarefa: Classe abstrata que representa uma tarefa. Possui atributos como título, descrição e uma referência ao Mediator. Define o método abstrato atribuirTarefa, que permite atribuir a tarefa a um utilizador.
- TarefaImpl: Implementação da classe tarefa.
- User:  Classe abstrata que representa um utilizador. Possui uma referência ao Mediator. Define o método abstrato updateTarefa, que permite atualizar uma tarefa, define também um método getNome para ir buscar o nome do utilizador e um método getTarefasAtribuidas, que retorna a lista das tarefas.
- UserImpl: Implementação da classe User.


### Referências 
- https://refactoring.guru/design-patterns/mediator
- Slides Teóricos sobre o padrão Mediator

