# Report Generator Platform (Microservice Architecture)

This repository contains a production-oriented scaffold for a microservice-based report generator platform:

- `api-gateway` (NestJS + TypeScript)
- `auth-service` (Spring Boot 3 / Java 21)
- `reporting-service` (Spring Boot 3 / Java 21, async worker)
- Infrastructure: PostgreSQL (x2), RabbitMQ, Redis, MinIO, Prometheus, Grafana

## Quick start

1. Copy environment values:
   ```bash
   cp .env.example .env
   ```
2. Start infrastructure and services:
   ```bash
   docker compose up -d --build
   ```
3. Open docs:
   - Gateway Swagger: `http://localhost:3000/docs`
   - Auth Swagger: `http://localhost:8081/swagger-ui/index.html`
   - Reporting Swagger: `http://localhost:8082/swagger-ui/index.html`
   - RabbitMQ: `http://localhost:15672`
   - MinIO: `http://localhost:9001`
   - Grafana: `http://localhost:3001`

## Architecture

See:
- `docs/architecture.md`
- `docs/api-spec.md`
- `docs/events.md`

## Notes

- Services are independent and do not share databases.
- JWT is validated without per-request database lookup.
- Report generation is asynchronous through RabbitMQ.
- Files and generated artifacts are stored in MinIO.
- Redis is used for short-lived download tokens and caching.
