# PayLocal

Proyecto de aprendizaje: plataforma de gestión de pagos para comercios locales, con un procesador de pagos **simulado** (no mueve dinero real). Sirve para practicar conceptos reales usados en la industria de pagos (Mercado Pago, dLocal, Stripe, bancos): APIs REST, Auth con JWT, API Keys, idempotencia, webhooks, conciliación, testing y observabilidad.

Ver [ROADMAP.md](ROADMAP.md) para el plan de fases y el detalle de los módulos.

## Idea simple

Un comercio (ej. restaurante) se registra, inicia sesión y crea un cobro. El cliente abre un link de pago, el sistema simula aprobación o rechazo, el estado del pago se actualiza, el comercio recibe una notificación (webhook) y el pago queda en el historial.

## Actores

- **Administrador**: ve todos los comercios y pagos, aprueba/bloquea comercios, reportes globales.
- **Comercio**: crea cobros, consulta/cancela/reembolsa pagos, configura webhook, genera API Keys.
- **Cliente final**: abre un link de pago y simula el resultado, sin necesidad de cuenta.

## Stack

- **Backend**: Java 25, Spring Boot, Spring Security, Maven
- **Base de datos**: PostgreSQL
- **Cache / idempotencia**: Redis
- **Infra local**: Docker / Docker Compose
- **Testing**: JUnit, Mockito, Testcontainers
- **Observabilidad**: Spring Boot Actuator

## Requisitos

- Java 25
- Docker (para levantar PostgreSQL y Redis vía `spring-boot-docker-compose`)

## Cómo levantar el proyecto localmente

```bash
./mvnw spring-boot:run
```

Spring Boot detecta el `compose.yaml` del repo y levanta automáticamente los contenedores de PostgreSQL y Redis necesarios para desarrollo.

## Estructura

Este repo es un monolito Spring Boot organizado por módulos funcionales (Auth, Merchant, Payment, Fake Processor, API Key, Idempotency, Webhook, Reconciliation, Audit, Reports) — ver [ROADMAP.md](ROADMAP.md) para el detalle de cada uno y el orden de implementación por fases.