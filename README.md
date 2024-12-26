# Proyecto de Kafka con Spring Boot

Este proyecto implementa una arquitectura hexagonal utilizando Spring Boot y Kafka. Incluye soporte para Actuator,
Lombok, MapStruct, Avro, y Schema Registry. Además, proporciona una configuración completa de Docker con servicios de
Kafka, Zookeeper, Schema Registry y Control Center de Confluent, junto con la aplicación dockerizada.

## Tabla de Contenidos

- [Requisitos Previos](#requisitos-previos)
- [Ejecución](#ejecución)
- [Docker](#docker)
- [Dependencias](#dependencias)
- [Contribuciones](#contribuciones)

---

## Requisitos Previos

- **Java**: Versión 17 o superior.
- **Docker**: Instalado y configurado.
- **Maven**: Para construir el proyecto.

## Ejecución

La aplicación estará disponible en `http://localhost:8080`.

## Características Principales

- **Arquitectura Hexagonal**: Separación clara entre dominio, aplicación e infraestructura.
- **Integración con Kafka**: Productores y consumidores implementados con Spring Kafka.
- **Actuator**: Monitoreo del estado de la aplicación.
- **Lombok**: Reducción de código boilerplate.
- **MapStruct**: Mappeo eficiente de objetos.
- **Avro**: Serialización y validación basada en esquemas.
- **Schema Registry**: Gestión centralizada de esquemas.

## Docker

### Servicios Incluidos

- **Kafka**: Broker de mensajería.
- **Zookeeper**: Gestión del clúster de Kafka.
- **Schema Registry**: Gestión de esquemas Avro.
- **Control Center**: Herramienta de administración de Confluent.
- **Aplicación Spring Boot**: Dockerizada y configurada para interactuar con Kafka.

## Dependencias

Las principales dependencias utilizadas son:

- **Spring Boot**: Framework principal.
- **Spring Kafka**: Integración con Kafka.
- **Spring Actuator**: Monitoreo.
- **Lombok**: Simplificación de código.
- **MapStruct**: Mapeo de objetos.
- **Avro**: Serialización basada en esquemas.
- **Confluent Schema Registry**: Gestión de esquemas.

## Contribuciones

¡Contribuciones son bienvenidas! Si tienes ideas, mejoras o nuevos casos de uso, abre un issue o envía un pull request.