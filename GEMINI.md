# Gemini Code Assist

This document outlines how Gemini Code Assist, your AI-powered software engineering assistant, can help you create, develop and maintain your project.

## Project Overview

### **Key Technologies:**
*   **Backend:** Java 21, Spring Boot 3
*   **Data:** Spring Data JPA, PostgreSQL, Liquibase
*   **API:** Spring Web, SpringDoc (OpenAPI)
*   **Testing:** Spock, ArchUnit, H2
*   **Tooling:** Maven, Lombok, MapStruct

### **Code Architecture**

This project is structured following the principles of **Clean Architecture**. 

Clean Architecture is a software design philosophy created by Robert C. Martin (Uncle Bob) that focuses on creating systems that are independent, testable, and maintainable.

Core Principle
The main idea is to organize your code in concentric layers, where dependencies only point inward (from outer layers to inner layers, never the reverse).

The Layers (from inside out)
1. Entities (Core/Domain)
   * The innermost layer
   * Contains business rules and enterprise logic
   * Pure business objects with no dependencies on frameworks or databases
   * Example: A User entity with validation rules
2. Use Cases (Application Business Rules)
   * Contains application-specific business rules
   * Orchestrates the flow of data to/from entities
   * Example: "Register a new user", "Process an order"
3. Interface Adapters
   * Converts data between use cases and external systems
   * Contains controllers, presenters, and gateways
   * Example: REST API controllers, database repositories
4. Frameworks & Drivers (Outermost)
   * External tools and frameworks
   * Databases, web frameworks, UI, external APIs
   * The most volatile layer - easiest to change

### **Implementation of clean architecture**

The package base is `com.demis27.countries`

The core/domain that contains the Entities is a sub-package `domain`. 
The Use cases are in the sub-package `service`.
The Interface Adapters are in the sub-package `infrastructure`. 

This last package contains two sub-packages: 
The first one is `jap` that contains `jpa.entity` for JPA Entities, `jpa.mapper` for Mapping definition between domain object and JPA Entities, and finally `jap.repository`that contains the JPA repository.
The second one is `web`that contains by packages `controller`, `dto`, `mapper`to map dto to/from Entities.

### **Open API**




