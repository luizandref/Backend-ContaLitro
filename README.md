## Tecnologias utilizadas

- Java 25
- Spring Boot 4.1.1
- Maven
- Spring Integration
- Eclipse Paho MQTT
- Spring Data JPA
- Hibernate
- PostgreSQL
- Docker
- Docker Compose

---

## Docker

O banco de dados PostgreSQL pode ser iniciado utilizando o Docker Compose.

### Iniciar o PostgreSQL

```bash
docker compose up -d

## Verificar os containers

```bash
docker ps

## Parar o PostgreSQL

```bash
docker compose down

---

## Estrutura do projeto

backend/
│
├── .mvn/
│
├── src/
│   │
│   ├── main/
│   │   │
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── contalitro/
│   │   │           └── backend/
│   │   │               │
│   │   │               ├── BackendApplication.java
│   │   │               │
│   │   │               ├── TesteController.java
│   │   │               │
│   │   │               ├── domain/
│   │   │               │   ├── Veiculo.java
│   │   │               │   ├── Leitura.java
│   │   │               │   └── Viagem.java
│   │   │               │
│   │   │               └── mqtt/
│   │   │                   ├── MqttConfig.java
│   │   │                   └── MqttSubscriberHandler.java
│   │   │
│   │   └── resources/
│   │       └── application.properties
│   │
│   └── test/
│
├── .gitignore
├── docker-compose.yml
├── mvnw
├── mvnw.cmd
├── pom.xml
└── README.md

---

## Executar o Spring Boot

.\mvnw.cmd spring-boot:run