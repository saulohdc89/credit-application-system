<!-- Badges (troque os links quando fizer o push para seu repositório) -->
<p align="center">
  <img src="https://img.shields.io/badge/Kotlin-2.0-blue?logo=kotlin" alt="Kotlin">
  <img src="https://img.shields.io/badge/Spring%20Boot-3.2-brightgreen?logo=spring" alt="Spring Boot">
  <img src="https://img.shields.io/badge/status-em%20desenvolvimento-yellow" alt="Status">
  <img src="https://img.shields.io/github/stars/seu-usuario/credit-application-system?style=social" alt="Stars">
</p>

# 💳 Credit Analysis System · Kotlin Spring Boot

> API Rest para análise de solicitação de crédito com regras de negócio aprimoradas.

Este projeto é uma **evolução** do sistema original desenvolvido por [Camila Cavalcante](https://github.com/cami-la/credit-application-system) para o desafio da DIO.  
Foram adicionadas novas validações e melhorias na lógica de negócio.

---

## ✨ O que há de diferente neste fork?

- ✅ **Validação do número de parcelas** – limite mínimo de 1 e máximo de **48 parcelas** (regra ausente no original).
- ✅ **Validação da data da primeira parcela** – deve ser no máximo 3 meses após a data atual (mantida e refinada).

---

## 📋 Regras de negócio implementadas

| Regra | Descrição | Status |
|-------|-----------|--------|
| Parcelas | `numberOfInstallments` deve estar entre **1 e 48** | ✅ nova |
| Data da 1ª parcela | Máximo **3 meses** após hoje | ✅ original |

---

## 🛠️ Tecnologias

- **Linguagem:** Kotlin
- **Framework:** Spring Boot 3
- **Persistência:** Spring Data JPA + H2 / PostgreSQL
- **Build:** Gradle (Kotlin DSL)
- **Testes:** JUnit 5 + MockK
- **Documentação:** SpringDoc OpenAPI (Swagger)

---

## 🚀 Como executar

### Pré‑requisitos
- JDK 17+
- Git
- Gradle (opcional, use o wrapper)

### Passo a passo

```bash
# Clone o repositório
git clone https://github.com/seu-usuario/credit-application-system.git

# Entre na pasta
cd credit-application-system

# Execute a aplicação
./gradlew bootRun


