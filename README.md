# Spring Boot Async Community Template 🚀

[![Java](https://img.shields.io/badge/Java-17-orange.svg)](https://openjdk.java.net/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.4-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![License](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)

---

## Elige tu idioma | Choose your language:

- [Español](#español)
- [English](#english)

---

## Español

### Índice

1. [Descripción General](#descripción-general-)
2. [Características Principales](#características-principales-)
3. [Tecnologías y Dependencias](#tecnologías--dependencias-)
4. [Instalación y Puesta en Marcha](#instalación--puesta-en-marcha-)
5. [Interfaces disponibles](#interfaces-disponibles)
6. [Licencia](#licencia)

### Descripción General

Plantilla avanzada de Spring Boot orientada a la creación de microservicios modernos, escalables y mantenibles.
Implementa arquitectura hexagonal, comunicación basada en eventos con Kafka y Avro, y está pensada para facilitar la
integración en entornos reales.

**¿Quieres más funcionalidades y soporte adicional?**

Accede a la versión completa de la plantilla con características adicionales y soporte exclusivo para entornos de
producción a través de la [versión comercial](https://davinchicoder.dev/templates).

### Características Principales

- Arquitectura Hexagonal
- Kafka preconfigurado para producir y consumir eventos
- Serialización con Avro y validación vía Confluent Schema Registry
- Containerización lista con Docker Compose

### Tecnologías & Dependenciass️

- Java 17
- Spring Boot 3.2.4
- Spring Web
- Kafka + Spring Kafka
- Avro + Confluent Schema Registry
- MapStruct + Lombok
- Docker & Docker Compose

### Instalación & Puesta en Marcha

1. Clona el repositorio:
   ```bash
   git clone https://github.com/David-DAM/spring-boot-async-template-community.git
   cd spring-boot-async-template-community
   ```
2. Configura las variables de entorno si es necesario.
3. Instala las dependencias
   ```bash
   mvn clean install
   ```
4. Inicia los servicios:
   ```bash
   docker-compose up -d
   ```
5. Ejecuta la aplicación:
   ```bash
   ./mvn spring-boot:run
   ```

### Interfaces disponibles

- Kafka Control Center (monitorización de Kafka): http://localhost:9021
- Schema Registry (gestión de esquemas Avro): http://localhost:8081

### Licencia

#### Versión gratuita

Esta plantilla cuenta con la licencia [MIT License](LICENSE).

Puede usarla, modificarla y distribuirla libremente para proyectos personales, educativos o no comerciales.

#### Versión comercial

Para uso comercial, consulte el [Acuerdo de licencia comercial](LICENSE-COMMERCIAL.txt).

La versión comercial incluye funciones y soporte adicionales. Debe adquirir la licencia comercial para usar esta
plantilla en entornos de producción o con fines comerciales.

---

## English

### Index

1. [Overview](#overview-)
2. [Key Features](#key-features-)
3. [Technologies & Dependencies](#technologies--dependencies-)
4. [Setup & Installation](#setup--installation-)
5. [Available Interfaces](#available-interfaces)
6. [License](#license)

### Overview

Advanced Spring Boot template focused on building modern, scalable, and maintainable microservices.
Implements hexagonal architecture, event-driven communication with Kafka and Avro, and is designed to facilitate
integration in real environments.

### Key Features

- Hexagonal Architecture
- Preconfigured Kafka for producing and consuming events
- Avro serialization and validation via Confluent Schema Registry
- Ready-to-use containerization with Docker Compose

### Technologies & Dependencies

- Java 17
- Spring Boot 3.2.4
- Spring Web
- Kafka + Spring Kafka
- Avro + Confluent Schema Registry
- MapStruct + Lombok
- Docker & Docker Compose

### Setup & Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/David-DAM/spring-boot-async-template-community.git
   cd spring-boot-async-template-community
   ```
2. Set up environment variables if needed.
3. Install dependencies
   ```bash
   mvn clean install
   ```
4. Start the services:
   ```bash
   docker-compose up -d
   ```
5. Run the application:
   ```bash
   mvn spring-boot:run
   ```

### Available interfaces

- Kafka Control Center (Kafka monitoring): http://localhost:9021
- Schema Registry (Avro schema management): http://localhost:8081

### License

#### Free Version

This template is licensed under the [MIT License](LICENSE).

You can freely use, modify, and distribute this template for personal, educational, or non-commercial projects.

#### Commercial Version

For commercial use, please refer to the [Commercial License Agreement](LICENSE-COMMERCIAL.txt).

The commercial version includes additional features and support. You must purchase the commercial license to use this
template in production environments or for commercial purposes.

