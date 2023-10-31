# Projeto CRUD Java para Cadastro de Fungos

## Descrição

Este projeto Java é uma aplicação de CRUD (Create, Read, Update, Delete) que permite aos usuários cadastrar informações sobre fungos, armazenar imagens associadas a esses registros e realizar operações de ordenação dos dados usando algoritmos de ordenação, como o Insert Sort, Bubble Sort e Quick Sort. O projeto utiliza um banco de dados MySQL para armazenar informações sobre os fungos e suas imagens.

## Estrutura do Projeto

O projeto é organizado em pacotes que representam diferentes partes do sistema:

- **`connection`**: Este pacote contém a classe `ConnectionFactory`, responsável por criar e gerenciar a conexão com o banco de dados MySQL.

- **`model.bean`**: Neste pacote, você encontrará a classe `fungo`, que representa os atributos de um Fungo

- **`model.dao`**: O pacote `model.dao` contém a classe `FungoDAO`, que lida com operações de acesso ao banco de dados relacionadas aos clientes.

- **`view`**: Este pacote contém a classe `Fungos`, que é a interface gráfica de usuário (GUI) para interagir com o formulário. Ela permite a visualização, inserção, atualização e exclusão de fungos.

## Funcionalidades

- **Cadastro de Fungos:** Os usuários podem adicionar informações sobre fungos, incluindo ID, Nome, Número e Data de identificação.
- **Armazenamento de Imagens:** O sistema permite a seleção e armazenamento de imagens associadas a cada registro de fungo.
- **Operações de CRUD:** Os usuários podem criar, ler, atualizar e excluir registros de fungos no banco de dados.
- **Ordenação de Dados:** O projeto inclui a implementação de três algoritmos de ordenação para classificar os registros de fungos:
  1. **Insert Sort:** Algoritmo de ordenação por inserção.
  2. **Bubble Sort:** Algoritmo de ordenação bolha.
  3. **Quick Sort:** Algoritmo de ordenação rápida.
- **Comparação de Algoritmos:** Os usuários podem comparar os tempos de execução dos algoritmos de ordenação e identificar qual deles é o mais eficiente.

## Tecnologias Utilizadas

- **Linguagem de Programação:** Java
- **Biblioteca Gráfica:** Swing (para criar a interface gráfica)
- **Banco de Dados:** MySQL (para armazenamento dos dados de fungos e imagens)
- **Algoritmos de Ordenação:** Insert Sort, Bubble Sort, Quick Sort
- **Classes Personalizadas:** `Fungos.java` (JFrame para a interface gráfica), `FungoDAO.java` (para operações no banco de dados), `ConnectionFactory.java` (responsável pela conexão com o banco de dados).

## Instruções de Uso

1. Configure um banco de dados MySQL e ajuste as informações de conexão no arquivo `FungoDAO.java` e `Conexao.java` para se conectar ao seu banco de dados.
2. Execute o aplicativo usando a classe `Fungos.java` e utilize a interface gráfica para adicionar, editar, excluir e visualizar registros de fungos.
3. Selecione e associe imagens aos registros de fungos.
4. Utilize as opções de ordenação para classificar os registros com os algoritmos disponíveis.
5. Compare os tempos de execução dos algoritmos de ordenação e veja qual é o mais rápido.

## Observações

- Certifique-se de ter as bibliotecas e dependências necessárias configuradas para executar o projeto.
- É importante que o banco de dados MySQL esteja configurado e em execução.
- Este projeto pode servir como exemplo de como criar uma aplicação Java para CRUD com recursos de ordenação e armazenamento de imagens.

## Contribuição

Sinta-se à vontade para contribuir com melhorias, correções de bugs ou novos recursos para este projeto. Basta criar um fork do repositório, fazer as alterações desejadas e enviar um pull request.

## Licença

Este projeto está licenciado sob a licença MIT. Consulte o arquivo [LICENSE](LICENSE) para obter mais informações.

