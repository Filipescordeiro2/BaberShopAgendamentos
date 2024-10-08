# Projeto BaberShop Agendamento

## Descrição do Projeto

Este projeto consiste em um sistema de agendamento para barbearias, implementado com back-end em Java Spring Boot no modelo API REST.

## Tecnologias Utilizadas

- **Back-end**: Java Spring Boot.
- **Banco de Dados**: MySQL.

## Estrutura do Projeto

### Back-end (Java Spring Boot)

#### Estrutura de Pastas:

```plaintext
src
└── main
    ├── java
    │   └── BaberShopSistemaDeAgendamento
    │       ├── Controller
    │       ├── DTO
    │       ├── Model
    │       ├── Repository
    │       ├── Enum
    │       ├── Service
    │       │   └── Imp
    │       └── SistemaDeAgendamentoApplication.java
    └── resources
        └── application.properties
```

### Dependências do Spring Boot

As seguintes dependências do Spring Boot são utilizadas no projeto e são declaradas no arquivo `pom.xml`:

```xml
<dependencies>
    <!-- Dependência do Spring Boot Starter Web para construir aplicações web, incluindo RESTful -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    
    <!-- Dependência do Spring Boot Starter Data JPA para persistência de dados -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>

    <!-- Dependência do Spring Boot Starter Validation para suporte à validação de dados -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-validation</artifactId>
    </dependency>
    
    <!-- Dependência do MySQL Connector para conectividade com o banco de dados MySQL -->
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <scope>runtime</scope>
    </dependency>

    <!-- Dependência do Lombok para reduzir a boilerplate de código -->
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <optional>true</optional>
    </dependency>

    <!-- Dependência do Spring Boot Starter Test para testes unitários e de integração -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
</dependencies>
```

## Regras de Negócio

### Eu: Barbeiro (administrador da barbearia)
- **Posso**:
  - Cadastrar minha barbearia.
  - Me cadastrar como profissional.
  - Cadastrar outro profissional.
  - Ter gestão de bloqueio ou desbloqueio de perfil do profissional.
  - Ter gestão de agendas de todos os profissionais.
  - Realizar todas as ações que um profissional pode fazer, referentes à gestão de agendamentos.

### Eu: Profissional
- **Posso**:
  - Criar várias agendas, podendo escolher o tempo de espaçamento de cada horário (10min, 20min, 30min ou 1h).
  - Ter gestão das minhas agendas (podendo excluir ou alterar agendas).
  - Ter gestão dos horários individuais (podendo excluir um horário específico, ou bloquear/desbloquear horários).
  - Ter gestão de clientes (podendo bloquear/desbloquear clientes).

### Eu: Cliente
- **Posso**:
  - Me cadastrar.
  - Escolher uma barbearia.
  - Escolher um profissional.
  - Escolher uma agenda para atendimento.
  - Dar feedbacks para as barbearias.
  - Dar feedbacks para os profissionais.
  - Cancelar uma agenda com status agendado.
  - Ter controle dos meus agendamentos passados, cancelados e agendados.

## Observação

Este projeto está na fase inicial, podendo haver alterações.