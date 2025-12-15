# Fisioterapia App

## Descrição do Projeto

Este projeto é uma aplicação de gestão de pacientes e consultas de fisioterapia, desenvolvida utilizando o framework **Spring Boot** para o backend e **Thymeleaf** para a camada de visualização (frontend). A persistência de dados é gerenciada pelo **Spring Data JPA** com o **Hibernate**, utilizando um banco de dados **PostgreSQL**.

## Tecnologias Utilizadas

O projeto foi construído com as seguintes tecnologias e dependências principais:

| Categoria | Tecnologia | Versão | Detalhes |
| :--- | :--- | :--- | :--- |
| **Linguagem** | Java | 17 | Linguagem principal de desenvolvimento. |
| **Framework** | Spring Boot | 2.7.18 | Facilita a criação de aplicações Spring autossuficientes. |
| **Web** | Spring Boot Starter Web | - | Suporte para desenvolvimento de aplicações web. |
| **Frontend** | Thymeleaf | - | Motor de template para renderização de páginas HTML. |
| **Persistência** | Spring Data JPA & Hibernate | - | Gerenciamento de dados e mapeamento Objeto-Relacional. |
| **Banco de Dados** | PostgreSQL | - | Driver de conexão para o banco de dados. |
| **Segurança** | Spring Boot Starter Security | - | Configuração de segurança e autenticação. |
| **Build** | Maven | - | Gerenciamento de dependências e ciclo de vida do projeto. |

## Estrutura do Projeto

A estrutura segue o padrão de uma aplicação Spring Boot, organizada em pacotes para separação de responsabilidades (MVC e camadas de serviço/persistência):

```
src/main/java/com/adsimepac/fisioterapia/
├── config/
│   └── SecurityConfig.java         # Configuração de segurança (Spring Security)
├── controller/
│   ├── ConsultaController.java     # Endpoints para gestão de consultas
│   ├── PacienteController.java     # Endpoints para gestão de pacientes
│   ├── RegistroMedicaoController.java # Endpoints para medições
│   └── ViewController.java         # Controladores para navegação de páginas (Thymeleaf)
├── dto/
│   └── ...                         # Objetos de Transferência de Dados
├── model/
│   ├── Consulta.java               # Entidade JPA para Consultas
│   ├── Paciente.java               # Entidade JPA para Pacientes
│   └── RegistroMedicao.java        # Entidade JPA para Medições
├── repository/
│   └── ...                         # Interfaces Spring Data JPA para acesso ao banco
└── service/
    └── ...                         # Camada de lógica de negócio
```

## Configuração e Execução

Para configurar e executar o projeto localmente, siga os passos abaixo:

### Pré-requisitos

*   **Java Development Kit (JDK) 17** ou superior.
*   **Maven** (já incluso no ambiente de desenvolvimento se estiver usando uma IDE como IntelliJ ou Eclipse).
*   **PostgreSQL** instalado e em execução.

### 1. Configuração do Banco de Dados

O projeto está configurado para usar um banco de dados PostgreSQL. Você deve criar um banco de dados e configurar as credenciais no arquivo `src/main/resources/application.properties`.

**Configuração Padrão:**

```properties
# Configuracao do PostgreSQL
spring.datasource.url=jdbc:postgresql://localhost:5432/fisioterapia
spring.datasource.username=postgres
spring.datasource.password=123456
spring.datasource.driver-class-name=org.postgresql.Driver

# Configuracao do JPA/Hibernate
spring.jpa.hibernate.ddl-auto=update
```

**Atenção:** Certifique-se de que o banco de dados `fisioterapia` exista e que as credenciais (`postgres`/`123456`) correspondam às suas configurações locais. O `ddl-auto=update` fará com que o Hibernate crie ou atualize as tabelas automaticamente.

### 2. Compilação e Execução

Navegue até o diretório raiz do projeto (`Fisioterapia-final/Fisioterapia-final`) e execute os comandos:

**Compilar o projeto:**

```bash
mvn clean install
```

**Executar a aplicação:**

```bash
mvn spring-boot:run
```

A aplicação estará acessível em `http://localhost:8080`.

### 3. Acesso

O projeto utiliza Spring Security. Se houver uma configuração de usuário e senha no `SecurityConfig.java` ou no `application.properties`, utilize-a para acessar a aplicação. Caso contrário, a tela de login padrão do Spring Security será exibida.
