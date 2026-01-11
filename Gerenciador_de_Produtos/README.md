# Gerenciador de Produtos (Java Web)

Sistema web desenvolvido para gestão de produtos, permitindo o controle completo de estoque (CRUD) e importação de dados em massa via arquivos CSV/Excel.

## 💻 Sobre o Projeto

Este projeto foi desenvolvido como objeto de estudo para consolidar conhecimentos em **Java Web**, arquitetura **MVC** e manipulação de **Banco de Dados**. 

O sistema não utiliza frameworks pesados (como Spring) propositalmente, visando o entendimento profundo do ciclo de vida dos Servlets, conexões JDBC e protocolo HTTP.

## ⚙️ Funcionalidades

- **Cadastro de Produtos:** Inserção manual de dados.
- **Listagem:** Visualização tabular de todos os itens.
- **Edição e Exclusão:** Atualização e remoção de registros.
- **Busca:** Pesquisa dinâmica por nome ou parte do nome.
- **Importação em Lote:** Upload de arquivos `.csv` para cadastro automático de múltiplos produtos, com validação de duplicidade e tratamento de dados.

## 🛠️ Tecnologias Utilizadas

- **Backend:** Java 8+, Servlets, JDBC.
- **Frontend:** JSP, JSTL, HTML5, CSS3.
- **Banco de Dados:** MySQL.
- **Servidor:** Apache Tomcat 9.
- **IDE:** Eclipse Enterprise.
- **Padrão de Projeto:** MVC (Model-View-Controller) e DAO (Data Access Object).

## 🗄️ Estrutura do Banco de Dados

Para rodar o projeto, crie o banco de dados `loja` e a tabela abaixo:

```sql
CREATE DATABASE loja;
USE loja;

CREATE TABLE produto (
    codigo INT PRIMARY KEY,
    nome VARCHAR(50),
    marca VARCHAR(50),
    preco DOUBLE
);