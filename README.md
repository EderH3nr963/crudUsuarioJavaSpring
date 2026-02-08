# CRUD de Usuários — Spring Boot

Este é meu **primeiro projeto utilizando Java com Spring Boot**.  
O objetivo principal foi aprender os **fundamentos do ecossistema Spring**, boas práticas de arquitetura e padrões comuns no desenvolvimento de APIs REST.

Apesar de ser um projeto de estudo, busquei escrever o código de forma **organizada, escalável e próxima do que é usado em ambientes profissionais**.

---

## 🚀 Tecnologias utilizadas

- **Java 17**
- **Spring Boot**
- **Spring Web**
- **Spring Data JPA**
- **Spring Validation**
- **Spring Security (PasswordEncoder)**
- **Hibernate**
- **Banco de dados relacional (JPA)**
- **UUID como identificador**
- **Maven**

---

## 🧠 Conceitos aplicados

- Arquitetura em camadas:
    - Controller
    - Service
    - Repository
- DTOs para Request e Response
- Validação de dados com `@Valid`, `@NotBlank`, etc.
- Hash de senha com `PasswordEncoder`
- Uso correto de HTTP Status Codes
- Separação de responsabilidades
- Atualizações parciais com `PATCH`
- Tratamento de erros
- Mapeamento entre DTOs e entidades
- Boas práticas REST

---

## 📌 Funcionalidades

- Criar usuário
- Buscar usuário por ID
- Atualizar:
    - Email
    - Username
    - Senha
- Deletar usuário

---

## 📂 Estrutura do projeto

```text
src/main/java/com/crudUser/demo
├── controller 
├── service
├── repository
├── model
├── dto
│   ├── Request
│   └── Response
└── config
````

---

## 🔐 Segurança

- Senhas nunca são armazenadas em texto puro
- Utilização de hash com `PasswordEncoder`
- Dados sensíveis não são retornados nas respostas da API

---

## 🎯 Objetivo do projeto

Este projeto foi criado com foco em **aprendizado** e **migração de stack**  
(de TypeScript / Node.js para Java / Spring Boot).

Ele marca meu primeiro contato prático com:
- Spring Boot
- JPA
- Padrões comuns do ecossistema Java

---

## 📌 Próximos passos (roadmap)

- Criar testes unitários
- Adicionar paginação
- Documentar a API com Swagger/OpenAPI

---

##  Autor

Desenvolvido por **Eder Henrique**  
Estudante e desenvolvedor em constante aprendizado 🚀
